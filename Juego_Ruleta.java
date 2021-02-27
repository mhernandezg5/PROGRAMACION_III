package juego_ruleta;

//LIBRERIA PARA LEER DEL TECLADO
import java.util.Scanner;

public class Juego_Ruleta {
    /**
 *
 * @author mhernandezg5@miumg.edu.gt
 * Mynor Augusto Hernández González
 * 0900-10-6904
 * PROGRAMACIÓN III
 */
    // EL METODO PRINCIPAL  
    public static void main(String[] args) {

        //PARA LEER DEL TECLADO
        Scanner teclado = new Scanner(System.in);

        //VARIABLES.
        int opcion, saldo = 100, apuesta = 10, ganan, random;
        int acertarNumero, acertarColor;

        // MENU PRINCIPAL
        System.out.println("**** BIENVENIDO AL JUEGO DE LA RULETA ****");

        //VALIDAR SI TIENE SALDO PARA INICIAR LA APUESTA
        if (saldo >= 10) {

            //CICLO PARA REPETER EL JUEGO. (HASTA QUE NO TENGA SALDO)
            do {
                //MENÚ PARA QUE EL USUARIO ELIJA 
                System.out.println("\n1. ACERTAR NUMERO");
                System.out.println("2. ACERTAR COLOR");

                System.out.print("\nELIJE UNA OPCION: ");
                //LEE LA OPCION QUE EL USUARIO INGRESA
                opcion = teclado.nextInt();

                //EVALUAR LA OPCION QUE EL USUARIO INGRESE
                switch (opcion) {

                    case 1:
                        //AQUI DEBE IR OTRO CICLO PRA VER SI TIENE SALDO 
                        if (saldo >= 10) {
                            //EVALUA SI EL NUMERO QUE APUESTA GANA O PIERDE
                            System.out.print("\nESCRIBE UN NUMERO\n");
                            System.out.print(" ENTRE 1 Y 10: ");
                            acertarNumero = teclado.nextInt();

                            while (acertarNumero >= 1 && acertarNumero <= 10) {

                                //NUMERO ALEATORIO ENTRE 1 Y 10 NO CERO
                                random = (int) (Math.random() * 10 + 1);
                                System.out.println("\nEL NUMERO ES: " + random);

                                saldo -= 10; //le quita una apuesta al saldo inicial

                                //VALIDA SI ACIERTA EL NUMERO
                                if (acertarNumero == random) {

                                    //SI ACIERTA GANA EL TRIPLE DE LO QUE APUESTA
                                    ganan = apuesta * 3;

                                    //CALCULA EL SALDO ACUTAL, LOQ UE GANA MAS LO QUE TENIA
                                    saldo += ganan;

                                    //MUESTRA EL SALDO QUE SUMA AL GANAR
                                    System.out.println("FELICIDADES, ACERTASTE EL NUMERO");
                                    System.out.println("\nTU SALDO ACTUAL ES: " + saldo);
                                    System.out.println("_________________________________");

                                } else {

                                    System.out.println("\nHAS PERDIDO");

                                    //MUESTRA EL SALDO QUE LE QUEDA DESPUES DE LA APUESTA
                                    System.out.println("TU SALDO ACTUAL ES: " + saldo);
                                    System.out.println("_________________________________");
                                }
                            }
                            System.out.println("______________________________________________________");
                            System.out.println("\nEL NUMERO " + acertarNumero + "  NO ESTA EN EL RANGO");//FIN WHILE
                            System.out.println("______________________________________________________");
                        } else {
                            System.out.println("TU SALDO ES INSUFICIENTE");
                        }
                        break;
                    case 2:

                        // MENU DEL CASO 2
                        System.out.println("____________");
                        System.out.println("\nELIJE UN COLOR");
                        System.out.println("1. BLANCO");
                        System.out.println("2. NEGRO");
                        System.out.print("\nELIJO: ");

                        //LEE LA OPCION QUE EL USUARIO INGRESA
                        acertarColor = teclado.nextInt();

                        while (acertarColor >= 1 && acertarColor <= 2) {

                            //NUMERO ALEATORIO 1 Y 2 NO CERO 0
                            random = (int) (Math.random() * 2 + 1);

                            //LE QUITA 10 AL SALDO INICIAL, ESO VALE CADA APUESTA
                            saldo -= 10;
                            //VALIA SI EL COLOR QUE EL USUARIO INGRESA ES EL QUE SE GENERA

                            if (acertarColor == random) {

                                //SI ACIERTA GANA EL DOBLE DE LO QUE APUESTA                    
                                ganan = apuesta * 2;

                                //CALCULA EL SALDO ACUTAL, LOQ UE GANA MAS LO QUE TENIA
                                saldo += ganan;

                                //MUESTRA EL NUMERO DEL COLOR ALEATORIO
                                System.out.println("EL COLOR ES:" + random);

                                //MUESTRA EL SALDO QUE SUMA AL GANAR
                                System.out.println("FELICIDADES, ACERTASTE EL COLOR");
                                System.out.println("TU SALDO ACTUAL ES: " + saldo);

                            } else {
                                //MUESTRA EL NUMERO DEL COLOR ALEATORIO
                                System.out.println("EL COLOR ES:" + random);
                                System.out.println("HAS PERDIDO");

                                //MUESTRA EL SALDO QUE LE QUEDA AL PERDER
                                System.out.println("TU SALDO ES:" + saldo);
                            }
                            break;
                            //SI ES CUALQUIER OPCION QUE NO SEA 1, 2 O 3. CIERRA
                        }
                        System.out.println("LA OPCION NO ESTA EN EL RANGO");//FIN DEL WHILE
                }
                //SI LA OPCION ES DISTINTA O IGUAL A 3 CIERRA
            } while (opcion == 1 || opcion == 2);
            {
                System.out.println("\nLA OPCION " + opcion + " NO EXISTE\n");
                System.out.println("*****   SALISTE DEL JUEGO  ***** \n");
            }
            //SI YANO TIENE SALDO YA NO PUEDE SEGUIR APOSTANDO
        } else {
            System.out.println("\n **** TU SALDO ES INSUFICIETE PARA SEGUIR ****");
        }
    }
}
