package org.example;

public class Mostwater {
    public static void main(String[] args ) {
        int[] a={};
    int l=0;
    int r=a.length-1;
    int ans=0;
    while (l<r){
        int w=r-l;
        int h=Math.min(a[l],a[r]);
        int wa=w*h;
        ans=Math.max(ans,wa);
        if (a[l]<a[r]){
            l++;
        }else
            r--;

    }

    }
    }
