import java.util.*;
/**
 * Implementación de patrón de diseño Factory
 * @author Mariel Guamuche
 * @author Lourdes Saavedra
 * **/
public class FactoryMaps {
    /**
     * Instancia el objeto de acuerdo a la elección del usuario para el catálogo de cartas
     * @param action: Integer de implementación requerida
     * **/
    public Map<String, String> createMap (Integer action) {
        switch (action){
            case 1:                
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                System.out.println("No es una operacion valida");
                return Collections.emptyMap();
        }
    }

    /**
     * Instancia el objeto de acuerdo a la elección del usuario para la colección del usuario
     * @param action: Integer de implementación requerida
     * **/
    public Map<String, ArrayList<String>> createMapU (Integer action) {
        switch (action){
            case 1:                
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                System.out.println("No es una operacion valida");
                return Collections.emptyMap();
        }
    }
}
