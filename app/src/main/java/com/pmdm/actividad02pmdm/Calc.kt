package com.pmdm.actividad02pmdm

/**
 * En la clase @calc vamos a realizar las diferentes operaciones disponibles en la calculadora.
 */
class Calc(private val n1: Double, private val n2: Double){
    fun operation(operator: String): Double {
        /**
         * Dentro del método @operation de la clase @calc pondremos los
         * diferentes cálculos que la calculadora podrá realizar. Usando el @return when
         * para devolver el resultado de las diferentes operaciones en base al caracter
         * que contenga la variable @op.
         */
        return when (operator) {
            "+" -> n1 + n2 // Operación suma
            "-" -> n1 - n2 // Operación resta
            "*" -> n1 * n2 // Operación multiplicación
            "/" -> n1 / n2 // Operación división
            else -> throw IllegalArgumentException("Operador no válido: $operator")
        }
    }
}


