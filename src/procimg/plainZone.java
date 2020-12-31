package procimg;

public class plainZone {
    public static void main(String[] args) {
        int dim = 10;
        int matrix[][] = new int[dim][dim];
        int test[][] = new int[dim][dim];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 4);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");//agregar mat test
            }
            System.out.print("\n");
        }

        System.out.print("=======================================\n");

        Matrix mt = new Matrix(matrix, dim);
        mt.procesaZPlana();
        test = mt.getZP();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", test[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("=======================================\n");
        
        mt.getZonas();
        mt.despliegaZonas();

     }
}
