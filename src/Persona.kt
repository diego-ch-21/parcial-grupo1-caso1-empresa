package main
import Gender

open class Persona(nombre:String, apellidos:String, fechaNacimiento: String, sexo: Gender){
    var nombre: String
    var apellidos: String
    var fechaNacimiento: String
    var sexo: Gender

    init{
        this.nombre=nombre
        this.apellidos=apellidos
        this.fechaNacimiento=fechaNacimiento
        this.sexo  =sexo
    }
}
