import java.util.Random;
import java.util.Scanner;

public class RPGMenuSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int opcion;

        String nombre = "";
        String tipo = "";
        int vida = 100;
        int fuerza = 0;
        int nivel = 1;
        int batallasGanadas = 0;
        boolean personajeCreado = false;

        String[] inventario = {
            "❤️ Poción Curativa",
            "💧 Poción de Maná",
            "⛏️ Hierro",
            "📜 Pergamino",
            "🗝️ Llave Antigua"
        };

        do {
            System.out.println("\n=== RPG SIMULATOR ===");
            System.out.println("1. Crear personaje");
            System.out.println("2. Entrenar");
            System.out.println("3. Batalla");
            System.out.println("4. Inventario");
            System.out.println("5. Estado del personaje");
            System.out.println("6. Créditos");
            System.out.println("7. Salir");
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

                    if (vida <= 0) {
                        System.out.println("La vida debe ser mayor a 0");
                        break;
                    }

                    System.out.print("Ingrese fuerza base: ");
                    fuerza = scanner.nextInt();

                    if (fuerza < 0) {
                        System.out.println("La fuerza no puede ser negativa");
                        break;
                    }

                    nivel = 1;
                    batallasGanadas = 0;
                    personajeCreado = true;

                    System.out.println("\n=== PERSONAJE CREADO ===");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Clase: " + tipo);
                    System.out.println("Vida: " + vida);
                    System.out.println("Fuerza: " + fuerza);
                    System.out.println("Nivel: " + nivel);
                    break;

                case 2:
                    if (!personajeCreado) {
                        System.out.println("\n⚠️ Primero debes crear un personaje.");
                        break;
                    }

                    System.out.println("\n=== ENTRENAMIENTO ===");
                    System.out.println("1. Entrenar Fuerza");
                    System.out.println("2. Entrenar Resistencia (Vida)");
                    System.out.println("3. Volver al menú principal");
                    System.out.print("Seleccione una opción: ");

                    int entrenamientoOpcion = scanner.nextInt();

                    switch (entrenamientoOpcion) {
                        case 1 -> {
                            int gananciaFuerza = random.nextInt(5) + 1;
                            fuerza += gananciaFuerza;

                            String nivelFuerza;
                            if (fuerza < 20) {
                                nivelFuerza = "Débil";
                            } else if (fuerza < 50) {
                                nivelFuerza = "Promedio";
                            } else if (fuerza <= 80) {
                                nivelFuerza = "Fuerte";
                            } else {
                                nivelFuerza = "¡Imparable!";
                            }

                            System.out.println("\n=== RESULTADO DEL ENTRENAMIENTO ===");
                            System.out.println("Tipo    : Fuerza");
                            System.out.println("─────────────────────────────");
                            System.out.println("Ganancia: +" + gananciaFuerza + " de Fuerza 💪");
                            System.out.println("Fuerza  : " + fuerza + "  " + nivelFuerza);
                        }
                        case 2 -> {
                            int gananciaVida = random.nextInt(10) + 5;
                            vida = Math.min(vida + gananciaVida, 100);

                            int barraLlenaT = vida / 10;
                            String barraT = "[";

                            for (int i = 0; i < 10; i++) {
                                if (i < barraLlenaT) {
                                    barraT += "█";
                                } else {
                                    barraT += "░";
                                }
                            }
                            barraT += "]";

                            System.out.println("\n=== RESULTADO DEL ENTRENAMIENTO ===");
                            System.out.println("Tipo    : Resistencia");
                            System.out.println("─────────────────────────────");
                            System.out.println("Ganancia: +" + gananciaVida + " de Vida ❤️");
                            System.out.println("Vida    : " + barraT + "  " + vida + "/100");
                        }
                        case 3 -> System.out.println("Volviendo al menú principal...");
                        default -> System.out.println("Opción inválida");
                    }
                    break;

                case 3:
                    if (!personajeCreado) {
                        System.out.println("\n⚠️ Primero debes crear un personaje.");
                        break;
                    }

                    int vidaEnemigo = 100;
                    System.out.println("\n⚔️ === BATALLA === ⚔️");

                    for (int turno = 1; turno <= 5; turno++) {
                        if (vida <= 0 || vidaEnemigo <= 0) {
                            break;
                        }

                        System.out.println("\n--- Turno " + turno + " ---");

                        int danoJugador = random.nextInt(11) + 10 + (fuerza / 10);
                        int danoEnemigo = random.nextInt(11) + 8;

                        vidaEnemigo -= danoJugador;
                        vida -= danoEnemigo;

                        if (vidaEnemigo < 0) {
                            vidaEnemigo = 0;
                        }
                        if (vida < 0) {
                            vida = 0;
                        }

                        System.out.println(nombre + " hace " + danoJugador + " de daño 🗡️");
                        System.out.println("Enemigo hace " + danoEnemigo + " de daño 💥");
                        System.out.println("Vida del Jugador: " + vida + "/100");
                        System.out.println("Vida del Enemigo: " + vidaEnemigo + "/100");
                    }

                    System.out.println("\n========= RESULTADO FINAL =========");

                    if (vida > 0 && vidaEnemigo == 0) {
                        batallasGanadas++;
                        nivel++;
                        fuerza += 2;
                        vida = Math.min(vida + 10, 100);

                        System.out.println("🏆 ¡ENHORABUENA, HAS GANADO!");
                        System.out.println("⬆️ Subiste a nivel " + nivel);
                        System.out.println("💪 Fuerza actual: " + fuerza);
                        System.out.println("❤️ Recuperaste un poco de vida. Vida actual: " + vida);
                    } else if (vida == 0) {
                        System.out.println("💀 HAS SIDO DERROTADO");
                        System.out.println("🔄 El personaje se reiniciará...");

                        vida = 100;
                        fuerza = 0;
                        nivel = 1;
                        batallasGanadas = 0;
                        personajeCreado = false;
                        nombre = "";
                        tipo = "";

                        System.out.println("Tu personaje fue reiniciado. Debes crear uno nuevo.");
                    } else if (vida > vidaEnemigo) {
                        batallasGanadas++;
                        nivel++;
                        fuerza += 2;

                        System.out.println("🏆 ¡GANASTE POR VENTAJA!");
                        System.out.println("⬆️ Subiste a nivel " + nivel);
                    } else if (vida < vidaEnemigo) {
                        System.out.println("😢 HAS SIDO DERROTADO");
                    } else {
                        System.out.println("🤝 ¡EMPATE!");
                    }
                    break;

                case 4:
                    if (!personajeCreado) {
                        System.out.println("\n⚠️ Primero debes crear un personaje.");
                        break;
                    }

                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║         INVENTARIO 🎒        ║");
                    System.out.println("╠══════════════════════════════╣");

                    for (String item : inventario) {
                        System.out.println("║ " + item);
                    }

                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ Total: " + inventario.length + " objetos            ║");
                    System.out.println("╚══════════════════════════════╝");

                    System.out.println("\n¿Deseas usar una poción?");
                    System.out.println("1. ❤️ Poción Curativa (+20 vida)");
                    System.out.println("2. No usar nada");
                    System.out.print("Opción: ");
                    int opcionPocion = scanner.nextInt();

                    if (opcionPocion == 1) {
                        vida = Math.min(vida + 20, 100);
                        System.out.println("❤️ Usaste una Poción Curativa. Vida actual: " + vida);
                    } else if (opcionPocion == 2) {
                        System.out.println("No usaste ningún objeto.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 5:
                    if (!personajeCreado) {
                        System.out.println("\nNo se ha creado un personaje aún...");
                        break;
                    }

                    int barraLlena = vida / 10;
                    String barra = "[";

                    for (int i = 0; i < 10; i++) {
                        if (i < barraLlena) {
                            barra += "█";
                        } else {
                            barra += "░";
                        }
                    }
                    barra += "]";

                    String estadoVida;
                    if (vida < 20) {
                        estadoVida = "¡PELIGRO! Vida crítica";
                    } else if (vida < 50) {
                        estadoVida = "Vida baja, ten cuidado";
                    } else if (vida <= 80) {
                        estadoVida = "Vida estable";
                    } else {
                        estadoVida = "¡Excelente forma!";
                    }

                    System.out.println("\n=== ESTADO DEL PERSONAJE ===");
                    System.out.println("Nombre  : " + nombre);
                    System.out.println("Clase   : " + tipo);
                    System.out.println("Nivel   : " + nivel);
                    System.out.println("─────────────────────────────");
                    System.out.println("Vida    : " + barra + "  " + vida + "/100  " + estadoVida);
                    System.out.println("Fuerza  : " + fuerza);
                    System.out.println("Victorias: " + batallasGanadas);
                    break;

                case 6:
                    System.out.println("\n=== CRÉDITOS ===");
                    System.out.println("Desarrollado por:");
                    System.out.println("JAVIERA GODOY");
                    System.out.println("RENATO CAMPOS");
                    System.out.println("DIEGO CASTILLO");
                    System.out.println("MATIAS CELIS");
                    System.out.println("VICTOR ERAZO");
                    System.out.println("Inspirado en juegos RPG clásicos");
                    System.out.println("¡Gracias por jugar!");
                    break;

                case 7:
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);

        scanner.close();
    }
}