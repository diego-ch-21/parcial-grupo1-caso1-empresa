

open class Persona constructor(nombre: String, apellidos: String, fechaNacimiento: Fecha, sexo: Gender ){
    var nombre:String
    var apellidos:String
    var fechaNacimiento: Fecha
    var sexo:Gender

    init{
        this.nombre=nombre
        this.apellidos=apellidos
        this.fechaNacimiento=fechaNacimiento
        this.sexo=sexo
    }

    override fun toString():String{
        return "Nombre: $nombre, Apellidos: $apellidos, Fecha de Nacimiento: ${fechaNacimiento.toString()}, Sexo: $sexo"
    }

}