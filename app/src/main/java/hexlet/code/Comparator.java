package hexlet.code;

import java.util.*;

public class Comparator {

    public static List<Difference> comparator (Map<String, Object> firstMap, Map<String, Object> secondMap) {
        NavigableSet<String> keys = new TreeSet<>();
        keys.addAll(firstMap.keySet());
        keys.addAll(secondMap.keySet());
        List<Difference> list = new ArrayList<>();
        keys.
                forEach(key -> {
                    boolean mapContain1 = firstMap.containsKey(key);
                    boolean mapContain2 = secondMap.containsKey(key);
                    Object map1 = firstMap.get(key);
                    Object map2 = secondMap.get(key);
                    Difference difference;
                    if(!mapContain1) {
                        difference = new Difference("+", key , map2);
                    } else if (!mapContain2) {
                        difference = new Difference("-", key, map1);
                    } else if (Objects.equals(map1, map2)) {
                        difference = new Difference(" ", key, map1);
                    } else {
                        difference = new Difference("+", key, map1, map2);
                    }
                    list.add(difference);
                });
        return list;
    }
}
