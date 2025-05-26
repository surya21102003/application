package String;

public class Longestpalindromsubstring {
    public static int func(String s,int left,int right){
        while (left>0&&right<s.length()&& s.charAt(left)==s.charAt(right)){
            left++;
            right--;

        }
        return right-left-1;
    }
    public static void main(String[] args) {
    String s="";
    int st=0;
    int en=0;
    if (s==null||s.length()<1){
        System.out.println("null");
    }
    for (int i=0;i<s.length();i++){
        int l1=func(s,i,i);
        int l2=func(s,i,i+1);
        int len=Math.max(l1,l2);
        if (len>en-st){
            st=i-(len-1)/2;
            en=i+len/2;
        }
    }
    System.out.println(s.substring(st,en+1));

    }
    }
