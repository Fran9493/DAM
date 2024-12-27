fun main() {

    //ejercicio1()
    ejercicio12()
    
}

fun ejercicio1(){

    var distanciaConductor: Double
    var disponibilidad: Boolean = false
    var salida: String

    println("Introduce la distancia del conductor:")
    distanciaConductor = readln().toDouble()

    println("¿Está disponible? (s/n):")
    var disponibilidadCadena = readln().toString()

    if (disponibilidadCadena.equals("s")) {

        disponibilidad = true
    } else if (disponibilidadCadena.equals("n")) {

        disponibilidad = false
    }

    salida = llamaUber(distanciaConductor, disponibilidad)
    println(salida)

}

fun ejercicio12(){

    var distanciaConductor: Double
    var disponibilidad: Boolean = false
    var salida: String

    

    do{

        println("Introduce la distancia del conductor:")
        distanciaConductor = readln().toDouble()

        println("¿Está disponible? (s/n):")
        var disponibilidadCadena = readln().toString()

        if (disponibilidadCadena.equals("s")) {

            disponibilidad = true
        } else if (disponibilidadCadena.equals("n")) {

            disponibilidad = false
        }

        salida = llamaUber(distanciaConductor, disponibilidad)

    } while (salida != "Listo para iniciar recorrido")

    
    println(salida)

}

fun llamaUber(distanciaConductor: Double, disponibilidad: Boolean): String {

    var salida: String = "Error"

    if (distanciaConductor <= 0.5 && disponibilidad) {

        salida = "Listo para iniciar recorrido"
    } else if (distanciaConductor <= 0.5 && !disponibilidad) {

        salida = "Conductor cercano pero no disponible"
    } else if (distanciaConductor > 0.5 && disponibilidad) {

        salida = "Conductor disponible pero muy lejos, tarifas especiales"
    } else if (distanciaConductor > 0.5 && !disponibilidad) {

        salida = "No hay conductores disponibles"
    }

    return salida
}
