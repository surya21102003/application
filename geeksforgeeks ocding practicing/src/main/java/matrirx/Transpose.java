package matrirx;

public class Transpose {
        public static void main(String[] args){
        int[][] matrix = {};
int row= matrix.length;
int col=matrix[0].length;
int[][ ] res=new int[col][row];
for (int r=0;r<row;r++){
    for (int c=0;c<col;c++){
        res[c][r]=matrix[r][c];
    }
}


    }
}
