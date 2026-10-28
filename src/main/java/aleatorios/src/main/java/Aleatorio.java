import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aleatorio {

    public static void main(String[] args) {

        // Leemos las peticiones que llegan del proceso padre.
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        try {
            String cadena = br.readLine();

            // Generamos números hasta recibir la petición "fin".
            while (!cadena.equals("fin")) {

                int aleatorio = (int) (Math.random() * 11);
                System.out.println(aleatorio);

                cadena = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
            e.printStackTrace();
        }
    }
}