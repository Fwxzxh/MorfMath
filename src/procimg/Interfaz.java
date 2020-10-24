
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
	int[][] pixels = new int[600][600];
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

	public static int getColorRGB(int color) {
		int blue = color & 0xff;
		int green = (color & 0xff00) >> 8;
		int red = (color & 0xff0000) >> 16;

		int Tg = red + green + blue / 3;
		return Tg;
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

                L_img = new javax.swing.JLabel();
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

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                L_img.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
                L_img.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                L_imgMouseClicked(evt);
                        }
                });

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

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(L_img, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                                .addComponent(Txt_y, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(131, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(L_img, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
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
					pixels[i][j] = getColorRGB(img.getRGB(i, j));
				}
			}

			System.out.println(pixels.length);
			System.out.println(pixels[0].length);
			System.out.println(pixels[100][150]);

		} catch (Exception ex) {
			System.out.println("bruh");
		}
        }//GEN-LAST:event_Btn_extraerActionPerformed


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
        private javax.swing.JButton Btn_color;
        private javax.swing.JButton Btn_extraer;
        private javax.swing.JButton Btn_salir;
        private javax.swing.JLabel L_img;
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
        // End of variables declaration//GEN-END:variables
}
