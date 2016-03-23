import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@SuppressWarnings("unchecked")

/**
 * Created by h3dg3wytch on 3/15/16.
 * Rex Petersen
 */
public class HeapQueue<Element extends Comparable<Element>> {
    //We set this equal to two, because we don't want to keep comparing null over and over again
    //Each resize is 0(logn)
    private static final int DEFAULT_CAPACITY = 2;

    private Element[] heap;
    //the amount of elements that are in the heap
    private int size;

    public HeapQueue() {
        size = 0;
        heap = (Element[]) new Comparable[DEFAULT_CAPACITY];
    }

    //tells if the heap is empty or not
    public boolean isEmpty(){
        return size == 0;
    }

    //linear search to see if heap contains the specific node in question
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

    //builds the heap
    public void update() {
        //We get the mid value and then percolate teh values down
        for (int k = size/2; k > 0; k--) {
            percolatingDown(k);
        }
    }

    private void percolatingDown(int k) {
        //We get the item at the top of the heap
        Element tmp = heap[k];
        //This will be for it's child
        int child;

        //We iterate via the left child, setting it to 2 * k
        for(; 2*k <= size; k = child){

            child = 2*k;

            //If the child is less then the last element, and greater then
            //the right node, we increment child
            if(child != size && heap[child].compareTo(heap[child + 1]) > 0)
                child++;

            //If the temp is greater then child, then we move the child up
            //the heap
            if(tmp.compareTo(heap[child]) > 0)
                heap[k] = heap[child];
            else
                break;
        }
        //we have gone through the heap! The first element is now placed at the
        //end
        heap[k] = tmp;
    }

    //Deletes the min element. Which is root, which is the first element
    public Element deleteMin() {
        //if empty we return null
        if (isEmpty())
           return null;
        //We get the min
        Element min = heap[1];
        //the we set the first element to the last element in the array
        heap[1] = heap[size--];
        //We now percolate this item down
        percolatingDown(1);
        return min;
    }

    //We are going to skip the index zero cell of the array
    //the left child is located at 2 * k index
    //the right child is located at 2* k + 1 index
    //the parent is located at k/2 index

    //A new element is at first added to the end of the array. It then
    //compares it to its parent, then swaps it if it is less.
    public void insert(Element x) {
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
    private void resize() {
        heap = Arrays.copyOf(heap, heap.length * 2);

    }
}