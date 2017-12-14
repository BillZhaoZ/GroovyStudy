/**
 * 其他特性
 */
class Groovy特性 {

    static main(args) {

        // 在Groovy中，所有的Class类型，都可以省略.class
        func(File.class)
        func(File)

        // 在Groovy中，当对同一个对象进行操作时，可以使用with
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
