package org.example;

import java.util.Arrays;

public class productOfArrayExceptSelf {

static int[] poaes(int[] a){
    int n=a.length;
    int[] r=new int[n];
    Arrays.fill(r,1);
    for (int i=0;i<n;i++){
        for (int j=0;j<n;j++){
            if (i!=j){
                r[i]*=a[j];
            }
        }
    }
    return r;
}

    public static void main(String[] args ) {



        //dificult mode above easy mode is there
    int[] a={1,2,3,4};
    int n=a.length;
    int[] l=new int[n];
    int[] r=new int[n];
    l[0]=1;
    r[n-1]=1;
    for (int i=1;i<n;i++){
        l[i]=l[i-1]*a[i-1];
    }
    for (int i=n-2;i>0;i--){
        r[i]=r[i+1]*a[i+1];
    }
    for (int i=0;i<n;i++){
        if (i==0)
            a[i]=r[i];
        else if (i==n-1) {
            a[i]=l[i];
        }
        else
            a[i]=l[i]*r[i];
    }

    }
    }
