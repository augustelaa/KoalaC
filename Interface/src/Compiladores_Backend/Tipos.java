package Compiladores_Backend;

public enum Tipos {
    t_int64, t_float64, t_bool, t_double, t_string;

    public static String retornarOperadorDotNet(Tipos tipo) {
        switch (tipo) {
            case t_int64:
                return "int64";
            case t_float64:
                return "float64";
            case t_bool:
                return "bool";
            case t_string:
                return "string";
        }
        return "";
    }
}
