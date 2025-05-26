package String;

public class Longestrepeatingreplacement {
    public static void main(String[] args) {
    String s="aaaaabbbb";
    int n=s.length();
    int max=0;
    int res=s.charAt(0);
    for (int i=0;i<n;i++){
        int cnt=0;
        for (int j=i;j<n;j++){
            if (s.charAt(i)!=s.charAt(j))
                break;
            cnt++;
        }
        if (cnt>max){
            max=cnt;
            res=s.charAt(i);
        }
    }


    }
    }
