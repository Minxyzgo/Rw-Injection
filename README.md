# Rw-Injection - 适用于Rw的注入库 & 映射库
## 支持的功能：
* 为Rw游戏库创建映射表，并能支持直接调用
* 使用一套基于[javassist](https://github.com/jboss-javassist/javassist)的代理服务，支持实时代理任意方法

## TODO
* [ ] 支持编译source内的 Overwrite 的代码
* [ ] 支持自动设置代理 & hot-load
* [x] 支持缓存
* [ ] 使用asm或kcp代替重命名的解决方案
* [ ] gradle-插件
* [ ] headless-simulation 子项目

## 如何使用？

build.gradle.kts添加如下代码
```kotlin
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.minxyzgo.rw-injection:source:master-SNAPSHOT") //添加映射库
    implementation("com.github.minxyzgo.rw-injection:core:master-SNAPSHOT")
}
```

对于一个Rw class，获取它的field的值或修改有以下方式：
```java
//class 定义
public class Example {
    @RenameFrom(oldName = "a")
    Object field = null;
    
    int c = 0;
    //...
}
```

```kotlin
val xx = Example()
xx.get { ::field } // 获取
xx.set(xx::field, null) // 设置

//并请注意，如果一个field它没有被Rename映射过，那么它不能采取上述方式，只能采取传统方式:
xx.c //get
xx.c = 1

//换言之， 如果一个field被Rename映射，就只能采取第一种方式，反之则必须采取第二种
```

如果你需要代理一个Rw class的函数， 那么采取以下代码: 
```kotlin
ProxyFactory.runInit {
    setProxy(Builder.getClassTreeByLibName("game-lib"), "a.a.b") 
    setProxy(Builder.getClassTreeByLibName("ibxm"), "ibxm.Channel", "ibxm.IBXM") //你可以同时从其它lib中添加更多要被代理的类
}
//注意，runInit应当在程序生命周期中只调用一次
```
对于以下定义的java class:
```java
public class Example {
    void sample1() {
        System.out.println(12345);
    }
    
    void sample2(int v) {
        //...
    }
}
```
可以: 
```kotlin
val e = Example()
e.sample1() // 12345
Example::class.setFunction {
    addProxy(Example::sample1) { // 自动推断为 （Example) -> Unit. 因此可以用idea自动补全
        println(123)
    }

    addProxy(Example::sample2) { self, i -> // 自动推断为 （Example, Int) -> Unit. 因此可以用idea自动补全
        println(i)
    }
}

e.sample1() // 123

e.sample2(234) // 234

e.setFunction(e::sample1) {
    println(234)
}
e.sample1() // 234
```
因此，代理优先级为 对象代理 > 类代理 > 原始函数

## source 贡献映射
映射是十分有用的特性，可以将不含任何意义的源rw代码中的字段名映射为一个有意义的字段名，这将大大增加可读性并易于对源码解读。

任何有关的代码都在`source`子项目中。

### 开始
假设有以下类
```java
package a.a;
public class a {
    public Object c;
    void q() {
        
    }
}
```
当你通过`jadx`或者`cfr`等反编译器确切的了解class`a`的功能后，你可以为其取一个合适的名字，例如`Parser`对`class a`,`parse`对`method b`, `tree`对`field c`

你都可以如下编写:
```java
package a.a;
import rwij.annotations.RenameFrom;
@RenameFrom(oldName = "a")
public class Parser {
    @RenameFrom(oldName = "c")
    public Object tree;
    @RenameFrom(oldName = "q")
    void parse() {
        
    }
}
```
请注意，若接下来需要继续修改映射名，保留`RenameFrom`且无需再次更改`oldName`.例如：将`Parser`转化为`TreeParser`,只需直接更改class name
而无需更改`RenameFrom`的`oldName`，它应该保留为`@RenameFrom(oldName = "a")`

此外如果你同样确切的了解一个反编译方法的代码的实现，你也可以将其添加进映射的方法体。现在它是无用的，仅是为了阅读，但以后可能会对其编译。

另外一点需要注意的是，当你更改了任意一个映射名后，你应当使用ide中的重命名来进行修正其它地方的引用。

### 部分注解的作用

 * `@Additional`表示生成器在生成期间为了能通过编译而不得不增加字段或方法，它本不应该出现在类中，因此你不应该对其进行任何操作。 当一个类的相关映射全部编写完成并能通过编译后，便可以删掉有关注释及其方法和字段.
 * `@Fixed`表示为了能够通过编译，其方法的类型，实现等可能与实际不符，它是需要被重新编写的。
