import java.util.*;
import java.util.stream.Stream;
public class Operaciones {
    private Operaciones(){}
    
    public static void ingresarDatos(Map<String, String> cartas,Map<String,ArrayList<String>> usuario, String nombre){    
        boolean encontrado=false;
        for (Map.Entry<String, String> element : cartas.entrySet()) {            
            if(element.getKey().equals(nombre.toUpperCase())) {
                ArrayList<String> itemsList = usuario.get(nombre);
                if(itemsList == null) {
                    itemsList = new ArrayList<String>();
                    itemsList.add(element.getValue());
                    usuario.put(nombre, itemsList);  
               } else {
                   // si el elemento ya existe
                   if(itemsList.contains(element.getValue())) itemsList.add(element.getValue());
               }                                                    
                encontrado=true;
                System.out.println("La carta "+nombre+" de tipo "+element.getValue()+" ha sido agregada");
            }
        } 
        if(encontrado==false) System.out.println("Esta carta no existe, no será agregada");      
    }

    public static void mostrarTipo(Map<String, String> cartas, String nombre) {
        boolean encontrado=false;
        for (Map.Entry<String, String> element : cartas.entrySet()) {
            if(element.getKey().equals(nombre.toUpperCase())) {
                System.out.println("La carta "+nombre+" es de tipo "+element.getValue());   
                encontrado=true;  
            }
        }         
        if(encontrado==false) 
            System.out.println("Esta carta no existe entre el catálogo de cartas");

    }

    public static void mostrarColeccion(Map<String, ArrayList<String>> usuarioCartas, boolean ordenado){
        Map<String, String> nuevo = new HashMap<>();
        String element;  
    
        if(!ordenado) {
            for (Map.Entry<String, ArrayList<String>> entry : usuarioCartas.entrySet()) {                                                     
                System.out.println("El usuario tiene: "+entry.getValue().size()+" veces la carta "+entry.getKey()+" de tipo "+entry.getValue().get(0));
            }
        }  else { // es porque tiene que estar ordenado
            for (Map.Entry<String, ArrayList<String>> entry : usuarioCartas.entrySet()) {                       
                element = "El usuario tiene: "+entry.getValue().size()+" veces la carta "+entry.getKey()+ " de tipo ";        
                nuevo.put(element, entry.getValue().get(0));                           
            }
            
            Stream<Map.Entry<String, String>> sorted = nuevo.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue());
		sorted.forEach(System.out::println);
        }        
    }

    public static void mostrarCatalogo(Map<String, String> cartasCatalogo, boolean ordenado) {
        if(ordenado==true){
            Stream<Map.Entry<String, String>> sorted = cartasCatalogo.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue());
		sorted.forEach(System.out::println);
        } else {
            for (Map.Entry<String, String> element : cartasCatalogo.entrySet()) {            
                System.out.println("Nombre de carta: "+element.getKey()+". Tipo de carta: "+element.getValue());            
            }
        }        
    }
}
