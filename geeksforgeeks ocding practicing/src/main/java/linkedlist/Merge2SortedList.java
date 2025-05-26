package linkedlist;

public class Merge2SortedList {

    class Node{
        int data;
        Node next;
        Node(int new_data){
            data=new_data;
            next=null;
        }
    }
    public Node mergetwolist(Node l1,Node l2){
        if (l1==null)return l2;
        if (l2==null)return l1;
        Node cur=null;
        Node res=null;
        while (l1!=null&&l2!=null){
            if (l1.data<=l2.data){
                if (cur==null){
                    cur=l1;
                    res=cur;
                }else {
                    cur.next=l1;
                cur=cur.next;
                }
                l1=l1.next;
            }
            else {
                if (cur==null){
                    cur=l2;
                    res=cur;
                }else {
                    cur.next=l2;
                    cur=cur.next;
                }
                l2=l2.next;
            }
        }
    while(l1!=null){
        cur.next=l1;
        cur=cur.next;
        l1=l1.next;
    }

    while(l2!=null){
        cur.next=l2;
        cur=cur.next;
        l2=l2.next;
    }
    return res;
}}
