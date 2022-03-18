import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

/**
 * Utilizada para poder leer el archivo de texto
 * @author Mariel Guamuche
 * @author Lourdes Saavedra
 * **/
public class Reader {
    private ArrayList<String> expressionKeys = new ArrayList<>();
    private ArrayList<String> expressionValues = new ArrayList<>();

    /**
     * Realiza la lectura del archivo indicado y llena las listas de los atributos según lo leído del archivo
     */
    private void readerFile() {
        try {
            File myObj = new File("cards_desc.txt"); //archivo que se leera
            Scanner myReader = new Scanner(myObj);   // objeto Scanner para realizar lectura de datos
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();  // obtiene la linea leida 
                int separator = data.indexOf("|");  // se obtiene el index donde se encuentra el separador
                String key = data.substring(0, separator); // se obtiene el nombre de la carta
                String value = data.substring(separator+1, data.length()); // se obtiene el tipo de carta
                this.expressionKeys.add(key); // se agrega al arraylist de llaves
                this.expressionValues.add(value); // se agrega al arraylist de valores
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }        
    }

    /**
     * Llena de datos el mapa indicado
     * @param mapaCartas mapa que se desea que se asignen los datos leídos del archivo
     * */
    public  Map<String, String> cargarDatos(Map<String, String> mapaCartas) {
        int i=0;
        readerFile();
        while(i<expressionKeys.size()) {
            mapaCartas.put(this.expressionKeys.get(i).toUpperCase(), this.expressionValues.get(i).toUpperCase()); // se agrega la carta al mapa
            i++; // aumento del valor que recorre los arraylist
        }
        return mapaCartas;
    }
}
