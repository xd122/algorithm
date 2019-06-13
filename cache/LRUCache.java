import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * *********************************************************
 * From XD: God only helps those who help themselves
 * *********************************************************
 * Author : xiangdong
 * Time : 2019/5/21
 * Package : PACKAGE_NAME
 * ProjectName: mingo
 * Describe :
 * ============================================================
 */
public class LRUCache {
    private HashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.8f, true) {
            private static final long serialVersionUID = -8210507570355805997L;

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache != null && cache.size() > 0) {
            return cache.getOrDefault(key, -1);
        }
        return -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
