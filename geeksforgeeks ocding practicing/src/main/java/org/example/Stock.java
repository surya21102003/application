package org.example;

public class Stock {
    static int mp(int[] p){
        int  n=p.length;
        int res=0;

        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                res=Math.max(res,p[j]-p[i]);
            }
        }
        return res;
    }
    public static void main(String[] args ){
        int[] p={7,10,1,3,6,9};

    }
}
