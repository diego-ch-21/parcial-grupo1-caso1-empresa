import java.util.Scanner

class DemoMenu {
    private val empresas = mutableListOf<Empresa>()
    private val clientes = mutableListOf<Cliente>()
    private var empresaSeleccionada: Empresa? = null
    private val scanner = Scanner(System.`in`)

    fun start() {
        var option: Int
        do {
            clearConsole()
            println("\n------ Menú Principal ------")
            println("1. Crear Empresa")
            println("2. Seleccionar Empresa")
            println("3. Crear Cliente Independiente")
            println("4. Mostrar Clientes Independientes")
            println("5. Salir")
            print("Seleccione una opción:")

            option = scanner.nextInt()
            scanner.nextLine() // Limpia el buffer

            when (option) {
                1 -> crearEmpresa()
                2 -> seleccionarEmpresa()
                3 -> agregarClienteIndependiente()
                4 -> mostrarClientesIndependientes()
                5 -> println("Saliendo del programa...")
                else -> println("Opción no válida, intente de nuevo.")
            }
        } while (option != 5)
    }

    private fun crearEmpresa() {
        clearConsole()
        println("\n-- Crear Empresa --")
        print("Nombre de la Empresa: ")
        val nombre = scanner.nextLine()
        val nuevaEmpresa = Empresa(nombre)
        empresas.add(nuevaEmpresa)
        empresaSeleccionada = nuevaEmpresa
        println("Empresa '$nombre' creada con éxito y seleccionada.")
    }

    private fun seleccionarEmpresa() {
        clearConsole()
        if (empresas.isEmpty()) {
            println("No hay empresas creadas.")
            return
        }

        println("\n-- Seleccionar Empresa --")
        empresas.forEachIndexed { index, empresa ->
            println("${index + 1}. ${empresa.nombre}")
        }
        print("Seleccione el número de la empresa:")

        val seleccion = scanner.nextInt()
        scanner.nextLine() // Limpia el buffer
        if (seleccion in 1..empresas.size) {
            empresaSeleccionada = empresas[seleccion - 1]
            println("Empresa '${empresaSeleccionada?.nombre}' seleccionada.")
            subMenuEmpresa()
        } else {
            println("Selección no válida.")
        }
    }

    private fun subMenuEmpresa() {
        var option: Int
        do {
            clearConsole()
            println("\n------ Menú de Empresa (${empresaSeleccionada?.nombre}) ------")
            println("1. Agregar Empleado")
            println("2. Agregar Cliente")
            println("3. Mostrar Empleados")
            println("4. Mostrar Clientes")
            println("5. Agregar Subordinado")
            println("6. Mostrar Información de la Empresa")
            println("7. Volver al Menú Principal")
            print("Seleccione una opción:")

            option = scanner.nextInt()
            scanner.nextLine() // Limpia el buffer

            when (option) {
                1 -> agregarEmpleado()
                2 -> agregarCliente()
                3 -> empresaSeleccionada?.mostrarEmpleados()
                4 -> empresaSeleccionada?.mostrarClientes()
                5 -> agregarSubordinado()
                6 -> println(empresaSeleccionada.toString())
                7 -> println("Volviendo al Menú Principal...")
                else -> println("Opción no válida, intente de nuevo.")
            }
            if (option != 7) waitForEnter()
        } while (option != 7)
    }

    private fun agregarEmpleado() {
        clearConsole()
        println("\n-- Agregar Empleado --")
        print("Nombre: ")
        val nombre = scanner.nextLine()
        print("Apellidos: ")
        val apellidos = scanner.nextLine()
        print("Fecha de Nacimiento (dd mm yyyy): ")
        val dia = scanner.nextInt()
        val mes = scanner.nextInt()
        val año = scanner.nextInt()
        val fecha = Fecha(dia, mes, año)
        print("Sexo (MASCULINO/FEMENINO): ")
        val sexo = Gender.valueOf(scanner.next().uppercase())
        print("Sueldo Bruto: ")
        val sueldoBruto = scanner.nextInt()
        scanner.nextLine() // Limpia el buffer
        print("Categoría (opcional): ")
        val categoria = scanner.nextLine().ifBlank { null }

        empresaSeleccionada?.agregarEmpleado(nombre, apellidos, fecha, sexo, sueldoBruto, categoria)?.let {
            println("Empleado agregado: $it")
        }
    }

