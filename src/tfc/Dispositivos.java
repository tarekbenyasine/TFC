
package tfc;

import com.jtattoo.plaf.noire.NoireLookAndFeel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tarek
 */
public class Dispositivos extends javax.swing.JFrame {

    /**
     * Creates new form Dispositivos
     */
    public Dispositivos() {
        initComponents();
        
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setResizable(true);
        Object[] cabecera = new Object[]{"Id Dispositivo","Tipo Dispositivo","Modelo","Marca","Numero de Serie","IP","MAC","EAN13","Eliminar"};
        Object[][] datos = new Object[][]{};
        DefaultTableModel miModelo = new DefaultTableModel(datos,cabecera){
        @Override
        public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0: return Integer.class;
            case 8: return ImageIcon.class;
            default: return Object.class;
        }
        }
        };
        jTable.setModel(miModelo);
        Statement sentencia;
        try {
             sentencia = dameConexion().createStatement();
            String sql="SELECT D.id_dispositivo,T.tipo,D.modelo,M.marca,D.numero_serie,D.ip,D.mac,D.ean13 FROM Dispositivo D,Marca M,Tipo T WHERE D.id_tipo = T.id_tipo AND D.id_marca = M.id_marca;";
            
            ResultSet resul = sentencia.executeQuery(sql);
            Object[] resultado = {"","","","","","","","","",""};
            while(resul.next())
            {
                resultado[0]=resul.getInt(1);
                resultado[1]=resul.getString(2);
                resultado[2]=resul.getString(3);
                resultado[3]=resul.getString(4);
                resultado[4]=resul.getString(5);
                resultado[5]=resul.getString(6);
                resultado[6]=resul.getString(7);
                resultado[7]=resul.getString(8);
                resultado[8]=new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
                
                miModelo.addRow(resultado);
            }
            
            String sql2="SELECT id_marca, marca FROM Marca";
            String sql3="SELECT id_tipo, tipo FROM Tipo";
            resul = sentencia.executeQuery(sql2);
            while(resul.next())
            {
                idmarca.put(resul.getString(2),resul.getInt(1));
                jComboBoxMarca.addItem(resul.getString(2));
            }
            resul = sentencia.executeQuery(sql3);
            while(resul.next())
            {
                jComboBoxTipo.addItem(resul.getString(2));
                idtipo.put(resul.getString(2), resul.getInt(1));
            }
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        
        }
        
    }
    private HashMap<String, Integer> idtipo = new HashMap<String, Integer>();
    private HashMap<String, Integer> idmarca = new HashMap<String, Integer>();
    private Connection dameConexion(){
          Connection con = null;
          String baseDatos = "jdbc:sqlite:"+System.getProperty("user.dir")+"\\BBDD\\BBDD.db";
         
          try {
              con= DriverManager.getConnection(baseDatos);
          } catch (SQLException ex) {
              Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
          return con;
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabelModelo = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldSN = new javax.swing.JTextField();
        jLabelSN = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jLabelIP = new javax.swing.JLabel();
        jTextFieldMAC = new javax.swing.JTextField();
        jLabelMAC = new javax.swing.JLabel();
        jButtonFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jTextFieldIdDispositivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jButtonLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jFormattedTextFieldean13 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemAniadirPlanta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de dispositivo" }));
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 48);
        jPanel2.add(jComboBoxTipo, gridBagConstraints);

        jLabelModelo.setText("Modelo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 10);
        jPanel2.add(jLabelModelo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 0);
        jPanel2.add(jTextFieldModelo, gridBagConstraints);

        jTextFieldSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSNActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jTextFieldSN, gridBagConstraints);

        jLabelSN.setText("Numero de serie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jLabelSN, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jTextFieldIP, gridBagConstraints);

        jLabelIP.setText("IP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jLabelIP, gridBagConstraints);

        jTextFieldMAC.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jTextFieldMAC, gridBagConstraints);

        jLabelMAC.setText("MAC");
        jLabelMAC.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jLabelMAC, gridBagConstraints);

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 6;
        jPanel2.add(jButtonFiltrar, gridBagConstraints);

        jLabel1.setText("EAN13");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jLabel1, gridBagConstraints);

        jButtonModificar.setText("Modificar Dispositivo");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 6;
        jPanel2.add(jButtonModificar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jTextFieldIdDispositivo, gridBagConstraints);

        jLabel2.setText("Id dispositivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jLabel2, gridBagConstraints);

        jComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca del dispositivo" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 48);
        jPanel2.add(jComboBoxMarca, gridBagConstraints);

        jButtonLimpiar.setText("Actualizar Tabla");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 6;
        jPanel2.add(jButtonLimpiar, gridBagConstraints);

        jButton1.setText("Eliminar tipo de dispositivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jButton1, gridBagConstraints);

        jButton2.setText("Eliminar marca");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jButton2, gridBagConstraints);

        jFormattedTextFieldean13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldean13KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel2.add(jFormattedTextFieldean13, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.jpg"))); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Secciones");

        jMenuItem2.setText("Ventana Principal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Usuarios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Dispositivos");
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Añadir");

        jMenuItemAniadirPlanta.setText("Añadir ");
        jMenuItemAniadirPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAniadirPlantaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemAniadirPlanta);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Info");

        jMenuItem1.setText("Acerca De");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Usuarios v1 = new Usuarios();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void jMenuItemAniadirPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAniadirPlantaActionPerformed
        // TODO add your handling code here:
        Aniadir v1 = new Aniadir();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemAniadirPlantaActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        Object[] cabecera = new Object[]{"Id Dispositivo","Tipo Dispositivo","Modelo","Marca","Numero de Serie","IP","MAC","EAN13","Eliminar"};
        Object[][] datos = new Object[][]{};
        DefaultTableModel miModelo = new DefaultTableModel(datos,cabecera){
        @Override
        public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0: return Integer.class;
            case 8: return ImageIcon.class;
            default: return Object.class;
        }
        }
        };
        jTable.setModel(miModelo);
        try {
            Statement sentencia = dameConexion().createStatement();
            String sql="SELECT D.id_dispositivo,T.tipo,D.modelo,M.marca,D.numero_serie,D.ip,D.mac,D.ean13 FROM Dispositivo D,Marca M,Tipo T WHERE D.id_tipo = T.id_tipo AND D.id_marca = M.id_marca ";
            if(jComboBoxTipo.getSelectedIndex()!=0){
                
                sql=sql+"AND T.id_tipo LIKE '"+idtipo.get(jComboBoxTipo.getItemAt(jComboBoxTipo.getSelectedIndex()))+"'";
                
            }
            if(!jTextFieldModelo.getText().isEmpty()){
                sql=sql+"AND D.modelo LIKE '%"+jTextFieldModelo.getText()+"%'";
                
            }
            if(jComboBoxMarca.getSelectedIndex()!=0){
                sql=sql+"AND M.id_marca LIKE '"+idmarca.get(jComboBoxMarca.getItemAt(jComboBoxMarca.getSelectedIndex()))+"'";
                System.out.println(sql);
            }
            if(!jTextFieldSN.getText().isEmpty()){
                sql=sql+"AND D.numero_serie LIKE '%"+jTextFieldSN.getText()+"%'";
                
            }
            if(!jFormattedTextFieldean13.getText().isEmpty()){
                sql=sql+"AND D.ean13 LIKE '%"+jFormattedTextFieldean13.getText()+"%'";
                
            }
            if(!jTextFieldIP.getText().isEmpty()){
                sql=sql+"AND D.ip LIKE '%"+jTextFieldIP.getText()+"%'";
                
            }
            if(!jTextFieldMAC.getText().isEmpty()){
                sql=sql+"AND D.mac LIKE '%"+jTextFieldMAC.getText()+"%'";
                
            }
            ResultSet resul = sentencia.executeQuery(sql);
             Object[] resultado = {"","","","","","","","","",""};
            while(resul.next())
            {
                resultado[0]=resul.getInt(1);
                resultado[1]=resul.getString(2);
                resultado[2]=resul.getString(3);
                resultado[3]=resul.getString(4);
                resultado[4]=resul.getString(5);
                resultado[5]=resul.getString(6);
                resultado[6]=resul.getString(7);
                resultado[7]=resul.getString(8);
                resultado[8]=new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
                
                miModelo.addRow(resultado);
            }
            
            String sql2="SELECT id_marca, marca FROM Marca";
            String sql3="SELECT id_tipo, tipo FROM Tipo";
            resul = sentencia.executeQuery(sql2);
            while(resul.next())
            {
                idmarca.put(resul.getString(2),resul.getInt(1));
                jComboBoxMarca.addItem(resul.getString(2));
            }
            resul = sentencia.executeQuery(sql3);
            while(resul.next())
            {
                jComboBoxTipo.addItem(resul.getString(2));
                idtipo.put(resul.getString(2), resul.getInt(1));
            }
            sentencia.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        try {
            // TODO add your handling code here:
            Connection con= dameConexion();
            Statement sentencia = con.createStatement();
            String tipo;
            String Marca;
           
            
            String sql="UPDATE Dispositivo SET id_tipo = "+idtipo.get(jComboBoxTipo.getSelectedItem())+", id_marca = "+idmarca.get(jComboBoxMarca.getSelectedItem())+", modelo = '"+jTextFieldModelo.getText()+"',numero_serie = '"+jTextFieldSN.getText()+"',ip = '"+jTextFieldIP.getText()+"', ean13 = '"+jFormattedTextFieldean13.getText()+"', mac = '"+jTextFieldMAC.getText()+"' WHERE id_dispositivo = "+jTextFieldIdDispositivo.getText()+";";
       
            
            sentencia.executeUpdate(sql);
            sentencia.close();
        Object[] cabecera = new Object[]{"Id Dispositivo","Tipo Dispositivo","Modelo","Marca","Numero de Serie","IP","MAC","EAN13","Eliminar"};
        Object[][] datos = new Object[][]{};
        DefaultTableModel miModelo = new DefaultTableModel(datos,cabecera){
        @Override
        public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0: return Integer.class;
            case 8: return ImageIcon.class;
            default: return Object.class;
        }
        }
        };
        jTable.setModel(miModelo);
       
            Statement sentencia2=dameConexion().createStatement();
            sql="SELECT D.id_dispositivo, T.tipo, D.modelo, M.marca, D.numero_serie, D.ip, D.mac, D.ean13, T.id_tipo, M.id_marca FROM Dispositivo D, Marca M, Tipo T WHERE (D.id_tipo = T.id_tipo OR D.id_tipo IS NULL) AND (D.id_marca = M.id_marca OR D.id_marca IS NULL);";
            ResultSet resul = sentencia2.executeQuery(sql);
             Object[] resultado = {"","","","","","","","","",""};
            while(resul.next())
            {
                resultado[0]=resul.getInt(1);
                resultado[1]=resul.getString(2);
                resultado[2]=resul.getString(3);
                resultado[3]=resul.getString(4);
                resultado[4]=resul.getString(5);
                resultado[5]=resul.getString(6);
                resultado[6]=resul.getString(7);
                resultado[7]=resul.getString(8);
                resultado[8]=new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
                
                miModelo.addRow(resultado);
            }
            
            String sql2="SELECT id_marca, marca FROM Marca";
            String sql3="SELECT id_tipo, tipo FROM Tipo";
            resul = sentencia.executeQuery(sql2);
            while(resul.next())
            {
                idmarca.put(resul.getString(2),resul.getInt(1));
                jComboBoxMarca.addItem(resul.getString(2));
            }
            resul = sentencia.executeQuery(sql3);
            while(resul.next())
            {
                jComboBoxTipo.addItem(resul.getString(2));
                idtipo.put(resul.getString(2), resul.getInt(1));
            }
            sentencia.close();
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed
private String datomarca;
private String datotipo;
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        String[] seleccionado= new String[8];
        if(jTable.getSelectedColumn()==8){
           int resul = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el dispositivo de la base de datos?");
            
            if(resul==0){
               String sql="DELETE FROM Dispositivo WHERE id_dispositivo = "+jTable.getValueAt(jTable.getSelectedRow(), 0);
              
               Connection con= dameConexion();
                try {
                    Statement sentencia = con.createStatement();
                    sentencia.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{ 
        
            for(int i=0;i<8;i++)
            {
                 if (i==0){
                    seleccionado[i]= String.valueOf((int)jTable.getValueAt(jTable.getSelectedRow(), i));
                }else if(jTable.getValueAt(jTable.getSelectedRow(), i)!=null){
                    seleccionado[i]= jTable.getValueAt(jTable.getSelectedRow(), i).toString();
                }
            }
            jTextFieldIdDispositivo.setText(seleccionado[0]);
            jTextFieldModelo.setText(seleccionado[2]);


            jTextFieldSN.setText(seleccionado[4]);
            jFormattedTextFieldean13.setText(seleccionado[7]);
            jTextFieldIP.setText(seleccionado[5]);
            jTextFieldMAC.setText(seleccionado[6]);
            for(int i=0;i<jComboBoxMarca.getItemCount();i++)
            {if(jComboBoxMarca.getItemAt(i).equals(seleccionado[3])){
                jComboBoxMarca.setSelectedIndex(i);
                  datomarca= jComboBoxMarca.getItemAt(i);
            }
            }
            for(int i=0;i<jComboBoxTipo.getItemCount();i++)
            {if(jComboBoxTipo.getItemAt(i).equals(seleccionado[1])){
                jComboBoxTipo.setSelectedIndex(i);
                  datotipo= jComboBoxTipo.getItemAt(i);
            }
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        Object[] cabecera = new Object[]{"Id Dispositivo","Tipo Dispositivo","Modelo","Marca","Numero de Serie","IP","MAC","EAN13","Eliminar"};
        Object[][] datos = new Object[][]{};
        DefaultTableModel miModelo = new DefaultTableModel(datos,cabecera){
        @Override
        public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0: return Integer.class;
            case 8: return ImageIcon.class;
            default: return Object.class;
        }
        }
        };
        jTable.setModel(miModelo);
        Statement sentencia;
        try {
             sentencia = dameConexion().createStatement();
            String sql="SELECT DISTINCT D.id_dispositivo,T.tipo,D.modelo,M.marca,D.numero_serie,D.ip,D.mac,D.ean13 FROM Dispositivo D,Marca M,Tipo T WHERE D.id_tipo = T.id_tipo AND D.id_marca = M.id_marca;";
            
            ResultSet resul = sentencia.executeQuery(sql);
            Object[] resultado = {"","","","","","","","","",""};
            while(resul.next())
            {
                resultado[0]=resul.getInt(1);
                resultado[1]=resul.getString(2);
                resultado[2]=resul.getString(3);
                resultado[3]=resul.getString(4);
                resultado[4]=resul.getString(5);
                resultado[5]=resul.getString(6);
                resultado[6]=resul.getString(7);
                resultado[7]=resul.getString(8);
                resultado[8]=new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
                
                miModelo.addRow(resultado);
            }
            
            String sql2="SELECT id_marca, marca FROM Marca";
            String sql3="SELECT id_tipo, tipo FROM Tipo";
            resul = sentencia.executeQuery(sql2);
            while(resul.next())
            {
                idmarca.put(resul.getString(2),resul.getInt(1));
                jComboBoxMarca.addItem(resul.getString(2));
            }
            resul = sentencia.executeQuery(sql3);
            while(resul.next())
            {
                jComboBoxTipo.addItem(resul.getString(2));
                idtipo.put(resul.getString(2), resul.getInt(1));
            }
            sentencia.close();
            jComboBoxTipo.setSelectedIndex(0);
            jComboBoxMarca.setSelectedIndex(0);
            jTextFieldModelo.setText("");
            jTextFieldSN.setText("");
            jFormattedTextFieldean13.setText("");
            jTextFieldIdDispositivo.setText("");
            jTextFieldIP.setText("");
            jTextFieldMAC.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EliminarTipo jD1 = new EliminarTipo(this,true,idtipo);
        jD1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        EliminarMarca jD1 = new EliminarMarca(this,true,idmarca);
        jD1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AcercaDe v1 = new AcercaDe();
        v1.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextFieldSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSNActionPerformed
 private boolean validadorEan13(String doceEan)
    {
         int[] digitosEan = new int[12];
         int control=Character.getNumericValue(doceEan.charAt(12));
         for(int i =0;i<12;i++)
         {
             digitosEan[i]=Character.getNumericValue(doceEan.charAt(i));
         }
         int[] ean13 =
         {
            1, 3
         };
         int suma = 0;
         for(int i = 0; i < digitosEan.length; i++)
         {
             suma +=digitosEan[i] * ean13[i % 2];
         }
         int checksum = 10 - suma % 10;
         if(checksum == 10){
             checksum = 0;
         }
         boolean validador;
         validador = checksum == control;

         return validador;
    }
    private void jFormattedTextFieldean13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldean13KeyReleased
        // TODO add your handling code here:
       String ean13 = jFormattedTextFieldean13.getText();
        char[] cadena = ean13.toCharArray();
        String  caracter = String.valueOf(cadena[cadena.length-1]);
        String[] numeros={"1","2","3","4","5","6","7","8","9","0"};
        boolean comprobador=false;
        for(int i=0;i<numeros.length;i++)
        {
           if(caracter.equals(numeros[i]))
           {
               comprobador=true;
               i=numeros.length;
           }
        }
        if(!comprobador){
           ean13=String.valueOf(cadena);
           ean13=ean13.replaceFirst(".$", "");
        }
        if(cadena.length==13)
        {
            if(!validadorEan13(ean13)){
                JOptionPane.showMessageDialog(this,"Eso no es un ean13 correcto");
                ean13="";
            }
        }
        jFormattedTextFieldean13.setText(ean13);
    }//GEN-LAST:event_jFormattedTextFieldean13KeyReleased

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
            
                
                    javax.swing.UIManager.setLookAndFeel(new NoireLookAndFeel());
                    
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dispositivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JTextField jFormattedTextFieldean13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIP;
    private javax.swing.JLabel jLabelMAC;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelSN;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemAniadirPlanta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldIdDispositivo;
    private javax.swing.JTextField jTextFieldMAC;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldSN;
    // End of variables declaration//GEN-END:variables
}
