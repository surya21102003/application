package String;

public class Sentencepalindrom {
    public static void main(String[] args) {
    String s="";
    StringBuilder s1=new StringBuilder();
    for (char ch:s.toCharArray()){
        if (Character.isLetterOrDigit(ch)){
            s1.append(Character.toString(ch));
        }
    }
        StringBuilder rev=new StringBuilder(s1.toString());
    rev.reverse();
    if (s1.toString().equals(rev.toString())){
        System.out.println("true");
    }


    }
    }
