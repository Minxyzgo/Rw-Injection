import android.util.Log
import com.Element
import org.junit.jupiter.api.Test
import rwij.*
import java.io.File
import kotlin.reflect.full.functions
import kotlin.reflect.jvm.kotlinFunction

class ProxyTest {

    fun reload() {
        Builder.releaseLib()
        File("${Builder.libDir}/info.properties").apply { if(exists()) delete() }
    }
    @Test
    fun testGetAndSetField() {
        val tobj = object {
            @JvmField
            var i: Int = 0

            fun geti() = 10
            fun seti(i: Int) { this.i = i }
        }

        println(tobj.get { ::i })
        tobj.set(tobj::i, 123)
        println(tobj.i)
    }

    @Test
    fun testProxyFunction() {
        Builder.libDir = "testLib"
        reload()

        val tree = Builder.getClassTreeByLibName("game-lib")

        ProxyFactory.runInit {
            setProxy(tree, "a.a.b")
        }

        val i = 0
        val bc = a.a.b()

        a.a.b::class.setFunction {
            this.addProxy(a.a.b::close) {
                println(i)
            }
        }
        bc.close()

        bc.setFunction(bc::close) {
            println(i + 1)
        }

        bc.close()
    }

    @Test
    fun testProxyFunction2() {
        Builder.libDir = "testLib"
        reload()

        val tree = Builder.getClassTreeByLibName("game-lib")

        ProxyFactory.runInit {
            setProxy(tree, "android.util.Log", "empty:com.Element")
        }

        Log::class.setFunction {
            addProxy("d", "(Ljava/lang/String;Ljava/lang/String;)") { _: Nothing?, s1: String?, s2: String? ->
                println("log: $s1, $s2")
                1
            }
        }

        println(Element().numChildren)
        Log.d("A", "b")
    }

    @Test
    fun testFindPackage() {
        Builder.libDir = "testLib"
        Builder.loadLib()
        val tree = Builder.getClassTreeByLibName("game-lib")
        val pack = tree.findTreeByPackage("com.corrodinggames.rts.game")
        println(tree.allPackageFromRoot.keys)
        println(pack.classesName)
    }
}