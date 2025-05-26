package org.example;

public class TrpingRainwater {
    static int maxwater(int[] a){
        int re=0;
        for (int i=1;i<a.length;i++){

            int l=a[i];
            for (int j=0;j<i;j++){
                l=Math.max(l,a[j]);
            }

            int r=a[i];
            for (int j=i+1;j<a.length;j++){
                r=Math.max(r,a[j]);
            }

            re+=Math.min(l,r)-a[i];
        }
        return  re;
    }
    public static void main(String[] args) {


    }
    }
