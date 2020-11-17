package horus.hash_table;

public class HashTable<_KeyType, _DataType> {
    private HashTableNode<_KeyType, _DataType>[] data;
    private Integer size;
    private Integer frames;

    public HashTable(Integer frames) {
        this.size = 0;
        this.frames = frames;
        this.data = new HashTableNode[frames];
    }

    public Integer Size() {
        return this.size;
    }

    public Integer Frames() {
        return this.frames;
    }

    public void Insert(_KeyType key, _DataType value) {
        Integer position = Math.abs(key.hashCode()) % frames;

        if (data[position] == null)
            data[position] = new HashTableNode<_KeyType, _DataType>(key, value);
        else {
            HashTableNode<_KeyType, _DataType> tmp_node = data[position];

            while (tmp_node.next != null)
                tmp_node = tmp_node.next;

            tmp_node.next = new HashTableNode<_KeyType, _DataType>(key, value);
            tmp_node.next.prev = tmp_node;
        }

        this.size++;
    }

    public _DataType Get(_KeyType key) {
        Integer position = Math.abs(key.hashCode()) % frames;

        if (data[position] == null)
            return null;

        if (data[position].next == null)
            return data[position].data;

        HashTableNode<_KeyType, _DataType> tmp_node = data[position];

        while (true) {
            if (tmp_node == null)
                break;

            if (tmp_node.key.equals(key))
                return tmp_node.data;

            tmp_node = tmp_node.next;
        }

        return null;
    }

    public _DataType Remove(_KeyType key) {
        Integer position = Math.abs(key.hashCode()) % frames;

        if (data[position] == null)
            return null;

        HashTableNode<_KeyType, _DataType> tmp_node = data[position];

        if (data[position].next == null) {
            tmp_node = data[position];
            data[position] = data[position].next;

            this.size--;
            return tmp_node.data;
        }

        while (true) {
            if (tmp_node == null)
                break;

            if (tmp_node.key.equals(key)) {
                _DataType tmp_data = tmp_node.data;

                if (tmp_node.prev == null)
                    data[position] = tmp_node.next;
                else
                    tmp_node.prev.next = tmp_node.next;

                this.size--;
                return tmp_data;
            }

            tmp_node = tmp_node.next;
        }

        return null;
    }

    private HashTableNode<_KeyType, _DataType>[] InsertToResize(HashTableNode<_KeyType, _DataType>[] arr,
            Integer arr_size, _KeyType key, _DataType value) {
        Integer position = Math.abs(key.hashCode()) % arr_size;

        if (arr[position] == null)
            arr[position] = new HashTableNode<_KeyType, _DataType>(key, value);
        else {
            HashTableNode<_KeyType, _DataType> tmp_node = arr[position];

            while (tmp_node.next != null)
                tmp_node = tmp_node.next;

            tmp_node.next = new HashTableNode<_KeyType, _DataType>(key, value);
            tmp_node.next.prev = tmp_node;
        }

        return arr;
    }

    public void ResizeFrames(Integer frames) {
        HashTableNode<_KeyType, _DataType>[] new_data = new HashTableNode[frames];

        for (Integer i = 0; i < this.frames; i++) {
            HashTableNode<_KeyType, _DataType> tmp_node = data[i];

            if (tmp_node == null)
                continue;

            while (true) {
                if (tmp_node == null)
                    break;
                new_data = InsertToResize(new_data, frames, tmp_node.key, tmp_node.data);
                tmp_node = tmp_node.next;
            }
        }

        this.frames = frames;
        this.data = new_data;
    }

    public String ToString() {
        String out = "";

        HashTableNode<_KeyType, _DataType> tmp_node;

        for (Integer i = 0; i < frames; i++) {
            out += (i.toString() + ": ");

            if (data[i] != null) {
                tmp_node = data[i];

                out += tmp_node.toString() + " ";

                while (true) {
                    tmp_node = tmp_node.next;

                    if (tmp_node != null)
                        out += tmp_node.toString() + " ";
                    else
                        break;
                }
            }

            out += ("\n");
        }

        return out;
    }

    @Override
    public String toString() {
        return ToString();
    }
}
