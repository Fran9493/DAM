fun main(){
    
    var numEntrada: Int
    
    println("¿Cómo es el clima de hoy?")
    numEntrada = readln().toInt()

    when(numEntrada){

        1 -> println("Soleado")
        2 -> println("Nublado")
        3 -> println("Lluvioso")
        4 -> println("Tormentoso")
        5 -> println("Nevado")
        else -> println("Pregúntale a Google")

    }

}