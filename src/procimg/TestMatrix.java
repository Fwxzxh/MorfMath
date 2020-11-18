package procimg;

public class TestMatrix {

    public static void main(String[] args) {
        int d = 1;
        int[][] matrix = new int[100][100];
        int[][] test = new int[100][100];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 99);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("=======================================\n");

        int widith = matrix.length;
        int height = matrix[0].length;
        int MIN_X = 0;
        int MIN_Y = 0;
        int MAX_Y = widith - 1;
        int MAX_X = height - 1;

        for (int thisPosX = 0; thisPosX < widith; thisPosX++) {
            for (int thisPosY = 0; thisPosY < height; thisPosY++) { //iteramos en la matriz a modificar        

                int startPosX = (thisPosX - d < MIN_X) ? thisPosX : thisPosX - d;// iniciox = (posAct - n menor al mnimo?) 
                int startPosY = (thisPosY - d < MIN_Y) ? thisPosY : thisPosY - d;// same y
                int endPosX = (thisPosX + d > MAX_X) ? thisPosX : thisPosX + d;// finX = (posAct + n mayor al maximo? 
                int endPosY = (thisPosY + d > MAX_Y) ? thisPosY : thisPosY + d;

                int di = d + d + 1;
                int dim = di * di;
                int sum[] = new int[dim + 1]; //dimencion de el array suma.
                int o = 0;

                for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {     // incioX menor o igual a la posfinal x
                    for (int colNum = startPosY; colNum <= endPosY; colNum++) {
                        sum[o] = matrix[rowNum][colNum];
                        o++;
                    }
                }

                int mayor = sum[0]; // sacamos el mayor de la lista
                for (int x = 0; x < sum.length; x++) {
                    if (sum[x] > mayor) {
                        mayor = sum[x];
                    }
                }

                test[thisPosX][thisPosY] = mayor; //ponemos el mayor en la nueva matriz
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
