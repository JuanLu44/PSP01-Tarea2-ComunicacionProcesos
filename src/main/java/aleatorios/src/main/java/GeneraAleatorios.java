import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class GeneraAleatorios {

    public static void main(String[] args) {

        // Preparamos el proceso hijo que genera los números aleatorios.
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                "build/classes/java/main",
                "Aleatorio"
        );

        try {
            // Iniciamos el proceso hijo.
            Process proceso = pb.start();

            // Creamos los flujos para enviar peticiones y leer las respuestas.
            PrintStream ps = new PrintStream(
                    proceso.getOutputStream(), true
            );

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            System.out.println("Introduce una cadena de caracteres: ");
            String cadena = Entrada.cadena();

            // Enviamos peticiones hasta que el usuario escriba "fin".
            while (!cadena.equals("fin")) {

                ps.println(cadena);

                String aleatorio = br.readLine();
                System.out.println(aleatorio);

                System.out.println("Introduce una cadena de caracteres: ");
                cadena = Entrada.cadena();
            }

            // Avisamos al proceso hijo de que debe finalizar.
            ps.println(cadena);

            // Cerramos los flujos y esperamos a que termine el hijo.
            ps.close();
            br.close();

            proceso.waitFor();

        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
            e.printStackTrace();

        } catch (InterruptedException e) {
            System.out.println("Error al esperar la finalización del proceso.");
            e.printStackTrace();
        }
    }
}