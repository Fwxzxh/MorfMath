package procimg;

import java.util.Random;

public class Matrix {
    // Crear una matriz random de 10 x 10 y hacer el procedimiento con ella
    // TODO hacer que use como imput la matriz hecha con la imagen, convertir en
    // blanco y negro
    // https://medium.com/@himnickson/converting-rgb-image-to-the-grayscale-image-in-java-9e1edc5bd6e7
    // formatear matriz
    // https://stackoverflow.com/questions/5061912/printing-out-a-2-d-array-in-matrix-format
    private int n;
    private int Matrix[][];
    int NewMatrix[][];
    int MinMatrix[][];

    public Matrix(int matriz[][], int dimenciones){
        n = dimenciones;
        Matrix = matriz;    
        NewMatrix = new int[n][n];
        MinMatrix = new int[n][n];
    }
    
    public int mayorMatrix(int valores[]) {
        int mayor = valores[0];
        for (int x = 0; x < valores.length; x++) {
            if (valores[x] > mayor) {
                mayor = valores[x];
            }
        }
        return mayor;
    }

    public int menorMatrix(int valores[]) {
      int menor = valores[0];
      for (int x = 0; x < valores.length; x++) {
        if (valores[x] < menor) {
          menor = valores[x];
        }
      }
      return menor;
    }

    public void procesaMatrix() {
      for (int i = 0; i < n; i++) {   // i=x
        for (int j = 0; j < n; j++) { // j=y
          if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
            if (i == n - 1) {   // esquinas inf y borde inf
              if (j == n - 1) { // esquina inf der
                NewMatrix[i][j] = 11;
                int[] valores =
                    new int[] {Matrix[i - 1][j - 1], Matrix[i - 1][j],
                               Matrix[i][j - 1], Matrix[i][j]};
                NewMatrix[i][j] = mayorMatrix(valores);
                MinMatrix[i][j] = menorMatrix(valores);
              }
              if (j == 0) { // esquina inf izq
                int[] valores =
                    new int[] {Matrix[i - 1][j], Matrix[i - 1][j + 1],
                               Matrix[i][j], Matrix[i][j + 1]};
                NewMatrix[i][j] = mayorMatrix(valores);
                MinMatrix[i][j] = menorMatrix(valores);
              } else { // el punto esta en el borde inferior
                if (j != n - 1) {
                  int[] valores =
                      new int[] {Matrix[i - 1][j - 1], Matrix[i - 1][j],
                                 Matrix[i - 1][j + 1], Matrix[i][j - 1],
                                 Matrix[i][j],         Matrix[i][j + 1]};
                  NewMatrix[i][j] = mayorMatrix(valores);
                  MinMatrix[i][j] = menorMatrix(valores);
                }
              }
            }
            if (i == 0) {   // esquinas sup y borde sup
              if (j == 0) { // esquina sup izq
                int[] valores =
                    new int[] {Matrix[i][j], Matrix[i][j + 1], Matrix[i + 1][j],
                               Matrix[i + 1][j + 1]};
                NewMatrix[i][j] = mayorMatrix(valores);
                MinMatrix[i][j] = menorMatrix(valores);
              }
              if (j == n - 1) { // esquina superior derecha
                int[] valores =
                    new int[] {Matrix[i][j - 1], Matrix[i][j],
                               Matrix[i + 1][j - 1], Matrix[i + 1][j]};
                NewMatrix[i][j] = mayorMatrix(valores);
                MinMatrix[i][j] = menorMatrix(valores);
              } else { // el punto esta solo en el borde superior
                if (j != 0) {
                  int[] valores =
                      new int[] {Matrix[i][j - 1], Matrix[i][j],
                                 Matrix[i][j + 1], Matrix[i + 1][j - 1],
                                 Matrix[i + 1][j], Matrix[i + 1][j + 1]};
                  NewMatrix[i][j] = mayorMatrix(valores);
                  MinMatrix[i][j] = menorMatrix(valores);
                }
              }
            }
            if (j == n - 1) { // el valor esta en el borde der
              if (i != 0 && i != n - 1) {
                int[] valores =
                    new int[] {Matrix[i - 1][j - 1], Matrix[i - 1][j],
                               Matrix[i][j - 1],     Matrix[i][j],
                               Matrix[i + 1][j - 1], Matrix[i + 1][j]};
                NewMatrix[i][j] = mayorMatrix(valores);
                MinMatrix[i][j] = menorMatrix(valores);
              }
            }
            if (j == 0) { // el punto esta en el borde izq
              if (i != 0 && i != n - 1) {
                int[] valores =
                    new int[] {Matrix[i - 1][j], Matrix[i - 1][j + 1],
                               Matrix[i][j],     Matrix[i][j + 1],
                               Matrix[i + 1][j], Matrix[i + 1][j + 1]};
                NewMatrix[i][j] = mayorMatrix(valores);
                MinMatrix[i][j] = menorMatrix(valores);
              }
            }
          } else {
            int[] valores = new int[] {
                Matrix[i - 1][j - 1], Matrix[i - 1][j], Matrix[i - 1][j + 1],
                Matrix[i][j - 1],     Matrix[i][j],     Matrix[i][j + 1],
                Matrix[i + 1][j - 1], Matrix[i + 1][j], Matrix[i + 1][j + 1]};
            NewMatrix[i][j] = mayorMatrix(valores);
            MinMatrix[i][j] = menorMatrix(valores);
          }
        }
      }
    }

    void despliegaNMatrix() {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(NewMatrix[i][j] + " ");
        }
        System.out.println("");
      }
    }

    void despliegaMMatrix() {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(MinMatrix[i][j] + " ");
        }
        System.out.println("");
      }
    }
    
    public int[][] getMax(){
        return NewMatrix;
    }
    
    public int[][] getMin(){
        return MinMatrix;
    }

}
