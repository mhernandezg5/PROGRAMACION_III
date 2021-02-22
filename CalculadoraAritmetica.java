/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraaritmetica;

// librería para utilizar lectura del teclado
import java.util.Scanner;

/**
 *
 * @author mhernandezg5@miumg.edu.gt
 */
public class CalculadoraAritmetica {

    /**
     * @param args the command line arguments
     */
    // METODO PRINCIPAL
    public static void main(String[] args) {

        //LEE DEL TECLADO
        Scanner leer = new Scanner(System.in);
        //DECLARACION DE VARIABLES
        int ope = 0;
        double num1 = 0, num2 = 0, result = 0;

        //MENU PRINCIPAL DE OPERACIONES ARITMETICAS.
        do {
            System.out.println("\n");
            System.out.println("*****   CALCULADORA   *****");
            System.out.println("1. SUMA.");
            System.out.println("2. RESTA.");
            System.out.println("3. MULTIPLICAR.");
            System.out.println("4. DIVIDIR.");
            System.out.println("5. SALIR");
            System.out.println("--- SELECIONE UNA OPCION ---");

            //LEE LA OPCION QUE EL USUARIO ELIJA.
            ope = leer.nextInt();

            //VALIDA QUE LA OPCION ESTE EN EL PARAMETRO ESPLEGADO.
            if (ope >= 1 && ope <= 4) {
                System.out.print("ESCRIBA EL PRIMER NUMERO:  ");
                num1 = leer.nextDouble();
                System.out.print("ESCRIBA EL SEGUNDO NUMERO:  ");
                num2 = leer.nextDouble();
            }

            //OPERACIONES ARITMETICAS.
            {
                switch (ope) {
                    //SUMA DOS NUMEROS, PUEDEN SER DECIMALES.
                    case 1:
                        ope = 1;
                        result = num1 + num2;
                        //MUESTAR EL RESULTADO DE LA SUMA.
                        System.out.print("LA SUMA ES:" + result);
                        break;

                    //RESTA DOS NUMEROS, PUEDEN SER DECIMALES.
                    case 2:
                        ope = 2;
                        result = num1 - num2;
                        //MUESTRA EL RESULTADO DE LA RESTA.
                        System.out.print("LA RESTA ES: " + result);
                        break;

                    // MULTIPLICA DOS NUMEROS, PUEDEN SER DECIMALES.
                    case 3:
                        ope = 3;
                        result = num1 * num2;
                        //MUESTRA EL RESULTADO DE LA RESTA.
                        System.out.print("LA MULTIPLIACION:" + result);
                        break;

                    //DIVIDE DOS NUMEROS, PUEDEN SER DECIMALES.
                    //REGLA: EL DENOMINADOR DE LA DIVISION NO DEBE SER CERO.
                    //de lo contrario la division no se puuede calcular.
                    case 4:
                        ope = 4;
                        //VERIFICA QUE EL DENOMINADOR NO SEA CERO.
                        //puede ser menor a cero.
                        if (num2 > 0 && num2 < 0) {
                            result = num1 / num2;
                            //MUESTRA EL RESULTADO DE LA DIVISION.
                            System.out.println("LA DIVISION ES: " + result);
                        } else {
                            //VALIDA SI EL NUMERO ES IGUAL A CERO
                            //DESPLIEGA MENSAJE DE ERROR, no se puede operar.
                            if (num2 == 0) {
                                System.out.println("\n-------------------------");
                                System.out.println("ERROR FATAL DIVISION EN 0");
                                System.out.println("-------------------------");
                            }
                        }
                        break;
                }
            }
            //AL ELEGIR LA OPCION 5 SALE DEL PROGRAMA
        } while (ope != 5);
        System.out.println("USTED SALIO");
    }
}
