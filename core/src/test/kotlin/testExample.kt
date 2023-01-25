
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
            Builder.releaseLib(ProxyTest::class.java.classLoader)
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
}