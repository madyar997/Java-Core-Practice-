package Collections.Maps;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //HashMap
        Map<String, Integer> products = new HashMap<>();
        products.put("Apples", 5);
        products.put("Onions", 2);
        products.put("Carrots", 4);
        products.put("Tomato", 3);
        products.put("Boobs", 2);
        products.remove("Carrots");
        products.put("Carrots", 4);

        for(Map.Entry<String,Integer> entrySet: products.entrySet()){
            System.out.println(entrySet.getKey() + ": " + entrySet.getValue());
        }
        System.out.println(products.get("Apples"));
        Set<String> keySet = products.keySet();
        Collection<Integer> values = products.values();

        //SortedMap
        NavigableMap<String,Integer> cars = new TreeMap<>(products);
        cars.descendingKeySet();
        System.out.println(cars);
        Map<String, Integer> linkedMap = new LinkedHashMap<>(products);
        System.out.println(linkedMap);
    }

}
