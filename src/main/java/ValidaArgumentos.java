public class ValidaArgumentos {

    public static void main(String[] args) {

        // Comprobamos si el programa se ha ejecutado sin argumentos.
        if (args.length == 0) {
            System.exit(1);
        }

        try {
            // Convertimos el primer argumento de texto a un número entero.
            int numero = Integer.parseInt(args[0]);

            // Devolvemos un código según el valor del número recibido.
            if (numero < 0) {
                System.exit(3); // El número es menor que cero.
            } else {
                System.exit(4); // El número es mayor o igual que cero.
            }

        } catch (NumberFormatException e) {
            // Si el argumento no representa un entero válido, devolvemos el código 2.
            System.exit(2);
        }
    }
}
