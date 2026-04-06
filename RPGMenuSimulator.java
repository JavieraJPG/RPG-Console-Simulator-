import java.util.Scanner;

public class RPGMenuSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        String nombre = "";
        String tipo = "";
        int vida = 0;
        int fuerza = 0;
        boolean personajeCreado = false;

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
                    System.out.println("\nBatalla próximamente...");
                    break;

                case 4:
                    System.out.println("\nInventario próximamente...");
                    break;

                case 5:
                    System.out.println("\nEstado del personaje próximamente...");
                    if (personajeCreado) {
                        
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Clase: " + tipo);
                        if (vida < 20) {
                            System.out.println("¡Cuidado! Tu vida es baja.");
                            
                        }else if (vida < 50) {
                            System.out.println("Tu vida es moderada.");
                            break;
                        }else if (vida > 80) {
                            System.out.println("¡Estás en excelente forma!");
                            break;
                        } else {
                            System.out.println("Tu vida es estable.");
                            break;
                        }
                        System.out.println("Fuerza: " + fuerza);
                        break;
                    } else {
                        System.out.println("No se ha creado un personaje aún...");
                        break;
                    }
                    

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