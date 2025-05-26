package matrirx;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix={};

        List<Integer> ans=new ArrayList<>();
        int cls=0;
        int rs=0;
        int re= matrix.length-1;
        int ce= matrix[0].length;
        while (cls<=ce&& rs<=re){
            for (int i = cls; i < ce; i++) {
                ans.add(matrix[rs][i]);

            }

            rs++;

            for (int i = rs; i < re; i++) {
                ans.add(matrix[i][ce]);
            }

            ce--;
            if (rs <= re) {
                for (int i = ce; i >= cls; i--) {
                    ans.add(matrix[re][i]);
                }
                re--;
            }
            if (cls <= ce) {
                for (int i = re; i > rs; i--) {
                    ans.add(matrix[i][cls]);
                }
                cls++;
            }
        }

    }
    }
