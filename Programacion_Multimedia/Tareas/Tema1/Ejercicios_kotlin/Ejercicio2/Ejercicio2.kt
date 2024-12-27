fun main(){

    var numero: Int = 5
    var sumatoriaFor: Int = 0

    for(i in 1..numero){

        sumatoriaFor += i

    }

    println("La sumatoria con el bucle for es: $sumatoriaFor")

    var contador: Int = 1
    var sumatoriaWhile: Int = 0

    while(contador <= numero){

        sumatoriaWhile += contador
        contador++

    }

    println("La sumatoria con el bucle while es: $sumatoriaWhile")

}

