import java.util.LinkedHashMap;

public class LRU<K, V> extends LinkedHashMap<K, V> {

    private int capacity;
    public LRU(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        if (size() >  capacity) {
            return true;
        }
        return false;
    }

    public V get(Object key) {
        return super.get(key);
    }

    public V put(K key, V value) {
        return super.put(key, value);
    }


    public static void main(String[] args) {
        LRU<Character, Integer> lru = new LRU<Character, Integer>(16);
        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println("LRU中key为h的Entry的值为： " + lru.get('h'));
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
    }
}
