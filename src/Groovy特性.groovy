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
