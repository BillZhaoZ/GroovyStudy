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

        // 2.遍历1
        def file = new File("a.txt")
        println "read file using two parameters"

        file.eachLine { line, lineNo ->
            println "${lineNo} ${line}"
        }

        // 3.遍历2
        println "read file using one parameters"

        file.eachLine { line ->
            println "${line}"
        }

        // 4.遍历3
        def test4 = ["id": 100, "name": "Bill", "isMale": true]
        test4["id"] = 2 // id改成2
        test4.id = 900  // id改成900

        println test4.id
        println test4.isMale
        println test4.name
    }

}
