package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateDistribution {
    static int choco(int[] a,int n,int m) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            int dif = a[i + m - 1] - a[i];
            if (dif < min)
                min = dif;
        }
        return min;
    }
    public static void main(String[] args ) {

    int[] a={};
    int n=7;
    int m=5;
    choco(a,n,m);
    }
    }
