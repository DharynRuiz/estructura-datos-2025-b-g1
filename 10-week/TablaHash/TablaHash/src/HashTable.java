

public class HashTable<K, V> {
    private Entry<K, V>[] buckets;
    private int capacidad;
    private int tamaño;

    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        buckets = new Entry[capacidad];
        tamaño = 0;
    }

    private int indexFor(K key) {
        return Math.abs(key.hashCode()) % capacidad;
    }

    public V put(K key, V value) {
        int idx = indexFor(key);
        Entry<K, V> head = buckets[idx];

        for (Entry<K, V> cur = head; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                V old = cur.value;
                cur.value = value;
                return old;
            }
        }
        buckets[idx] = new Entry<>(key, value, head);
        tamaño++;
        return value;
    }

    public V get(K key) {
        int idx = indexFor(key);
        Entry<K, V> cur = buckets[idx];

        while (cur != null) {
            if (cur.key.equals(key)) return cur.value;
            cur = cur.next;

        }
        return null;
    }

    public V remove(K key) {
        int idx = indexFor(key);
        Entry<K, V> cur = buckets[idx];
        Entry<K, V> prev = null;

        while (cur != null) {
            if (cur.key.equals(key)) {
                if (prev == null) buckets[idx] = cur.next;
                else prev.next = cur.next;
                tamaño--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }
    public boolean contains(K key) {
        return get(key) != null;
    }
    public int tamaño () {
        return tamaño;
    }
    public boolean vacio() {
        return tamaño ==0;
    }

    public void imprimirTabla(){
        for (int i= 0; i< capacidad; i++) {
            System.out.println("["+i+"]: ");
            Entry<K, V> cur = buckets[i];
            while (cur != null) {
                System.out.println(cur.key + ": " + cur.value+" ");
                cur = cur.next;
            }
            System.out.println();
        }

    }

}
