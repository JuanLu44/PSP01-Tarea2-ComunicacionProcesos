import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaVisualizador {

    public static void main(String[] args) {
        System.out.print("Introduce una cadena de caracteres: ");
        String cadena = Entrada.cadena();

        System.out.print("Introduce el número de repeticiones: ");
        String repeticiones = Entrada.cadena();

        // Preparamos el proceso hijo y le pasamos los argumentos.
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                "build/classes/java/main",
                "Visualizador"
        );

        pb.command().add(cadena);
        pb.command().add(repeticiones);

        try {
            // Iniciamos el proceso hijo.
            Process proceso = pb.start();

            // Leemos la salida que genera el proceso hijo.
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

            // Esperamos a que termine y obtenemos su código de salida.
            int codigoSalida = proceso.waitFor();

            System.out.println("Valor de salida: " + codigoSalida);

            // Mostramos el resultado según el código devuelto.
            switch (codigoSalida) {
                case 0:
                    System.out.println("Final Correcto");
                    break;

                case 1:
                    System.out.println("Final Incorrecto");
                    break;
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
            e.printStackTrace();

        } catch (InterruptedException e) {
            System.out.println("Error al esperar la finalización del proceso.");
            e.printStackTrace();
        }
    }
}