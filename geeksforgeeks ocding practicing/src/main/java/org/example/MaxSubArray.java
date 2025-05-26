package org.example;

public class MaxSubArray {
    
    //base on website
    static int maxsa(int[]a){
        int r=a[0];
        for (int i=0;i<a.length;i++){
            int cursum=0;
            for (int j=i;j<a.length;j++){
                cursum=cursum+a[j];
                r=Math.max(r,cursum);
            }
        }
    return r;
    }


    public static void main(String[] args ) {
    int[] n={-2,1,-3,4,-1,2,1,-5,4};
    int cur=n[0], maxsum=n[0];
    for (int i=1;i<n.length;i++){
        if (cur<0)
            cur=n[i];
        else
            cur=cur+n[i];
        maxsum=Math.max(maxsum,cur);

    }

    }
    }
