package utils.arrayList;

public class BlockingQueue<T> {
    private ListADT<T> list = new ArrayList<>();
    private int capacity;

    public BlockingQueue(int capacity){
        this.capacity = capacity;
    }

    public void put(T item){
        if(item == null) throw new IllegalArgumentException("Nulls are not accepted");
        if(!isFull())
        list.add(item);
    }

    public T take(){
        return list.remove(0);
    }

    public boolean isFull(){
        return list.size() == capacity;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public int capacity(){
        return capacity;
    }
}
