/**
 * 数据类型
 *
 * 在Groovy中，数据类型有：
 * Java中的基本数据类型
 * Java中的对象
 * Closure（闭包）
 * 加强的List、Map等集合类型
 * 加强的File、Stream等IO类型 类型可以显示声明，也可以用 def 来声明，用 def 声明的类型Groovy将会进行类型推断。
 */
class 数据类型 {

    static main(args) {

        // 1.string   String的特色在于字符串的拼接
        def a = 1
        def b = "hello guys"
        def c = "a = ${a}, b= ${b}"

        println c

        // 使用闭包
        closure(100, "bill")
        test.call(100, 200)

        def d = bill(20, 30)
        println d

        my(100)
    }

    // 2.闭包
    // 闭包作为一种特殊的数据类型而存在，闭包可以作为方法的参数和返回值，
    // 也可以作为一个变量而存在。

    static def closure = { int a, String b ->
        println "a = ${a}, b=${b}, i am a smart closure!!!"
    }

    // 这里省略了闭包的参数类型
    static def test = { a, b ->
        println "a = ${a}, b=${b}, i am a smart closure without type!!!"
    }

    static def bill = { a, b ->
        a + b
    }

    // 如果闭包不指定参数，那么它会有一个隐含的参数 it
    static def my = {
        println "find it = ${it}, i am another it!!!"
    }
}
