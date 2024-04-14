import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        String prueba = "switch \" stringAux \" ( aux >= 10 ) { }";
        Gramatica.Validacion(prueba);
    }
}
//ANTLER