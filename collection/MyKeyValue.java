import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MyKeyValue {

    private static <K, V> void print(HashMap<K, V> map) {
        Set<K>       keys   = map.keySet();
        ArrayList<V> values = new ArrayList<>(map.values());
        
        System.out.println("Ключи   : " + keys.toString());
        System.out.println("Значения: " + values.toString());
    }

    private static <K, V> HashMap<V, K> invertMap(HashMap<K, V> map) {
        HashMap<V, K> newMap = new HashMap<>();

        for (K key :  map.keySet()) {
            newMap.put(map.get(key), key);
        }

        return newMap;
    } 

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        
        map.put(2121339, "Лидия Аркадьевна Бубликова");
        map.put(1623487, "Иван Михайлович Серебряков");
        map.put(8082771, "Петров Генадий Шариков");
        map.put(8082771, "Петров Генадиьевич Шариков");
        map.put(8082671, "Петров Генадий Шариков");
        map.put(3638478, "Иван Михайлович Серебряков");
        map.put(3638383, "Иван Михайлович Серебряков");
        map.put(3668383, "Иван Михайлович Серебряков");

        HashMap<String, Integer> newMap = invertMap(map);
        print(newMap);

    }
}
