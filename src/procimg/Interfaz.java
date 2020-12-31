
package procimg;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;




public class Interfaz extends javax.swing.JFrame {
	JFileChooser seleccionar = new JFileChooser();
	File archivo;
	byte[] imagen;
	BufferedImage img;// org

      
        int widith = 600;
        int height = 600;
        BufferedImage imgG = new BufferedImage(widith, height, BufferedImage.TYPE_INT_RGB); // img gris
        BufferedImage imgE = new BufferedImage(widith, height, BufferedImage.TYPE_INT_RGB); // img Erocionada
        BufferedImage imgD = new BufferedImage(widith, height, BufferedImage.TYPE_INT_RGB); // img Dilatada

        
	int[][] pixels = new int[600][600]; //matriz de grises original
	int[][] pixelsMin = new int[600][600]; //matriz de grises minima
	int[][] pixelsMax = new int[600][600]; //matriz de grises maxima
        int[][] pixelsZp = new int[600][600];

	FileInputStream entrada;
	FileOutputStream salida;
        public Map<Integer, pZoneModel> zonaPlanaUI = new HashMap<Integer, pZoneModel>();  

       
        
	
	public Interfaz() {
		initComponents();
	}
	
	public static BufferedImage scale(BufferedImage src, int w, int h) {
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		int x, y;
		int ww = src.getWidth();
		int hh = src.getHeight();
		int[] ys = new int[h];
		for (y = 0; y < h; y++) {
			ys[y] = y * hh / h;
		}
		for (x = 0; x < w; x++) {
			int newX = x * ww / w;
			for (y = 0; y < h; y++) {
				int col = src.getRGB(newX, ys[y]);
				img.setRGB(x, y, col);
			}
		}
		return img;
	}

        public static int getPromRGB(int color) {
            int blue = color & 0xff;
            int green = (color & 0xff00) >> 8;
            int red = (color & 0xff0000) >> 16;

            int Tg = (red + green + blue) / 3;
            return Tg;
        }

