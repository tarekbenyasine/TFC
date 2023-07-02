package tfc;

import com.jtattoo.plaf.noire.NoireLookAndFeel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;



/**
 *
 * @author Tarek
 */
public class Usuarios extends javax.swing.JFrame {

    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setResizable(true);
        Object[] cabecera = new Object[]{"Usuario","Nombre","Primer Apellido","Segundo Apellido","Id Puesto","Planta","Eliminar","Codigo"};
        Object[][] datos = new Object[][]{};
        DefaultTableModel miModelo = new DefaultTableModel(datos,cabecera){
        @Override
        public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 4,5,7: return Integer.class;
            case 6: return ImageIcon.class;
            default: return Object.class;
        }
        }
        };
        jTable.setModel(miModelo);
        try {
            Statement sentencia = dameConexion().createStatement();
            String sql="SELECT U.usuario, U.nombre, U.apellido1, U.apellido2, P.id_puesto, P.planta, U.id_usuario FROM Usuario U LEFT JOIN Usuario_Puesto UP ON U.id_usuario = UP.id_usuario LEFT JOIN Puesto P ON UP.id_puesto = P.id_puesto;";
            ResultSet resul = sentencia.executeQuery(sql);
            Object[] resultado = {"","","","","","","",""};
            while(resul.next())
            {
                resultado[0]=resul.getString(1);
                resultado[1]=resul.getString(2);
                resultado[2]=resul.getString(3);
                resultado[3]=resul.getString(4);
                resultado[4]=resul.getInt(5);
                resultado[5]=resul.getInt(6);
                resultado[6] = new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
                resultado[7]=resul.getInt(7);
                miModelo.addRow(resultado);
            }
        } catch (SQLException ex) {
            log.severe("Ocurrió un error: " + ex.getMessage());
        }catch(Exception e){
            log.severe("Ocurrió un error: " + e.getMessage());
        }
       TableColumnModel columna;
        columna=jTable.getColumnModel();
        columna.getColumn(7).setMinWidth(0);
        columna.getColumn(7).setMaxWidth(0);
        columna.getColumn(7).setWidth(0);
        columna.getColumn(7).setPreferredWidth(0);
    }
    private FileHandler fileHandler;
    private ConsoleHandler cons;
    private Logger log = Logger.getLogger("controlador");
    private void logs(){
    try {
            cons = new ConsoleHandler();
            log.addHandler(cons);
            fileHandler = new FileHandler("Logs/errorres.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
            log.severe("Ocurrió un error: " + e.getMessage());
        }
    }
    private Connection dameConexion(){
        Connection con = null;
        String baseDatos = "jdbc:sqlite:"+System.getProperty("user.dir")+"\\BBDD\\BBDD.db";
        try {
            con= DriverManager.getConnection(baseDatos);
        } catch (SQLException ex) {
            log.severe("Ocurrió un error: " + ex.getMessage());
        }catch(Exception e){
            log.severe("Ocurrió un error: " + e.getMessage());
        }
        return con;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellid2 = new javax.swing.JTextField();
        jTextFieldApellido1 = new javax.swing.JTextField();
        jTextFieldPlanta = new javax.swing.JTextField();
        jTextFieldPuesto = new javax.swing.JTextField();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonFiltrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

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
        jScrollPane2.setViewportView(jTable);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar/Modificar"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Apellido1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Apellido2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 7, 0, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Puesto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 8, 0, 0);
        jPanel2.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Planta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 22, 0, 0);
        jPanel2.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 18, 0, 0);
        jPanel2.add(jTextFieldUsuario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel2.add(jTextFieldNombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(46, 18, 85, 0);
        jPanel2.add(jTextFieldApellid2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 55);
        jPanel2.add(jTextFieldApellido1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(46, 6, 85, 0);
        jPanel2.add(jTextFieldPlanta, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(46, 6, 85, 55);
        jPanel2.add(jTextFieldPuesto, gridBagConstraints);

        jButtonLimpiar.setText("Limpiar tabla/busqueda");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 8, 6);
        jPanel2.add(jButtonLimpiar, gridBagConstraints);

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 8, 0);
        jPanel2.add(jButtonFiltrar, gridBagConstraints);

        jButtonModificar.setText("Modificar Usuario");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 6);
        jPanel2.add(jButtonModificar, gridBagConstraints);

        jButton1.setText("Eliminar Puesto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel2.add(jButton1, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
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
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Usuarios v1 = new Usuarios();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Dispositivos v1 = new Dispositivos();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItemAniadirPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAniadirPlantaActionPerformed
        // TODO add your handling code here:
        Aniadir v1 = new Aniadir();
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemAniadirPlantaActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
         jButtonLimpiar.setVisible(true);
         Object[] cabecera = new Object[]{"Usuario","Nombre","Primer Apellido","Segundo Apellido","Id Puesto","Planta","Codigo"};
        Object[][] datos = new Object[][]{};
        DefaultTableModel miModelo = new DefaultTableModel(datos,cabecera){
        @Override
        public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 4,5,6: return Integer.class;
            default: return Object.class;
        }
        }
        };
        jTable.setModel(miModelo);
        try {
            Statement sentencia = dameConexion().createStatement();
            String sql="SELECT U.usuario, U.nombre, U.apellido1, U.apellido2, P.id_puesto, P.planta, U.id_usuario FROM Usuario U LEFT JOIN Usuario_Puesto UP ON U.id_usuario = UP.id_usuario LEFT JOIN Puesto P ON UP.id_puesto = P.id_puesto ";
            if(!jTextFieldUsuario.getText().isEmpty()|| !jTextFieldNombre.getText().isEmpty()||!jTextFieldApellid2.getText().isEmpty()||!jTextFieldPlanta.getText().isEmpty()||!jTextFieldPuesto.getText().isEmpty()){
               sql=sql+" WHERE 1=1 ";
                if(!jTextFieldUsuario.getText().isEmpty()){
                    sql=sql+"AND U.usuario LIKE '%"+jTextFieldUsuario.getText()+"%'";
                }
                if(!jTextFieldNombre.getText().isEmpty()){
                    sql=sql+"AND U.nombre LIKE '%"+jTextFieldNombre.getText()+"%'";
                }
                if(!jTextFieldApellido1.getText().isEmpty()){
                    sql=sql+"AND U.apellido1 LIKE '%"+jTextFieldApellido1.getText()+"%'";
                }
                if(!jTextFieldApellid2.getText().isEmpty()){
                    sql=sql+"AND U.apellido2 LIKE '%"+jTextFieldApellid2.getText()+"%'";
                }
                if(!jTextFieldPlanta.getText().isEmpty()){
                    sql=sql+"AND P.planta LIKE '%"+jTextFieldPlanta.getText()+"%'";
                }
                if(!jTextFieldPuesto.getText().isEmpty()){
                    sql=sql+"AND P.id_puesto LIKE '%"+jTextFieldPuesto.getText()+"%'";
                }
            }
            ResultSet resul = sentencia.executeQuery(sql);
            Object[] resultado = {"","","","","","",""};
            while(resul.next())
            {
                resultado[0]=resul.getString(1);
                resultado[1]=resul.getString(2);
                resultado[2]=resul.getString(3);
                resultado[3]=resul.getString(4);
                resultado[4]=resul.getInt(5);
                resultado[5]=resul.getInt(6);
                resultado[6]=resul.getInt(7);
                miModelo.addRow(resultado);
            }
            TableColumnModel columna;
        columna=jTable.getColumnModel();
        columna.getColumn(6).setMinWidth(0);
        columna.getColumn(6).setMaxWidth(0);
        columna.getColumn(6).setWidth(0);
        columna.getColumn(6).setPreferredWidth(0);
            
            
        } catch (SQLException ex) {
           log.severe("Ocurrió un error: " + ex.getMessage());
        }catch(Exception e){
            log.severe("Ocurrió un error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        jTextFieldUsuario.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellido1.setText("");
        jTextFieldApellid2.setText("");
        jTextFieldPlanta.setText("");
        jTextFieldPuesto.setText("");
                
        Object[] cabecera = new Object[]{"Usuario","Nombre","Primer Apellido","Segundo Apellido","Id Puesto","Planta","Eliminar","Codigo"};
        Object[][] datos = new Object[][]{};
        DefaultTableModel miModelo = new DefaultTableModel(datos,cabecera){
        @Override
        public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 4,5,7: return Integer.class;
            case 6: return ImageIcon.class;
            default: return Object.class;
        }
        }
        };
        jTable.setModel(miModelo);
        try {
            Statement sentencia = dameConexion().createStatement();
            String sql="SELECT U.usuario, U.nombre, U.apellido1, U.apellido2, P.id_puesto, P.planta, U.id_usuario FROM Usuario U LEFT JOIN Usuario_Puesto UP ON U.id_usuario = UP.id_usuario LEFT JOIN Puesto P ON UP.id_puesto = P.id_puesto;";
            ResultSet resul = sentencia.executeQuery(sql);
            Object[] resultado = {"","","","","","","",""};
            while(resul.next())
            {
                resultado[0]=resul.getString(1);
                resultado[1]=resul.getString(2);
                resultado[2]=resul.getString(3);
                resultado[3]=resul.getString(4);
                resultado[4]=resul.getInt(5);
                resultado[5]=resul.getInt(6);
                resultado[6] = new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
                resultado[7]=resul.getInt(7);
                miModelo.addRow(resultado);
            }

            TableColumnModel columna;
        columna=jTable.getColumnModel();
        columna.getColumn(7).setMinWidth(0);
        columna.getColumn(7).setMaxWidth(0);
        columna.getColumn(7).setWidth(0);
        columna.getColumn(7).setPreferredWidth(0);
        } catch (SQLException ex) {
            log.severe("Ocurrió un error: " + ex.getMessage());
        }catch(Exception e){
            log.severe("Ocurrió un error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonLimpiarActionPerformed
private int idUsuario;
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
       
        String[] seleccionado= new String[8];
        if(jTable.getSelectedColumn()==6){
            int resul = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el cliente de la base de datos?");
            System.out.println(resul);
            if(resul==0){
               String sql="DELETE FROM Usuario WHERE id_usuario = "+jTable.getValueAt(jTable.getSelectedRow(), 7);
              
               Connection con= dameConexion();
                try {
                    Statement sentencia = con.createStatement();
                    sentencia.executeUpdate(sql);
                } catch (SQLException ex) {
                    log.severe("Ocurrió un error: " + ex.getMessage());
        }catch(Exception e){
            log.severe("Ocurrió un error: " + e.getMessage());
        }
            }
        }else{
            for(int i=0;i<8;i++)
            {
                 if (i>4&&i<6){
                     if(jTable.getValueAt(jTable.getSelectedRow(), i)!=null){


                    seleccionado[i]= String.valueOf((int)jTable.getValueAt(jTable.getSelectedRow(), i));
                    }
                }else if(jTable.getValueAt(jTable.getSelectedRow(), i)!=null){
                    seleccionado[i]= jTable.getValueAt(jTable.getSelectedRow(), i).toString();
                }
            }


            jTextFieldUsuario.setText(seleccionado[0]);
            jTextFieldNombre.setText(seleccionado[1]);
            jTextFieldApellido1.setText(seleccionado[2]);
            jTextFieldApellid2.setText(seleccionado[3]);
            jTextFieldPuesto.setText(seleccionado[4]);
            jTextFieldPlanta.setText(seleccionado[5]);
            idUsuario=Integer.valueOf(seleccionado[7]);
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        try {
            
            Connection con= dameConexion();
            Statement sentencia = con.createStatement();
            
            String sql="UPDATE Usuario SET usuario = '"+jTextFieldUsuario.getText()+"',nombre = '"+jTextFieldNombre.getText()+"',apellido1 = '"+jTextFieldApellido1.getText()+"',apellido2 ='"+jTextFieldApellid2.getText()+"'  WHERE id_usuario = "+idUsuario;
          
            sentencia.executeUpdate(sql);
           if(!jTextFieldPuesto.getText().equals("0")){
           String sql2="UPDATE Usuario_Puesto SET id_usuario = "+idUsuario+" WHERE id_puesto = "+ jTextFieldPuesto.getText();
           
           sentencia.executeUpdate(sql2);
           sql2="UPDATE Puesto SET planta = "+jTextFieldPlanta.getText()+" WHERE id_puesto = "+jTextFieldPuesto.getText();
           sentencia.executeUpdate(sql2);
           }
           
            
        } catch (SQLException ex) {
            log.severe("Ocurrió un error: " + ex.getMessage());
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            log.severe("Ocurrió un error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        AcercaDe v1 = new AcercaDe();
        v1.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        EliminarPuesto jD1 = new EliminarPuesto(this,true);
        jD1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldApellid2;
    private javax.swing.JTextField jTextFieldApellido1;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPlanta;
    private javax.swing.JTextField jTextFieldPuesto;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
