import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unchecked")
public class HeapQueue<Element extends Comparable<Element>>
{
    private static final int DEFAULT_CAPACITY = 50;

    private int size;            // Number of elements in heap
    private Element[] heap;     // The heap array

    public HeapQueue()
    {
        size = 0;
        heap = (Element[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void update()
    {
        for (int k = size/2; k > 0; k--)
        {
            percolatingDown(k);
        }
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


    private void percolatingDown(int k)
    {
        Element tmp = heap[k];
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
    public Element deleteMin() throws RuntimeException
    {
        if (size == 0) throw new RuntimeException();
        Element min = heap[1];
        heap[1] = heap[size--];
        percolatingDown(1);
        return min;
    }

    //We are going to skip the index zero cell of the array
    //the left child is located at 2 * k index
    //the right child is located at 2* k + 1 index
    //the parent is located at k/2 index

    //A new element is at first added to the end of the array. It then
    //compares it to its parent, then swaps it if it is less.
    public void insert(Element x)
    {
        if(size == heap.length - 1){
            resize();
        }

        //Insert a new item to the end of the array
        int pos = ++size;

        //While the position is greater then one, and the numer is less them
        //the parent (index /2) then move the number into the position
        for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2 )
            heap[pos] = heap[pos/2];

        heap[pos] = x;
    }

    //doubles the size of the array
    private void resize()
    {
        Element [] old = heap;
        heap = (Element []) new Comparable[heap.length * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }


    public boolean isEmpty(){
        return size == 0;
    }




}