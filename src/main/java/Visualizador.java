public class Visualizador {

    public static void main(String[] args) {

        // Si la cadena está vacía, mostramos un mensaje y finalizamos con código 1.
        if (args[0].isEmpty()) {
            System.out.println("Cadena introducida vacía");
            System.exit(1);
        }

        // Obtenemos la cadena y el número de repeticiones de los argumentos.
        String cadena = args[0];
        int repeticiones = Integer.parseInt(args[1]);

        // Mostramos la cadena el número de veces indicado.
        for (int i = 1; i < repeticiones + 1; i++) {
            System.out.println(i + ". " + cadena);
        }
    }
}