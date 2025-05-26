package linkedlist;

public class RemoveNthnodefromend {
    class Node{
        int data;
        Node next;
        Node(int new_data){
            data=new_data;
            next=null;
        }
    }
    public Node removeNthnode(Node head,int n){
        int length=0;
        Node c=head;
        while (c!=null){
            length++;
            c=c.next;
        }
        int t=length-n+1;
        if (t==1)
            return head.next;
        c=head;
        for (int i=1;i<t-1;i++){
            c=c.next;
        }
        c.next=c.next.next;
                return head;

    }
}
