/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaoperativo;

//import ProyectoSO2.PantallaPaginas;
//import ProyectoSO2.PantallaProcesos;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;

/**
 *
 * @author Familia
 */


public class Interfaz extends javax.swing.JFrame {      

    // Declaraciones
    AdministraAlgoritmos adminAlgoritmo;
    ArrayList listaProceso;
    int identificaProceso=0;
    int cont=0;
    AdministraTiempo aTiempo;
    AdministraProcesos adminProc;
    AdministraMemoria adminMemo;
    //TablaPCB tablaPCB;
    PantallaProcesos tablaDeProcesos;
    PantallaPaginas tablaDePaginas;
    int numeroPagina=0;
    int contInstrSolicitadas=1;
    DisenoProceso proc=null;
    
    //Variables a usar
    Tabla tabla;
    
    
    // Leer Archivo Txt
        static String cantPagProcesos;
	static String cantProcesos;
	static String tiempoLlegadaProc1;
	static String tiempoTotalEstimProc1;
	static String estadoProc1;
	static String cantPagProc1;
        ////////////////////////////////////////////////
	static String bitResPag0Proc1;
	static String tiempoLlegadaPag0Proc1;
	static String tiempoUltAccPag0Proc1;
	static String cantAccPag0Proc1;
	static String nur1Pag0Proc1;
	static String nur2Pag0Proc1;
        ////////////////////////////////////////////////
	static String bitResPag1Proc1;
	static String tiempoLlegadaPag1Proc1;
	static String tiempoUltAccPag1Proc1;
	static String cantAccPag1Proc1;
	static String nur1Pag1Proc1;
	static String nur2Pag1Proc1;
        ////////////////////////////////////////////////
	static String bitResPag2Proc1;
	static String tiempoLlegadaPag2Proc1;
	static String tiempoUltAccPag2Proc1;
	static String cantAccPag2Proc1;
	static String nur1Pag2Proc1;
	static String nur2Pag2Proc1;
        ////////////////////////////////////////////////
	static String bitResPag3Proc1;
	static String tiempoLlegadaPag3Proc1;
	static String tiempoUltAccPag3Proc1;
	static String cantAccPag3Proc1;
	static String nur1Pag3Proc1;
	static String nur2Pag3Proc1;
        ////////////////////////////////////////////////
	static String bitResPag4Proc1;
	static String tiempoLlegadaPag4Proc1;
	static String tiempoUltAccPag4Proc1;
	static String cantAccPag4Proc1;
	static String nur1Pag4Proc1;
	static String nur2Pag4Proc1;
        ///////////////////////////////////////////////
	static String tiempoLlegadaProc2;
	static String tiempoTotalEstimProc2;
	static String estadoProc2;
	static String cantPagProc2;
        ///////////////////////////////////////////////
	static String bitResPag0Proc2;
	static String tiempoLlegadaPag0Proc2;
	static String tiempoUltAccPag0Proc2;
	static String cantAccPag0Proc2;
	static String nur1Pag0Proc2;
	static String nur2Pag0Proc2;
	static String bitResPag1Proc2;
	static String tiempoLlegadaPag1Proc2;
	static String tiempoUltAccPag1Proc2;
	static String cantAccPag1Proc2;
	static String nur1Pag1Proc2;
	static String nur2Pag1Proc2;
	static String bitResPag2Proc2;
	static String tiempoLlegadaPag2Proc2;
	static String tiempoUltAccPag2Proc2;
	static String cantAccPag2Proc2;
	static String nur1Pag2Proc2;
	static String nur2Pag2Proc2;
	static String bitResPag3Proc2;
	static String tiempoLlegadaPag3Proc2;
	static String tiempoUltAccPag3Proc2;
	static String cantAccPag3Proc2;
	static String nur1Pag3Proc2;
	static String nur2Pag3Proc2;
	static String tiempoLlegadaProc3;
	static String tiempoTotalEstimProc3;
	static String estadoProc3;
	static String cantPagProc3;
	static String bitResPag0Proc3;
	static String tiempoLlegadaPag0Proc3;
	static String tiempoUltAccPag0Proc3;
	static String cantAccPag0Proc3;
	static String nur1Pag0Proc3;
	static String nur2Pag0Proc3;
	static String bitResPag1Proc3;
	static String tiempoLlegadaPag1Proc3;
	static String tiempoUltAccPag1Proc3;
	static String cantAccPag1Proc3;
	static String nur1Pag1Proc3;
	static String nur2Pag1Proc3;
	static String bitResPag2Proc3;
	static String tiempoLlegadaPag2Proc3;
	static String tiempoUltAccPag2Proc3;
	static String cantAccPag2Proc3;
	static String nur1Pag2Proc3;
	static String nur2Pag2Proc3;
	static String bitResPag3Proc3;
	static String tiempoLlegadaPag3Proc3;
	static String tiempoUltAccPag3Proc3;
	static String cantAccPag3Proc3;
	static String nur1Pag3Proc3;
	static String nur2Pag3Proc3;
    
