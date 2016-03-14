import sun.invoke.empty.Empty;

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



    //We are going to skip the index zero cell of the array
    //the left child is located at 2 * k index
    //the right child is located at 2* k + 1 index
    //the parent is located at k/2 index

    //A new element is at first added to the end of the array. It then
    //compares it to its parent, then swaps it if it is less.
    public void insert(int i){

        if(size == heap.length - 1)
            resize();
        int position = size++;


        //percolate up
        //While the position is greater then one, and the numer is less them
        //the parent (index /2) then move the number into the position

        for(; (position > 1 )&& i < heap[position/2] ; position = position / 2)
            heap[position] = heap[position/2];
        //We are out of the loop, we put the number into the position.
        heap[position] = i;

    }

    //doubles the size of the array
    private void resize(){

        heap = Arrays.copyOf(heap, heap.length * 2);

    }

    //Deletes the min element. Which is root, which is the first element
    //
    public int deleteMin() throws EmptyException{

        //If size is 0, the heap is empty
        if(size == 0) throw new EmptyException();
        //We get the min
        int min = heap[1];
        //the we set the first element to the last element in the array
        heap[1] = heap[size--];
        //We now percolate this item down
        percolatingDown(1);
        return min;


    }

    //the left child is located at 2 * k index
    //the right child is located at 2* k + 1 index
    //the parent is located at k/2 index

    private void percolatingDown(int k)
    {   //the item at the top of the heap
        int temp = heap[k];
        //the child of the element, temp
        int child;

        for(; 2 *k <= size; k = child){
            //We set it to the child of temp
            child = 2 * k;
            //If the child is less then the last element, and greater then
            //the right node, we increment child
            if(child != size && heap[child] > heap[child + 1])
                child++;
            //If the temp is greater then child, then we move the child up
            //the heap
            if(temp > heap[child] )
                heap[k] = heap[child];
        }
        //we have gone through the heap! The first element is now placed at the
        //end
        heap[k] = temp;
    }

    public void display(){
        for(int i = 1; i < heap.length; i++){
            System.out.println(heap[i]);
        }
    }
    //This is thrown if the heap is empty
    public class EmptyException extends Exception{


        public EmptyException() {
            super();
            System.out.println("The heap is empty!");
        }
        public EmptyException(String message, Throwable cause) {
            super(message, cause);
        }
    }



}


