import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperacionesTest {
    Map<String, ArrayList<String>> hash;
    Map<String, ArrayList<String>> tree;
    Map<String, ArrayList<String>> linked;

    Map<String, ArrayList<String>> hash1;
    Map<String, ArrayList<String>> tree1;
    Map<String, ArrayList<String>> linked1;
    
    Map<String, String> mapsCartas;
    @Test
    void setUp(){
        hash = new HashMap<>();
        tree = new TreeMap<>();
        linked = new LinkedHashMap<>();

        hash1 = new HashMap<>();
        tree1 = new TreeMap<>();
        linked1 = new LinkedHashMap<>();
        Reader archivo = new Reader();
        mapsCartas = archivo.cargarDatos(mapsCartas);
    }
    
    @Test
    public void testIngresarDatos() {
        ArrayList<String> dato = new ArrayList<>();
        dato.add("Bebe");
        dato.add("Bebe");
        dato.add("Bebe");
        hash.put("Hola", dato);
        Operaciones.ingresarDatos(mapsCartas, hash1, "Bebe");
        Operaciones.ingresarDatos(mapsCartas, hash1, "Bebe");
        Operaciones.ingresarDatos(mapsCartas, hash1, "Bebe");
        assertEquals(hash, hash1);
    }

    @Test
    public void testMostrarCatalogo() {

    }

    @Test
    public void testMostrarColeccion() {

    }

    @Test
    public void testMostrarTipo() {

    }
}
