
import java.util.Calendar
class Fecha(dia: Int, mes:Int, año: Int){
    var dia: Int=1
        get()=field
        set(valor: Int){
            if(valor>=1 && valor<=31){
                field=valor
            }
            else{
                println("El dia debe estar en el rango 1-31, se le asignará el dia número 1")
                field=1
            }
        }
    var mes: Int=1
        get()=field
        set(valor: Int){
            if(valor>=1 && valor<=12){
                field=valor
            }
            else{
                println("El mes debe estar en el rango 1-12, se le asignará el mes número 1")
            }
        }

    var año: Int=1980
        get()=field
        set(valor: Int){
            if(valor>=1900 && valor<=(Calendar.getInstance().get(Calendar.YEAR)-18)){
                field=valor
            }
            else{
                println("El año debe estar en el rango 1900-${Calendar.getInstance().get(Calendar.YEAR)-18}," +
                        "se le asignará el año por 1980")
            }
        }

    init{
        this.dia=dia
        this.mes=mes
        this.año=año
    }

    override fun toString():String{
        return "$dia/$mes/$año"
    }

}