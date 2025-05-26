package String;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longestsubstringnorep {
    public static void main(String[] args) {
        String s = "abcabc";
        Set<Character> seen=new HashSet<>();
    int start=0;
    int end =0;
    int max=Math.min(s.length(),1);
  while (end<s.length()){
char c=s.charAt(end);
while (seen.contains(c)){
    seen.remove(s.charAt(start));
    start+=1;
}
seen.add(c);
int wind=end-start+1;
max=Math.max(max,wind);
end++;
  }
  System.out.println(max);
    }
    }
