
import android.util.Log
import com.github.minxyzgo.rwij.*
import org.junit.jupiter.api.Test
import java.io.File

@OptIn(LibRequiredApi::class)
class ProxyTest {
    @Test
    fun testProxyFunction() {
        Builder.libDir = "testLib"
        val f = File(Builder.libDir)
        if(!f.exists()) {
            f.mkdirs()
            Builder.releaseLibs(ProxyTest::class.java.classLoader)
        }
        //
        ProxyFactory.runInit {
            setProxy(Libs.`game-lib`.classTree, "a.a.b".with("close"))
        }

        val i = 0
        val bc = a.a.b()

        a.a.b::class.setFunction {
            this.addProxy(a.a.b::close) {
                println(i)
            }
        }

        println("test")

        bc.close()
        bc.close()
       // bc.close()
        //bc.close()
        //bc.soTimeout

        println("test2")
        ProxyFactory.agentMap.forEach { (t, u) ->
            u.proxyMap.keys.forEach { println(it) }
        }
    }

    @Test
    fun testModluarFunction() {
        Builder.libDir = "testLib"
        val f = File(Builder.libDir)
        if(!f.exists()) {
            f.mkdirs()
            Builder.releaseLibs(ProxyTest::class.java.classLoader)
        }


        lateinit var bytes: ByteArray
        lateinit var bytes2: ByteArray
        ProxyFactory.runInit {
            setProxy(Libs.`game-lib`.classTree, "android.util.Log".with("a(Ljava/lang/String;Ljava/lang/String;)", "isLoggable"))
        }

        val c1 = Libs.`game-lib`.classTree.defPool["android.util.Log"]
        c1.defrost()
        bytes = c1.toBytecode()
        val c2 = Libs.`game-lib`.classTree.defPool["android.util.Log\$1"]
        c2.defrost()
        bytes2 = c2.toBytecode()


        val loader = GameModularLoadClass(Thread.currentThread().contextClassLoader,Thread.currentThread().contextClassLoader.parent)

        android.util.Log::class.setFunction {
            addProxy("a", "(Ljava/lang/String;Ljava/lang/String;)") { _: Any?, s: String, s2: String ->
                println(s + s2)
                1
            }

            addProxy(android.util.Log::isLoggable) { _: Any?, _: String, _: Int ->
                println("proxy native test!")
                false
            }
        }

        Log.a("123", "123")
        loader.addClassBytes("android.util.Log\$1", bytes2)
        loader.addClassBytes("android.util.Log", bytes)
        val clazz = loader.findClass("android.util.Log")!!
        clazz.getDeclaredMethod("a", String::class.java, String::class.java)
            .invoke(null, "234", "65")
        clazz.getDeclaredMethod("isLoggable", String::class.java, Int::class.java)
            .invoke(null, "", 0)
    }

}