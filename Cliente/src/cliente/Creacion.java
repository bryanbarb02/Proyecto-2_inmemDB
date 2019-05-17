/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import PaqueteDatos.DatoColumna;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Rodríguez
 * Es el jFrame donde se crea el esquema y su fila con el nombre
 * de las columnas.
 */
public class Creacion extends javax.swing.JFrame {
   

    /**
     * Creates new form Creacion
     */
    public Creacion() {
        initComponents();
        this.setLocationRelativeTo(null);//para centrar la pantalla
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCrearEsquema = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        LabelNomEsquema = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NombreEsquemaText = new javax.swing.JTextPane();
        Add1 = new javax.swing.JButton();
        LabelNomColumna = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        NombreColumnaText = new javax.swing.JTextPane();
        Add2 = new javax.swing.JButton();
        AddEsquema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Titulo.setText("Crear Esquema");

        Salir.setBackground(new java.awt.Color(255, 255, 255));
        Salir.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Salir.setForeground(new java.awt.Color(0, 0, 0));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        LabelNomEsquema.setText("Nombre del esquema :");

        jScrollPane1.setViewportView(NombreEsquemaText);

        Add1.setBackground(new java.awt.Color(255, 255, 255));
        Add1.setForeground(new java.awt.Color(0, 0, 0));
        Add1.setText("Add");
        Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add1ActionPerformed(evt);
            }
        });

        LabelNomColumna.setText("Nombre de columna :");

        jScrollPane2.setViewportView(NombreColumnaText);

        Add2.setBackground(new java.awt.Color(255, 255, 255));
        Add2.setForeground(new java.awt.Color(0, 0, 0));
        Add2.setText("Add");
        Add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add2ActionPerformed(evt);
            }
        });

        AddEsquema.setBackground(new java.awt.Color(255, 255, 255));
        AddEsquema.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        AddEsquema.setForeground(new java.awt.Color(0, 0, 0));
        AddEsquema.setText("Add Esquema");
        AddEsquema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEsquemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCrearEsquemaLayout = new javax.swing.GroupLayout(PanelCrearEsquema);
        PanelCrearEsquema.setLayout(PanelCrearEsquemaLayout);
        PanelCrearEsquemaLayout.setHorizontalGroup(
            PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCrearEsquemaLayout.createSequentialGroup()
                .addGroup(PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCrearEsquemaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salir))
                    .addGroup(PanelCrearEsquemaLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCrearEsquemaLayout.createSequentialGroup()
                                .addComponent(LabelNomEsquema)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCrearEsquemaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(LabelNomColumna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCrearEsquemaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AddEsquema)
                .addGap(297, 297, 297))
        );
        PanelCrearEsquemaLayout.setVerticalGroup(
            PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCrearEsquemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelCrearEsquemaLayout.createSequentialGroup()
                        .addGroup(PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Titulo)
                            .addComponent(Salir))
                        .addGap(29, 29, 29)
                        .addGroup(PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(LabelNomEsquema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Add1))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCrearEsquemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelNomColumna)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Add2))
                .addGap(18, 18, 18)
                .addComponent(AddEsquema)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        getContentPane().add(PanelCrearEsquema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);//para salir de la pantalla
    }//GEN-LAST:event_SalirActionPerformed

    private void Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add1ActionPerformed
        String Name=null;
        Name=(NombreEsquemaText.getText());
        Creacion (Name);
        System.out.println(Name);
        
    }//GEN-LAST:event_Add1ActionPerformed

    private void Add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add2ActionPerformed
        String Columna=null;
        Columna=(NombreColumnaText.getText());
        System.out.println(Columna);
        Creacion (Columna);
        NombreColumnaText.setText("");
    }//GEN-LAST:event_Add2ActionPerformed

    private void AddEsquemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEsquemaActionPerformed
        CrearColumna ();
        NombreEsquemaText.setText("");
        new AddMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_AddEsquemaActionPerformed
    List columna = new ArrayList();
    /**
     * Aquí
     * @param Colum tipo List
     */
    public void Creacion (String Colum){
        columna.add(Colum);
    }
     public void CrearColumna() {
      System.out.println(columna);
      DatoColumna enviarlista = new DatoColumna();
      enviarlista.ObtenerLista(columna);
      columna=null;
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
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Creacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add1;
    private javax.swing.JButton Add2;
    private javax.swing.JButton AddEsquema;
    private javax.swing.JLabel LabelNomColumna;
    private javax.swing.JLabel LabelNomEsquema;
    private javax.swing.JTextPane NombreColumnaText;
    private javax.swing.JTextPane NombreEsquemaText;
    private javax.swing.JPanel PanelCrearEsquema;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

   
}
