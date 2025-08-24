package mprep;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LList implements Iterable<LListNode>{
    private LListNode head = null;
    private LListNode currentNode = null;
    private int size = 0;
    
    public LList(){
        //initial creation of an empty LList
        this.head = null;
        this.currentNode = null;
        size = 0;
    }

    public LList(Object o){
        //initial creation of an LList with a value
        LListNode lln = new LListNode(o);
        if(this.head == null){
            this.head = lln;
            System.out.println("head is: " + o.toString());
            this.currentNode = lln;
            if(size <= 0){
                size++;
            }
        }
        // if(this.currentNode != null && !this.currentNode.hasNext()){
        //     this.currentNode.setNext(lln);
        //     size++;
        // }
    }

    public LList(LListNode head){
        //initial creation of an LList with an LListNode object
        this.head = head;
        this.currentNode = head;
        if(size <= 0){
            size++;
        }
    }

    public LListNode getHead(){
        if(this.head == null){
            throw new NoSuchElementException();
        }
        return this.head;
    }

    public int getSize(){
        return this.size;
    }
    
    public void setSize(int val){
        this.size = val;
    }

    public void setHead(LListNode lln){
        if(lln != null){
            this.head = lln;
            currentNode = this.head;
        }
    }

    public void setNext(LListNode lln){
        // if(lln != null && lln.hasNext()){
        if(lln != null){
            this.currentNode.setNext(lln);
            lln.setPrev(this.currentNode);
            System.out.println("adding node: " + lln.getItem().toString());
            size++;
        }
    }

    public LListNode getCurrentNode(){
        if(this.currentNode == null){
            throw new NoSuchElementException();
        }
        return this.currentNode;
    }

    public void setCurrentNodeToHead(){
        if(this.head != null){
            this.currentNode = this.head;
        } else {
            System.out.println("setting currentNode to null");
            this.currentNode = null;
        }
    }

    public void addNode(LListNode lln){
        this.moveNext();
        if(this.currentNode != null && this.currentNode.hasNext() == false){
            this.currentNode.setNext(lln);
            lln.setPrev(this.currentNode);
            size++;
        }
    }

    public void navigateThroughNextAndAddNode(LListNode lln){
        while(this.currentNode != null && this.currentNode.hasNext() == true){
            System.out.println("moving from: " + this.getCurrentNode().getItem().toString() + " to " + this.getCurrentNode().getNext().getItem().toString());
            this.moveNext();
        }
        if(this.currentNode != null && this.currentNode.hasNext() == false){
            this.currentNode.setNext(lln);
            lln.setPrev(this.currentNode);
            size++;
        }
    }

    public void moveNext(){
        if(this.currentNode != null){
            if(this.currentNode.hasNext()){
                this.currentNode = this.currentNode.getNext();
            }
            // else if(this.currentNode.hasPrev()){
            //     this.currentNode = this.currentNode.getPrev();
            // }
            else {
                this.currentNode = this.head;
            }
        }
    }

    public void setPreviousNodeNextToNode(LListNode lln){
        LListNode previousNode = null;
        if(lln.hasNext()){
            previousNode = lln.getNext();
            System.out.println("current (lln): " + lln.getItem().toString());
            System.out.println("previous: " + previousNode.getItem().toString());
            if(previousNode.hasNext()){
                System.out.println("previous: " + previousNode.getItem().toString());
                System.out.println("previous' next: " + previousNode.getNext().getItem().toString());
            }
            // if(previousNode.hasNext()){
            lln.setNext(null);
            lln.setPrev(previousNode);
            previousNode.setNext(lln);
            size++;
            System.out.println("previous: " + previousNode.getItem().toString());
            System.out.println("previous' next: " + previousNode.getNext().getItem().toString());
            // }
            System.out.println("current: " + lln.getItem().toString());
            System.out.println("previous: " + previousNode.getItem().toString());
            if(previousNode.hasNext()){
                System.out.println("previous: " + previousNode.getItem().toString());
                System.out.println("previous' next: " + previousNode.getNext().getItem().toString());
            }
        } else { //not hitting this...
            previousNode = lln.getNext();
            lln.setNext(null);
            lln.setPrev(previousNode);
            previousNode.setNext(lln);
            size++;
            System.out.println("c (lln): " + lln.getItem().toString());
            System.out.println("p: " + previousNode.getItem().toString());
            if(previousNode.hasNext()){
                System.out.println("p: " + previousNode.getItem().toString());
                System.out.println("p' next: " + previousNode.getNext().getItem().toString());
            }
        }
    }
    
    @Override
    public Iterator<LListNode> iterator() {
        return new LListIterator();
    }

    private class LListIterator implements Iterator<LListNode> {

        @Override
        public boolean hasNext() {
            if(currentNode == null){
                throw new NoSuchElementException();
            }
            return currentNode.hasNext();
        }

        @Override
        public LListNode next() {
            if(!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return currentNode.getNext();
        }
    }
}
