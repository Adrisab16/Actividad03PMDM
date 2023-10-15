package com.pmdm.actividad02pmdm

/**
 * En la clase @calc vamos a realizar las diferentes operaciones disponibles en la calculadora.
 */
class Calc (val n1:Int, val n2:Int, val op:String){
    fun operation(op:String):Int{
        /**
         * Dentro del método @operation de la clase @calc pondremos los
         * diferentes cálculos que la calculadora podrá realizar. Usando el @return when
         * para devolver el resultado de las diferentes operaciones en base al caracter
         * que contenga la variable @op.
         */
        return when (op) {
            "+" -> {(n1 + n2).toInt()} // Operación suma
            "-" -> {(n1 - n2).toInt()} // Operación resta
            "*" -> {(n1 * n2).toInt()} // Operación Multiplicación
            "/" -> {(n1 / n2).toInt()} // Operación División
            else -> 0
        }
    }
}