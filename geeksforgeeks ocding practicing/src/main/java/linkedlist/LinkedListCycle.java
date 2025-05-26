package linkedlist;

public class LinkedListCycle {

    class Node{
        int data;
        Node next;
        Node(int new_data){
            data=new_data;
            next=null;
        }
    }

    public boolean hascycle(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null&&slow!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)
                return true;
        }
        return false;
    }
}
