package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nonoverlapping {
    static int nonol(int[][] ar){
        Arrays.sort(ar,(a,b)->Integer.compare(a[1],b[1]));
        int erase=0;
        int end=Integer.MIN_VALUE;
        for (int[] i:ar){
            if (i[0]<end)
                erase++;
            else
                end=i[1];
        }
        return erase;
    }


    public static void main(String[] args ) {
        /* one more answer for that qoestoin*/
        int[][] in={};
        Arrays.sort(in,(a,b)->Integer.compare(a[1],b[1]));
     /*   List<int[]> res=new ArrayList<>();
        int res1;
        for (int i=1,i<in.length;i++){
            if (in[i-1][1]<in[1][0]){
                res.add(new int[]{in[i-1][1],in[i][0]});
                res++;
            }
        }*/





    int toremve=0;
    for (int i=0;i<in.length;i++){
        int curend=in[i][1];
        while(i+1<in.length&&curend>in[i+1][0]){
            toremve+=1;
            curend=Math.max(curend,in[i+1][1]);
            i+=1;
        }

    }



    }
}
