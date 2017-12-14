/**
 * 在Groovy中，文件访问要比Java简单的多，不管是普通文件还是xml文件
 */
class 加强的IO {

    static main(args) {

        // 1. 读文件  双参数
        def file = new File("a.txt")
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
