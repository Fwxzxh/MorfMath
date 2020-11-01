
package procimg;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
	BufferedImage img;
	int[][] pixels = new int[600][600]; //matriz de grises original
	int[][] pixelsMin = new int[600][600]; //matriz de grises minima
	int[][] pixelsMax = new int[600][600]; //matriz de grises maxima

	FileInputStream entrada;
	FileOutputStream salida;
	
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

            int Tg = red + green + blue / 3;
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
                        Txt_Org.append(String.format("%3d%5s", matrix[row][col], "|"));
                    }
                    Txt_Org.append("\n");
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        L_img = new javax.swing.JLabel();
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

        Txt_estado.setText("OK");

        L_img.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        L_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L_imgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_img, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(L_img, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        jTabbedPane1.addTab("Org", jPanel3);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
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

        jTabbedPane1.addTab("MatMin", jPanel4);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
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

        jTabbedPane1.addTab("MatMax", jPanel1);

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
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

        jTabbedPane1.addTab("MatOrg", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jTabbedPane1.getAccessibleContext().setAccessibleName("");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

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
					L_img.setText("");
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
                        
			Matrix mat = new Matrix(pixels,w); //instanciamos Matrix
                        mat.procesaMatrix(); //procesamos la matriz en escala de grises
                        pixelsMin = mat.getMin();
                        pixelsMax = mat.getMax(); 



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
    private javax.swing.JButton Btn_calcularMax;
    private javax.swing.JButton Btn_color;
    private javax.swing.JButton Btn_extraer;
    private javax.swing.JButton Btn_salir;
    private javax.swing.JLabel L_img;
    private javax.swing.JTextArea Txt_Max;
    private javax.swing.JTextArea Txt_Min;
    private javax.swing.JTextArea Txt_Org;
    private javax.swing.JTextField Txt_blue;
    private javax.swing.JLabel Txt_estado;
    private javax.swing.JTextField Txt_green;
    private javax.swing.JTextField Txt_red;
    private javax.swing.JTextField Txt_x;
    private javax.swing.JTextField Txt_y;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
