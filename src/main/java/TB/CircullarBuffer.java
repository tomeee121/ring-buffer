package TB;

public class CircullarBuffer<E> {
    private final Integer capacity;
    private E[] data;
    private volatile Integer readSequence;
    private volatile Integer writeSequence;
    public final Integer DEFAULT_CAPACITY_BUFFER = 4;

    public CircullarBuffer() {
        this.capacity = DEFAULT_CAPACITY_BUFFER;
        this.data = (E[]) new Object[this.capacity];
        this.readSequence = 0;
        this.writeSequence = -1;
    }
    public CircullarBuffer(int capacity) {
        this.capacity = (capacity < 1) ? DEFAULT_CAPACITY_BUFFER : capacity;
        this.data = (E[]) new Object[this.capacity];
        this.readSequence = 0;
        this.writeSequence = -1;
    }

    public boolean offer(E element) {
        boolean isFull = (writeSequence - readSequence) + 1 == capacity;
        if (!isFull) {
            int nextWriteSeq = writeSequence + 1;
            data[nextWriteSeq % capacity] = element;
            writeSequence++;
            return true;
        }
        return false;
    }

    public E poll() {
        boolean isEmpty = writeSequence < readSequence;
        if(!isEmpty) {
            E nextValue = data[readSequence % capacity];
            readSequence++;
            return nextValue;
        }
        return null;
    }
}
