package linkedlist;

import java.util.PriorityQueue;

public class MergeKsort {
    class Node{
        int data;
        Node next;
        Node(int new_data){
            data=new_data;
            next=null;
        }
    }
    public Node mergeKlists(Node[] lists){
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        Node res=new Node(-1);
        Node cur=res;
        for (Node node:lists){
            while (node!=null){
                queue.add(node.data);
                node=node.next;

            }
        }
        while (!queue.isEmpty()){
            Node node=new Node(queue.poll());
            cur.next=node;
            cur=node;
        }
        return res.next;

    }

}
