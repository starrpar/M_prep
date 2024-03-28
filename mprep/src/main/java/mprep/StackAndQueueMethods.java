package mprep;

import java.lang.Exception;
import java.util.Stack;

public class StackAndQueueMethods {

    public class Node {

        public Node() {
        }

        public Node(int val) {
            this.value = val;
            this.next = null;
        }

        int value;
        Node next;
    }

    public class Stack {

        public Stack() {
            this.top = null;
        }

        int pop() throws Exception {
            if (this.top != null) {
                int value = this.top.value;
                this.top = this.top.next;
                stackSize--;
                return value;
            } else {
                throw new Exception("Stack is empty.");
            }
        }

        void push(int value) {
            Node node = new Node(value);
            node.next = this.top;
            this.top = node;
            stackSize++;
        }

        int peek() throws Exception {
            if (this.top != null) {
                return this.top.value;
            } else {
                throw new Exception("Stack is empty.");
            }
        }

        int size() {
            return stackSize;
        }

        boolean empty() {
            return stackSize == 0;
        }

        Node top;
        int stackSize = 0;
    }

    public class Queue {

        public Queue() {
            this.head = null;
            this.tail = null;
        }

        int dequeue() throws Exception {
            if (this.head != null) {
                int value = this.head.value;
                this.head = this.head.next;
                queueSize--;
                return value;
            } else {
                throw new Exception("Stack is empty.");
            }
        }

        void enqueue(int value) {
            Node node = new Node(value);
            if (this.head == null) {
                this.head = node;
            }
            if (this.tail != null) {
                Node tmpNode = this.tail;
                tmpNode.next = node;
            }
            this.tail = node;

            queueSize++;
        }

        int peek() throws Exception {
            if (this.head != null) {
                return this.head.value;
            } else {
                throw new Exception("Stack is empty.");
            }
        }

        int size() {
            return queueSize;
        }

        boolean empty() {
            return queueSize == 0;
        }

        Node head;
        Node tail;
        int queueSize = 0;
    }

    public class QueueUsingStacks {
        java.util.Stack<Integer> s1 = new java.util.Stack<Integer>();
        java.util.Stack<Integer> s2 = new java.util.Stack<Integer>();

        public void enQueue(int value) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            s1.push(value);
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
            qsSize++;
        }

        public int deQueue() {
            int retVal = -1;
            if (!s1.empty()) {
                retVal = s1.pop();
            }
            qsSize--;
            return retVal;
        }

        public int peek() {
            int retVal = -1;
            if (!s1.empty()) {
                retVal = s1.peek();
            }
            return retVal;
        }

        boolean empty() {
            return qsSize == 0;
        }

        int qsSize = 0;
    }
}
