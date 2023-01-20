package datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;
/**
 * The MyStack class is a simple implementation of a stack data structure using generics. 
 * It allows the user to add and remove elements from the top of the stack. 
 * The stack is dynamic, meaning that it can automatically increase or decrease in size as elements are added or removed.
 * 
 * To use the MyStack class, create an instance of the class and specify the type of elements that the stack will hold, for example:
 * 
 * Mystack<Double> stack = new MyStack<>();
 * 
 * You can then use the following methods to interact with the stack:
 * 
 * - void push(T element): adds an element to the top of the stack.
 * - T pop(): removes and returns the element at the top of the stack.
 * - boolean isEmpty(): returns true if the stack is empty, false otherwise.
 * - boolean isFull(): returns true if the stack is full, false otherwise.
 * - int getTotalElements(): returns sum of the elements currently in the stack.
 * - int getSize(): returns size of the stack.
 * - T peek(): returns the element at the top of the stack without removing it.
 * - void display(): displays the current elements in the stack.
 * {@link} https://github.com/Danan623/My_Library
 * @author Daniel Andersson
 * @param <T> the type of elements in the stack
 */

public class MyStack<T> {

    private int N = 2; // default array size
    private T[] stack;
    private int total_elements = 0;// default
    private int head_index = 0;// default
    
    public MyStack() {
        this.stack = (T[]) new Object[N];
    }
    /**
     * 
     * @param element to put in stack
     */
    public void push(T element){ 
        if(isFull()){
            stack = increaseCapacity(N*2);
        }
        stack[head_index] = element;
        total_elements++; //increment
        head_index = total_elements;//increment
    }
    /**
     * 
     * @return : next element in stack
     */
    public T pop(){
        
        if(isEmpty()){
            throw new NoSuchElementException("The stack is empty");
        }
        if(N > 2 && total_elements < stack.length/2){
            stack = decreaseCapacity(N/2);
        }
        T head = stack[head_index -1];
        stack[head_index - 1] = null;
        total_elements--; //decrement
        head_index = total_elements;//decrement

        return head;  
    }
    /**
     * 
     * @return true if stack is empty else false
     */
    public boolean isEmpty(){
        if(total_elements == 0){
            return true;
        }
        return false;  
    }
    /**
     * 
     * @return : true if stack is full else false
     */
    public boolean isFull(){
        if(total_elements == stack.length){
            return true;
        }
        return false;
    }
    /**
     * Create dynamic stack
     * @param N : stack capacity
     * @return : new stack with 1/2 in capacity
     */
    private T[] decreaseCapacity(int N){
        this.N = N;// 1/2 in capacity
        T[] newStack = (T[]) new Object[N];
        System.arraycopy(stack, 0, newStack, 0, total_elements);
        head_index = total_elements;
        return newStack;
    }
    /**
     * Create dynamic stack
     * @param N : stack capacity
     * @return : new stack with x2 capacity
     */
    private T[] increaseCapacity(int N){
        this.N = N;// x2 in capacity
        T[] newStack = (T[]) new Object[N];
        System.arraycopy(stack, 0, newStack, 0, total_elements);
        head_index = total_elements;
        return newStack;
    }
    /**
     * 
     * @return : sum of the elements currently in the stack
     */
    public int getTotalElements(){
        return total_elements;
    }
     /**
     * 
     * @return : size of the stack
     */
    public int getSize(){
        return stack.length;
    }
    /**
     * 
     * @return : top element in the stack
     */
    public T peek(){
        if(head_index == 0){
            throw new NoSuchElementException("The stack is empty");
        }
        return stack[head_index - 1];
    }
    /**
     * display all elements in stack
     */
    public void display(){
        T[] disp_elements = (T[]) new Object[total_elements];
        int j = 0;
        for(T t : stack){
            if(t == null){
                break;
            }
            disp_elements[j] = t;
            j++;        
        }
        System.out.println(Arrays.toString(disp_elements));
        
    }
    
}
