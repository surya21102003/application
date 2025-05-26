package String;

import java.util.Stack;

public class Balancedparanthesis {
    public static void main(String[] args) {
        String exp="";

        Stack<Character> stack=new Stack<>();
        for (int i=0;i<exp.length();i++){
            char x=exp.charAt(i);
            if (x=='(' || x=='['||x=='{'){
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                System.out.println("not bal");
            switch (x){
                case ')':
                    if (!stack.peek().equals('('))
                         System.out.println("not bal");
                    stack.pop();
                    break;
                case ']':
                    if (!stack.peek().equals('['))
                        System.out.println("not bal");
                    stack.pop();
                    break;
                case '}':
                    if (!stack.peek().equals('{'))
                        System.out.println("not bal");
                    stack.pop();
                    break;
            }
        }
    }
    }
