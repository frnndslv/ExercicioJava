package Console;

import java.util.Scanner;

public class Console {

    private static Scanner console = new Scanner(System.in);

    public static int lerInt() {
        int valor = console.nextInt();

        return valor;
    }

    public static String lerString() {
        String valor = console.next();

        return valor;
    }

}
