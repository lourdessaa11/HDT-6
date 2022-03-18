import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class FactoryMapsTest {

	FactoryMaps factory = new FactoryMaps();
	HashMap<String, String> hashMap = new HashMap<String, String>();
	TreeMap<String, String> treeMap = new TreeMap<String, String>();
	LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
	
	@Test
	void testCreateMap() {
		
		assertEquals(hashMap.getClass(),factory.createMap(1).getClass());
		assertEquals(treeMap.getClass(),factory.createMap(2).getClass());
		assertEquals(linkedHashMap.getClass(),factory.createMap(3).getClass());
		
	}

}
