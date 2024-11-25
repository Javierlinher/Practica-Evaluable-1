/*
    Linares, Herrero, Javier
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PRACTICA1 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        boolean esPar = false;  // Para marcar si la elección de par o impar es válida.
        int canicasj1 = 10, canicasj2 = 10;  // Canicas de cada jugador, que comienza con 10 de ellas cada uno.
        int apuestaj1 = 0, apuestaj2 = 0;  // Apuesta de cada jugador.
        int comienzo, paroimpar2;  // El comienzo y la eleccion de par o impar del jugador 2.
        String paroimpar1 = "a";  // La elección de par o impar del jugador 1.
        System.out.println("Comienza el juego.");  // Inicio del juego.
        comienzo = rand.nextInt(0, 2);  // Se genera un número random entre 0 y 1.
        do {  // Bucle mientras ninguna de las canicas de los jugadores llegue a 0.

            if (comienzo == 0) {  // Turno del jugador 1.

                System.out.println("*********************** TURNO JUGADOR 1 ***********************");  // Turno de jugador 1.
                while (true) {  // Bucle infinito, para que hasta que no se cumplan las condiciones siga haciendose.
                    try {  // Para capturar excepciones.
                        System.out.print("Jugador 1, ¿Cuantas canicas quieres apostar?: \n");  // Pregunta de cuandas canicas apuesta el jugador 1.
                        apuestaj1 = sc.nextInt();  // Apuesta del jugador 1.
                        if (apuestaj1 >= 1 && apuestaj1 <= canicasj1 && apuestaj1 <= canicasj2) {  // Que cumpla que esté entre 1 y las canicas de los jugadores.
                            break;  // Salir del bucle infinito.
                        } else {
                            if (canicasj1 < canicasj2) {  // Para ver cual es el menor número maximo de canicas a apostar.
                                System.out.println("Número inválido. Ingrese un número entre 1 y " + canicasj1 + ".");
                            } else {
                                System.out.println("Número inválido. Ingrese un número entre 1 y " + canicasj2 + ".");
                            }
                        }
                    } catch (InputMismatchException e) { // Excepcion de poner algo que no sea un número.
                        System.out.println("El número debe ser un número.");
                        sc.nextLine(); // Para que no vuelva a dar el error.
                    }
                }
                while (esPar == false) {  // Bucle para que mientras no se ponga par o impar se siga pidiendo.
                    System.out.print("Jugador 1, ¿Que crees que tiene el Jugador 2? (Par/Impar): \n"); //Pregunta de si el jugador 2 tiene un numero par o impar de canicas en la mano.
                    paroimpar1 = sc.next();// Respuesta de par o impar del jugador 1.
                    paroimpar1 = paroimpar1.toLowerCase(); // Se pasa a minusculas.
                    if (paroimpar1.equals("par") || paroimpar1.equals("impar")) {
                        esPar = true;
                    } else {
                        esPar = false;
                        System.out.println("Palabra inválida. Debe escribir la palabra par o impar.");
                    }
                }
                System.out.println();  // Espacio entre lineas.

                System.out.println("Resultado");

                if(canicasj1 >= canicasj2){
                    apuestaj2 = rand.nextInt(1, canicasj2 + 1);  // Se genera la apuesta del jugador 2 si el j1 tiene más canicas.
                }else{
                    apuestaj2 = rand.nextInt(1, canicasj1 + 1);  // Se genera la apuesta del jugador 2 si el j1 tiene menos canicas.
                }

                if (paroimpar1.equals("par")) {  // Si has elegido par
                    if (apuestaj2 % 2 == 0) {  // Y el numero de canicas en la mano del jugador 2 es par.
                        System.out.println("Jugador 1 GANAS " + apuestaj1 + " canicas ya que el jugador 2 tenia " + apuestaj2 + " canicas");
                        canicasj2 = canicasj2 - apuestaj1;  // Se restan las canicas al jugador 2.
                        canicasj1 = canicasj1 + apuestaj1;  // Se suman las canicas al jugador 1.
                    } else {  // Y el número de canicas en la mano del jugador 2 es impar.
                        System.out.println("Jugador 1 PIERDES " + apuestaj2 + " canicas ya que el jugador 2 tenia " + apuestaj2 + " canicas");
                        canicasj1 = canicasj1 - apuestaj2;  // Se restan las canicas al jugador 1.
                        canicasj2 = canicasj2 + apuestaj2;  // Se suman las canicas al jugador 2.
                    }
                } else {  // Si has elegido impar.
                    if (apuestaj2 % 2 == 1) {  // Y el numero de canicas en la mano del jugador 2 es impar.
                        System.out.println("Jugador 1 GANAS " + apuestaj1 + " canicas ya que el jugador 2 tenia " + apuestaj2 + " canicas");
                        canicasj2 = canicasj2 - apuestaj1;  // Se restan las canicas al jugador 2.
                        canicasj1 = canicasj1 + apuestaj1;  // Se suman las canicas al jugador 1.
                    } else {  // Y el numero de canicas en la mano del jugador 2 es par.
                        System.out.println("Jugador 1 PIERDES " + apuestaj2 + " canicas ya que el jugador 2 tenia " + apuestaj2 + " canicas");
                        canicasj1 = canicasj1 - apuestaj2;  // Se restan las canicas al jugador 1.
                        canicasj2 = canicasj2 + apuestaj2;  // Se suman las canicas al jugador 2.
                    }
                }
                System.out.println("Jugador 1 tiene " + canicasj1 + " canicas");
                System.out.println("Jugador 2 tiene " + canicasj2 + " canicas");
                System.out.println("********************* FIN TURNO JUGADOR 1 *********************");  // Fin del turno del jugador 1.
                System.out.println();

                if (canicasj1 == 0 || canicasj2 == 0) {  // Si ha terminado este turno, y alguien tiene 0 canicas, sale del bucle.
                    break;
                }
            }
            comienzo = 1;  // Cambio de turno.

            if (comienzo == 1) {  // Turno del jugador 2.
                System.out.println("*********************** TURNO JUGADOR 2 ***********************");  // Turno de jugador 2.
                while (true) {  // Bucle infinito, para que hasta que no se cumplan las condiciones siga haciendose.
                    try { //para capturar excepciones.
                        System.out.print("Jugador 1, ¿Cuantas canicas quieres apostar?: \n");  // Pregunta de cuandas canicas apuesta el jugador 1.
                        apuestaj1 = sc.nextInt();  // Apuesta del jugador 1.
                        if (apuestaj1 >= 1 && apuestaj1 <= canicasj1 && apuestaj1 <= canicasj2) {  // Que cumpla que este entre 1 y las canicas de los jugadores.
                            break;  // Salir del bucle infinito.
                        } else {
                            if (canicasj1 < canicasj2) {  // Para ver cual es el menor número maximo de canicas a apostar.
                                System.out.println("Número inválido. Ingrese un número entre 1 y " + canicasj1 + ".");
                            } else {
                                System.out.println("Número inválido. Ingrese un número entre 1 y " + canicasj2 + ".");
                            }
                        }
                    } catch (InputMismatchException e) {  // Excepcion de poner algo que no sea un número.
                        System.out.println("El número debe ser un número.");
                        sc.nextLine();  // Para que no vuelva a dar el error.
                    }
                }
                if(canicasj1 >= canicasj2){
                    apuestaj2 = rand.nextInt(1, canicasj2 + 1);  // Se genera la apuesta del jugador 2 si el j1 tiene más canicas.
                }else{
                    apuestaj2 = rand.nextInt(1, canicasj1 + 1);  // Se genera la apuesta del jugador 2 si el j1 tiene menos canicas.
                }
                paroimpar2 = rand.nextInt(0, 2);  // Se genera un número aleatorio entre 0 y 1, entendiendo 0 como que ha salido par y 1 como que ha salido impar.
                if (paroimpar2 == 0) {  // Si jugador dos cree que tienes canicas pares.
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número par.");
                    System.out.println();
                    System.out.println("Resultado");
                    if (apuestaj1 % 2 == 0) {
                        System.out.println("Jugador 1 PIERDES " + apuestaj2 + " canicas ya que el jugador 2 tenia " + apuestaj2 + " canicas");
                        canicasj1 = canicasj1 - apuestaj2;  // Se restan las canicas al jugador 1.
                        canicasj2 = canicasj2 + apuestaj2;  // Se suman las canicas al jugador 2.
                    } else {
                        System.out.println("Jugador 1 GANAS " + apuestaj1 + " canicas ya que el jugador 2 tenia " + apuestaj2 + " canicas");
                        canicasj2 = canicasj2 - apuestaj1;  // Se restan las canicas al jugador 2.
                        canicasj1 = canicasj1 + apuestaj1;  // Se suman las canicas al jugador 1.
                    }
                } else {  // Si el jugador 2 cree que tienes canicas impares.
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número impar.");
                    System.out.println();
                    System.out.println("Resultado");
                    if (apuestaj1 % 2 == 1) {
                        System.out.println("Jugador 1 PIERDES " + apuestaj2 + " canicas ya que el jugador 2 tenia " + apuestaj2 + " canicas");
                        canicasj1 = canicasj1 - apuestaj2;  // Se restan las canicas al jugador 1.
                        canicasj2 = canicasj2 + apuestaj2;  // Se suman las canicas al jugador 2.
                    } else {
                        System.out.println("Jugador 1 GANAS " + apuestaj1 + " canicas ya que el jugador 2 tenia " + apuestaj2 + " canicas");
                        canicasj2 = canicasj2 - apuestaj1;  // Se restan las canicas al jugador 2.
                        canicasj1 = canicasj1 + apuestaj1;  // Se suman las canicas al jugador 1.
                    }
                }
                System.out.println("Jugador 1 tiene " + canicasj1 + " canicas");
                System.out.println("Jugador 2 tiene " + canicasj2 + " canicas");
                System.out.println("********************* FIN TURNO JUGADOR 2 *********************");  // Fin del turno del jugador 1.
                System.out.println();
            }
            comienzo = 0;  // Cambio de turno.

        } while (canicasj1 != 0 && canicasj2 != 0);  // Fin del bucle cuando alguien se queda sin canicas.

        if (canicasj1 == 0) {  // Si gana el jugador 2.
            System.out.println("¡Te quedaste sin canicas Jugador 1! Has perdido el juego.");
        } else {  // Si gana el jugador 1.
            System.out.println("¡Felicidades Jugador 1! Has ganado el juego.");
        }
    }
}