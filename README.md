# Rw-Injection - 适用于Rw的注入库
## 支持的功能：
* 使用一套基于[javassist](https://github.com/jboss-javassist/javassist)的代理服务，支持静态/动态代理

## TODO
* [x] 支持缓存
* [x] 支持加载jadx
* [x] gradle-插件
* [ ] 加快构建速率

## 如何使用？

`build.gradle.kts` 添加如下代码
```kotlin
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }


    dependencies {
        classpath("com.github.minxyzgo.rw-injection:com.github.minxyzgo.rwij.gradle.plugin:master-SNAPSHOT")
    }
}

apply<com.github.minxyzgo.rwij.GradlePlugin>()
dependencies {
    injectRwLib("master-SNAPSHOT")
}
```
## 静态代理模式
静态代理模式下，只会在编译期间在`classpath`内写入诸如`javassist`等依赖库，只会写入核心库`core`提供方便的代理方案

使用静态代理模式将极大减小运行期压力和缩小Jar所占空间大小，并且直接向`classpath`注入rw所需的lib，这将更为方便地兼容其它诸如android的平台

缺点: 运行期你将无法对类进行进一步修改

## 插件的使用

当调用`apply<com.github.minxyzgo.rwij.GradlePlugin>()`时，插件开始加载，此时插件会释放rw lib到`projectDir/lib/`下

如果该path已经存在，则不会自动释放rw lib

### injectRwLib
`injectRwLib`是插件提供的一个方便的函数，它只能在`dependencies{}`内调用

它的定义如下`injectRwLib(version: String, useRuntimeLib: Boolean)`

其中`version`是依赖的rwij版本， `useRuntimeLib`决定是否启用动态代理模式，默认为false，将在之后讲解

### injection
`injection`是插件提供的dsl，是静态代理模式的实现，它可以很方便地进行诸如反混淆，加载jadx和代理操作

`injection`提供下列函数

#### setProxy
`setProxy(lib: Libs, vararg proxyList: Any)`设置指定Lib内的某个class为代理

`proxyList`指代理列表，可以传入class name批量实现代理，下面为一个示例
```kotlin
setProxy(Libs.`game-lib`, "a.a.b", "a.a.a")
```
这将代理class`a.a.b`和`a.a.a`，之后便可以使用`core`内提供的函数来方便地进行代理，如何使用将在之后提到

此外`proxyList`还有十分方便的方法

若使用```setProxy(Libs.`game-lib`, "empty:a.a.b")```这意味者将`a.a.b`内的**所有方法**设置为空体，即所有方法不会包含任何实现，只会返回该方法的默认值

如函数返回类型为`Object`则默认返回`null`，类型为`int`则返回`0`，与java类型默认值一致，以此类推

若使用```setProxy(Libs.`game-lib`, "empty:a.a.b".with("a"))```表示`a.a.b`内方法名为`a`将会被设置为空体

同时，还可以同时设置多个方法，并且带签名，一个示例是```setProxy(Libs.`game-lib`, "empty:a.a.b".with("a(IIZLjava/lang/String;)"， “b”))```

还有另一个方法是`withNon(args..)`它意味着除了传入的方法都会被设置为空体，其余用法与`with(args..)`一致

#### deobfuscation
`deobfuscation`传入一个`classTree`，它会重命名所有与包名冲突的类，如果该包没有这样的类则可以忽略不用
一个示例是`deobfuscation(Libs.`game-lib`.classTree)`

#### initJadx
```kotlin
fun initJadx(
    fileName: String,
    dir: String = projectDir,
    lib: Libs = Libs.`game-lib`,
    otherTree: Array<Libs> = emptyArray()
)
```
其中`fileName`是jadx项目文件名(不包含.jadx后缀)，默认从项目路径开始寻找

这将加载jadx项目文件并为指定lib进行重命名操作

下面是一个综合以上示例的例子
```kotlin
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }


    dependencies {
        classpath("com.github.minxyzgo.rw-injection:com.github.minxyzgo.rwij.gradle.plugin:master-SNAPSHOT")
    }
}

apply<com.github.minxyzgo.rwij.GradlePlugin>()
dependencies {
    injectRwLib("master-SNAPSHOT")
}

injection {
    deobfuscation(com.github.minxyzgo.rwij.Libs.`game-lib`)
    initJadx("game-lib.jar")
    setProxy(Libs.`game-lib`, "a.a.b", "a.a.c".with("c"), "a.a.d".withNon("a", "b(IZ)"))
}
```

## 动态代理模式
如果你想在运行期方便修改各种class，只需要`injectRwLib("master-SNAPSHOT", true)`启动动态代理

动态代理模式下，rw lib将不会自动写入classpath，而是写入resources，且自动导入`javassist`等需要的库

此时如果你需要代理一个Rw class的函数， 那么在程序中采取以下代码: 
```kotlin
ProxyFactory.runInit {
    setProxy("...")
    setProxy("...") 
}
//注意，runInit应当在程序生命周期中只调用一次
```
其中`setProxy`用法同上面一致

## 代理方法
当你使用`injectRwLib`时，无论静态代理还是动态代理都已经写入了`core`库，对一个函数进行代理则可以用以下方法

示例
```kotlin
class Example {
    fun sample1() = 12345
    
    fun sample2(i: Int)
} //请确保该类在setProxy中
val e = Example()
e.sample1() // 12345
Example::class.setFunction {
    addProxy(Example::sample1) { // 自动推断为 （Example) -> Unit. 因此可以用idea自动补全
        println(123)
    }

    addProxy(Example::sample2) { self, i -> // 自动推断为 （Example, Int) -> Unit. 因此可以用idea自动补全
        println(i)
    }

    // 函数名 + 参数列表
    addProxy("sample2", Int::class) { self: Example, i: Int -> // 等效于上面函数，但无法自动推断，可以自行填充参数
        println(i)
    }

    // 函数名 + 签名
    addProxy("sample2", "(I)") { self: Example, i: Int -> // 等效于上面函数，但无法自动推断，可以自行填充参数
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