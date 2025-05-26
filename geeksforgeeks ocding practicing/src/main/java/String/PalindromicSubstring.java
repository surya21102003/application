package String;

public class PalindromicSubstring {
    static boolean ispal(String s,int i,int j){
        while(i<j){
            if (s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;

    }
    static int countpal(String s){
        int n=s.length();
        int res=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (ispal(s,i,j))
                    res++;
            }
        }
        return n;
    }
    public static void main(String[] args) {
    String s="aaa";
    System.out.println(countpal(s));

    }
    }
