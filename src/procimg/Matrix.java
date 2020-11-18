package procimg;

import java.util.Random;

public class Matrix {
    
    private int n;//dimenciones matriz cuadrada
    private int d;//profundidad
    int widith; //dimenciones en ancho y largo
    int height; //...
    
    private int Matrix[][];//matrix de grises
    int NewMatrix[][];//matrix dilatada
    int MinMatrix[][];// matrix erosionada
    
    int MIN_X = 0;
    int MIN_Y = 0;
    int MAX_Y;
    int MAX_X;


    public Matrix(int matriz[][], int dimenciones, int profundidad){
        d = profundidad;
        n = dimenciones;
        widith = n;
        height = n;
        MAX_Y = widith - 1;
        MAX_X = height - 1;
        
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
        for (int X = 0; X < widith; X++) {
            for (int Y = 0; Y < height; Y++) {      
                int startPosX = (X - d < MIN_X) ? X : X - d;// iniciox = (posAct - n menor al mnimo?) 
                int startPosY = (Y - d < MIN_Y) ? Y : Y - d;
                int endPosX = (X + d > MAX_X) ? X : X + d;
                int endPosY = (Y + d > MAX_Y) ? Y : Y + d;
                
                int di = d + d + 1;//calculamos el numero de vecinos
                int dim = di * di;
                int[] sum = new int[dim]; //dimencion de el array suma.
                int o = 0;
                
                for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {     // incioX menor o igual a la posfinal x
                    for (int colNum = startPosY; colNum <= endPosY; colNum++) {
                        sum[o] = Matrix[rowNum][colNum];
                        o++;
                    }
                }
            NewMatrix[X][Y] = mayorMatrix(sum);
            MinMatrix[X][Y] = menorMatrix(sum);
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
