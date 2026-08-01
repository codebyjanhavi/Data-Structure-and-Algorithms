//this program is for min heap
/*if we already have minheap or maxheap and we want to perform insertion or deletion operation in such case 
    we perform the operations like ReheapUp and ReheapDown

    Note:
    1) we can only delete root node/element and after deleting that node we have to
        replace it by the last element from the array.by doing this heap becomes disturb in such case perform
        ReheapDown.
    2) we only insert the element at the end of the array and after inserting the element the heap may become 
        disturb so maintain the property of heap we have to do ReheapUp 
    
    operations to be performe:
    1] after insertion:-perform ReheapUp
    2] after deletion:- perform ReheapDown

    for MaxHeap :  heap[index]>heap[parent(index)]
    for MinHeap :  heap[index]>heap[parent(index)]


    
 */
class Heap{
    int size;
    int capacity;
    int heap[];
    Heap(int capacity)
    {
        size=0;
        this.capacity= capacity;
        heap= new int[capacity];
    }
    int parent(int index){return (index-1)/2;}
    int left(int index){ return 2*index+1;}
    int right(int index){return 2*index+2;}
    
    void insert(int val){
        if(size==capacity){
            System.out.println("heap is full");
            return;
        }
        heap[size]= val;
        int current= size;
        size++;
        reheapUp(current);
    }
    void reheapUp(int index)
    {
        while(index>0 &&  heap[index]>heap[parent(index)]){
           swap(index,parent(index));
            reheapUp(parent(index));
            
        }
    }

    void delete()
    {
      if(size==0)
      {
        System.out.println("Heap is empty");
      }  
      int min= heap[0];
      heap[0]= heap[size-1];
      size--;
      reheapDown(0);
     
    }

    void reheapDown(int index)
    {
        int smallest= index;
        int leftC= left(index);
        int rightC= right(index);
        if(leftC<size && heap[leftC]<heap[smallest]){
            smallest= leftC;
        }
        if(rightC<size && heap[rightC]<heap[smallest]){
            smallest= rightC;
        }
        if(smallest!=index)
        {
            swap(smallest,index);
            reheapDown(smallest);
        }

    }
    void swap(int i,int j)
    {
        int temp= heap[i];
        heap[i]=heap[j];
        heap[j]= temp;
    }
    void display()
    {
        for(int i=0; i<size;i++)
        {
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }


}

public class MinReheap_UpDown{
    public static void main(String args[])
    {
        Heap h= new Heap(10);
        h.insert(5);
        h.insert(10);
        h.insert(50);
        System.out.print("min heap:");
        h.display();
        h.delete();
        System.out.print("After Deletion of node:");
        h.display();
    }
    
}
