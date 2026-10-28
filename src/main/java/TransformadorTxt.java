import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformadorTxt {

    public static void main(String[] args) {
        try {
            // Leemos los mensajes que el proceso padre envía por la entrada estándar.
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            String linea;

            // Leemos mensajes mientras la entrada siga abierta.
            while ((linea = br.readLine()) != null) {

                // Si recibimos "fin", terminamos el bucle y el proceso hijo.
                if (linea.equals("fin")) {
                    break;
                }

                // Convertimos el mensaje a mayúsculas y lo enviamos al proceso padre.
                System.out.println(linea.toUpperCase());

                // Nos aseguramos de que la respuesta se envíe inmediatamente.
                System.out.flush();
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
            e.printStackTrace();
        }
    }
}
