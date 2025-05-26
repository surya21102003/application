package String;

import java.util.Arrays;

public class LongestprefixSorting {
    public static void main(String[] args) {
        String[] s={};
    String ans="";
        Arrays.sort(s);
        String first=s[0];
        String last=s[s.length-1];
        for (int i=0;i< first.length();i++){
            if (first.charAt(i)==last.charAt(i)){
                ans=ans+first.charAt(i);

            }
            else break;
        }
    System.out.println(ans);


    }
    }
