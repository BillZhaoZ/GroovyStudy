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

6、特性
    
    /**
     * 其他特性
     */
    class Groovy特性 {
    
        static main(args) {
    
            // 1、在Groovy中，所有的Class类型，都可以省略.class
            func(File.class)
            func(File)
    
            // 2、在Groovy中，当对同一个对象进行操作时，可以使用with
            Book bk = new Book()
            bk.id = 1
            bk.name = "android art"
            bk.press = "china press"
    
            //可以简写为：
            Book bk2 = new Book()
            bk2.with {
                id = 1
                name = "android art"
                press = "china press"
            }
    
            // 3.判断是否为真
            if (bk.name != null && bk.name.length > 0) {
            }
    
            // 可以替换为：
            if (bk.name) {
            }
    
            // 4.简介的三元表达式
            def result = bk.name != null ? bk.name : "Unknown"
    
            // 省略了name
            def result2 = bk.name ?: "Unknown"
    
            // 5.简洁的非空判断   在Groovy中，非空判断可以用?表达式
            /*if (order != null) {
                if (order.getCustomer() != null) {
                    if (order.getCustomer().getAddress() != null) {
                        System.out.println(order.getCustomer().getAddress())
                    }
                }
            }
    
            //可以简写为：
            println order?.customer?.address*/
    
            // 7.switch方法  在Groovy中，switch方法变得更加灵活，可以同时支持更多的参数类型：
            def x = 1.23
            def result3 = ""
    
            switch (x) {
    
                case "foo": result3 = "found foo"
    
            // lets fall through
                case "bar": result3 += "bar"
    
            // lets fall through
                case [4, 5, 6, 'inList']:
                    result3 = "list"
                    break
    
                case 12..30:
                    result3 = "range"
                    break
    
                case Integer:
                    result3 = "integer"
                    break
    
                case Number:
                    result3 = "number"
                    break
    
                case { it > 3 }:
                    result3 = "number > 3"
                    break
    
                default:
                    result3 = "default"
            }
    
            assert result == "number"
    
            // 8. ==和equals
            // 在Groovy中，==相当于Java的equals（内容是否相同）
            // 如果需要比较对个对象是否是同一个，需要使用.is()。
            Object a = new Object()
            Object b = a.clone()
            
            assert a == b
            assert !a.is(b)
        }
    
        // 6.断言  在Groovy中，可以使用assert来设置断言，当断言的条件为false时，程序将会抛出异常：
        def check(String name3) {
            // name non-null and non-empty according to Groovy Truth
            assert name3
    
            // safe navigation + Groovy Truth to check
            assert name3?.size() > 3
        }
    
        // Class是一等公民
        static def func(Class clazz) {
            println "打印我啦"
        }
    
        // 在Groovy中，Getter/Setter和属性是默认关联的，比如：
        static class Book {
    
            private String name
            private String press
            private int id
    
            String getPress() {
                return press
            }
    
            void setPress(String press) {
                this.press = press
            }
    
            int getId() {
                return id
            }
    
            void setId(int id) {
                this.id = id
            }
    
            String getName() { return name }
    
            void setName(String name) { this.name = name }
        }
    
    
        class Book2 {
            String name
        }
    }

    
    
    