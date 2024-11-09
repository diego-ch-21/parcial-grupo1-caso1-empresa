
class Cliente:Persona {
    var telefono: Int=0
        get()=field
        set(valor: Int){
            if(valor>=900000000 && valor<=999999999){
                field=valor
            }
            else{
                println("El telefono debe estar en el rango de 9 digitos, se le asignará el 987654321")
                field=987654321
            }
        }
    constructor(nombre: String, apellidos: String, fechaNacimiento: Fecha, sexo: Gender, telefono: Int):
            super(nombre, apellidos,fechaNacimiento, sexo){
        this.telefono=telefono
    }

    override fun toString(): String {
        return super.toString() + ", Numero de Telefono: $telefono"
    }
}
