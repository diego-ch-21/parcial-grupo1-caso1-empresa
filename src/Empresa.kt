import main.Cliente
import main.Empleado

class Empresa(var nombre: String) {
    private var empleados: MutableList<Empleado> = mutableListOf()
    private var clientes: MutableList<Cliente> = mutableListOf()

    fun agregarEmpleado(empleado: Empleado) {
        this.empleados.add(empleado)
    }

    fun agregarCliente(cliente: Cliente) {
        this.clientes.add(cliente)
    }

    fun mostrarEmpresa(): String {
        return "1. Nombre de la Empresa: $nombre\n"
    }
    fun mostrarPersonal(): String {
        val sb = StringBuilder()
        sb.append("3. Empleados de la empresa $nombre:\n")
        this.empleados.forEach { empleado ->
            sb.append(" - ${empleado.nombre} ${empleado.apellidos}, Sueldo Bruto: ${empleado.getSueldoBruto()}")
            if (empleado.getCategoria() != null) {
                sb.append(", Categoría: ${empleado.getCategoria()}")
            }
            sb.append("\n")
            if (empleado.getSubordinados().isNotEmpty()) {
                sb.append("   Subordinados:\n")
                empleado.getSubordinados().forEach { sub ->
                    sb.append("   -  ${sub.nombre} ${sub.apellidos}, Sueldo Bruto: ${sub.getSueldoBruto()}, sexo: ${sub.getSexoString()}\n")
                }
            }
        }
        return sb.toString()
    }

    fun mostrarClientes(): String {
        val sb = StringBuilder()
        sb.append("2. Clientes de la empresa $nombre:\n")
        this.clientes.forEach { cliente ->
            sb.append(" - Nombre: ${cliente.nombre}, Apellidos: ${cliente.apellidos}, Teléfono: ${cliente.getTelefono()}, sexo: ${cliente.getSexoString()}\n")
        }
        return sb.toString()
    }
}