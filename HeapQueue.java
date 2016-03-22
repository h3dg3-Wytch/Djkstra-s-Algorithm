import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")
public class HeapQueue<AnyType extends Comparable<AnyType>>
{
    private static final int CAPACITY = 2;

    private int size;            // Number of elements in heap
    private AnyType[] heap;     // The heap array

    public HeapQueue()
    {
        size = 0;
        heap = (AnyType[]) new Comparable[CAPACITY];
    }

    public void buildHeap()
    {
        for (int k = size/2; k > 0; k--)
        {
            percolatingDown(k);
        }
    }

    /**
     * Construct the binary heap given an array of items.
     */
    public HeapQueue(AnyType[] array)
    {
        size = array.length;
        heap = (AnyType[]) new Comparable[array.length+1];

        System.arraycopy(array, 0, heap, 1, array.length);//we do not use 0 index


    }

    private void percolatingDown(int k)
    {
        AnyType tmp = heap[k];
        int child;

        for(; 2*k <= size; k = child)
        {
            child = 2*k;

            if(child != size &&
                    heap[child].compareTo(heap[child + 1]) > 0) child++;

            if(tmp.compareTo(heap[child]) > 0)  heap[k] = heap[child];
            else
                break;
        }
        heap[k] = tmp;
    }


    /**
     * Deletes the top item
     */
    public AnyType deleteMin() throws RuntimeException
    {
        if (size == 0) throw new RuntimeException();
        AnyType min = heap[1];
        heap[1] = heap[size--];
        percolatingDown(1);
        return min;
    }

    /**
     * Inserts a new item
     */
    public void insert(AnyType x)
    {
        if(size == heap.length - 1) doubleSize();

        //Insert a new item to the end of the array
        int pos = ++size;

        //Percolate up
        for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2 )
            heap[pos] = heap[pos/2];

        heap[pos] = x;
    }
    private void doubleSize()
    {
        AnyType [] old = heap;
        heap = (AnyType []) new Comparable[heap.length * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }

    public String toString()
    {
        String out = "";
        for(int k = 1; k <= size; k++) out += heap[k]+" ";
        return out;
    }

    public boolean contains(Node n){
        for(int i = 1; i < heap.length; i++){
            if(heap[i] == null){
                return false;
            }
            if(heap[i].equals(n)){
                return true;
            }
        }
        return false;
    }
}