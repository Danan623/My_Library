package datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * The MyQueue class is a simple implementation of a queue data structure using generics. 
 * It allows the user to add elements to the end of the queue and remove elements from the front of the queue. 
 * The queue is dynamic, meaning that it can automatically increase or decrease in size as elements are added or removed.
 * 
 * To use the MyQueue class, create an instance of the class and specify the type of elements that the queue will hold, for example:
 * 
 * MyQueue<Integer> queue = new MyQueue<>();
 * 
 * You can then use the following methods to interact with the queue:
 * 
 * - void enqueue(T element): adds an element to the end of the queue.
 * - T dequeue(): removes and returns the element at the front of the queue.
 * - boolean isEmpty(): returns true if the queue is empty, false otherwise.
 * - boolean isFull(): returns true if the queue is full, false otherwise.
 * - int getTotalElements(): returns sum of the elements currently in the queue.
 * - int getSize(): returns size of the queue.
 * - T peek(): returns the element at the front of the queue without removing it.
 * - void display(): displays the current elements in the queue.
 * {@link} https://github.com/Danan623/My_Library
 * @author Daniel Andersson
 * @param <T> the type of elements in the queue
 */
public class MyQueue<T> {

    private int N = 2; // default array size
    private T[] queue;
    private int total_elements = 0;// default
    private int head = 0;// default
    private int tail = 0;// default

    public MyQueue() {
        this.queue = (T[]) new Object[N];
    }
    /**
     * 
     * @param element to put in queue
     */
    public void enqueue(T element){ 
        if(isFull()){
            queue = increaseCapacity(N*2);
        }
        queue[head] = element;
        total_elements++; //increment
        head = total_elements;//increment
    }
    /**
     * 
     * @return : next element in queue
     */
    public T dequeue(){
        
        if(isEmpty()){
            throw new NoSuchElementException("The queue is empty");
        }
        if(N > 2 && total_elements < queue.length/2){
            queue = decreaseCapacity(N/2);
        }
        total_elements--; //decrement
        head = total_elements;//decrement
        T root = queue[tail];

        int j = 0;
        for(int i = 1; i < head + 1; i++){
            queue[j] = queue[i];
            j++;
        } 
        return root;  
    }
    /**
     * 
     * @return true if queue is empty else false
     */
    public boolean isEmpty(){
        if(total_elements == 0){
            return true;
        }
        return false;  
    }
    /**
     * 
     * @return : true if queue is full else false
     */
    public boolean isFull(){
        if(total_elements == queue.length){
            return true;
        }
        return false;
    }
    /**
     * Create dynamic queue
     * @param N : queue capacity
     * @return : new queue with 1/2 in capacity
     */
    private T[] decreaseCapacity(int N){
        this.N = N;// 1/2 in size
        T[] newQueue = (T[]) new Object[N];
        System.arraycopy(queue, 0, newQueue, 0, total_elements);
        head = total_elements;
        tail = 0;
        return newQueue;
    }
    /**
     * Create dynamic queue
     * @param N : queue capacity
     * @return : new queue with x2 capacity
     */
    private T[] increaseCapacity(int N){
        this.N = N;// x2 in size
        T[] newQueue = (T[]) new Object[N];
        System.arraycopy(queue, 0, newQueue, 0, total_elements);
        head = total_elements;
        tail = 0;
        return newQueue;
    }
    /**
     * 
     * @return : sum of the elements currently in the queue
     */
    public int getTotalElements(){
        return total_elements;
    }
     /**
     * 
     * @return : queue size
     */
    public int getSize(){
        return queue.length;
    }
    /**
     * 
     * @return : last element in the queue
     */
    public T peek(){
        if(head == 0){
            throw new NoSuchElementException("The queue is empty");
        }
        return queue[head - 1];
    }
    /**
     * display all elements in queue
     */
    public void display(){
        T[] disp_elements = (T[]) new Object[total_elements];
        int j = 0;
        for(T t : queue){
            if(t == null){
                break;
            }
            disp_elements[j] = t;
            j++;        
        }
        System.out.println(Arrays.toString(disp_elements));
        
    }
}
