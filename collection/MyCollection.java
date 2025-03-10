import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MyCollection {

    private static <K, V> void print(HashMap<K, V> map) {
        Set<K>       keys   = map.keySet();
        ArrayList<V> values = new ArrayList<>(map.values());
        
        System.out.println("Ключи   : " + keys.toString());
        System.out.println("Значения: " + values.toString());
    }

    private static int myFrequency(
        Collection<?> collection, 
        Object        object)  {
        
        int result = 0;   
        for (Object item : collection) {
            if (object.equals(item))  {
                result++;
            }
        }

        return result;
    }

    private static <T> HashMap<T, Integer> collectionInverse(ArrayList<T> values) {
        HashMap<T, Integer> newMap = new HashMap<>();

        for (T item : values) {
            newMap.put(item, 
                       myFrequency(values, item));
        }

        return newMap;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(2121339, "Лидия Аркадьевна Бубликова");
        map.put(1623487, "Иван Михайлович Серебряков");
        map.put(8082771, "Петров Генадий Шариков");
        map.put(8082671, "Петров Генадий Шариков");
        map.put(3638478, "Иван Михайлович Серебряков");
        map.put(3638383, "Иван Михайлович Серебряков");
        map.put(3668383, "Иван Михайлович Серебряков");

        HashMap<String, Integer> newMap = collectionInverse(new ArrayList<>(map.values()));
        print(newMap);
    }
}
