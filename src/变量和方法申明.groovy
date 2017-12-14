/**
 * 变量和方法申明
 *
 * 在Groovy中，很多东西都是可以省略的，比如
 * 语句后面的分号是可以省略的
 * 变量的类型和方法的返回值也是可以省略的
 * 方法调用时，括号也是可以省略的
 * 甚至语句中的return都是可以省略的
 */
class 变量和方法申明 {

    def a = 1
    static def b = "hello world from me!!!"
    int c = 1

    static void main(args) {

        // 调用下方的Hello
        hello(b)
        hello()
    }

    static def hello(String msg) {
        println(msg)
        return 1
    }

    static def hello() {
        println("have nothing to say!!!")
        return 1
    }
}
