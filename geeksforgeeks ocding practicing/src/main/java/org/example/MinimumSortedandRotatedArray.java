package org.example;

public class MinimumSortedandRotatedArray {
    static int findmin(int[] a){
        int res=a[0];
        for (int i=1;i<a.length;i++){
            res=Math.min(res,a[i]);
        }
        return res;
    }
    public static void main(String[] args ) {
int[] a={2,3,4,5,1};
System.out.println(findmin(a));


    }

    }
