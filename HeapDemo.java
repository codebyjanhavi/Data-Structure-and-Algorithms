import java.util.Arrays;

class Heap {
     int[] heap;
     int size;
     int capacity;

    // Constructor
    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    // Get parent, left, right indexes
    int parent(int i) { return (i - 1) / 2; }
    int leftChild(int i) { return 2 * i + 1; }
    int rightChild(int i) { return 2 * i + 2; }
      
    // Insert a new element into the heap
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full! Cannot insert " + key);
            return;
        }

        // First insert the new key at the end
        heap[size] = key;
        int current = size;
        size++;

        // Fix the max-heap property if it is violated
        while (current > 0 && heap[current] > heap[parent(current)]) 
        { // Swap with parent
            int temp = heap[current];
            heap[current] = heap[parent(current)];
            heap[parent(current)] = temp;
            current = parent(current);
        }
    }

    // Delete and return the root element (maximum)
    public int deleteRoot() {
        if (size <= 0) {
            System.out.println("Heap is empty! Nothing to delete.");
            return -1;
        }

        int root = heap[0];
        heap[0] = heap[size - 1]; // Move last element to root
        size--;
        heapify(0); // Restore heap property(here we are doing reheap up which is starting from root node hence we are giving index 0)
        return root;
    }

    // Heapify function
    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            // Swap
            int swap = heap[i];
            heap[i] = heap[largest];
            heap[largest] = swap;

            heapify(largest);
        }
    }

    // Print heap elements
    public void printHeap() {
        System.out.print("Heap array: ");
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}

public class HeapDemo {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);

        heap.printHeap();

        System.out.println("Deleted root: " + heap.deleteRoot());
        heap.printHeap();

        System.out.println("Deleted root: " + heap.deleteRoot());
        heap.printHeap();

        heap.insert(60);
        heap.printHeap();
    }
}
