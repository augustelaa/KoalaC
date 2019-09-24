package Biblioteca;

public class StringUtils {
    public static int line = 0;
    public static int getLine(String t, String code, int pos) {
        int column = 0;

        String[] teste = code.split("\n");
        for (int cont = line; cont <= (teste.length - 1); cont++) {
            line++;
            String[] teste1 = teste[cont].split(" ");
            if (teste1.length > 0) {
                for (int cont1 = column; cont1 <= (teste1.length - 1); cont1++) {
                    if (teste1[cont1].equalsIgnoreCase(t)) {
                        column = cont1 + 1;
                        return cont + 1;
                    }
                }
                line = cont + 1;
            }
        }
        return -1;
    }
}