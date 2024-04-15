import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gramatica {
    public static String[][] Validacion(String codigo){
        //System.out.println(codigo);
        String[] codigoNuevo = divirCodigo(codigo);
        /*for (int i=0;i<codigoNuevo.length;i++ ) {
            System.out.println(codigoNuevo[i]);
        }*/
        String[][] compilado = TipoIdentificacion(codigoNuevo);
        return compilado;
    }
    public static String[][] TipoIdentificacion(String[] codigo){
        ArrayList<String> tipo = new ArrayList<String>();
        String[][] aux = new String[codigo.length][2];
        int finComillas = 0;
        String auxTipoFuncion,auxTipoVariable,auxTipoLetras,auxTipoNumeros,auxTipoOperadoresComparacion,auxTipoInicioCondicion,auxTipoFinCondicion,auxTipoInicioCuerpo,auxTipoFinCuerpo,auxTipoComillas = " ";
        //Identificacion de funciones y palabras Reservadas?
        for(int i=0;i<codigo.length;i++){
            auxTipoFuncion = Funciones(codigo[i]);
            if (auxTipoFuncion == "Funcion"){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoFuncion;
            }
            auxTipoVariable = Variable(codigo[i]);
            boolean test = Arrays.stream(aux).anyMatch(x -> x[1] == "Comillas");
            if(test == true && (finComillas%2 != 0)){
                //System.out.println("HAY COMIILAS");
                auxTipoLetras = Letras(codigo[i]);
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoLetras;
                finComillas = finComillas + 1;
            }
            if(auxTipoVariable == "Variable" && auxTipoComillas != "Comillas" && auxTipoFuncion != "Funcion"){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoVariable;
            }
            /*auxTipoLetras = Letras(codigo[i]);
            if(auxTipoLetras == "Letras" && auxTipoFuncion != "Funcion" && auxTipoVariable != " "){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoLetras;
            }*/

            auxTipoNumeros = Numeros(codigo[i]);
            if(auxTipoNumeros == "Numeros" ){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoNumeros;
            }
            auxTipoOperadoresComparacion = OperadoresComparacion(codigo[i]);
            if(auxTipoOperadoresComparacion == "OperadorComparacion"){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoOperadoresComparacion;
            }
            auxTipoInicioCondicion = InicioCondicion(codigo[i]);
            if(auxTipoInicioCondicion == "InicioCondicion"){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoInicioCondicion;
            }
            auxTipoFinCondicion = FinCondicion(codigo[i]);
            if(auxTipoFinCondicion == "FinCondicion"){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoFinCondicion;
            }
            auxTipoInicioCuerpo = InicioCuerpo(codigo[i]);
            if(auxTipoInicioCuerpo == "InicioCuerpo"){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoInicioCuerpo;
            }
            auxTipoFinCuerpo = FinCuerpo(codigo[i]);
            if(auxTipoFinCuerpo == "FinCuerpo"){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoFinCuerpo;
            }
            auxTipoComillas = Comillas(codigo[i]);
            if(auxTipoComillas == "Comillas"){
                aux[i][0] = codigo[i];
                aux[i][1] = auxTipoComillas;
                finComillas = finComillas + 1;
            }

            //tipo = Espacio(codigo[i],tipo);
        }
        /*for(int i=0;i<codigo.length;i++) {
            System.out.println(aux[i][0]+" "+aux[i][1]);
        }*/
        return aux;
    }
    public static String Letras(String codigo){
        String funcion = " ";
        Pattern patternLetras = Pattern.compile("[A-Za-z]");
        Matcher matcherLetras = patternLetras.matcher(codigo);
        boolean matchFoundLetras = matcherLetras.find();
        if(matchFoundLetras){
            funcion = "Letras";
        }
        return funcion;
    }
    public static String Numeros(String codigo){
        String funcion = " ";
        Pattern patternNumeros = Pattern.compile("[0-9]");
        Matcher matcherNumeros = patternNumeros.matcher(codigo);
        boolean matchFoundNumeros = matcherNumeros.find();
        if(matchFoundNumeros){
            funcion = "Numeros";
        }
        return funcion;
    }
    public static String OperadoresComparacion(String codigo){
        String funcion = " ";
        Pattern patternOperadoresComparacion = Pattern.compile("[==,>=,<=,<,>,!=,&&]");
        Matcher matcherOperadoresComparacion = patternOperadoresComparacion.matcher(codigo);
        boolean foundOperadoresComparacion = matcherOperadoresComparacion.find();
        if(foundOperadoresComparacion){
            funcion = "OperadorComparacion";
        }
        return funcion;
    }
    public static String InicioCondicion(String codigo){
        String funcion = " ";
        Pattern patternInicioCondicion = Pattern.compile("[(]");
        Matcher matcherInicioCondicion = patternInicioCondicion.matcher(codigo);
        boolean matchFoundInicioCondicion = matcherInicioCondicion.find();
        if(matchFoundInicioCondicion){
            funcion = "InicioCondicion";
        }
        return funcion;
    }
    public static String FinCondicion(String codigo){
        String funcion = " ";
        Pattern patternFinCondicion = Pattern.compile("[)]");
        Matcher matcherFinCondicion = patternFinCondicion.matcher(codigo);
        boolean matchFoundFinCondicion = matcherFinCondicion.find();
        if(matchFoundFinCondicion){
            funcion = "FinCondicion";
        }
        return funcion;
    }
    public static String InicioCuerpo(String codigo){
        String funcion = " ";
        Pattern patternInicioCuerpo = Pattern.compile("[{]");
        Matcher matcherInicioCuerpo = patternInicioCuerpo.matcher(codigo);
        boolean matchFoundInicioCuerpo = matcherInicioCuerpo.find();
        if(matchFoundInicioCuerpo){
           funcion = "InicioCuerpo";
        }
        return funcion;
    }
    public static String FinCuerpo(String codigo){
        String funcion = " ";
        Pattern patternFinCuerpo = Pattern.compile("[}]");
        Matcher matcherFinCuerpo = patternFinCuerpo.matcher(codigo);
        boolean matchFoundFinCuerpo = matcherFinCuerpo.find();
        if(matchFoundFinCuerpo){
            funcion = "FinCuerpo";
        }
        return funcion;
    }
    public static String Variable(String codigo){
        String funcion = " ";
        Pattern patternVariable = Pattern.compile("[A-Za-z0-9]");
        Matcher matcherVariable = patternVariable.matcher(codigo);
        boolean matchFoundVariable = matcherVariable.find();
        if(matchFoundVariable){
            funcion = "Variable";
        }
        return funcion;
    }
    public static String Comillas(String codigo){
        String funcion = " ";
        Pattern patternComillas = Pattern.compile("\"");
        Matcher matcherComillas = patternComillas.matcher(codigo);
        boolean matchFoundComillas = matcherComillas.find();
        if(matchFoundComillas){
            funcion = "Comillas";
        }
        return funcion;
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
    public static String Funciones(String codigo){
        //System.out.println(codigo);
        String funcion = " ";
        Pattern ifPattern = Pattern.compile("if");
        Matcher ifMatcher = ifPattern.matcher(codigo);
        boolean ifMatch = ifMatcher.find();
        if(ifMatch){
            funcion = "Funcion";
            return funcion;
        }
        //System.out.println(ifMatch);
        Pattern switchPattern = Pattern.compile("switch");
        Matcher switchMatcher = switchPattern.matcher(codigo);
        boolean switchMatch = switchMatcher.find();
        if(switchMatch){
            funcion = "Funcion";
            return funcion;
        }
        //System.out.println(switchMatch);
        Pattern forPattern = Pattern.compile("for");
        Matcher forMatcher = forPattern.matcher(codigo);
        boolean forMatch = forMatcher.find();
        if(forMatch){
            funcion = "Funcion";
            return funcion;
        }
        Pattern whilePattern = Pattern.compile("while");
        Matcher whileMatcher = whilePattern.matcher(codigo);
        boolean whileMatch = whileMatcher.find();
        if(whileMatch){
            funcion = "Funcion";
            return funcion;
        }
        Pattern doPattern = Pattern.compile("do");
        Matcher doMatcher = doPattern.matcher(codigo);
        boolean doMatch = doMatcher.find();
        if(doMatch){
            funcion = "Funcion";
            return funcion;
        }
        return funcion;
    }
    public static void main(String[] args){
        System.out.println("Prueba del archivo Gramatica");
    }
}
