package com;


class Node{
    int data;
    Node next;
    Node(int data){
	   this.data=data;
	   this.next = null;
    }
}

class StackNode{
    Node top;

    public void push (int data)
    {
	   Node temp = new Node(data);

	   if(top == null)
	   {
		  top = temp;
		  return;
	   }
	   temp.next = top;
	   top = temp;
    }

    public int peek(){
	   if(top == null) return -1;
	   return top.data;
    }

    public int remove(){
	   if(top == null) return -1;
	   int data = top.data;
	   top = top.next;
	   return data;
    }

}
public class StackThroughLinkedList {
    public static void main(String[] args) {
	   StackNode obj = new StackNode();

		  obj.push(1);
		  obj.push(18);


	   System.out.println(obj.peek());
	   System.out.println(obj.remove());
	   System.out.println(obj.peek());
    }
}
