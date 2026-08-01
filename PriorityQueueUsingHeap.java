// Priority Queue implementation using Min-Heap
class MinHeap {
    private int[] heap;     // array to store heap elements
    private int size;       // current number of elements
    private int capacity;   // maximum capacity of heap

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }    
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }
    
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = key;
        int current = size;
        size++;

        // Fix the min heap property if violated
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Remove and return minimum element
    public int extractMin() {
        if (size <= 0) return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }

    // Heapify the subtree
    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size && heap[left] < heap[smallest])
            smallest = left;

        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Swap helper
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Print heap elements
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

// Demo class
public class PriorityQueueUsingHeap {
    public static void main(String[] args) {
        MinHeap pq = new MinHeap(10);

        pq.insert(10);
        pq.insert(5);
        pq.insert(20);
        pq.insert(2);

        System.out.print("Heap: ");
        pq.printHeap();

        System.out.println("Extracted Min: " + pq.extractMin());
        System.out.print("Heap after extract: ");
        pq.printHeap();
    }
}
