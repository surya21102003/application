package linkedlist;
class Node{
    int data;
    Node next;
    Node(int new_data){
        data=new_data;
        next=null;
    }
}

public class ReverseLlinkedlist {
    public void reverse(Node head){
        Node prev=null;
        Node current=head;
        Node next=head.next;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
    public static void main(String[] args){

    }
}
