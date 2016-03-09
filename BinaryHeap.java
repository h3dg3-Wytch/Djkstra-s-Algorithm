import java.util.Arrays;
import java.util.List;

/**
 * Created by h3dg3wytch on 3/8/16.
 */

//https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html
    
public class BinaryHeap {
    //The default number of elements
    private static final int DEFAULT_CAPACITY = 50;
    private int[] heap; //The heap
    private int size; //Number of elements


    public BinaryHeap(){

        size = 1;
        this.heap = new int[50];

    }

    public BinaryHeap(int capacity){
        size = 1;
        this.heap = new int[10];

    }

    public void insert(int i){

        if(size == heap.length - 1)
            resize();
        int position = size++;


        //percolate up
        for(; position > 1 && i < heap[position/2] ; position = position / 2)
            heap[position] = heap[position/2];
        heap[position] = i;

    }

    //doubles the size of the array
    private void resize(){

        heap = Arrays.copyOf(heap, heap.length * 2);

    }

    public int deleteMin(){

        int min = heap[1];
        heap[1] = heap[size--];
        percolatingDown(1);
        return min;


    }


    private void percolatingDown(int k)
    {
        int tmp = heap[k];
        int child;

        for(; 2*k <= size; k = child)
        {
            child = 2*k;

            if(child != size &&
                    heap[child] > heap[child + 1]) child++;

            if(tmp >(heap[child]))  heap[k] = heap[child];
            else
                break;
        }
        heap[k] = tmp;
    }

    public void display(){
        for(int i : heap){
            System.out.println(i);
        }
    }

}
