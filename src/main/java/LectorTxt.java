import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class LectorTxt {

    public static void main(String[] args) {

        // Preparamos el proceso hijo que ejecutará TransformadorTxt.
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                "build/classes/java/main",
                "TransformadorTxt"
        );

        try {
            // Iniciamos el proceso hijo.
            Process proceso = pb.start();

            // Permite enviar mensajes desde el padre a la entrada del hijo.
            // El valor true activa el vaciado automático del flujo al usar println.
            PrintStream ps = new PrintStream(
                    proceso.getOutputStream(), true
            );

            // Permite leer las respuestas que el hijo escribe por su salida estándar.
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            // Permite leer los mensajes que introduce el usuario por teclado.
            BufferedReader teclado = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            String linea;

            // Leemos mensajes hasta que se cierre la entrada estándar.
            while ((linea = teclado.readLine()) != null) {

                // Enviamos el mensaje introducido al proceso hijo.
                ps.println(linea);

                // Si el usuario escribe "fin", avisamos al hijo y salimos del bucle.
                if (linea.equals("fin")) {
                    break;
                }

                // Leemos la respuesta del hijo y la mostramos por consola.
                String respuesta = br.readLine();
                System.out.println(respuesta);
            }

            // Cerramos el flujo utilizado para enviar mensajes al hijo.
            ps.close();

            // Esperamos a que el proceso hijo termine y obtenemos su código de salida.
            int codigoSalida = proceso.waitFor();

            // Cerramos el lector que recibe las respuestas del hijo.
            br.close();

            // Mostramos el resultado de la finalización del proceso hijo.
            System.out.println("Proceso hijo finalizado: " + codigoSalida);

        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
            e.printStackTrace();

        } catch (InterruptedException e) {
            System.out.println("Error al esperar la finalización del proceso.");
            e.printStackTrace();
        }

    }
}
