package horus.hash_table;

public class HashTableNode<_KeyType, _DataType> {
    _KeyType key;
    _DataType data;
    HashTableNode<_KeyType, _DataType> next;
    HashTableNode<_KeyType, _DataType> prev;

    public HashTableNode(_KeyType key, _DataType data) {
        this.key = key;
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return ("{ " + key.toString() + " : " + data.toString() + " }");
    }
}
