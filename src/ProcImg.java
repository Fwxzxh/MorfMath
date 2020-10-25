import java.util.Random;

public class ProcImg {

  public static void main(String[] args) {
    // TODO code application logic here
    System.out.println(" ok ");
    operaciones op = new operaciones();
    op.construyeMatrix();
    op.despliegeMatrix();
  }
   static class operaciones {
     int n = 10;
     int m = 10;
     int Matrix[][] = new int[n][m];
     Random ran = new Random();
     int valorRGB() {
       int r = 10;
       int g = 20;
       int b = 30;
       int rgb = (r + g + b) / 3;
       return rgb;
     }
     void construyeMatrix() {
       for (int i = 0; i < n; i++) {
         for (int j = 0; i < m; j++) {
           Matrix[i][j] = valorRGB();
         }
       }
     }
     void despliegeMatrix() {
       for (int i = 0; i < n; i++) {
         for (int j = 0; i < m; j++) {
           System.out.print(Matrix[i][j] + "");
         }
         System.out.print("");
       }
     }
   }
}
