import java.util.Arrays;

public class MinHeap {
    int capacity = 10;
    int size = 0;
    int[] items = new int[capacity];

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public boolean hasLeftChild(int index) {
        return size > 2 * index + 1;
    }

    public boolean hasRightChild(int index) {
        return size > 2 * index + 2;
    }

    public boolean hasParent(int index) {
        return 0 <= (index - 1) / 2;
    }

    public int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    public int getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    public int getParent(int index) {
        return items[getParentIndex(index)];
    }

    public void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0)
            return -1;
        return items[0];
    }

    public int poll() {
        if (size == 0)
            return -1;
        int item = items[0];
        size--;
        items[0] = items[size];
        heapifyDown();

        return item;
    }

    private void heapifyDown() {
        if (size == 0)
            return;
        int index = 0;
        while (hasLeftChild(index)) {
            int smaller = getLeftChildIndex(index);
            if (hasRightChild(index) && getLeftChild(index) > getRightChild(index))
                smaller = getRightChildIndex(index);
            if(items[smaller]>items[index])
                break;
            else
                swap(index, smaller);
            index = smaller;
        }
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void swap(int parentIndex, int index) {
        int temp = items[parentIndex];
        items[parentIndex] = items[index];
        items[index] = temp;
    }

    public static void main(String[] args) {
        MinHeap s = new MinHeap();
        s.add(5);
        s.add(3);
        s.add(6);
        s.add(4);
        System.out.println(s.poll());
        System.out.println(s.poll());
        System.out.println(s.poll());
        System.out.println(s.poll());
    }


}
