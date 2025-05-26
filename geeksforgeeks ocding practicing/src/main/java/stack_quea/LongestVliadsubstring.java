package stack_quea;
/*
import java.util.Stack;

public class LongestVliadsubstring {
    String str;
    int n=str.length();
    Stack<Integer>stk;
    int res=0;
    for(int i=0;i<n;i++){
        if (str[i]=="("){
            stk.push(i);
        } else  {
            stk.pop();
            if (!stk.empty()){
                res=Math.max(res,i-stk.top());

            }
            else
                stk.push(i);
        }
    }
}
*/