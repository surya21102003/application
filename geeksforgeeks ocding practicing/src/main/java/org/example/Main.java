package org.example;

import java.util.Scanner;

public class Main {
     static boolean check(int[] arr,int t){
        for (int i=0;i< arr.length;i++){
            for (int j=i+1;j< arr.length;j++){
                if (arr[i]+arr[j]==t){
                    return true;
                }

            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int gn = scanner.nextInt();
        System.out.println("enter no");
        //int gn = scanner.nextInt();
int[] arrr={1,2,3,4,5};

if (check(arrr,gn)){
    System.out.println("true");
}else {
    System.out.println("false");

}

    }
}