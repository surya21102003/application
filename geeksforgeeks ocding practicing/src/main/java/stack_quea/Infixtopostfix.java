package stack_quea;

import java.util.Stack;

public class Infixtopostfix {
    boolean isoperator(char c){
        if (c=='+'||c=='-'||c=='*'||c=='/'||c=='^'){
            return true;
        }
        return false;
    }
    boolean isoperand(char c){
        if (c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9')
            return true;
        return false;
    }
    int getprecedence(char operator){
        switch (operator){
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
            case '^':return 3;
            default:return -1;
        }
    }
    String infixtopost(String infix){
        StringBuilder postfix=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for (char c:infix.toCharArray()){
            if (isoperand(c))
                postfix.append(c);
            else if (c=='(')
                stack.push(c);
            else if (c==')') {
                while (!stack.isEmpty()&&stack.peek()!='(')
                    postfix.append(stack.pop());
                stack.pop();
            } else if (isoperator(c)) {
                while (!stack.isEmpty()&&getprecedence(c)<=getprecedence(stack.peek()))
                    postfix.append(stack.pop());
                stack.push(c);

            }
while (!stack.isEmpty())
    postfix.append(stack.pop());

        }
        return postfix.toString();
    }
}
