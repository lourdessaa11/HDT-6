import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;
public class Operaciones {
    private Operaciones(){}
    
    public static void ingresarDatos(Map<String, String> cartas,Map<String,String> usuario, String nombre){    
        boolean encontrado=false;
        for (Map.Entry<String, String> element : cartas.entrySet()) {
            if(element.getKey().equals(nombre.toUpperCase())) {
                usuario.put(nombre, element.getValue());      
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

    public static void mostrarColeccion(Map<String, String> usuarioCartas, boolean ordenado){
        Map<String, String> nuevo = new HashMap<>();
        String element;  
        int count=0;      
        for (Map.Entry<String, String> entry : usuarioCartas.entrySet()) 
        {                       
            element = entry.getKey();
            for (Map.Entry<String, String> entry2 : usuarioCartas.entrySet()) {
                if(element.equals(entry2.getKey())) {
                    if(nuevo.containsKey(entry.getKey())){
                        // no se cuenta 
                    }else { 
                        count++;
                    }
                }                
            }
            nuevo.put(element, entry.getValue()+"|"+count);
            count=0;
        }
        if(!ordenado) {
            for (Map.Entry<String, String> entry : nuevo.entrySet()) {
                String tipo = entry.getValue().substring(0,entry.getValue().indexOf("|"));
                String cantidad = entry.getValue().substring(entry.getValue().indexOf("|")+1,entry.getValue().length());
                System.out.println("El usuario tiene: "+cantidad+" veces la carta " +entry.getKey()+" de tipo "+tipo);
            }
        } else {
            // ordenado
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
