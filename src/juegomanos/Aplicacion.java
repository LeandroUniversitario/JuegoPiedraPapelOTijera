

package juegomanos;


import java.util.Scanner;


public class Aplicacion {
    //tareas:
    //insertar la opcion a jugar
    //elegir una opcion aleatoria para la maquina
    //comparar los resultados
    //mostrarResultado
    private final String[] opciones;
    public Aplicacion() {
        opciones= new String[]{"piedra","papel","tijera"};
    }
    public String ingresarOpUsuario(){
        Scanner tec;
        String cadena;
        tec=new Scanner(System.in);
        do {
           System.out.println("Ingresar su opcion a jugar: piedra/papel/tijera");
           cadena = tec.nextLine();
          
        } while (!validarCadena(cadena)); // repite mientras esté vacío

        return cadena;
    }
    public boolean validarCadena(String cadena){
       boolean respuesta;
       respuesta=false;
        for (String opcion : opciones) {
            if (cadena.equalsIgnoreCase(opcion)) {
                respuesta=true;
            }
        }
       return respuesta;
    }
    public String elegirOpMaquina(){
        String cadena;
        int numAle;
        do {            
            numAle=(int)(Math.random() * (2 - 0 + 1)) + 0;
            cadena=opciones[numAle];
        } while (!validarCadena(cadena));
        return cadena;
    }
    public boolean compararResultados(String opMaquina, String opUsuario){
        boolean respuesta;
        respuesta=false;
        if ((opUsuario.equalsIgnoreCase(opciones[0]) && opMaquina.equalsIgnoreCase(opciones[2])) || // Piedra > Tijera
        (opUsuario.equalsIgnoreCase(opciones[1]) && opMaquina.equalsIgnoreCase(opciones[0])) || // Papel > Piedra
        (opUsuario.equalsIgnoreCase(opciones[2]) && opMaquina.equalsIgnoreCase(opciones[1])))   // Tijera > Papel
        {
            respuesta = true;
        }
        return respuesta;
    }
    public void mostrarResultados(boolean resultado,String opMaquina, String opUsuario){
        System.out.println("tu opcion: "+opUsuario);
        System.out.println("opcion de la maquina: "+opMaquina);
        if (resultado) {
            System.out.println("FELICIDADES!! GANASTE CRACK UWU");
        }else{
            System.out.println("perdiste campeon pipipi, gana la maquina");
        }
    }
    public static void main(String[] args) {
        Aplicacion ap;
        String opUsuario,opMaquina;
        boolean resultado;
        ap= new Aplicacion();
        opUsuario=ap.ingresarOpUsuario();
        opMaquina=ap.elegirOpMaquina();
        resultado= ap.compararResultados(opMaquina,opUsuario);
        ap.mostrarResultados(resultado,opMaquina,opUsuario);
    }

}
