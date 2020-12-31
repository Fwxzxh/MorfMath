package procimg;

import java.util.Hashtable;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Matrix {

    private int n;// dimenciones matriz cuadrada
    private int d;// profundidad
    int widith; // dimenciones en ancho y largo
    int height; // ...

    private int Matrix[][];// matrix de grises
    int NewMatrix[][];// matrix dilatada
    int MinMatrix[][];// matrix erosionada
    int ZpMatrix[][];// matriz de zonas planas
    int zp;

    int MIN_X = 0;
    int MIN_Y = 0;
    int MAX_Y;
    int MAX_X;
    int Alc;
    public Map<Integer, pZoneModel> zonaPlana = new HashMap<Integer, pZoneModel>();  

    public Matrix(int matriz[][], int dimenciones, int profundidad) {
        // Constructor para Min y Max
        d = profundidad;
        n = dimenciones;
        widith = n;
        height = n;
        MAX_Y = widith - 1;
        MAX_X = height - 1;

        Matrix = matriz;
        NewMatrix = new int[n][n];
        MinMatrix = new int[n][n];
        ZpMatrix = new int[n][n];
    }

    public Matrix(int matriz[][], int dimenciones) {
        // constructor para zona plana
        n = dimenciones;
        widith = n;
        height = n;
        MAX_Y = widith - 1;
        MAX_X = height - 1;

        Matrix = matriz;
        ZpMatrix = new int[n][n];
        zp = 1;
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

    public void procesaZPlana() {
        for (int X = 0; X < widith; X++) {
            for (int Y = 0; Y < height; Y++) {
                int startPosX = (X - 1 < MIN_X) ? X : X - 1;
                int startPosY = (Y - 1 < MIN_Y) ? Y : Y - 1;
                int endPosX = (X + 1 > MAX_X) ? X : X + 1;
                int endPosY = (Y + 1 > MAX_Y) ? Y : Y + 1;

                int kernel = Matrix[X][Y];
                ZpMatrix[X][Y] = zp;
                boolean flag = true;

                // :sweat_smile:
                for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
                    for (int colNum = startPosY; colNum <= endPosY; colNum++) {
                        if (X != rowNum || Y != colNum) {
                            if (kernel == Matrix[rowNum][colNum]) {
                                if (ZpMatrix[rowNum][colNum] != 0) {
                                    if (ZpMatrix[rowNum][colNum] < ZpMatrix[X][Y]) {
                                        flag = false;
                                        ZpMatrix[X][Y] = ZpMatrix[rowNum][colNum];
                                    }
                                    else { ZpMatrix[rowNum][colNum] = ZpMatrix[X][Y]; }
                                }
                                else { ZpMatrix[rowNum][colNum] = zp; }
                            }
                        }
                    }
                } if (flag) { zp++; }
            }
        }
    }

    public void getZonas() {
        for (int i = 0; i < widith; i++) {
            for (int j = 0; j < height; j++) {
                if (zonaPlana.containsKey(ZpMatrix[i][j])) {
                    pZoneModel modelo = zonaPlana.get(ZpMatrix[i][j]);
                    modelo.pushPar(i, j);
                }
                else {
                    zonaPlana.put(ZpMatrix[i][j], new pZoneModel(i,j));
                }
            }
        }
    }

    public void despliegaZonas() {
        for (Map.Entry<Integer, pZoneModel> entry : zonaPlana.entrySet()) {
            Integer key = entry.getKey();
            pZoneModel modelo = entry.getValue();
            System.out.print("Zona "+key+": ");
            for (int i = 0; i < modelo.pares.size(); i++) {
                System.out.print("["+modelo.pares.get(i)[0]+","+modelo.pares.get(i)[1]+"] ");
            }
            System.out.println();
        }
    }
 

    public void procesaMatrix() {
        for (int X = 0; X < widith; X++) {
            for (int Y = 0; Y < height; Y++) {
                int startPosX = (X - d < MIN_X) ? X : X - d;// iniciox = (posAct - n menor al mnimo?)
                int startPosY = (Y - d < MIN_Y) ? Y : Y - d;
                int endPosX = (X + d > MAX_X) ? X : X + d;
                int endPosY = (Y + d > MAX_Y) ? Y : Y + d;

                int di = d + d + 1;// calculamos el numero de vecinos
                int dim = di * di;
                int[] sum = new int[dim]; // dimencion de el array suma.
                int o = 0;

                for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) { // incioX menor o igual a la posfinal x
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

    public void despligaZPMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ZpMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int[][] getZP() {
        return ZpMatrix;
    }
    
    public Map<Integer, pZoneModel> getMapZP() {
        return zonaPlana;
    }

    public int[][] getMax() {
        return NewMatrix;
    }

    public int[][] getMin() {
        return MinMatrix;
    }
}
