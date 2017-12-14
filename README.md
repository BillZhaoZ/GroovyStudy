# GroovyStudy

groovy 语言学习

1.变量和方法声明
    
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


2.数据类型
    
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


3.集合
    
    /**
     * 遍历
     */
    class 集合 {
    
        static void main(args) {
    
            // 1.遍历
            def test = [100, "hello", true]
            test[1] = "world" // 下标为1的元素 更改为world
    
            println test[0] // 打印下表为0的元素
            println test[1] // 打印下表为1的元素
            test << 200     // 集合最后插入一个元素200
            println "集合大小为: ${test.size}" // 打印集合大小
    
            test.each { line ->
                println "集合的内容如下:${line}"
            }
    
            // 2.遍历2
            def test4 = ["id": 100, "name": "Bill", "isMale": true]
            test4["id"] = 2 // id改成2
            test4.id = 900  // id改成900
    
            println test4.id
            println test4.isMale
            println test4.name
        }
    
    }


4.加强的IO
    
    /**
     * 在Groovy中，文件访问要比Java简单的多，不管是普通文件还是xml文件
     */
    class 加强的IO {
    
        static main(args) {
    
            // 1. 读文件  双参数
            def file = new File("test.txt")
            println "read file using two parameters"
    
            file.eachLine { line, lineNo ->
                println "${lineNo} ${line}"
            }
    
            // 2.  单个参数
            println "read file using one parameters"
    
            file.eachLine { line ->
                println "${line}"
            }
        }
    }


5.访问XML文件
    
    /**
     * Groovy访问xml有两个类：XmlParser和XmlSlurper，二者几乎一样，在性能上有细微的差别，
     * 如果大家感兴趣可以从文档上去了解细节，不过这对于本文不重要。
     * 在下面的链接中找到XmlParser的API文档，参照例子即可编程，
     * http://docs.groovy-lang.org/docs/latest/html/a
     */
    class 访问XML {
    
        static main(args) {
    
            def xml = new XmlParser().parse(new File("attrs.xml"))
            // 访问declare-styleable节点的name属性
            println xml['declare-styleable'].@name[0]
    
            // 访问declare-styleable的第2个子节点的内容
            println xml['declare-styleable'].attr[1].text()
    
            // 访问declare-styleable的第三个子节点的内容
            println xml['declare-styleable'].attr[2].text()
        }
    }
