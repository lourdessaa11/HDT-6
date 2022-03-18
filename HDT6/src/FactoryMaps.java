import java.util.*;

public class FactoryMaps {
    
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
