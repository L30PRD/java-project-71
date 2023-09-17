package hexlet.code;


import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Comparator {

    public static List<Map<String, Object>> comparator(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        NavigableSet<String> keys = new TreeSet<>();
        keys.addAll(firstMap.keySet());
        keys.addAll(secondMap.keySet());
        List<Map<String, Object>> list = new ArrayList<>();
        keys.
                forEach(key -> {
                    boolean mapContain1 = firstMap.containsKey(key);
                    boolean mapContain2 = secondMap.containsKey(key);
                    Object map1 = firstMap.get(key);
                    Object map2 = secondMap.get(key);
                    Map<String, Object> map = new HashMap<>();
                    if (!mapContain1) {
                        map.put("key", key);
                        map.put("new_value", map2);
                        map.put("status", "ADDED");
                    } else if (!mapContain2) {
                        map.put("key", key);
                        map.put("old_value", map1);
                        map.put("status", "REMOVED");
                    } else if (Objects.equals(map1, map2)) {
                        map.put("key", key);
                        map.put("old_value", map1);
                        map.put("status", "UNCHANGED");
                    } else {
                        map.put("key", key);
                        map.put("old_value", map1);
                        map.put("new_value", map2);
                        map.put("status", "UPDATED");
                    }
                    list.add(map);
                });
        return list;
    }
}
