package org.example;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialoflargeNo {
    static String fact(int n){
        BigInteger r=new BigInteger("1");
        for (int i=1;i<=n;i++){
            r=r.multiply(new BigInteger(i+""));
        }
        return r.toString();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int  n=s.nextInt();
        String f=fact(n);
        System.out.println(f);


    }
    }
