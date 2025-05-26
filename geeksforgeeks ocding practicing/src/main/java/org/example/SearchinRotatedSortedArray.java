package org.example;

public class SearchinRotatedSortedArray {
    static int search(int[] num,int tar){
        if (num.length==0)
            return -1;
        if (num.length==1&&num[0]==tar)
            return 0;

        int lp=0;
        int rp=num.length;
        while (lp<=rp){
            int mid=lp+(rp-lp)/2;
            if (mid==tar){
                return mid;
            } else if (num[lp]<=num[mid]) {
                if (num[lp]<=tar&&tar<=num[mid]){
                    rp=mid-1;
                }else {
                    lp=mid-1;
                }
            }else{
                if (num[mid]<=tar&&tar<=num[rp]){
                    lp=mid-1;
                }else {
                    rp=mid-1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args ) {
    int[] a={1,2,3,4,5,6};
    System.out.println(search(a,5));

    }

    }
