/**
 * 遍历
 */
class 集合遍历 {

    static void main(args) {

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
    }

}
