import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entradaDatos  = new Scanner(System.in); // lector de objetos
        Scanner opcionCartas  = new Scanner(System.in); // lector de objetos
        Reader archivo = new Reader();
        
        int opcion = 0;                
        FactoryMaps factory;
        Map<String, String> mapsCartas;
        Map<String, String> mapsUsuario;
        while(opcion!=4) {
            System.out.println("Ingrese el tipo de mapa");
            System.out.print("1. HashMap\n");
            System.out.print("2. TreeMap\n");
            System.out.print("3. LinkedHashMap\n"); 
            System.out.print("4. Salir\n");        
            opcion = entradaDatos.nextInt();     
                
            System.out.println("Creando Mapa...");
            try 
            {
                factory = new FactoryMaps();
                mapsCartas = factory.createMap(opcion);  
                mapsUsuario = factory.createMap(opcion);  
                System.out.println("Mapa correctamente creado");                    
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }  

        }        
        entradaDatos.close();
    }
}
