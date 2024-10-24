package main
import Gender

class Cliente: Persona {
    private var telefono: Int

    constructor(nombre:String, apellidos:String, fechaNacimiento: String, sexo: Gender,telefono: Int):
            super(nombre,apellidos,fechaNacimiento,sexo){
        this.telefono=telefono
    }

    fun getTelefono(): String = telefono.toString()
    fun getSexoString(): String = sexo.name
}
