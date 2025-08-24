package mprep;

import java.util.NoSuchElementException;

public class LListNode {
    private Object item;
    private LListNode next;
    private LListNode prev;

    public LListNode(){

    }

    public LListNode(Object item){
        this.item = item;
        this.next = null;
        System.out.println("creating lln: " + item.toString());
    }

    // LListNode(Object item, LListNode prev){
    //     this.item = item;
    //     this.next = null;
    //     prev.next = this;
    // }
    
    public Object getItem(){
        if(this.item == null){
            throw new NoSuchElementException();
        }
        return this.item;
    }

    public boolean hasNext(){
        if(this.next == null){
            return false;
        }
        return true;
    }

    public LListNode getNext(){
        if(this.next == null){
            throw new NoSuchElementException();
        }
        return this.next;
    }

    public void setNext(LListNode lln){
        if(lln != null && this.next == null){
            System.out.println("setNext: " + this.getItem().toString());
            this.next = lln;
            System.out.println("setNext: " + this.getNext().getItem().toString());
        }
    }
    
    public boolean hasPrev(){
        if(this.prev == null){
            return false;
        }
        return true;
    }

    public LListNode getPrev(){
        if(this.prev == null){
            throw new NoSuchElementException();
        }
        return this.prev;
    }

    public void setPrev(LListNode lln){
        if(lln != null && this.prev == null){
            this.prev = lln;
        }
    }

    // public void setPreviousNodeNextToCurrentNode(){
    //     LListNode previousNode = null;
    //     if(this.getNext() != null){
    //         previousNode = this.getNext();
    //         System.out.println("current: " + this.getItem().toString());
    //         System.out.println("previous: " + previousNode.getItem().toString());
    //         if(previousNode.getNext() == null){
    //             previousNode.setNext(this);
    //             this.setNext(null);
    //         }
    //         System.out.println("previous: " + previousNode.getItem().toString());
    //         System.out.println("current: " + this.getItem().toString());
    //     }
    // }
}