        public void printMatrix(int[][] matrix,int n) {
           //TODO fix this messs
            Txt_estado.setText("procesando... ");
            if (n == 1) {
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        Txt_Min.append(String.format("%3d%5s", matrix[row][col], "|"));
                    }
                    Txt_Min.append("\n");
                }
                Txt_estado.setText("OK");
            }
            if (n == 2) {
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        Txt_Max.append(String.format("%3d%5s", matrix[row][col], "|"));
                    }
                    Txt_Max.append("\n");
                }
                Txt_estado.setText("OK");
            }
            if (n == 3) {
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        Txt_Org.append(String.format("%4d%5s", matrix[row][col], "|"));
                    }
                    Txt_Org.append("\n");
                }
                Txt_estado.setText("OK");
            }
            if (n == 4) {
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        Txt_ZpMatrix.append(String.format("%4d%5s", matrix[row][col], "|"));
                    }
                    Txt_ZpMatrix.append("\n");
                }
                Txt_estado.setText("OK");
            }
        }

	byte[] AbrirArchivo(File Archivo) {
		byte[] imagen = new byte[3840 * 2160];
		try {
			entrada = new FileInputStream(archivo);
			entrada.read(imagen);
		} catch (Exception e) {
			System.out.println("Error = " + e);
		}
		return imagen;
	}
        
        ArrayList<Point> lista = new ArrayList<Point>();
        
        double suma = 0;

	
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Abrir = new javax.swing.JButton();
        Btn_extraer = new javax.swing.JButton();
        Btn_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Txt_green = new javax.swing.JTextField();
        Txt_red = new javax.swing.JTextField();
        Txt_blue = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Txt_x = new javax.swing.JTextField();
        Txt_y = new javax.swing.JTextField();
        Btn_color = new javax.swing.JButton();
        Txt_estado = new javax.swing.JLabel();
        Panel = new javax.swing.JTabbedPane();
        Img_org = new javax.swing.JPanel();
        L_img = new javax.swing.JLabel();
        PanelImg = new javax.swing.JPanel();
        L_imgG = new javax.swing.JLabel();
        Btn_Gray = new javax.swing.JButton();
        Txt_suma = new javax.swing.JLabel();
        Img_Min = new javax.swing.JPanel();
        L_ImgMin = new javax.swing.JLabel();
        Btn_MostrarMin = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Txt_profMin = new javax.swing.JTextField();
        ImgMax = new javax.swing.JPanel();
        L_ImgMax = new javax.swing.JLabel();
        Btn_Max = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Txt_profMax = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Txt_Min = new javax.swing.JTextArea();
        Btn_CalcularMin = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Txt_Max = new javax.swing.JTextArea();
        Btn_calcularMax = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Txt_Org = new javax.swing.JTextArea();
        Btn_CalcularOrg = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Txt_ZP = new javax.swing.JTextArea();
        Btn_getZP = new javax.swing.JButton();
        Btn_printZP = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Txt_ZpMatrix = new javax.swing.JTextArea();
        Btn_ZpMatrix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_Abrir.setText("Abrir");
        Btn_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AbrirActionPerformed(evt);
            }
        });

        Btn_extraer.setText("Extraer");
        Btn_extraer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_extraerActionPerformed(evt);
            }
        });

        Btn_salir.setText("Salir");
        Btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_salirActionPerformed(evt);
            }
        });

        jLabel1.setText("Red:");

        jLabel2.setText("Green:");

        jLabel3.setText("Blue:");

        Txt_red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_redActionPerformed(evt);
            }
        });

        jLabel4.setText("X:");

        jLabel5.setText("Y:");

        Txt_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_xActionPerformed(evt);
            }
        });

        Txt_y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_yActionPerformed(evt);
            }
        });

        Txt_estado.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        Txt_estado.setText("OK");

        L_img.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        L_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L_imgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Img_orgLayout = new javax.swing.GroupLayout(Img_org);
        Img_org.setLayout(Img_orgLayout);
        Img_orgLayout.setHorizontalGroup(
            Img_orgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Img_orgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_img, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Img_orgLayout.setVerticalGroup(
            Img_orgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Img_orgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(L_img, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        Panel.addTab("Org", Img_org);

        L_imgG.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        L_imgG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L_imgGMouseClicked(evt);
            }
        });
        L_imgG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                L_imgGKeyPressed(evt);
            }
        });

        Btn_Gray.setText("Mostrar");
        Btn_Gray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GrayActionPerformed(evt);
            }
        });

        Txt_suma.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        javax.swing.GroupLayout PanelImgLayout = new javax.swing.GroupLayout(PanelImg);
        PanelImg.setLayout(PanelImgLayout);
        PanelImgLayout.setHorizontalGroup(
            PanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelImgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_imgG, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_suma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelImgLayout.createSequentialGroup()
                        .addComponent(Btn_Gray)
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelImgLayout.setVerticalGroup(
            PanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelImgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelImgLayout.createSequentialGroup()
                        .addComponent(Btn_Gray)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Txt_suma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(L_imgG, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel.addTab("ImgGray", PanelImg);

        L_ImgMin.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        Btn_MostrarMin.setText("Mostrar");
        Btn_MostrarMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MostrarMinActionPerformed(evt);
            }
        });

        jLabel6.setText("Profundidad, Default 1:");

        javax.swing.GroupLayout Img_MinLayout = new javax.swing.GroupLayout(Img_Min);
        Img_Min.setLayout(Img_MinLayout);
        Img_MinLayout.setHorizontalGroup(
            Img_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Img_MinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_ImgMin, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Img_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_MostrarMin)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Txt_profMin))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        Img_MinLayout.setVerticalGroup(
            Img_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Img_MinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Img_MinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Img_MinLayout.createSequentialGroup()
                        .addComponent(Btn_MostrarMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_profMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(L_ImgMin, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel.addTab("ImgMin", Img_Min);

        ImgMax.setBorder(null);

        L_ImgMax.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        Btn_Max.setText("Mostrar");
        Btn_Max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MaxActionPerformed(evt);
            }
        });

        jLabel7.setText("Profundidad, Default 1:");

        javax.swing.GroupLayout ImgMaxLayout = new javax.swing.GroupLayout(ImgMax);
        ImgMax.setLayout(ImgMaxLayout);
        ImgMaxLayout.setHorizontalGroup(
            ImgMaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImgMaxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_ImgMax, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ImgMaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_Max)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Txt_profMax))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        ImgMaxLayout.setVerticalGroup(
            ImgMaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImgMaxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ImgMaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImgMaxLayout.createSequentialGroup()
                        .addComponent(Btn_Max)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_profMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(L_ImgMax, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel.addTab("ImgMax", ImgMax);

        jPanel4.setToolTipText("");

        Txt_Min.setColumns(20);
        Txt_Min.setRows(5);
        jScrollPane1.setViewportView(Txt_Min);

        Btn_CalcularMin.setText("Mostrar");
        Btn_CalcularMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CalcularMinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_CalcularMin)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Btn_CalcularMin)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
                .addContainerGap())
        );

        Panel.addTab("MatMin", jPanel4);

        Txt_Max.setColumns(20);
        Txt_Max.setRows(5);
        jScrollPane2.setViewportView(Txt_Max);

        Btn_calcularMax.setText("Mostrar");
        Btn_calcularMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_calcularMaxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_calcularMax)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_calcularMax)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
                .addContainerGap())
        );

        Panel.addTab("MatMax", jPanel1);

        Txt_Org.setColumns(20);
        Txt_Org.setRows(5);
        jScrollPane3.setViewportView(Txt_Org);

        Btn_CalcularOrg.setText("Mostrar");
        Btn_CalcularOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CalcularOrgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_CalcularOrg)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Btn_CalcularOrg)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
                .addContainerGap())
        );

        Panel.addTab("MatOrg", jPanel2);

        Txt_ZP.setColumns(20);
        Txt_ZP.setRows(5);
        jScrollPane4.setViewportView(Txt_ZP);

        Btn_getZP.setText("P. Zonas planas");
        Btn_getZP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_getZPActionPerformed(evt);
            }
        });

        Btn_printZP.setText("Print ZonasPlanas");
        Btn_printZP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_printZPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Btn_getZP)
                        .addGap(30, 30, 30)
                        .addComponent(Btn_printZP)
                        .addGap(0, 504, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_getZP)
                    .addComponent(Btn_printZP))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Panel.addTab("Zonas Planas", jPanel3);

        Txt_ZpMatrix.setColumns(20);
        Txt_ZpMatrix.setRows(5);
        jScrollPane5.setViewportView(Txt_ZpMatrix);

        Btn_ZpMatrix.setText("Mostrar");
        Btn_ZpMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ZpMatrixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_ZpMatrix)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Btn_ZpMatrix)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
                .addContainerGap())
        );

        Panel.addTab("zPMatrix", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Txt_estado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_Abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Txt_red, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Btn_extraer, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Txt_green, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Btn_color, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Txt_blue, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Txt_x, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Txt_y, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Abrir)
                    .addComponent(jLabel1)
                    .addComponent(Txt_red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Txt_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_extraer)
                    .addComponent(jLabel2)
                    .addComponent(Txt_green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(Txt_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_salir)
                    .addComponent(jLabel3)
                    .addComponent(Txt_blue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_color, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel.getAccessibleContext().setAccessibleName("");
        Panel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void Txt_redActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_redActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_Txt_redActionPerformed

        private void Txt_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_xActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_Txt_xActionPerformed

        private void Txt_yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_yActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_Txt_yActionPerformed

        private void Btn_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AbrirActionPerformed
                // TODO add your handling code here:
		if (seleccionar.showDialog(null, null) == JFileChooser.APPROVE_OPTION) {
			archivo = seleccionar.getSelectedFile();
			if (archivo.canRead()) {
				if (archivo.getName().endsWith("jpg")
					|| archivo.getName().endsWith("bmp")
					|| archivo.getName().endsWith("png")
					|| archivo.getName().endsWith("jpeg")) {
					imagen = AbrirArchivo(archivo);

					L_img.setIcon(new ImageIcon(imagen));
					ImageIcon fot = new ImageIcon(imagen);
					Icon icono = new ImageIcon(fot.getImage().getScaledInstance(
						L_img.getHeight(), L_img.getWidth(), Image.SCALE_DEFAULT));

					L_img.setIcon(icono);
				} else {
					Txt_estado.setText("Tipo de archivo no compatible");
				}
			}
		}
        }//GEN-LAST:event_Btn_AbrirActionPerformed

        private void Btn_extraerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_extraerActionPerformed
                // TODO add your handling code here:
		BufferedImage buffPlano;
		try {
			int w = 600;
			int h = 600;
			buffPlano = ImageIO.read(archivo);
			img = scale(buffPlano, w, h);
			Txt_estado.setText("Imagen Lista para Analisis");

			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					pixels[i][j] = getPromRGB(img.getRGB(i, j)); //RGB -> Escala de grises
				}
			}                      
                        
                        Txt_estado.setText("Procesando Imagen");
			Matrix mat = new Matrix(pixels,w,1); //instanciamos Matrix
                        mat.procesaMatrix(); //procesamos la matriz en escala de grises
                        pixelsMin = mat.getMin();// eroción
                        pixelsMax = mat.getMax(); // dilaciatión
                        Txt_estado.setText("Imagen Procesada");                     

		} catch (Exception ex) {
			System.out.println("Bruh: "+ex);
		}

        }//GEN-LAST:event_Btn_extraerActionPerformed

        private void L_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_imgMouseClicked
                // TODO add your handling code here:
                int x = (int) L_img.getMousePosition().getX();
                int y = (int) L_img.getMousePosition().getY();

                Txt_x.setText(""+x);
                Txt_y.setText(""+y);

                int rgb = img.getRGB(x, y);
                Color color = new Color(rgb, true);

                Txt_red.setText(""+color.getRed());
                Txt_green.setText(""+color.getGreen());
                Txt_blue.setText(""+color.getBlue());
                Btn_color.setBackground(color);
        }//GEN-LAST:event_L_imgMouseClicked

    private void Btn_CalcularMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CalcularMinActionPerformed
        // TODO add your handling code here:
        printMatrix(pixelsMin, 1);
    }//GEN-LAST:event_Btn_CalcularMinActionPerformed

    private void Btn_calcularMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_calcularMaxActionPerformed
        // TODO add your handling code here:
        printMatrix(pixelsMax, 2);
    }//GEN-LAST:event_Btn_calcularMaxActionPerformed

    private void Btn_CalcularOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CalcularOrgActionPerformed
        // TODO add your handling code here:
        printMatrix(pixels, 3);
    }//GEN-LAST:event_Btn_CalcularOrgActionPerformed

    private void Btn_GrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GrayActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < widith; i++) {
            for (int j = 0; j < height; j++) {
                int n = pixels[i][j];
                Color color = new Color(n,n,n);
                imgG.setRGB(i, j, color.getRGB());
            }
        }
        
        L_imgG.setIcon(new ImageIcon(imgG));
        ImageIcon fot = new ImageIcon(imgG);
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(
                L_imgG.getHeight(), L_imgG.getWidth(), Image.SCALE_DEFAULT));
        L_imgG.setIcon(icono);    

    }//GEN-LAST:event_Btn_GrayActionPerformed

    private void Btn_MostrarMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MostrarMinActionPerformed
        // TODO add your handling code here:
        if (!Txt_profMin.getText().equals("")) {
            
            int msg = Integer.parseInt(Txt_profMin.getText());
            Txt_estado.setText("Procesando Imagen, Eroción, Prof: " + msg);
            Matrix mat = new Matrix(pixels, widith, msg); //instanciamos Matrix
            mat.procesaMatrix(); //procesamos la matriz en escala de grises
            pixelsMin = mat.getMin();// eroción
            
        }
       
        for (int i = 0; i < widith; i++) {
            for (int j = 0; j < height; j++) {
                int n = pixelsMin[i][j];
                Color color = new Color(n, n, n);
                imgE.setRGB(i, j, color.getRGB());
            }
        }

        L_ImgMin.setIcon(new ImageIcon(imgE));
        ImageIcon fot = new ImageIcon(imgE);
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(
                L_ImgMin.getHeight(), L_ImgMin.getWidth(), Image.SCALE_DEFAULT));
        L_ImgMin.setIcon(icono);
    }//GEN-LAST:event_Btn_MostrarMinActionPerformed

    private void Btn_MaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MaxActionPerformed
        // TODO add your handling code here:
        if (!Txt_profMax.getText().equals("")) {
            
            int msg = Integer.parseInt(Txt_profMax.getText());
            Txt_estado.setText("Procesando Imagen, Dilatación, Prof: "+msg);
            Matrix mat = new Matrix(pixels, widith, msg); //instanciamos Matrix
            mat.procesaMatrix(); //procesamos la matriz en escala de grises
            pixelsMax = mat.getMax(); // dilaciatión
            
        } 
        
        for (int i = 0; i < widith; i++) {
            for (int j = 0; j < height; j++) {
                int n = pixelsMax[i][j];
                Color color = new Color(n, n, n);
                imgD.setRGB(i, j, color.getRGB());
            }
        }

        L_ImgMax.setIcon(new ImageIcon(imgD));
        ImageIcon fot = new ImageIcon(imgD);
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(
                L_ImgMax.getHeight(), L_ImgMax.getWidth(), Image.SCALE_DEFAULT));
        L_ImgMax.setIcon(icono);

    }//GEN-LAST:event_Btn_MaxActionPerformed

    private void L_imgGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_imgGMouseClicked
        // TODO add your handling code here:
        Graphics g = L_imgG.getGraphics();
        g.setColor(Color.red);
        g.drawRect(evt.getX(), evt.getY(), 5, 5);
        
        lista.add(new Point(evt.getX(), evt.getY()));
        
        if (lista.size() > 1) {
            //DIBUJAR LINEA
            suma =  suma + sqrt(
                    (Math.pow((lista.get(lista.size() -2).x - lista.get(lista.size() -1).x),2)) +
                    (Math.pow((lista.get(lista.size() -2).y - lista.get(lista.size() -1).y),2))
                    );

            Txt_suma.setText("Distancia(px): "+String.format("%.3f %n", suma));
            
            g.drawLine( lista.get(lista.size() - 1).x, 
                        lista.get(lista.size() - 1).y, 
                        lista.get(lista.size() - 2).x, 
                        lista.get(lista.size() - 2).y);
        }
    }//GEN-LAST:event_L_imgGMouseClicked

    private void L_imgGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L_imgGKeyPressed
        // TODO add your handling code here:
        System.out.print("okokokokok");
    }//GEN-LAST:event_L_imgGKeyPressed

    private void Btn_getZPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_getZPActionPerformed
        // TODO add your handling code here:
        Txt_estado.setText("Obteniendo Zonas Planas");
        Matrix mt = new Matrix(pixels, widith);
        mt.procesaZPlana();
        pixelsZp = mt.getZP();
        mt.getZonas();
        zonaPlanaUI = mt.getMapZP();
        Txt_estado.setText("Zonas planas obtenidas!");
    }//GEN-LAST:event_Btn_getZPActionPerformed

    private void Btn_printZPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_printZPActionPerformed
        // TODO add your handling code here:
        for (Map.Entry<Integer, pZoneModel> entry : zonaPlanaUI.entrySet()) {
            Integer key = entry.getKey();
            pZoneModel modelo = entry.getValue();
            Txt_ZP.append("Zona "+key+": ");
            System.out.println(key);
            for (int i = 0; i < modelo.pares.size(); i++) {
                Txt_ZP.append("["+modelo.pares.get(i)[0]+","+modelo.pares.get(i)[1]+"] ");
                if (i > 1024){ break; }
            }
            Txt_ZP.append("\n");
        }
    }//GEN-LAST:event_Btn_printZPActionPerformed

    private void Btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_salirActionPerformed
        // TODO add your handling code here:
        Txt_estado.setText("Ok");
    }//GEN-LAST:event_Btn_salirActionPerformed

    private void Btn_ZpMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ZpMatrixActionPerformed
        // TODO add your handling code here:
        printMatrix(pixelsZp, 4);
    }//GEN-LAST:event_Btn_ZpMatrixActionPerformed


	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Interfaz().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Abrir;
    private javax.swing.JButton Btn_CalcularMin;
    private javax.swing.JButton Btn_CalcularOrg;
    private javax.swing.JButton Btn_Gray;
    private javax.swing.JButton Btn_Max;
    private javax.swing.JButton Btn_MostrarMin;
    private javax.swing.JButton Btn_ZpMatrix;
    private javax.swing.JButton Btn_calcularMax;
    private javax.swing.JButton Btn_color;
    private javax.swing.JButton Btn_extraer;
    private javax.swing.JButton Btn_getZP;
    private javax.swing.JButton Btn_printZP;
    private javax.swing.JButton Btn_salir;
    private javax.swing.JPanel ImgMax;
    private javax.swing.JPanel Img_Min;
    private javax.swing.JPanel Img_org;
    private javax.swing.JLabel L_ImgMax;
    private javax.swing.JLabel L_ImgMin;
    private javax.swing.JLabel L_img;
    private javax.swing.JLabel L_imgG;
    private javax.swing.JTabbedPane Panel;
    private javax.swing.JPanel PanelImg;
    private javax.swing.JTextArea Txt_Max;
    private javax.swing.JTextArea Txt_Min;
    private javax.swing.JTextArea Txt_Org;
    private javax.swing.JTextArea Txt_ZP;
    private javax.swing.JTextArea Txt_ZpMatrix;
    private javax.swing.JTextField Txt_blue;
    private javax.swing.JLabel Txt_estado;
    private javax.swing.JTextField Txt_green;
    private javax.swing.JTextField Txt_profMax;
    private javax.swing.JTextField Txt_profMin;
    private javax.swing.JTextField Txt_red;
    private javax.swing.JLabel Txt_suma;
    private javax.swing.JTextField Txt_x;
    private javax.swing.JTextField Txt_y;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
