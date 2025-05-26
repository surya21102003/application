package String;

import java.util.Arrays;

public class Checkanagram {


    public static void main(String[] args) {
    String s1="listen";
    String s2="silent";
    if (s1.length()==s2.length()){
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean res=Arrays.equals(c2,c2);
        if (res)
            System.out.println("both are anagrma");
        else
            System.out.println("not anagram");

    }
    }
    }
