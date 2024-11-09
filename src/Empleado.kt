

class Empleado: Persona{
    val SUELDOMINIMO=1025

    var sueldoBruto: Int=0
        get()=field
        set(valor: Int){
            if(valor>1025){
                field=valor
            }
            else{
                println("El valor debe ser mayor al sueldo minimo ($SUELDOMINIMO), se le asignará este")
                field=SUELDOMINIMO
            }
        }
    var categoria: String?=null
    var superior: Empleado?=null
    var subordinados: MutableList<Empleado> = mutableListOf()


    constructor(nombre: String, apellidos: String, fechaNacimiento: Fecha, sexo: Gender, sueldoBruto: Int, categoria: String?):
            super(nombre, apellidos,fechaNacimiento, sexo){
        this.sueldoBruto=sueldoBruto
        this.categoria=categoria
    }

    override fun toString(): String {
        if(categoria.isNullOrEmpty()){
            return super.toString() + ", Sueldo Bruto: $sueldoBruto"
        }
        else{
            return super.toString() + ", Sueldo Bruto: $sueldoBruto, Categoria: $categoria"
        }
    }


}