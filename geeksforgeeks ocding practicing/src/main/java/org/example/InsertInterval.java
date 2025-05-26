package org.example;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] interval,int[] newinterval){
        List<int[]> r=new ArrayList<>();
        int c=0;
        while (c< interval.length && interval[c][1]<newinterval[0]){
            r.add(interval[c++]);
        }
        while(c< interval.length && interval[c][0]<=newinterval[1]){
            newinterval[0]=Math.min(newinterval[0],interval[c][0]);
            newinterval[1]=Math.max(newinterval[1],interval[c][1]);
            c++;
        }
        r.add(newinterval);
        while (c< interval.length){
            r.add(interval[c++]);
        }
            return r.toArray(new int[r.size()][]);
    }
    public static void main(String[] args ) {

    }
    }
