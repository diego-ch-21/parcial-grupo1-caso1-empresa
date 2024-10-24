package main
import Gender
import Empresa

class Empleado: Persona {
    private var sueldoBruto: Double
    private var categoria: String
    private var directivo: Empleado?=null
    private var subordinados: MutableList<Empleado> = mutableListOf()
    private var empresa: Empresa?=null

    constructor(nombre:String, apellidos:String, fechaNacimiento: String, sexo: Gender, sueldoBruto: Double, categoria:String):
            super(nombre, apellidos, fechaNacimiento, sexo){
        this.sueldoBruto=sueldoBruto
        this.categoria=categoria
    }

    fun agregarSubordinado(empleado: Empleado) {
        this.subordinados.add(empleado)
    }
    fun agregarDirectivo(directivo: Empleado) {
        this.directivo= directivo
    }

    fun getCategoria(): String? = categoria
    fun getSueldoBruto(): Double = sueldoBruto
    fun getSubordinados(): List<Empleado> = subordinados
    fun setEmpresa(empresa: Empresa) {
        this.empresa = empresa
    }
    fun getSexoString(): String = sexo.name

}