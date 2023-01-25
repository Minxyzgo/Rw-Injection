//
//import com.github.minxyzgo.rwij.*
//import org.junit.jupiter.api.Test
//
//@OptIn(LibRequiredApi::class)
//class ProxyTest {
//    @Test
//    fun testProxyFunction() {
//        Builder.libDir = "testLib"
//       // reload()
//
//        val tree = Builder.getClassTreeByLibName("game-lib")
//
//        ProxyFactory.runInit {
//            setProxy(tree, "a.a.b")
//        }
//
//        val i = 0
//        val bc = a.a.b()
//
//        a.a.b::class.setFunction {
//            this.addProxy(a.a.b::close) {
//                println(i)
//            }
//        }
//        bc.close()
//
//        bc.setFunction(bc::getSoTimeout) {
//            println(i + 1)
//        }
//
//        bc.close()
//    }
//
//    @Test
//    fun testProxyFunction2() {
//        Builder.libDir = "testLib"
//        //reload()
//
//        val tree = Builder.getClassTreeByLibName("game-lib")
//
//        ProxyFactory.runInit {
//            setProxy(tree,
//                "android.util.Log",
//                "empty:com.Element".withNon("loadCharsetIfNeededWithCurrentText")
//            )
//        }
//
//        Log::class.setFunction {
//            addProxy("d", "(Ljava/lang/String;Ljava/lang/String;)") { _: Nothing?, s1: String?, s2: String? ->
//                println("log: $s1, $s2")
//                1
//            }
//        }
//
//        println(Element().tagName)
//        Log.d("A", "b")
//    }
//}