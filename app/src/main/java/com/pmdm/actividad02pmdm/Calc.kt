package com.pmdm.actividad02pmdm

/**
 * En la clase @calc vamos a realizar las diferentes operaciones disponibles en la calculadora.
 */
class Calc (val n1:Double, val n2:Double, val op:String){
    fun operation(op:String):Double{
        /**
         * Dentro del método @operation de la clase @calc pondremos los
         * diferentes cálculos que la calculadora podrá realizar. Usando el @return when
         * para devolver el resultado de las diferentes operaciones en base al caracter
         * que contenga la variable @op.
         */
        return when (op) {
            "+" -> {(n1 + n2)} // Operación suma
            "-" -> {(n1 - n2)} // Operación resta
            "*" -> {(n1 * n2)} // Operación Multiplicación
            "/" -> {(n1 / n2)} // Operación División
            else -> 0.0
        }
    }
}