package com.pmdm.actividad02pmdm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.pmdm.actividad02pmdm.R.*

/**
 * En el @MainActivity tendremos el grueso de nuestro
 * código, empezando con un @override del método @onCreate
 */
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val mainbox = findViewById<TextView>(id.mainbox)
        val detailbox = findViewById<TextView>(id.detailbox)

        /**
         * A continuación, explicaré las variables que usaré
         * para el funcionamiento de mi calculadora:
         *
         * @param n1 es la variable que contendra el primer número de la operación.
         *
         * @param n2 es la variable que contendrá el segundo número de la operación.
         *
         * @param output es la variable que contendrá el resultado de la operación, así
         * como la operación en sí.
         *
         * @param operator variable que nos dará la operación a realizar, es decir, el simbolo.
         *
         * @param calc es el objeto de la clase Calc en la que vamos a
         * obtener los datos para usar su método @operation.
         *
         * @see Calc para obtener una información más
         * detallada sobre la realización de los calculos.
         */

        // Variables Calculadora:

        var n1 = 0.0
        var n2: Double
        var output = ""
        var operator= ""
        var calc: Calc

        /**
         * Botones de números del 1 al 9 y incluyendo el 0:
         */
        val button1 = findViewById<Button>(id.buttonN1)
        button1.setOnClickListener{
            output+="1" // Se añade el valor indicado a la variable output
            mainbox.text = output}// Se añade el valor a la visibilidad del TextView principal
        val button2 = findViewById<Button>(id.buttonN2)
        button2.setOnClickListener{
            output+="2"
            mainbox.text = output}
        val button3 = findViewById<Button>(id.buttonN3)
        button3.setOnClickListener {
            output += "3"
            mainbox.text = output}
        val button4 = findViewById<Button>(id.buttonN4)
        button4.setOnClickListener{
            output+="4"
            mainbox.text = output}
        val button5 = findViewById<Button>(id.buttonN5)
        button5.setOnClickListener{
            output+="5"
            mainbox.text = output}
        val button6 = findViewById<Button>(id.buttonN6)
        button6.setOnClickListener{
            output+="6"
            mainbox.text = output}
        val button7 = findViewById<Button>(id.buttonN7)
        button7.setOnClickListener{
            output+="7"
            mainbox.text = output}
        val button8 = findViewById<Button>(id.buttonN8)
        button8.setOnClickListener {
            output += "8"
            mainbox.text = output}
        val button9 = findViewById<Button>(id.buttonN9)
        button9.setOnClickListener{
            output+="9"
            mainbox.text = output}
        val button0 = findViewById<Button>(id.buttonN0)
        button0.setOnClickListener{
            output+="0"
            mainbox.text = output}

        /**
         * Botón punto:
         *
         * Simplemente añade un punto para operaciones con decimales
         */

        val buttonPoint = findViewById<Button>(id.buttonOpPoint)
        buttonPoint.setOnClickListener{
            output+="."
            mainbox.text = output}

        /**
         * Botón de suma:
         *
         * Si el operator está vacio pondremos el simbolo "+" para pasar a la
         * segunda parte de la operacion, si además de estar vacio, el valor
         * de n1 es 0, lo añadiremos al output. En caso de no estar el valor
         * del operator vacio, quiere decir que es una operación concatenada,
         * en la que n1 ya tendrá el valor de la anterior operación, solamente
         * cambiaremos de simbolo a la variable operator.
         *
         * Luego, añadimos una condición para evitar errores, si el operator ya
         * es el mismo que ya estaba, no se altera, por lo que al pulsar varias
         * veces el mismo boton, no da errores, simplemente se queda como está.
         *
         * A continuación, añadimos una condición para evitar otro error, en
         * este caso se trata de si el operator ya tiene un simbolo diferente
         * al de este botón, al pulsar este boton se va a cambiar de simbolo
         * al de este botón, así evitamos que si se pulsan dos botones de
         * operación seguidos de un error.
         *
         * Al final vaciaremos el
         * output para poder dejar paso a la segunda parte de la operación.
         */

        val buttonsum = findViewById<Button>(id.buttonOpSum)
        buttonsum.setOnClickListener {
            when {
                operator.isEmpty() -> {
                    operator = "+"
                    if (n1 == 0.0) {n1 = output.toDouble()}
                }
                operator == "+" -> {operator = "+"}
                operator.isNotEmpty() && operator != "+" -> {operator = "+"}
                else -> {
                    n1 = output.toDouble()
                    operator = "+"
                }
            }
            output = ""
        }

        /**
         * Botón de resta:
         *
         * Si el operator está vacio pondremos el simbolo "-" para pasar a la
         * segunda parte de la operacion, si además de estar vacio, el valor
         * de n1 es 0, lo añadiremos al output. En caso de no estar el valor
         * del operator vacio, quiere decir que es una operación concatenada,
         * en la que n1 ya tendrá el valor de la anterior operación, solamente
         * cambiaremos de simbolo a la variable operator.
         *
         * Luego, añadimos una condición para evitar errores, si el operator ya
         * es el mismo que ya estaba, no se altera, por lo que al pulsar varias
         * veces el mismo boton, no da errores, simplemente se queda como está.
         *
         * A continuación, añadimos una condición para evitar otro error, en
         * este caso se trata de si el operator ya tiene un simbolo diferente
         * al de este botón, al pulsar este boton se va a cambiar de simbolo
         * al de este botón, así evitamos que si se pulsan dos botones de
         * operación seguidos de un error.
         *
         * Al final vaciaremos el
         * output para poder dejar paso a la segunda parte de la operación.
         */

        val buttonrest = findViewById<Button>(id.buttonOpRest)
        buttonrest.setOnClickListener {
            when {
                operator.isEmpty() -> {
                    operator = "-"
                    if (n1 == 0.0) {n1 = output.toDouble()}
                }
                operator == "-" -> {operator = "-"}
                operator.isNotEmpty() && operator != "-" -> {operator = "-"}
                else -> {
                    n1 = output.toDouble()
                    operator = "-"
                }
            }
            output = ""
        }

        /**
         * Botón de mutiplicación:
         *
         * Si el operator está vacio pondremos el simbolo "*" para pasar a la
         * segunda parte de la operacion, si además de estar vacio, el valor
         * de n1 es 0, lo añadiremos al output. En caso de no estar el valor
         * del operator vacio, quiere decir que es una operación concatenada,
         * en la que n1 ya tendrá el valor de la anterior operación, solamente
         * cambiaremos de simbolo a la variable operator.
         *
         * Luego, añadimos una condición para evitar errores, si el operator ya
         * es el mismo que ya estaba, no se altera, por lo que al pulsar varias
         * veces el mismo boton, no da errores, simplemente se queda como está.
         *
         * A continuación, añadimos una condición para evitar otro error, en
         * este caso se trata de si el operator ya tiene un simbolo diferente
         * al de este botón, al pulsar este boton se va a cambiar de simbolo
         * al de este botón, así evitamos que si se pulsan dos botones de
         * operación seguidos de un error.
         *
         * Al final vaciaremos el
         * output para poder dejar paso a la segunda parte de la operación.
         */

        val buttonmult = findViewById<Button>(id.buttonOpMult)

        buttonmult.setOnClickListener {
            when {
                operator.isEmpty() -> {
                    operator = "*"
                    if (n1 == 0.0) {n1 = output.toDouble()}
                }
                operator == "*" -> {operator = "*"}
                operator.isNotEmpty() && operator != "*" -> {operator = "*"}
                else -> {
                    n1 = output.toDouble()
                    operator = "*"
                }
            }
            output = ""
        }

        /**
         * Botón división:
         *
         * Si el operator está vacio pondremos el simbolo "/" para pasar a la
         * segunda parte de la operacion, si además de estar vacio, el valor
         * de n1 es 0, lo añadiremos al output. En caso de no estar el valor
         * del operator vacio, quiere decir que es una operación concatenada,
         * en la que n1 ya tendrá el valor de la anterior operación, solamente
         * cambiaremos de simbolo a la variable operator.
         *
         * Luego, añadimos una condición para evitar errores, si el operator ya
         * es el mismo que ya estaba, no se altera, por lo que al pulsar varias
         * veces el mismo boton, no da errores, simplemente se queda como está.
         *
         * A continuación, añadimos una condición para evitar otro error, en
         * este caso se trata de si el operator ya tiene un simbolo diferente
         * al de este botón, al pulsar este boton se va a cambiar de simbolo
         * al de este botón, así evitamos que si se pulsan dos botones de
         * operación seguidos de un error.
         *
         * Al final vaciaremos el
         * output para poder dejar paso a la segunda parte de la operación.
         */

        val buttondiv = findViewById<Button>(id.buttonOpDiv)
        buttondiv.setOnClickListener{
            when {
                operator.isEmpty() -> {
                    operator = "/"
                    if (n1 == 0.0) {n1 = output.toDouble()}
                }
                operator == "/" -> {operator = "/"}
                operator.isNotEmpty() && operator != "/" -> {operator = "/"}
                else -> {
                    n1 = output.toDouble()
                    operator = "/"
                }
            }
            output = ""
        }

        /**
         * A continuación, tenemos el botón C, donde podremos
         * borrar lo que tengamos escrito hasta ahora.
         * Simplemente devolvemos los valores a como estaban
         * al principio del programa y lo mostraremos por pantalla,
         * el resultado es que quedará vacio.
         *
         */
        val buttonC = findViewById<Button>(id.buttonC)
        buttonC.setOnClickListener{
            output = ""
            n1 = 0.0
            n2 = 0.0
            operator=""
            mainbox.text = output
        }
        /**
         * Botón Equal:
         *
         * Este botón nos servirá para obtener el resultado de la operación,
         * al pulsar, se creará el objeto cálculo con los valores de las
         * variables n1, n2 y operator y procederemos a llamar al método
         * operation de la clase Calc.
         * Para más información sobre la clase Calc, @see Calc
         */
        val buttoneq = findViewById<Button>(id.buttonOpEq)
        buttoneq.setOnClickListener{
            n2=output.toDouble()
            mainbox.text = output
            calc = Calc(n1, n2)
            output = calc.operation(operator).toString()
            mainbox.text = output
            n1 = output.toDouble()
            n2 = 0.0
            output=""
            operator = ""
        }
    }
}