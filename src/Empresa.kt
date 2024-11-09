
class Empresa {
    var nombre:String
    var empleados: MutableList<Empleado>
    var clientes: MutableList<Cliente> = mutableListOf()
    constructor(nombre:String){
        this.nombre=nombre
        this.empleados= mutableListOf()
    }

    fun agregarEmpleado(nombre: String, apellidos: String, fechaNacimiento: Fecha,
                        sexo: Gender, sueldoBruto: Int, categoria: String?=null): Empleado {
        val empleado = Empleado(nombre, apellidos, fechaNacimiento, sexo, sueldoBruto, categoria)
        empleados.add(empleado)
        return empleado
    }

    fun agregarCliente (cliente: Cliente){
        clientes.add(cliente)
    }

    fun agregarSubordinado(directivo: Empleado, subordinado: Empleado) {
        if (empleados.contains(directivo) && empleados.contains(subordinado)) {
            directivo.subordinados.add(subordinado)
            subordinado.superior=directivo
        } else {
            println("Error: Ambos empleados deben pertenecer a la empresa para asignar subordinados.")
        }
    }

    fun mostrarEmpleados() {
        println("Empleados en la empresa $nombre:")
        empleados.forEach { empleado ->
            println(empleado.toString())
        }
    }

    fun mostrarClientes(){
        println("Clientes de la empresa $nombre")
        clientes.forEach{ cliente ->
            println(cliente.toString())

        }
    }

    override fun toString(): String {
        val separator = "-".repeat(60)
        val sb = StringBuilder()

        with(sb) {
            append("Empresa: $nombre\n")
            append(separator).append("\n")
            append("Lista de empleados:\n")

            empleados.forEach { empleado ->
                append("  - ${empleado.nombre} ${empleado.apellidos}")
                empleado.categoria?.let { append(", Categoria: $it") }
                append("\n")

                if (empleado.subordinados.isNotEmpty()) {
                    append("    Subordinados:\n")
                    empleado.subordinados.forEach { subordinado ->
                        append("      * ${subordinado.nombre} ${subordinado.apellidos}")
                        subordinado.categoria?.let { append(" (Categoria: $it)") }
                        append("\n")
                    }
                }
            }

            if (clientes.isNotEmpty()) {
                append(separator).append("\n")
                append("Lista de Clientes:\n")
                clientes.forEach { cliente ->
                    append("  - ${cliente.nombre} ${cliente.apellidos}\n")
                }
            }

            append(separator)
        }
        return sb.toString()
    }

}