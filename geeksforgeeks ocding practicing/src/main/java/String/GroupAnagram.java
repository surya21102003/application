package String;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] str = {"aa","aa"};
        Map<String, List<String>>m=new HashMap<>();

        for (String s:str){
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            String s1=String.valueOf(ch);

            if (!m.containsKey(s)){
                m.put(s1,new ArrayList<>());
            }
            m.get(s1).add(s);
        }
        System.out.println(m.values());
    }
    }
