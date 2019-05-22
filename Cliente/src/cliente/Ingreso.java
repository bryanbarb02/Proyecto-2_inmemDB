
package cliente;
import PaqueteDatos.GetIP;
import PaqueteDatos.SingletonIP;
/**
 *
 * @author Kevin Rodríguez
 * Este es un jFrame que que pide el IP y luego avanza.
 */
public class Ingreso extends javax.swing.JFrame {
    SingletonIP si;
    /**
     * Creates new form Ingreso
     */
    public Ingreso() {
        initComponents();
        this.setLocationRelativeTo(null);//para centrar la pantalla
        si = SingletonIP.getInstanceSingletonIP();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelIP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IpText = new javax.swing.JTextPane();
        Siguente = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        LabelInmemDB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelIP.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        LabelIP.setForeground(new java.awt.Color(0, 0, 0));
        LabelIP.setText("Ingrese IP :");

        IpText.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(IpText);

        Siguente.setBackground(new java.awt.Color(255, 255, 255));
        Siguente.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Siguente.setForeground(new java.awt.Color(0, 0, 0));
        Siguente.setText("Siguinte");
        Siguente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguenteActionPerformed(evt);
            }
        });

        Salir.setBackground(new java.awt.Color(255, 255, 255));
        Salir.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Salir.setForeground(new java.awt.Color(0, 0, 0));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        LabelInmemDB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LabelInmemDB.setForeground(new java.awt.Color(0, 0, 0));
        LabelInmemDB.setText("InmemDB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Siguente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Salir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LabelIP)
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(LabelInmemDB, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(LabelInmemDB)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelIP)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Siguente)
                    .addComponent(Salir)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 100));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     *Botón siguiente que obtiene el IP del TextPlane y sigue a la próxima ventana.
     * @param evt 
     */
    private void SiguenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguenteActionPerformed
        new Arbol_menu().setVisible(true);
        String Ip=null;
        Ip=(IpText.getText());
        System.out.println(Ip);
        si.setIP(Ip);
        dispose();
    }//GEN-LAST:event_SiguenteActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);//para salir de la pantalla
    }//GEN-LAST:event_SalirActionPerformed
    public void enviarIP(String IP){
        GetIP getip = new GetIP();
        getip.GetIP(IP);
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane IpText;
    private javax.swing.JLabel LabelIP;
    private javax.swing.JLabel LabelInmemDB;
    private javax.swing.JButton Salir;
    private javax.swing.JButton Siguente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
