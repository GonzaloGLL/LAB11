import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {
    private List<Pair<K, V>> pairs;

    public Dictionary() {
        pairs = new ArrayList<>();
    }

    public void add(K key, V value) {
        pairs.add(new Pair<>(key, value));
    }

    public boolean delete(K key) {
        return pairs.removeIf(pair -> pair.getKey().equals(key));
    }

    public V getValue(K key) throws ObjectNoExistException {
        for (Pair<K, V> pair : pairs) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        throw new ObjectNoExistException("No existe un objeto con la clave: " + key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair<K, V> pair : pairs) {
            sb.append(pair.toString()).append("\n");
        }
        return sb.toString();
    }
}
