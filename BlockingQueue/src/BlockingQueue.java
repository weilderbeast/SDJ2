public class BlockingQueue implements Buffer {
    QueueADT<Integer> queue;
    public BlockingQueue(int capacity){
        queue = new BoundedArrayQueue<>(capacity);
    }

    public String toString(){
        return "";
    }

    @Override
    public synchronized void put(Object element) {
        if(element == null){
            throw new IllegalArgumentException("Null element");
        }

        if (queue.isFull()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            notify();
        }
        queue.enqueue((Integer) element);
    }

    @Override
    public synchronized Object take() {
        if (queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            notify();
        }
        return queue.dequeue();
    }

    @Override
    public synchronized Object look() {
        if(queue.isEmpty()) return null;
        else return queue.first();
    }

    @Override
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public synchronized boolean isFull() {
        return queue.isFull();
    }

    @Override
    public synchronized int size() {
        return queue.size();
    }
}
