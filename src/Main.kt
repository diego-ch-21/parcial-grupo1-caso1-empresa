

fun main(){
    var fecha=Fecha(7,-4,2023)
    println(fecha.toString())

    var p1=Persona("David", "Fernandez", fecha, Gender.MASCULINO)
    println(p1.toString())

    var e1=Empleado("Diego", "Cuchillo", fecha, Gender.FEMENINO, 500, "Gerente Ventas")
    println(e1.toString())

    var c1=Cliente("Juana", "De Arco", fecha, Gender.FEMENINO, 98987)
    println(c1.toString())

    var c2=Cliente("Mario", "Bros", fecha, Gender.MASCULINO, 984596321)

    var empresa= Empresa("Domotic")
    println(empresa.toString())

    var e2=empresa.agregarEmpleado("Emma", "Watson", Fecha(8,12,2001),
        Gender.MASCULINO, 1000, "Gerente Tecnico")
    println(e2.toString())

    var e3 = empresa.agregarEmpleado("John", "Doe", Fecha(10, 10, 2000),
        Gender.MASCULINO, 800, "Asistente")

    var e4 = empresa.agregarEmpleado("Alice", "Johnson", Fecha(15, 5, 1995),
        Gender.FEMENINO, 1200, "Analista de Datos")

    var e5 = empresa.agregarEmpleado("Robert", "Smith", Fecha(22, 3, 1988),
        Gender.MASCULINO, 950)

    var e6 = empresa.agregarEmpleado("Laura", "Martinez", Fecha(30, 7, 1980),
        Gender.FEMENINO, 2000, "Directora de Finanzas")

    println("------")
    empresa.agregarSubordinado(e2,e3)
    empresa.agregarSubordinado(e2,e5)
    empresa.agregarSubordinado(e3,e6)
    empresa.mostrarEmpleados()
    println("Superior de e2: ${e3.superior}")
    println("------")
    empresa.agregarCliente(c1)
    empresa.agregarCliente(c2)
    empresa.mostrarClientes()
    println("------")
    println(empresa.toString())
}