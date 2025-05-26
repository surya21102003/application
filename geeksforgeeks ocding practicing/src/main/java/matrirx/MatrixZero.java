package matrirx;

public class MatrixZero {
    public static void main(String[] args) {
    int[][] matrix={};
    int rl= matrix.length;
    int cl=matrix[0].length;

    int[] row=new int[rl];
    int[] col=new int[cl];

    for (int i=0;i<rl;i++){
        for (int j=0;j<cl;j++){
            if(matrix[i][j]==0){
                row[i]=1;
                col[j]=1;
            }
        }
    }
        for (int i=0;i<rl;i++){
            for (int j=0;j<cl;j++){
              if (row[i]==1||col[j]==1){
                  matrix[i][j]=0;
                }
            }
        }



    }
    }
