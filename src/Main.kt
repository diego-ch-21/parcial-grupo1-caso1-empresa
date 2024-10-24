package main
import Empresa
import Gender
// Ejemplo de uso
fun main() {
    // Creación de una empresa
    val empresa = Empresa("Edu-Read")

    // Creación de empleados y directivos
    val empleado1 = Empleado("Juan", "Pérez", "1985-10-10", Gender.MASCULINO, 2500.00,"subordinado")
    val empleado2 = Empleado("David", "Fernandez", "2001-03-22", Gender.MASCULINO, 1800.50,"subordinado")
    val directivo1= Empleado("Diego", "Cuchillo", "2002-07-11", Gender.MASCULINO, 8000.00, "directivo")

    // Agregar empleados y directivos a la empresa
    empresa.agregarEmpleado(empleado1)
    empresa.agregarEmpleado(empleado2)
    empresa.agregarEmpleado(directivo1)

    // Agregar subordinados al directivo
    directivo1.agregarSubordinado(empleado1)
    directivo1.agregarSubordinado(empleado2)

    // Agregar directivo a empleado
    empleado1.agregarDirectivo(directivo1)
    empleado1.agregarDirectivo(directivo1)

    // Creación de clientes
    val cliente1 = Cliente("Carlos", "Martínez", "1980-12-02", Gender.MASCULINO, 987654321)
    val cliente2 = Cliente("Laura", "Fernández", "1995-07-15", Gender.FEMENINO, 912345678)

    // Agregar clientes a la empresa
    empresa.agregarCliente(cliente1)
    empresa.agregarCliente(cliente2)

    // Mostrar datos de la empresa
    print(empresa.mostrarEmpresa())
    // Mostrar datos de empleados
    print(empresa.mostrarPersonal())
    //Mostrar datos de clientes
    print(empresa.mostrarClientes())

}