    //Atributos PantallaInicial
    
        
        
    public int TActual;
    public int valorSpinner;
    //public int cpuRestante;
    int cpuAsignado=0;
    
    public Interfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelTiempoActual = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelLlegada = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCpuAsignado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelEnvejecimiento = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelCpuRestante = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelQuantumRestante = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btn_PanelProcesador = new javax.swing.JButton();
        cbx_scheduling = new javax.swing.JComboBox<>();
        cbx_replacement = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jSpinnerQuantum = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jButton6 = new javax.swing.JButton();
        jButtonFIFO = new javax.swing.JButton();
        jButtonLRU = new javax.swing.JButton();
        jButtonLFU = new javax.swing.JButton();
        jButtonNUR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Tiempo Actual:");

        jLabelTiempoActual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTiempoActual.setText("0");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Proceso Actual");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Llegada:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("CPU Asignado:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Envejecimiento:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("CPU Restante:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Quantum Restante:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Página a Ejecutar:");

        jSpinner1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Ejecutar Página");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelCpuAsignado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelEnvejecimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelCpuRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelQuantumRestante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelLlegada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelCpuAsignado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelEnvejecimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabelCpuRestante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabelQuantumRestante))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Cargar Archivo .txt");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTableDatos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pagina", "R", "Llegada", "Ultimo Acceso", "Accesos", "NUR 1", "NUR 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDatos);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Solicitud de Interrupción");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SVC Terminación Normal", "SVC Terminaciòn Anormal", "SVC Solicitud de I/O", "SVC Solicitud de Recurso", "Fallo de Programa", "Externa de Quantum Expirado", "Dispositivo de I/O" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("Interrumpir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton3)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Memoria");

        btn_PanelProcesador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_PanelProcesador.setText("Reseteo de Bits NUR");
        btn_PanelProcesador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PanelProcesadorActionPerformed(evt);
            }
        });

        cbx_scheduling.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbx_scheduling.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIFO", "RR", "SJF", "SRT", "HRRN", " " }));
        cbx_scheduling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_schedulingActionPerformed(evt);
            }
        });

        cbx_replacement.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbx_replacement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIFO", "LRU", "LFU", "NRU", "2dC" }));
        cbx_replacement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_replacementActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Algoritmo de Scheduling:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Algoritmo de Reemplazo:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_replacement, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_scheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btn_PanelProcesador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbx_scheduling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_replacement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(32, 32, 32)
                .addComponent(btn_PanelProcesador)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("CPU");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Round Robin", "FIFO", "SJF", "SRT", "HRRN" }));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Tamaño de Quantum:");

        jSpinnerQuantum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSpinnerQuantum.setModel(new javax.swing.SpinnerNumberModel(5, 1, 100, 1));
        jSpinnerQuantum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinnerQuantumMouseClicked(evt);
            }
        });

        jButton4.setText("Actualizar Quantum");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addGap(18, 18, 18)
                            .addComponent(jSpinnerQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jSpinnerQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Nuevo Proceso");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Nombre:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("1");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Páginas:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Ejecución Total:");

        jButton6.setText("Crear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel23))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonFIFO.setText("FIFO");
        jButtonFIFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFIFOActionPerformed(evt);
            }
        });

        jButtonLRU.setText("LRU");

        jButtonLFU.setText("LFU");

        jButtonNUR.setText("NUR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonFIFO)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonLRU)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonLFU)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonNUR))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTiempoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelTiempoActual)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFIFO)
                            .addComponent(jButtonLRU)
                            .addComponent(jButtonLFU)
                            .addComponent(jButtonNUR)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*if(seleccionado.showDialog(null, "ABRIR ARCHIVO") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    String contenido = archivo1.AbrirATexto(archivo);
                    //txtAreaTexto.setText(contenido);
                }else{
                    
                        JOptionPane.showMessageDialog(null, "Por favor seleccione un archivo de texto.");
                    
                }
            }
        }
        */
        
    //Proceso Actual
    
        
        jLabelNombre.setText("Proceso 1");
        jLabelLlegada.setText(tiempoLlegadaProc1);
        jLabelCpuAsignado.setText("0");
        jLabelEnvejecimiento.setText("0");
        jLabelCpuRestante.setText(tiempoTotalEstimProc1);
        
        
        
       /* int QntmRes;
        final JSpinner valorspin = new JSpinner(); 
        JComponent comp = spinner.getEditor(); 
        JFormattedTextField field = (JFormattedTextField) comp.getComponent(0); 
        DefaultFormatter formatter = (DefaultFormatter) field.getFormatter(); 
        formatter.setCommitsOnValidEdit(true); 
        @Override 
        public void stateChanged(ChangeEvent e) { 
        LOG.info("value changed: " + valorspin.getValue()); }
        */
       
       
        
        
        
        
        /*SpinnerNumberModel spin = new SpinnerNumberModel();
        JSpinner spinner = new JSpinner(spin); 
        jLabelQuantumRestante.setText(((SpinnerNumberModel)spinner.getModel()).getNumber().toString());
        jLabelQuantumRestante=jSpinnerQuantum;*/
        
        
        
        
    int contPag=0;    
    DefaultTableModel model=(DefaultTableModel) jTableDatos.getModel();
    model.addRow(new Object[]{contPag,bitResPag0Proc1,tiempoLlegadaPag0Proc1,tiempoUltAccPag0Proc1,cantAccPag0Proc1,nur1Pag0Proc1,nur2Pag0Proc1});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag1Proc1,tiempoLlegadaPag1Proc1,tiempoUltAccPag1Proc1,cantAccPag1Proc1,nur1Pag1Proc1,nur2Pag1Proc1});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag2Proc1,tiempoLlegadaPag2Proc1,tiempoUltAccPag2Proc1,cantAccPag2Proc1,nur1Pag2Proc1,nur2Pag2Proc1});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag3Proc1,tiempoLlegadaPag3Proc1,tiempoUltAccPag3Proc1,cantAccPag3Proc1,nur1Pag3Proc1,nur2Pag3Proc1});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag4Proc1,tiempoLlegadaPag4Proc1,tiempoUltAccPag4Proc1,cantAccPag4Proc1,nur1Pag4Proc1,nur2Pag4Proc1});
    contPag++;
    
    
    //Tiempo Actual
    int tiempo0 = Integer.parseInt(tiempoUltAccPag0Proc1);
    int tiempo1 = Integer.parseInt(tiempoUltAccPag1Proc1);
    int tiempo2 = Integer.parseInt(tiempoUltAccPag2Proc1);
    int tiempo3 = Integer.parseInt(tiempoUltAccPag3Proc1);
    int tiempo4 = Integer.parseInt(tiempoUltAccPag4Proc1);
    
      
    if((tiempo0>tiempo1)&&(tiempo0>tiempo2)&&(tiempo0>tiempo3)&&(tiempo0>tiempo4)){
        TActual=tiempo0;}
    
    if((tiempo1>tiempo0)&&(tiempo1>tiempo2)&&(tiempo1>tiempo3)&&(tiempo1>tiempo4)){
        TActual=tiempo1;}
    
    if((tiempo2>tiempo0)&&(tiempo2>tiempo1)&&(tiempo2>tiempo3)&&(tiempo2>tiempo4)){
        TActual=tiempo2;}
    
    if((tiempo3>tiempo4)&&(tiempo3>tiempo2)&&(tiempo3>tiempo1)&&(tiempo3>tiempo0)){
        TActual=tiempo3;}
    
    if((tiempo4>tiempo0)&&(tiempo4>tiempo1)&&(tiempo4>tiempo2)&&(tiempo4>tiempo3)){
        TActual=tiempo4;}
    
    
    /*if(tiempo1>tiempo0 && tiempo1>tiempo2 &&tiempo1>tiempo3 && tiempo1>tiempo3 && tiempo1>tiempo4){    
    TActual=tiempo1;
    }*/
    
    String TiempoActual = String.valueOf(TActual); 
    jLabelTiempoActual.setText(TiempoActual);
  
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        btn_PanelProcesador = new javax.swing.JButton();
    }//GEN-LAST:event_jButton2MouseClicked

    private void cbx_schedulingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_schedulingActionPerformed
        cbx_scheduling = new javax.swing.JComboBox();
    }//GEN-LAST:event_cbx_schedulingActionPerformed

    private void cbx_replacementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_replacementActionPerformed
        cbx_replacement = new javax.swing.JComboBox();
    }//GEN-LAST:event_cbx_replacementActionPerformed

    private void btn_PanelProcesadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PanelProcesadorActionPerformed
        btn_PanelProcesador = new javax.swing.JButton();
        
        /*if(cbx_scheduling.equals("FIFO")&&cbx_replacement.equals("LRU")){
            
        }*/
        int nur1Pag0Proc1=0;
        int nur2Pag0Proc1=0;
        
        int contPag=0;    
        DefaultTableModel model=(DefaultTableModel) jTableDatos.getModel();
        int reemplazo=0;
        model.setValueAt(reemplazo, 0, 5);
        model.setValueAt(reemplazo, 0, 6);
        
        model.setValueAt(reemplazo, 1, 5);
        model.setValueAt(reemplazo, 1, 6);
        
        model.setValueAt(reemplazo, 2, 5);
        model.setValueAt(reemplazo, 2, 6);
        
        model.setValueAt(reemplazo, 3, 5);
        model.setValueAt(reemplazo, 3, 6);
        
        model.setValueAt(reemplazo, 4, 5);
        model.setValueAt(reemplazo, 4, 6);
        contPag++;
        
        
        
    }//GEN-LAST:event_btn_PanelProcesadorActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:   
    TActual++;
    String TiempoActual = String.valueOf(TActual); 
    jLabelTiempoActual.setText(TiempoActual);   
    
    //Cpu Asignado
    cpuAsignado++;
    String cpuAsig = String.valueOf(cpuAsignado); 
    jLabelCpuAsignado.setText(cpuAsig);
    
    //Cpu Restante
    int cpuRestante = Integer.parseInt(tiempoTotalEstimProc1);
    int valRes=cpuRestante-cpuAsignado;

    String cpuRes = String.valueOf(valRes); 
    jLabelCpuRestante.setText(cpuRes);   
    
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButtonFIFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFIFOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFIFOActionPerformed

    private void jSpinnerQuantumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerQuantumMouseClicked
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_jSpinnerQuantumMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int valorSpinner=(Integer)(jSpinnerQuantum.getValue());
        String valSpin = String.valueOf(valorSpinner);
        jLabelQuantumRestante.setText(valSpin); 
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException{
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
        
        //PantallaPaginas pantallaPaginas=new PantallaPaginas();
        //PantallaProcesos pantallaProcesos=new PantallaProcesos();
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
        
        
        
        
    	
    	ArrayList <String> ls = new ArrayList<String>();
    	    	
    	String cadena;
      	String archivo = "C:/ArchivoEntradaSO.txt";
     	FileReader f = new FileReader(archivo);
      	BufferedReader b = new BufferedReader(f);
      	while((cadena = b.readLine())!=null) {
          	ls.add( cadena );
      	}      	
      	b.close();
      	
      	String var = "";
      	for (int i = 0; i <= ls.size() - 1; i++) {
            //System.out.println(ls.get(i));
            var = var + ls.get(i).trim()+ " ";
        }
      	//JOptionPane.showMessageDialog(null, var);
      	
      	//System.out.print("\n\n Variables "+ var);
      	
      	String var2 []= var.trim().split(",");
      	for(int i = 0; i < var2.length; i++){
      		//System.out.print("\n"+var2[i].trim());
      		
      		switch (i){
      		case 0: cantPagProcesos 	  	= var2[0].trim(); // L�nea 0
      		case 1: cantProcesos 			= var2[1].trim(); // L�nea 1
      		case 2: tiempoLlegadaProc1 		= var2[2].trim(); // L�nea 2
      		case 3: tiempoTotalEstimProc1 	= var2[3].trim(); // L�nea 2
      		case 4: estadoProc1 			= var2[4].trim(); // L�nea 2
      		case 5: cantPagProc1 			= var2[5].trim(); // L�nea 3
      		case 6: bitResPag0Proc1 		= var2[6].trim(); // L�nea 4
      		case 7: tiempoLlegadaPag0Proc1 	= var2[7].trim(); // L�nea 4
      		case 8: tiempoUltAccPag0Proc1 	= var2[8].trim(); // L�nea 4
      		case 9: cantAccPag0Proc1 		= var2[9].trim(); // L�nea 4
      		case 10: nur1Pag0Proc1 			= var2[10].trim(); // L�nea 4
      		case 11: nur2Pag0Proc1 			= var2[11].trim(); // L�nea 4
      		case 12: bitResPag1Proc1 		= var2[12].trim(); // L�nea 5
      		case 13: tiempoLlegadaPag1Proc1 = var2[13].trim(); // L�nea 5
      		case 14: tiempoUltAccPag1Proc1 	= var2[14].trim(); // L�nea 5
      		case 15: cantAccPag1Proc1 		= var2[15].trim(); // L�nea 5
      		case 16: nur1Pag1Proc1 			= var2[16].trim(); // L�nea 5
      		case 17: nur2Pag1Proc1 			= var2[17].trim(); // L�nea 5
      		case 18: bitResPag2Proc1 		= var2[18].trim(); // L�nea 6
      		case 19: tiempoLlegadaPag2Proc1 = var2[19].trim(); // L�nea 6
      		case 20: tiempoUltAccPag2Proc1 	= var2[20].trim(); // L�nea 6
      		case 21: cantAccPag2Proc1 		= var2[21].trim(); // L�nea 6
      		case 22: nur1Pag2Proc1 			= var2[22].trim(); // L�nea 6
      		case 23: nur2Pag2Proc1 			= var2[23].trim(); // L�nea 6
      		case 24: bitResPag3Proc1 		= var2[24].trim(); // L�nea 7
      		case 25: tiempoLlegadaPag3Proc1 = var2[25].trim(); // L�nea 7
      		case 26: tiempoUltAccPag3Proc1 	= var2[26].trim(); // L�nea 7
      		case 27: cantAccPag3Proc1 		= var2[27].trim(); // L�nea 7
      		case 28: nur1Pag3Proc1 			= var2[28].trim(); // L�nea 7
      		case 29: nur2Pag3Proc1 			= var2[29].trim(); // L�nea 7
      		case 30: bitResPag4Proc1 		= var2[30].trim(); // L�nea 8 
      		case 31: tiempoLlegadaPag4Proc1 = var2[31].trim(); // L�nea 8
      		case 32: tiempoUltAccPag4Proc1 	= var2[32].trim(); // L�nea 8
      		case 33: cantAccPag4Proc1 		= var2[33].trim(); // L�nea 8
      		case 34: nur1Pag4Proc1 			= var2[34].trim(); // L�nea 8
      		case 35: nur2Pag4Proc1 			= var2[35].trim(); // L�nea 8
      		case 36: tiempoLlegadaProc2 	= var2[36].trim(); // L�nea 9
      		case 37: tiempoTotalEstimProc2 	= var2[37].trim(); // L�nea 9
      		case 38: estadoProc2 			= var2[38].trim(); // L�nea 9
      		case 39: cantPagProc2 			= var2[39].trim(); // L�nea 10
      		case 40: bitResPag0Proc2 		= var2[40].trim(); // L�nea 11
      		case 41: tiempoLlegadaPag0Proc2 = var2[41].trim(); // L�nea 11
      		case 42: tiempoUltAccPag0Proc2 	= var2[42].trim(); // L�nea 11
      		case 43: cantAccPag0Proc2 		= var2[43].trim(); // L�nea 11
      		case 44: nur1Pag0Proc2 			= var2[44].trim(); // L�nea 11
      		case 45: nur2Pag0Proc2 			= var2[45].trim(); // L�nea 11
      		case 46: bitResPag1Proc2 		= var2[46].trim(); // L�nea 12 
      		case 47: tiempoLlegadaPag1Proc2 = var2[47].trim(); // L�nea 12
      		case 48: tiempoUltAccPag1Proc2 	= var2[48].trim(); // L�nea 12
      		case 49: cantAccPag1Proc2 		= var2[49].trim(); // L�nea 12
      		case 50: nur1Pag1Proc2 			= var2[50].trim(); // L�nea 12
      		case 51: nur2Pag1Proc2 			= var2[51].trim(); // L�nea 12
      		case 52: bitResPag2Proc2 		= var2[52].trim(); // L�nea 13
      		case 53: tiempoLlegadaPag2Proc2 = var2[53].trim(); // L�nea 13
      		case 54: tiempoUltAccPag2Proc2 	= var2[54].trim(); // L�nea 13
      		case 55: cantAccPag2Proc2 		= var2[55].trim(); // L�nea 13
      		case 56: nur1Pag2Proc2 			= var2[56].trim(); // L�nea 13
      		case 57: nur2Pag2Proc2 			= var2[57].trim(); // L�nea 13
      		case 58: bitResPag3Proc2 		= var2[58].trim(); // L�nea 14
      		case 59: tiempoLlegadaPag3Proc2 = var2[59].trim(); // L�nea 14
      		case 60: tiempoUltAccPag3Proc2 	= var2[60].trim(); // L�nea 14
      		case 61: cantAccPag3Proc2 		= var2[61].trim(); // L�nea 14
      		case 62: nur1Pag3Proc2 			= var2[62].trim(); // L�nea 14
      		case 63: nur2Pag3Proc2 			= var2[63].trim(); // L�nea 14
      		case 64: tiempoLlegadaProc3 	= var2[64].trim(); // L�nea 15
      		case 65: tiempoTotalEstimProc3 	= var2[65].trim(); // L�nea 15
      		case 66: estadoProc3 			= var2[66].trim(); // L�nea 15
      		case 67: cantPagProc3 			= var2[67].trim(); // L�nea 16
      		case 68: bitResPag0Proc3 		= var2[68].trim(); // L�nea 17
      		case 69: tiempoLlegadaPag0Proc3 = var2[69].trim(); // L�nea 17
      		case 70: tiempoUltAccPag0Proc3 	= var2[70].trim(); // L�nea 17
      		case 71: cantAccPag0Proc3 		= var2[71].trim(); // L�nea 17
      		case 72: nur1Pag0Proc3 			= var2[72].trim(); // L�nea 17 
      		case 73: nur2Pag0Proc3 			= var2[73].trim(); // L�nea 17
      		case 74: bitResPag1Proc3 		= var2[74].trim(); // L�nea 18
      		case 75: tiempoLlegadaPag1Proc3 = var2[75].trim(); // L�nea 18
      		case 76: tiempoUltAccPag1Proc3 	= var2[76].trim(); // L�nea 18
      		case 77: cantAccPag1Proc3 		= var2[77].trim(); // L�nea 18
      		case 78: nur1Pag1Proc3 			= var2[78].trim(); // L�nea 18
      		case 79: nur2Pag1Proc3 			= var2[79].trim(); // L�nea 18
      		case 80: bitResPag2Proc3 		= var2[80].trim(); // L�nea 19
      		case 81: tiempoLlegadaPag2Proc3 = var2[81].trim(); // L�nea 19
      		case 82: tiempoUltAccPag2Proc3 	= var2[82].trim(); // L�nea 19
      		case 83: cantAccPag2Proc3 		= var2[83].trim(); // L�nea 19
      		case 84: nur1Pag2Proc3 			= var2[84].trim(); // L�nea 19
      		case 85: nur2Pag2Proc3 			= var2[85].trim(); // L�nea 19
      		case 86: bitResPag3Proc3 		= var2[86].trim(); // L�nea 20 
      		case 87: tiempoLlegadaPag3Proc3 = var2[87].trim(); // L�nea 20
      		case 88: tiempoUltAccPag3Proc3 	= var2[88].trim(); // L�nea 20
      		case 89: cantAccPag3Proc3 		= var2[89].trim(); // L�nea 20
      		case 90: nur1Pag3Proc3 			= var2[90].trim(); // L�nea 20
      		case 91: nur2Pag3Proc3 			= var2[91].trim(); // L�nea 20
      		} // Fin del Switch 	
      	} // Fin del For      	

      	//System.out.print("\nCantidad de Procesos: "+cantProcesos + "\nEdo proceso 2: "+estadoProc2); 
        
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_PanelProcesador;
    private javax.swing.JComboBox<String> cbx_replacement;
    private javax.swing.JComboBox<String> cbx_scheduling;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonFIFO;
    private javax.swing.JButton jButtonLFU;
    private javax.swing.JButton jButtonLRU;
    private javax.swing.JButton jButtonNUR;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCpuAsignado;
    private javax.swing.JLabel jLabelCpuRestante;
    private javax.swing.JLabel jLabelEnvejecimiento;
    private javax.swing.JLabel jLabelLlegada;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelQuantumRestante;
    private javax.swing.JLabel jLabelTiempoActual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinnerQuantum;
    private javax.swing.JTable jTableDatos;
    // End of variables declaration//GEN-END:variables
}
