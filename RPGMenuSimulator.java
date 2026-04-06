import java.util.Random;
import java.util.Scanner;

public class RPGMenuSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        String nombre = "";
        String tipo = "";
        int vida = 100;
        int vidaEnemigo = 100;
        int fuerza = 0;
        boolean personajeCreado = false;
        Random random = new Random();

        do {
            System.out.println("\n=== RPG SIMULATOR ===");
            System.out.println("1. Crear personaje");
            System.out.println("2. Entrenar");
            System.out.println("3. Batalla");
            System.out.println("4. Inventario");
            System.out.println("5. Estado del personaje");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n=== CREAR PERSONAJE ===");

                    scanner.nextLine(); // limpiar buffer

                    System.out.print("Ingrese nombre del personaje: ");
                    nombre = scanner.nextLine();

                    System.out.println("Seleccione tipo de personaje:");
                    System.out.println("1. Mago");
                    System.out.println("2. Guerrero");
                    System.out.println("3. Arquero");
                    System.out.print("Opción: ");
                    int tipoOpcion = scanner.nextInt();

                    if (tipoOpcion == 1) {
                        tipo = "Mago";
                    } else if (tipoOpcion == 2) {
                        tipo = "Guerrero";
                    } else if (tipoOpcion == 3) {
                        tipo = "Arquero";
                    } else {
                        System.out.println("Opción inválida");
                        break;
                    }

                    System.out.print("Ingrese puntos de vida: ");
                    vida = scanner.nextInt();

                    if (vida < 0) {
                        System.out.println("La vida no puede ser negativa");
                        break;
                    }

                    System.out.print("Ingrese fuerza base: ");
                    fuerza = scanner.nextInt();

                    if (fuerza < 0) {
                        System.out.println("La fuerza no puede ser negativa");
                        break;
                    }

                    personajeCreado = true;

                    System.out.println("\n=== PERSONAJE CREADO ===");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Clase: " + tipo);
                    System.out.println("Vida: " + vida);
                    System.out.println("Fuerza: " + fuerza);
                    break;

                case 2:
                    System.out.println("\nEntrenamiento próximamente...");
                    break;

                case 3:
                    System.out.println("\nBatalla");
                    //BATALLA DE 5 TURNOS
                    for (int turno = 1; turno <=5; turno++)
                    System.out.println("Turno" + turno);

                    //DAÑO ENTRE 10 Y 20
                    int dañoJugador = random.nextInt(11) + 10;
                    int dañoEnemigo = random.nextInt(11) + 10;

                    //PARA RESTAR VIDA
                    vidaEnemigo-= dañoJugador;
                    vida-= dañoEnemigo;

                    //PARA EVITAR VIDA NEGATIVA
                    if (vidaEnemigo <= 0) vidaEnemigo = 0;
                    if (vida <=0) vida = 0;

                    //PARA MOSTRAR VIDA RESTANTE
                    System.out.println("Vida del Jugador: " + vida);
                    System.out.println("Vida del Enemigo" + vidaEnemigo);
                    System.out.println("------------------------------");

                    //SI ALGUNO MUERE ANTES DE LOS 5 TURNOS
                    if (vida == 0 || vidaEnemigo == 0)
                        System.out.println("LA BATALLA HA TERMINADO");

                    //RESULTADO FINAL
                    System.out.println("\n=========RESULTADO FINAL==========");
                    if (vida > vidaEnemigo) {
                        System.out.println("¡ENHORABUENA, HAS GANADO!");
                    } else if (vida < vidaEnemigo) {
                        System.out.println("HAS SIDO DERROTADO");
                    } else {
                        System.out.println("¡EMPATE!");
                    }
                    break;

                case 4:
                    System.out.println("\nInventario próximamente...");
                    break;

                case 5:
                    System.out.println("\nEstado del personaje próximamente...");
                    break;

                case 6:
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 6);

        scanner.close();
    }
}