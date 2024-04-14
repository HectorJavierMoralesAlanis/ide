import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gramatica {
    public static void Validacion(String codigo){
        //System.out.println(codigo);
        String[] codigoNuevo = divirCodigo(codigo);
        for (int i=0;i<codigoNuevo.length;i++ ) {
            System.out.println(codigoNuevo[i]);
        }
        TipoIdentificacion(codigoNuevo);
    }
    public static void TipoIdentificacion(String[] codigo){
        ArrayList<String> tipo = new ArrayList<String>();
        boolean aux;
        //Identificacion de funciones y palabras Reservadas?
        for(int i=0;i<codigo.length;i++){
            tipo = Funciones(codigo[i],tipo);
            tipo = Letras(codigo[i], tipo);
            tipo = Numeros(codigo[i],tipo);
            tipo = OperadoresComparacion(codigo[i],tipo);
            tipo = InicioCondicion(codigo[i],tipo);
            tipo = FinCondicion(codigo[i],tipo);
            tipo = InicioCuerpo(codigo[i],tipo);
            tipo = FinCuerpo(codigo[i],tipo);
            tipo = Espacio(codigo[i],tipo);
        }
        System.out.println(tipo);
    }
    public static ArrayList<String> Letras(String codigo,ArrayList<String> tipo){
        Pattern patternLetras = Pattern.compile("[A-Za-z]");
        Matcher matcherLetras = patternLetras.matcher(codigo);
        boolean matchFoundLetras = matcherLetras.find();
        if(matchFoundLetras){
            tipo.add("Letras");
        }
        return tipo;
    }
    public static ArrayList<String> Numeros(String codigo,ArrayList<String> tipo){
        Pattern patternNumeros = Pattern.compile("[0-9]");
        Matcher matcherNumeros = patternNumeros.matcher(codigo);
        boolean matchFoundNumeros = matcherNumeros.find();
        if(matchFoundNumeros){
            tipo.add("Numeros");
        }
        return tipo;
    }
    public static ArrayList<String> OperadoresComparacion(String codigo,ArrayList<String> tipo){
        Pattern patternOperadoresComparacion = Pattern.compile("[==,>=,<=,<,>,!=,&&]");
        Matcher matcherOperadoresComparacion = patternOperadoresComparacion.matcher(codigo);
        boolean foundOperadoresComparacion = matcherOperadoresComparacion.find();
        if(foundOperadoresComparacion){
            tipo.add("OperadorComparacion");
        }
        return tipo;
    }
    public static ArrayList<String> InicioCondicion(String codigo,ArrayList<String> tipo){
        Pattern patternInicioCondicion = Pattern.compile("[(]");
        Matcher matcherInicioCondicion = patternInicioCondicion.matcher(codigo);
        boolean matchFoundInicioCondicion = matcherInicioCondicion.find();
        if(matchFoundInicioCondicion){
            tipo.add("InicioCondicion");
        }
        return tipo;
    }
    public static ArrayList<String> FinCondicion(String codigo,ArrayList<String> tipo){
        Pattern patternFinCondicion = Pattern.compile("[)]");
        Matcher matcherFinCondicion = patternFinCondicion.matcher(codigo);
        boolean matchFoundFinCondicion = matcherFinCondicion.find();
        if(matchFoundFinCondicion){
            tipo.add("FinCondicion");
        }
        return tipo;
    }
    public static ArrayList<String> InicioCuerpo(String codigo,ArrayList<String> tipo){
        Pattern patternInicioCuerpo = Pattern.compile("[{]");
        Matcher matcherInicioCuerpo = patternInicioCuerpo.matcher(codigo);
        boolean matchFoundInicioCuerpo = matcherInicioCuerpo.find();
        if(matchFoundInicioCuerpo){
            tipo.add("InicioCuerpo");
        }
        return tipo;
    }
    public static ArrayList<String> FinCuerpo(String codigo,ArrayList<String> tipo){
        Pattern patternFinCuerpo = Pattern.compile("[}]");
        Matcher matcherFinCuerpo = patternFinCuerpo.matcher(codigo);
        boolean matchFoundFinCuerpo = matcherFinCuerpo.find();
        if(matchFoundFinCuerpo){
            tipo.add("FinCuerpo");
        }
        return tipo;
    }
    public static ArrayList<String> Espacio(String codigo,ArrayList<String> tipo){
        Pattern patternEspacio = Pattern.compile("[ ]");
        Matcher matcherEspacio = patternEspacio.matcher(codigo);
        boolean matchFoundEspacio = matcherEspacio.find();
        if(matchFoundEspacio){
            tipo.add("Espacio");
        }
        return tipo;
    }
    public static String[] divirCodigo(String codigo) {
        ArrayList<String> charsStr = new ArrayList<String>();
        String[]  codigoDivido = codigo.split("[\\s]");
        return codigoDivido;
    }
    public static ArrayList<String> Funciones(String codigo,ArrayList<String> funcion){
        //System.out.println(codigo);
        Pattern ifPattern = Pattern.compile("if");
        Matcher ifMatcher = ifPattern.matcher(codigo);
        boolean ifMatch = ifMatcher.find();
        if(ifMatch){
            funcion.add("Funcion");
        }
        //System.out.println(ifMatch);
        Pattern switchPattern = Pattern.compile("switch");
        Matcher switchMatcher = switchPattern.matcher(codigo);
        boolean switchMatch = switchMatcher.find();
        if(switchMatch){
            funcion.add("Funcion");
        }
        //System.out.println(switchMatch);
        Pattern forPattern = Pattern.compile("for");
        Matcher forMatcher = forPattern.matcher(codigo);
        boolean forMatch = forMatcher.find();
        if(forMatch){
            funcion.add("Funcion");
        }
        Pattern whilePattern = Pattern.compile("while");
        Matcher whileMatcher = whilePattern.matcher(codigo);
        boolean whileMatch = whileMatcher.find();
        if(whileMatch){
            funcion.add("Funcion");
        }
        Pattern doPattern = Pattern.compile("do");
        Matcher doMatcher = doPattern.matcher(codigo);
        boolean doMatch = doMatcher.find();
        if(doMatch){
            funcion.add("Funcion");
        }
        return funcion;
    }
    public static void main(String[] args){
        System.out.println("Prueba del archivo Gramatica");
    }
}