    private fun agregarCliente() {
        clearConsole()
        println("\n-- Agregar Cliente a Empresa --")
        println("1. Crear nuevo cliente")
        println("2. Agregar cliente existente")
        print("Seleccione una opción: ")
        val opcion = scanner.nextInt()
        scanner.nextLine() // Limpia el buffer

        when (opcion) {
            1 -> {
                // Crear un cliente nuevo y agregarlo a la empresa
                val clienteNuevo = crearCliente()
                empresaSeleccionada?.agregarCliente(clienteNuevo)
                println("Cliente agregado a la empresa: $clienteNuevo")
            }
            2 -> {
                // Agregar un cliente existente a la empresa
                if (clientes.isEmpty()) {
                    println("No hay clientes independientes disponibles para agregar.")
                    return
                }

                println("\nSeleccione el cliente que desea agregar a la empresa:")
                clientes.forEachIndexed { index, cliente ->
                    println("${index + 1}. $cliente")
                }
                print("Ingrese el número del cliente: ")
                val clienteIndex = scanner.nextInt()
                scanner.nextLine() // Limpia el buffer

                if (clienteIndex in 1..clientes.size) {
                    val clienteExistente = clientes[clienteIndex - 1]
                    empresaSeleccionada?.agregarCliente(clienteExistente)
                    println("Cliente existente agregado a la empresa: $clienteExistente")
                } else {
                    println("Selección no válida.")
                }
            }
            else -> println("Opción no válida.")
        }
    }

    private fun agregarClienteIndependiente() {
        clearConsole()
        println("\n-- Crear Cliente Independiente --")
        val cliente = crearCliente()
        clientes.add(cliente)
        println("Cliente independiente agregado: $cliente")
    }

    private fun mostrarClientesIndependientes() {
        clearConsole()
        println("\n-- Clientes Independientes --")
        if (clientes.isEmpty()) {
            println("No hay clientes independientes.")
        } else {
            clientes.forEach { println(it) }
        }
        waitForEnter()
    }

    private fun agregarSubordinado() {
        clearConsole()
        empresaSeleccionada?.mostrarEmpleados()
        print("Ingrese el índice del directivo:")
        val indiceDirectivo = scanner.nextInt()
        print("Ingrese el índice del subordinado:")
        val indiceSubordinado = scanner.nextInt()
        scanner.nextLine() // Limpia el buffer

        if (indiceDirectivo in empresaSeleccionada!!.empleados.indices && indiceSubordinado in empresaSeleccionada!!.empleados.indices) {
            val directivo = empresaSeleccionada!!.empleados[indiceDirectivo]
            val subordinado = empresaSeleccionada!!.empleados[indiceSubordinado]
            empresaSeleccionada?.agregarSubordinado(directivo, subordinado)
            println("Subordinado agregado correctamente.")
        } else {
            println("Índices no válidos.")
        }
    }

    private fun crearCliente(): Cliente {
        print("Nombre: ")
        val nombre = scanner.nextLine()
        print("Apellidos: ")
        val apellidos = scanner.nextLine()
        print("Fecha de Nacimiento (dd mm yyyy): ")
        val dia = scanner.nextInt()
        val mes = scanner.nextInt()
        val año = scanner.nextInt()
        val fecha = Fecha(dia, mes, año)
        print("Sexo (MASCULINO/FEMENINO): ")
        val sexo = Gender.valueOf(scanner.next().uppercase())
        print("Teléfono: ")
        val telefono = scanner.nextInt()
        scanner.nextLine() // Limpia el buffer
        return Cliente(nombre, apellidos, fecha, sexo, telefono)
    }

    fun clearConsole() {
        try {
            Runtime.getRuntime().exec("cls")
        } catch (e: Exception) {
            repeat(25) { println() } // En caso de que el comando no funcione
        }
    }

    private fun waitForEnter() {
        println("\nPresiona Enter para continuar...")
        scanner.nextLine()
    }
}

fun main() {
    val mainMenu = DemoMenu()
    mainMenu.start()
}