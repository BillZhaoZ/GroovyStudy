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
