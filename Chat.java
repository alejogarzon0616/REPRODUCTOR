import java.util.Scanner;

public class Chat extends Thread {
    private ReproductorMusica musicaThread;

    public Chat(ReproductorMusica musicaThread) {
        this.musicaThread = musicaThread;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Reproduciendo la canción. Para detener la música y salir, presiona Enter.");

        System.out.println("Hola, ¿cómo te llamas?");
        String nombre = scanner.nextLine();
        System.out.println("¡Encantado de conocerte, " + nombre + "!");

        System.out.println("¿Cuál es tu edad?");
        String edad = scanner.nextLine();

        System.out.println("¿Crees que Cristiano Ronaldo es el mejor jugador de fútbol? (responde 'si' o 'no')");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("¡Efectivamente, Cristiano Ronaldo es un gran jugador!");
        } else {
            System.out.println("¡Gracias por compartir tu opinión!");
        }

        scanner.close();
        musicaThread.detenerReproduccion();
    }
}
