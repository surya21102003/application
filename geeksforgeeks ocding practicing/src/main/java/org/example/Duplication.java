package org.example;

import java.util.ArrayList;

public class Duplication {

    public static void main(String[] args ) {

        int[] a = {7, 10, 1,3,4,1,5};
        ArrayList<Integer> r=new ArrayList<>();
        boolean is=false;
        for (int i=0;i< a.length-1;i++){
            for (int j=i+1;j< a.length;j++){
                if (a[i]==a[j]){
                    if (r.contains(a[i])){
                        is=false;

                    }else{
                        r.add(a[i]);
                    is=true;
                    }

                }
            }
        }

if (is){
    System.out.println(r);
}else
    System.out.println("no duplicates");
    }
    }
