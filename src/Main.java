import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    Gramatica gr = new Gramatica();
    public static boolean Letras(String prueba,int index) {
        Pattern patternLetras = Pattern.compile("[A-Za-z]");
        Matcher matcherLetras = patternLetras.matcher(String.valueOf(prueba.charAt(index)));
        boolean matchFoundLetras = matcherLetras.find();
        return matchFoundLetras;
    }
    public static boolean Numeros(String prueba,int index) {
        Pattern patternNumeros = Pattern.compile("[0-9]");
        Matcher matcherNumeros = patternNumeros.matcher(String.valueOf(prueba.charAt(index)));
        boolean matchFoundNumeros = matcherNumeros.find();
        return matchFoundNumeros;
    }
    public static boolean OperadoresComparacion(String prueba,int index){
        Pattern patternOperadoresComparacion = Pattern.compile("[==,>=,<=,<,>,!=,&&]");
        Matcher matcherOperadoresComparacion = patternOperadoresComparacion.matcher(String.valueOf(prueba.charAt(index)));
        boolean matchFoundOperadoresComparacion = matcherOperadoresComparacion.find();
        return matchFoundOperadoresComparacion;
    }
    public static boolean InicioCondicion(String prueba,int index){
        Pattern patternInicioCondicion = Pattern.compile("[(]");
        Matcher matcherInicioCondicion = patternInicioCondicion.matcher(String.valueOf(prueba.charAt(index)));
        boolean matchFoundInicioCondicion = matcherInicioCondicion.find();
        return matchFoundInicioCondicion;
    }
    public static boolean FinCondicion(String prueba,int index){
        Pattern patternFinCondicion = Pattern.compile("[)]");
        Matcher matcherFinCondicion = patternFinCondicion.matcher(String.valueOf(prueba.charAt(index)));
        boolean matchFoundFinCondicion = matcherFinCondicion.find();
        return matchFoundFinCondicion;
    }
    public static boolean InicioCuerpo(String prueba,int index){
        Pattern patternInicioCuerpo = Pattern.compile("[{]");
        Matcher matcherInicioCuerpo = patternInicioCuerpo.matcher(String.valueOf(prueba.charAt(index)));
        boolean matchFoundInicioCuerpo = matcherInicioCuerpo.find();
        return matchFoundInicioCuerpo;
    }
    public static boolean FinCuerpo(String prueba,int index){
        Pattern patternFinCuerpo = Pattern.compile("[}]");
        Matcher matcherFinCuerpo = patternFinCuerpo.matcher(String.valueOf(prueba.charAt(index)));
        boolean matchFoundFinCuerpo = matcherFinCuerpo.find();
        return matchFoundFinCuerpo;
    }
    public static boolean Espacio(String prueba,int index){
        Pattern patternEspacio = Pattern.compile("[ ]");
        Matcher matcherEspacio = patternEspacio.matcher(String.valueOf(prueba.charAt(index)));
        boolean matchFoundEspacio = matcherEspacio.find();
        return matchFoundEspacio;
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.printf("Hello and welcome!");
        String prueba = "switch ( 5l >= 10 ){ }";
        Gramatica.Validacion(prueba);
        ArrayList<String> charsStr = new ArrayList<String>();
        System.out.println(prueba.charAt(1));
        for (int i=0;i<prueba.length();i++){
            charsStr.add(String.valueOf(prueba.charAt(i)));
        }
        Pattern pattern = Pattern.compile("if");
        Matcher matcher = pattern.matcher(String.valueOf(prueba.charAt(0))+String.valueOf(prueba.charAt(1)));
        boolean matchFound = matcher.find();
        int index = 2;
        boolean coinLetras,coinEspacios,coinOp,coinNumero,coinInicioCondicion,coinFinCondicion,coinInicioCuerpo,coinFinCuerpo = false;
        if(matchFound){
            //CICLO PARA ENCONTRAR EL INICIO DEL PARENTESIS CONDICION
            for (int i=index;i<prueba.length();i++){
                coinLetras = Letras(prueba,i);
                coinEspacios = Espacio(prueba,i);
                coinOp = OperadoresComparacion(prueba,i);
                coinNumero = Numeros(prueba,i);
                coinInicioCondicion = InicioCondicion(prueba,i);
                coinFinCondicion = FinCondicion(prueba,i);
                coinInicioCuerpo = InicioCuerpo(prueba,i);
                coinFinCuerpo = FinCuerpo(prueba,i);
                if (coinLetras){
                    System.out.println("Letra");
                }
                if (coinEspacios){
                    System.out.println("Espacio");
                }
                if (coinOp){
                    System.out.println("Operaadores");
                }
                if (coinNumero){
                    System.out.println("Numero");
                }
                if (coinInicioCondicion){
                    System.out.print("InicioCondicion");
                }
                if (coinFinCondicion){
                    System.out.print("FinCondicion");
                }
                if (coinInicioCuerpo){
                    System.out.println("InicioCuerpo");
                }
                if (coinFinCuerpo){
                    System.out.println("FinCuerpo");
                }
            }

        }
    }
}
//ANTLER