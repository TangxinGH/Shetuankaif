package POJO

fun dao() {
    println("this is dao ")
}

class Department {
    var id: Long = 0
    var departmentName: String? = null

    override fun toString(): String {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}'
    }
}