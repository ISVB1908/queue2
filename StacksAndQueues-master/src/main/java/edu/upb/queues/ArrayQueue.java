/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.queues;
import edu.upb.models.IQueue;
import edu.upb.models.MyException;

/**
 *
 * @author cahuc
 */
public class ArrayQueue implements IQueue {
    private Object[] array;
    private int size = 0;
    private int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added
    //with only tail or size its enought
    public ArrayQueue(int capacity) {
        array = new Object[capacity];
    }

    @Override
    public void enqueue(Object item) {
        if(array.length>size){
        throw new MyException("Cannot add to full queue");
        }else{
        
            array[tail]=item;
            tail++;
            size++;
        }
    }

    @Override
    public Object dequeue() {
        if(size==0){
        
            throw new MyException("Cannot remove to empty queue");
        }
        Object item = array[head];
        for(int i=0;i<tail-1;i++){//throught until one less than the last 
        
            array[i]=array[i+1];//move to the head
        }
        size--;
        tail--;
        return item;
    }

    @Override
    public Object peek() {
        if(size==0){
        
            throw new MyException("Cannot remove to full queue");
        }
        Object item=array[tail-1];
        return item;
    }

    @Override
    public int size() {
        
        return size;
        
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

}