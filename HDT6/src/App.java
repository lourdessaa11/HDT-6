import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {       
        Scanner entradaDatos  = new Scanner(System.in); // lector de objetos
        Scanner opcionCartas  = new Scanner(System.in); // lector de objetos
        Reader archivo = new Reader();
        FactoryMaps factory;
        Map<String, String> mapsCartas;        
        Map<String, String> mapsUsuario;
        int opcion = 0;                
        
        while(opcion!=4) {
            System.out.println("Ingrese el tipo de mapa");
            System.out.print("1. HashMap\n");
            System.out.print("2. TreeMap\n");
            System.out.print("3. LinkedHashMap\n"); 
            System.out.print("4. Salir\n");        
            opcion = isNumCorrect(opcionCartas);                             
            System.out.println("Creando Mapa...");

            try             
            {
                factory = new FactoryMaps();
                mapsCartas = factory.createMap(opcion);  
                mapsCartas = archivo.cargarDatos(mapsCartas); // se crea el mapa de datos disponibles
                mapsUsuario = factory.createMap(opcion);  
                System.out.println("Mapa correctamente creado");                    
                int opcion2=0;
                // seleccion de operacion 
                while(opcion2!=7 &&  opcion!=4) {
                    System.out.println("Ingrese la operación que desea realizar");
                    System.out.print("1. Agregar carta a la colección\n");
                    System.out.print("2. Mostrar tipo de carta específica\n");
                    System.out.print("3. Mostrar nombre, tipo y cantidad de carta\n"); 
                    System.out.print("4. Mostrar nombre, tipo y cantidad de carta ordenadas por tipo\n"); 
                    System.out.print("5. Mostrar nombre y tipo de cartas existentes en catalogo\n"); 
                    System.out.print("6. Mostrar nombre y tipo de cartas existentes ordenadas por tipo en catalogo\n"); 
                    System.out.print("7. Salir\n"); 
                    opcion2=isNumCorrect(opcionCartas);    

                    switch(opcion2){
                        case 1: // Agregar carta a la coleccion
                            System.out.println("Ingresa el nombre de la carta");
                            String value = entradaDatos.nextLine();
                            Operaciones.ingresarDatos(mapsCartas, mapsUsuario, value); 
                        break;
                        case 2:// Mostrar tipo de carta especifica
                            System.out.println("Ingresa el nombre de la carta. Será buscada en el catálogo de cartas");
                            value = entradaDatos.nextLine();
                            Operaciones.mostrarTipo(mapsCartas, value);
                        break;
                        case 3: // Mostrar nombre, tipo y cantidad de carta
                            System.out.println("Se desplegaran sus cartas");
                            Operaciones.mostrarColeccion(mapsUsuario, false);
                        break;
                        case 4: // Mostrar nombre, tipo y cantidad de carta ordenados
                            System.out.println("Se desplegaran sus cartas ordenadas por tipo");
                            Operaciones.mostrarColeccion(mapsUsuario, true);
                        break;
                        case 5: // Mostrar nombre y tipo en catalogo
                            Operaciones.mostrarCatalogo(mapsCartas, false);
                        break;
                        case 6: // mostrar nombre y tipo en catalogo ordenado por tipo
                            Operaciones.mostrarCatalogo(mapsCartas, true);
                        break;
                        default:
                            opcion2=7;
                        break;
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }  

        }        
        entradaDatos.close();
        opcionCartas.close();    
    }

    private static Integer isNumCorrect(Scanner scanner) {
        boolean correct=false;
        String number = scanner.nextLine();
        int a=0;
        while(correct!=true) {
            try {
                a = Integer.parseInt(number);
                correct=true;            
            } catch (Exception e) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = scanner.nextLine();        
            }
        }        
        return a;
    }
}
