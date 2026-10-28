import java.io.IOException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class EjecutaValidaArgumentos {

    public static void main(String[] args) {

        // Pedimos al usuario el argumento que recibirá el proceso hijo.
        // Si pulsa Enter sin escribir nada, se ejecutará sin argumentos.
        System.out.print("Introduce un argumento (o pulsa Enter para ninguno): ");
        String argumento = Entrada.cadena();

        // Preparamos el comando para ejecutar ValidaArgumentos.
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                "build/classes/java/main",
                "ValidaArgumentos"
        );

        // Añadimos el argumento únicamente si el usuario ha introducido texto.
        if (!argumento.isEmpty()) {
            pb.command().add(argumento);
        }

        try {
            // Iniciamos el proceso hijo.
            Process proceso = pb.start();

            // Esperamos a que termine y obtenemos su código de salida.
            int codigoSalida = proceso.waitFor();

            // Mostramos el código devuelto por ValidaArgumentos.
            System.out.println("Valor de salida: " + codigoSalida);

            // Interpretamos el código de salida y mostramos el mensaje correspondiente.
            switch (codigoSalida) {
                case 1:
                    System.out.println("No hay argumentos...");
                    break;

                case 2:
                    System.out.println("Es una cadena...");
                    break;

                case 3:
                    System.out.println("Número menor que 0...");
                    break;

                case 4:
                    System.out.println("Número mayor o igual que 0...");
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
