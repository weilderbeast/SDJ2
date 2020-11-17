public class BoundedArrayQueue<T> implements QueueADT<T> {
        private int front;

        private int count;

        private T[] queue;

        public BoundedArrayQueue(int capacity) {
            this.queue = (T[])new Object[capacity];
            this.front = 0;
            this.count = 0;
        }

        public void enqueue(T element) {
            if (isFull())
                throw new IllegalStateException("Queue is full");
            int rear = (this.count + this.front) % this.queue.length;
            this.queue[rear] = element;
            this.count++;
        }

        public T dequeue() {
            T tmp = first();
            this.queue[this.front] = null;
            this.front = (this.front + 1) % this.queue.length;
            this.count--;
            return tmp;
        }

        public T first() {
            if (isEmpty())
                throw new IllegalStateException("Queue is empty");
            return this.queue[this.front];
        }

        public int indexOf(T element) {
            if (element == null) {
                for (int i = 0; i < this.count; i++) {
                    int index = (i + this.front) % this.queue.length;
                    if (element == this.queue[index])
                        return i;
                }
            } else {
                for (int i = 0; i < this.count; i++) {
                    int index = (i + this.front) % this.queue.length;
                    if (element.equals(this.queue[index]))
                        return i;
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            return (this.count == 0);
        }

        public boolean isFull() {
            return (this.count >= this.queue.length);
        }

        public int size() {
            return this.count;
        }

        public int capacity() {
            return this.queue.length;
        }

        public String toString() {
            String s = "{";
            for (int i = 0; i < this.count; i++) {
                int index = (i + this.front) % this.queue.length;
                s = String.valueOf(s) + this.queue[index];
                if (i < this.count - 1)
                    s = String.valueOf(s) + ", ";
            }
            s = String.valueOf(s) + "}";
            return s;
        }
    }

