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
import javax.swing.JOptionPane;
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
    public int Acc;
    public int envejecimiento;
    public int llegadaProc2;
    public int cpurestante;
    
    public int valorSpinner;
    public int temporalLlegada;
    public int temporalUltAcc;
    
    //public int cpuRestante;
    int cpuAsignado=0;
    int totalQuantum=0;
    static String totQuantum;
    
    int pagEjecRR;
    int pagEjecFifo;
    int pagEjecSrt;
    int pagEjecSjf;
    int pagEjecHrrn;
    
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

        grupoMemoria = new javax.swing.ButtonGroup();
        grupoCpu = new javax.swing.ButtonGroup();
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
        jSpinnerPaginaEjecutar = new javax.swing.JSpinner();
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
        ReseteoBits = new javax.swing.JButton();
        MemoriaFifo = new javax.swing.JRadioButton();
        MemoriaLru = new javax.swing.JRadioButton();
        MemoriaLfu = new javax.swing.JRadioButton();
        MemoriaNur = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSpinnerQuantum = new javax.swing.JSpinner();
        CpuRR = new javax.swing.JRadioButton();
        CpuFifo = new javax.swing.JRadioButton();
        CpuSrt = new javax.swing.JRadioButton();
        CpuSjf = new javax.swing.JRadioButton();
        CpuHrrn = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabelNPNombre = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSpinnerPaginas = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        jSpinnerTotalEjec = new javax.swing.JSpinner();
        jButton6 = new javax.swing.JButton();

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

        jSpinnerPaginaEjecutar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSpinnerPaginaEjecutar.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));
        jSpinnerPaginaEjecutar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPaginaEjecutarStateChanged(evt);
            }
        });

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
                                .addComponent(jSpinnerPaginaEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jSpinnerPaginaEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Memoria");

        ReseteoBits.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ReseteoBits.setText("Reseteo de Bits NUR");
        ReseteoBits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReseteoBitsActionPerformed(evt);
            }
        });

        grupoMemoria.add(MemoriaFifo);
        MemoriaFifo.setText("FIFO");
        MemoriaFifo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemoriaFifoActionPerformed(evt);
            }
        });

        grupoMemoria.add(MemoriaLru);
        MemoriaLru.setText("LRU");

        grupoMemoria.add(MemoriaLfu);
        MemoriaLfu.setText("LFU");

        grupoMemoria.add(MemoriaNur);
        MemoriaNur.setText("NUR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReseteoBits)
                    .addComponent(MemoriaNur)
                    .addComponent(MemoriaLfu)
                    .addComponent(MemoriaLru)
                    .addComponent(MemoriaFifo)
                    .addComponent(jLabel19))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MemoriaFifo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MemoriaLru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MemoriaLfu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MemoriaNur)
                .addGap(18, 18, 18)
                .addComponent(ReseteoBits)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("CPU");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Tamaño de Quantum:");

        jSpinnerQuantum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jSpinnerQuantum.setModel(new javax.swing.SpinnerNumberModel(5, 1, 100, 1));
        jSpinnerQuantum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerQuantumStateChanged(evt);
            }
        });
        jSpinnerQuantum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinnerQuantumMouseClicked(evt);
            }
        });

        grupoCpu.add(CpuRR);
        CpuRR.setText("Round Robin");
        CpuRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CpuRRActionPerformed(evt);
            }
        });

        grupoCpu.add(CpuFifo);
        CpuFifo.setText("FIFO");

        grupoCpu.add(CpuSrt);
        CpuSrt.setText("SRT");

        grupoCpu.add(CpuSjf);
        CpuSjf.setText("SJF");

        grupoCpu.add(CpuHrrn);
        CpuHrrn.setText("HRRN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CpuHrrn)
                    .addComponent(CpuSjf)
                    .addComponent(CpuSrt)
                    .addComponent(CpuFifo)
                    .addComponent(CpuRR)
                    .addComponent(jLabel21)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CpuRR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CpuFifo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CpuSrt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CpuSjf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CpuHrrn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jSpinnerQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Nuevo Proceso");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Nombre:");

        jLabelNPNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Páginas:");

        jSpinnerPaginas.setModel(new javax.swing.SpinnerNumberModel(3, 0, 4, 1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Ejecución Total:");

        jSpinnerTotalEjec.setModel(new javax.swing.SpinnerNumberModel(10, 1, 20, 1));

        jButton6.setText("Crear Proceso");
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
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelNPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerTotalEjec, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabelNPNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jSpinnerPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jSpinnerTotalEjec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTiempoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(730, 730, 730)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
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
        
        int pag=Integer.parseInt(jSpinnerPaginas.getValue().toString());
        int totejec=Integer.parseInt(jSpinnerTotalEjec.getValue().toString());
        
        JOptionPane.showMessageDialog(null, "Se ha creado un nuevo proceso"+ "\ntamaño de pagina: "+pag+"\nejecución total: "+totejec);
        
        
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
   
        int llegadaProc2=6;
        String lp2 = String.valueOf(llegadaProc2); 
        
        int cpurestante=9;
        String cr2 = String.valueOf(cpurestante);  
        
        
        
        jLabelNombre.setText("2");
        jLabelLlegada.setText(lp2);
        jLabelCpuAsignado.setText("0");
        jLabelEnvejecimiento.setText("0");
        jLabelCpuRestante.setText(cr2);
        jLabelNPNombre.setText("4");
        
        
    //Proceso 2    
    int contPag=0;    
    DefaultTableModel model=(DefaultTableModel) jTableDatos.getModel();
    model.addRow(new Object[]{contPag,bitResPag0Proc1,tiempoLlegadaPag0Proc1,tiempoUltAccPag0Proc1,cantAccPag0Proc1,nur1Pag0Proc1,nur2Pag0Proc1});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag0Proc2,tiempoLlegadaPag0Proc2,tiempoUltAccPag0Proc2,cantAccPag0Proc2,nur1Pag0Proc2,nur2Pag0Proc2});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag1Proc2,tiempoLlegadaPag1Proc2,tiempoUltAccPag1Proc2,cantAccPag1Proc2,nur1Pag1Proc2,nur2Pag1Proc2});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag2Proc2,tiempoLlegadaPag2Proc2,tiempoUltAccPag2Proc2,cantAccPag2Proc2,nur1Pag2Proc2,nur2Pag2Proc2});
    contPag++;
    
        TActual=25;
        String TiempoActual = String.valueOf(TActual); 
        jLabelTiempoActual.setText(TiempoActual); 
        
        /*
        int llegadaProc3=13;
        String lp3 = String.valueOf(llegadaProc3); 
        
        int cpurestante3=21;
        String cr3 = String.valueOf(cpurestante3); 
        
        int envejecimiento=1;
        String env = String.valueOf(envejecimiento);
    
        jLabelNombre.setText("3");
        jLabelLlegada.setText(lp3);
        jLabelCpuAsignado.setText("0");
        jLabelEnvejecimiento.setText(env);
        jLabelCpuRestante.setText(cr3);
        jLabelNPNombre.setText("4");*/
    
        
    
    //model.addRow(new Object[]{contPag,bitResPag4Proc1,tiempoLlegadaPag4Proc1,tiempoUltAccPag4Proc1,cantAccPag4Proc1,nur1Pag4Proc1,nur2Pag4Proc1});
    //contPag++;
    
    
    /*
    //Proceso 2
    model.addRow(new Object[]{contPag,bitResPag0Proc2,tiempoLlegadaPag0Proc2,tiempoUltAccPag0Proc2,cantAccPag0Proc2,nur1Pag0Proc2,nur2Pag0Proc2});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag1Proc2,tiempoLlegadaPag1Proc2,tiempoUltAccPag1Proc2,cantAccPag1Proc2,nur1Pag1Proc2,nur2Pag1Proc2});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag2Proc2,tiempoLlegadaPag2Proc2,tiempoUltAccPag2Proc2,cantAccPag2Proc2,nur1Pag2Proc2,nur2Pag2Proc2});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag3Proc2,tiempoLlegadaPag3Proc2,tiempoUltAccPag3Proc2,cantAccPag3Proc2,nur1Pag3Proc2,nur2Pag3Proc2});
    contPag++;
    
    //Proceso 2
    model.addRow(new Object[]{contPag,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,cantAccPag1Proc3,nur1Pag1Proc3,nur2Pag1Proc3});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
    contPag++;
    model.addRow(new Object[]{contPag,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
    contPag++;
    */
    
    //Tiempo Actualger.parseInt(tiempoUltAccPag0Proc1); Proceso 1
    int tiempo0 = Integer.parseInt(tiempoUltAccPag0Proc1);
    int tiempo1 = Integer.parseInt(tiempoUltAccPag1Proc1);
    int tiempo2 = Integer.parseInt(tiempoUltAccPag2Proc1);
    int tiempo3 = Integer.parseInt(tiempoUltAccPag3Proc1);
    int tiempo4 = Integer.parseInt(tiempoUltAccPag4Proc1);
    
    //Tiempo Actual Proceso 2
    int tiempo5 = Integer.parseInt(tiempoUltAccPag0Proc2);
    int tiempo6 = Integer.parseInt(tiempoUltAccPag1Proc2);
    int tiempo7 = Integer.parseInt(tiempoUltAccPag2Proc2);
    int tiempo8 = Integer.parseInt(tiempoUltAccPag3Proc2);
    
    //Tiempo Actual Proceso 3
    int tiempo9 = Integer.parseInt(tiempoUltAccPag0Proc3);
    int tiempo10 = Integer.parseInt(tiempoUltAccPag1Proc3);
    int tiempo11 = Integer.parseInt(tiempoUltAccPag2Proc3);
    int tiempo12 = Integer.parseInt(tiempoUltAccPag3Proc3);
    
      
    if((tiempo0>tiempo1)&&(tiempo0>tiempo2)&&(tiempo0>tiempo3)&&(tiempo0>tiempo4)&&(tiempo0>tiempo5)&&(tiempo0>tiempo6)&&(tiempo0>tiempo7)&&(tiempo0>tiempo8)&&(tiempo0>tiempo9)&&(tiempo0>tiempo10)&&(tiempo0>tiempo11)&&(tiempo0>tiempo12)){
        TActual=tiempo0;}
    
    if((tiempo1>tiempo0)&&(tiempo1>tiempo2)&&(tiempo1>tiempo3)&&(tiempo1>tiempo4&&(tiempo1>tiempo4)&&(tiempo1>tiempo6)&&(tiempo1>tiempo7)&&(tiempo1>tiempo8)&&(tiempo1>tiempo9)&&(tiempo1>tiempo10)&&(tiempo1>tiempo11)&&(tiempo1>tiempo12))){
        TActual=tiempo1;}
    
    if((tiempo2>tiempo0)&&(tiempo2>tiempo1)&&(tiempo2>tiempo3)&&(tiempo2>tiempo4)&&(tiempo2>tiempo4)&&(tiempo2>tiempo6)&&(tiempo2>tiempo7)&&(tiempo2>tiempo8)&&(tiempo2>tiempo9)&&(tiempo2>tiempo10)&&(tiempo2>tiempo11)&&(tiempo2>tiempo12)){
        TActual=tiempo2;}
    
    if((tiempo3>tiempo0)&&(tiempo3>tiempo1)&&(tiempo3>tiempo2)&&(tiempo3>tiempo4)&&(tiempo3>tiempo4)&&(tiempo3>tiempo6)&&(tiempo3>tiempo7)&&(tiempo3>tiempo8)&&(tiempo3>tiempo9)&&(tiempo3>tiempo10)&&(tiempo3>tiempo11)&&(tiempo3>tiempo12)){
        TActual=tiempo3;}
    
    if((tiempo4>tiempo0)&&(tiempo4>tiempo1)&&(tiempo4>tiempo2)&&(tiempo4>tiempo3)&&(tiempo4>tiempo5)&&(tiempo4>tiempo6)&&(tiempo4>tiempo7)&&(tiempo4>tiempo8)&&(tiempo4>tiempo9)&&(tiempo4>tiempo10)&&(tiempo4>tiempo11)&&(tiempo4>tiempo12)){
        TActual=tiempo4;}
    
    if((tiempo5>tiempo0)&&(tiempo5>tiempo1)&&(tiempo5>tiempo2)&&(tiempo5>tiempo3)&&(tiempo5>tiempo4)&&(tiempo5>tiempo6)&&(tiempo5>tiempo7)&&(tiempo5>tiempo8)&&(tiempo5>tiempo9)&&(tiempo5>tiempo10)&&(tiempo5>tiempo11)&&(tiempo5>tiempo12)){
        TActual=tiempo5;}
    
    if((tiempo6>tiempo0)&&(tiempo6>tiempo1)&&(tiempo6>tiempo2)&&(tiempo6>tiempo3)&&(tiempo6>tiempo4)&&(tiempo6>tiempo5)&&(tiempo6>tiempo7)&&(tiempo6>tiempo8)&&(tiempo6>tiempo9)&&(tiempo6>tiempo10)&&(tiempo6>tiempo11)&&(tiempo6>tiempo12)){
        TActual=tiempo6;}
    
    if((tiempo7>tiempo0)&&(tiempo7>tiempo1)&&(tiempo7>tiempo2)&&(tiempo7>tiempo3)&&(tiempo7>tiempo4)&&(tiempo7>tiempo5)&&(tiempo7>tiempo6)&&(tiempo7>tiempo8)&&(tiempo7>tiempo9)&&(tiempo7>tiempo10)&&(tiempo7>tiempo11)&&(tiempo7>tiempo12)){
        TActual=tiempo7;}
    
    if((tiempo8>tiempo0)&&(tiempo8>tiempo1)&&(tiempo8>tiempo2)&&(tiempo8>tiempo3)&&(tiempo8>tiempo4)&&(tiempo8>tiempo5)&&(tiempo8>tiempo6)&&(tiempo8>tiempo7)&&(tiempo8>tiempo9)&&(tiempo8>tiempo10)&&(tiempo8>tiempo11)&&(tiempo8>tiempo12)){
        TActual=tiempo8;}
    
    if((tiempo9>tiempo0)&&(tiempo9>tiempo1)&&(tiempo9>tiempo2)&&(tiempo9>tiempo3)&&(tiempo9>tiempo4)&&(tiempo9>tiempo5)&&(tiempo9>tiempo6)&&(tiempo9>tiempo7)&&(tiempo9>tiempo8)&&(tiempo9>tiempo10)&&(tiempo9>tiempo11)&&(tiempo9>tiempo12)){
        TActual=tiempo9;}
    
    if((tiempo10>tiempo0)&&(tiempo10>tiempo1)&&(tiempo10>tiempo2)&&(tiempo10>tiempo3)&&(tiempo10>tiempo4)&&(tiempo10>tiempo5)&&(tiempo10>tiempo6)&&(tiempo10>tiempo7)&&(tiempo10>tiempo8)&&(tiempo10>tiempo9)&&(tiempo10>tiempo11)&&(tiempo10>tiempo12)){
        TActual=tiempo10;}
    
    if((tiempo11>tiempo0)&&(tiempo11>tiempo1)&&(tiempo11>tiempo2)&&(tiempo11>tiempo3)&&(tiempo11>tiempo4)&&(tiempo11>tiempo5)&&(tiempo11>tiempo6)&&(tiempo11>tiempo7)&&(tiempo11>tiempo8)&&(tiempo11>tiempo9)&&(tiempo11>tiempo10)&&(tiempo11>tiempo10)){
        TActual=tiempo11;}
    
    if((tiempo12>tiempo0)&&(tiempo12>tiempo1)&&(tiempo12>tiempo2)&&(tiempo12>tiempo3)&&(tiempo12>tiempo4)&&(tiempo12>tiempo5)&&(tiempo12>tiempo6)&&(tiempo12>tiempo7)&&(tiempo12>tiempo8)&&(tiempo12>tiempo9)&&(tiempo12>tiempo10)&&(tiempo12>tiempo11)){
        TActual=tiempo12;}
    
    
    /*if(tiempo1>tiempo0 && tiempo1>tiempo2 &&tiempo1>tiempo3 && tiempo1>tiempo3 && tiempo1>tiempo4){    
    TActual=tiempo1;
    }*/
    
    
  
    MemoriaFifo.setSelected(true);
    CpuRR.setSelected(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        ReseteoBits = new javax.swing.JButton();
    }//GEN-LAST:event_jButton2MouseClicked

    private void ReseteoBitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReseteoBitsActionPerformed
        ReseteoBits = new javax.swing.JButton();
        
        /*if(cbx_scheduling.equals("FIFO")&&cbx_replacement.equals("LRU")){
            
        }*/
        
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
        
        
        
    }//GEN-LAST:event_ReseteoBitsActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:   
    
    //public int TActual;
    //public int Acc;
    //public int envejecimiento;
    //public int llegadaProc2;
    //public int cpurestante;
        
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
    
    //RestarQuantum 
    
    totalQuantum=Integer.parseInt(jSpinnerQuantum.getValue().toString());
    int valRestaQuantum=totalQuantum-cpuAsignado;
    String varQuantum = String.valueOf(valRestaQuantum); 
    
    
    /*if(MemoriaFifo.isSelected()&&CpuRR.isSelected()){

       JOptionPane.showMessageDialog(null, "Ocurrió un fallo de página");
       DefaultTableModel model2=(DefaultTableModel)jTableDatos.getModel();
        model2.removeRow(jTableDatos.getRowMargin());
        model2.removeRow(jTableDatos.getRowMargin());
        model2.removeRow(jTableDatos.getRowMargin());
        model2.removeRow(jTableDatos.getRowMargin());  
    
    }*/
    
    //int pagEjecRR
    //int pagEjecFifo
    //int pagEjecSrt
    //int pagEjecSjf
    //int pagEjecHrrn
    
    int pagEjecRR=Integer.parseInt(jSpinnerPaginaEjecutar.getValue().toString());
    //JOptionPane.showMessageDialog(null, pagEjec);
    
    /*if(pagEjecRR==0){
        JOptionPane.showMessageDialog(null, "Ocurrió un fallo de página");
        
        //Proceso 3
        int contPag2=0;
        temporalLlegada=26;
        temporalUltAcc=3;
        DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
        model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,cantAccPag1Proc3,nur1Pag1Proc3,nur2Pag1Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
        contPag2++;
        
    }
    */
    if(pagEjecRR==1){
        Acc++;
        
         int mFifoFifo = Integer.parseInt(tiempoUltAccPag0Proc1);
            mFifoFifo=(Acc+temporalUltAcc)+mFifoFifo;

            DefaultTableModel modelFifo=(DefaultTableModel) jTableDatos.getModel();
            modelFifo.setValueAt(mFifoFifo, 1, 3);
            
            int contPag=0;    
            DefaultTableModel model=(DefaultTableModel) jTableDatos.getModel();
            model.addRow(new Object[]{contPag,bitResPag0Proc1,tiempoLlegadaPag0Proc1,tiempoUltAccPag0Proc1,cantAccPag0Proc1,nur1Pag0Proc1,nur2Pag0Proc1});
            contPag++;
            model.addRow(new Object[]{contPag,bitResPag0Proc2,tiempoLlegadaPag0Proc2,tiempoUltAccPag0Proc2,cantAccPag0Proc2,nur1Pag0Proc2,nur2Pag0Proc2});
            contPag++;
            model.addRow(new Object[]{contPag,bitResPag1Proc2,tiempoLlegadaPag1Proc2,tiempoUltAccPag1Proc2,cantAccPag1Proc2,nur1Pag1Proc2,nur2Pag1Proc2});
            contPag++;
            model.addRow(new Object[]{contPag,bitResPag2Proc2,tiempoLlegadaPag2Proc2,tiempoUltAccPag2Proc2,cantAccPag2Proc2,nur1Pag2Proc2,nur2Pag2Proc2});
            contPag++;
    
    }
    
    if(pagEjecSrt==0){
                
                DefaultTableModel model2=(DefaultTableModel)jTableDatos.getModel();
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                
                int llegadaProc2=13;
                String lp2 = String.valueOf(llegadaProc2); 

                int cpurestante=21;
                String cr2 = String.valueOf(cpurestante);  

                jLabelNombre.setText("3");
                jLabelLlegada.setText(lp2);
                jLabelCpuAsignado.setText("0");
                jLabelEnvejecimiento.setText("1");
                jLabelCpuRestante.setText(cr2);
                jLabelNPNombre.setText("4");

                //Proceso 3
                int contPag2=0;
                temporalLlegada=26;
                temporalUltAcc=3;
                DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
                model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,cantAccPag1Proc3,nur1Pag1Proc3,nur2Pag1Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
                contPag2++;
                
            }
    
    if(pagEjecSrt==0){
                JOptionPane.showMessageDialog(null, "Ocurrió un fallo de página");
                DefaultTableModel model2=(DefaultTableModel)jTableDatos.getModel();
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                
                int llegadaProc2=13;
                String lp2 = String.valueOf(llegadaProc2); 

                int cpurestante=21;
                String cr2 = String.valueOf(cpurestante);  

                jLabelNombre.setText("3");
                jLabelLlegada.setText(lp2);
                jLabelCpuAsignado.setText("0");
                jLabelEnvejecimiento.setText("1");
                jLabelCpuRestante.setText(cr2);
                jLabelNPNombre.setText("4");

                //Proceso 3
                int contPag2=0;
                temporalLlegada=26;
                temporalUltAcc=3;
                DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
                model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,cantAccPag1Proc3,nur1Pag1Proc3,nur2Pag1Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
                contPag2++;
            }
    
    
    
    //jLabelCpuRestante.setText(cpuRes); 
    
    /*int var=0;
    do{
        totalQuantum--;
        var=totalQuantum;
    //JOptionPane.showMessageDialog(null, totalQuantum);
    
    }while(totalQuantum>0);
    String totalQntm = String.valueOf(var);
    jLabelQuantumRestante.setText(totalQntm);*/
    
    //jLabelQuantumRestante.setText(jSpinnerQuantum.getValue().toString());
    
    //int pagEjecRR
    //int pagEjecFifo
    //int pagEjecSrt
    //int pagEjecSjf
    //int pagEjecHrrn
    
    // Seleccion de Opcion de Memoria y Cpu
    if (MemoriaFifo.isSelected()&&CpuRR.isSelected()||MemoriaLru.isSelected()&&CpuRR.isSelected()) {
    //jLabelTiempoActual.setText(TiempoActual);
    int mFifoRR = Integer.parseInt(tiempoUltAccPag0Proc1);
    mFifoRR=TActual;
           
    DefaultTableModel modelFifo=(DefaultTableModel) jTableDatos.getModel();
    modelFifo.setValueAt(mFifoRR, 0, 3);
    
    JOptionPane.showMessageDialog(null, "Ocurrió un fallo de página");
       DefaultTableModel model2=(DefaultTableModel)jTableDatos.getModel();
        model2.removeRow(jTableDatos.getRowMargin());
        model2.removeRow(jTableDatos.getRowMargin());
        model2.removeRow(jTableDatos.getRowMargin());
        model2.removeRow(jTableDatos.getRowMargin());
        
        if(pagEjecRR==0){
        JOptionPane.showMessageDialog(null, "Ocurrió un fallo de página");
        
        int llegadaProc2=21;
        String lp2 = String.valueOf(llegadaProc2); 
        
        int cpurestante=9;
        String cr2 = String.valueOf(cpurestante);  
        
        jLabelNombre.setText("3");
        jLabelLlegada.setText(lp2);
        jLabelCpuAsignado.setText("0");
        jLabelEnvejecimiento.setText("1");
        jLabelCpuRestante.setText(cr2);
        jLabelNPNombre.setText("4");
        
        //Proceso 3
        int contPag2=0;
        temporalLlegada=26;
        temporalUltAcc=3;
        DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
        model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,cantAccPag1Proc3,nur1Pag1Proc3,nur2Pag1Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
        contPag2++;
        
        
    }
    
    if(pagEjecRR==1){
        
         int mFifoFifo = Integer.parseInt(tiempoUltAccPag0Proc3);
         Acc++;
         mFifoFifo+=(Acc*2)+1;
            
        //Proceso 3
           
        modelFifo.setValueAt(mFifoFifo, 1, 4); 
        int contPag2=0;
        temporalLlegada=26;
        temporalUltAcc=3;
        DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
        model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,(mFifoFifo+cantAccPag1Proc3),nur1Pag1Proc3,nur2Pag1Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
        contPag2++;
        model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
        contPag2++;
        int reemplazo=1;
        model3.setValueAt(TiempoActual, 1, 3);
        model3.setValueAt(reemplazo, 1, 5);
        
        jLabelCpuRestante.setText("8");
        
    
    }
 
        } else if (MemoriaFifo.isSelected()&&CpuFifo.isSelected()) {
        
            int llegadaProc2=13;
            String lp2 = String.valueOf(llegadaProc2); 

            int cpurestante=21;
            String cr2 = String.valueOf(cpurestante); 
/*
            jLabelNombre.setText("3");
            jLabelLlegada.setText(lp2);
            jLabelCpuAsignado.setText("0");
            jLabelEnvejecimiento.setText("1");
            jLabelCpuRestante.setText(cr2);
            jLabelNPNombre.setText("4");*/
            
            cpuRestante = Integer.parseInt(tiempoTotalEstimProc1);
            valRes=cpuRestante-cpuAsignado;
            cpuRes = String.valueOf(valRes); 
            jLabelCpuRestante.setText(cpuRes);
            
            int mFifoFifo = Integer.parseInt(tiempoUltAccPag0Proc1);
            mFifoFifo=Acc;
            
            if(pagEjecFifo==0){
                
                DefaultTableModel model2=(DefaultTableModel)jTableDatos.getModel();
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                
               JOptionPane.showMessageDialog(null, "Ocurrió un fallo de página");
                int contPag2=0;
                temporalLlegada=26;
                temporalUltAcc=3;
                DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
                model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,(mFifoFifo+cantAccPag1Proc3),nur1Pag1Proc3,nur2Pag1Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
                contPag2++;
                int reemplazo=1;
                model3.setValueAt(TiempoActual, 1, 3);
                model3.setValueAt(reemplazo, 1, 5);
                
            }
            
            
            if(pagEjecFifo==1){
                if(totalQuantum>=0){

                    int var=0;
                    do{
                        totalQuantum--;
                        var=totalQuantum;
                    JOptionPane.showMessageDialog(null, "Ha terminado la ejecución actual");

                    }while(totalQuantum>0);
                    String totalQntm = String.valueOf(var);
                    jLabelQuantumRestante.setText(totalQntm);

                }
            }
             
 
        } 
    
    
    
    
        else if (MemoriaFifo.isSelected()&&CpuSrt.isSelected()) {
            
            if(pagEjecSrt==0){
                
                DefaultTableModel model2=(DefaultTableModel)jTableDatos.getModel();
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                
                int llegadaProc2=13;
                String lp2 = String.valueOf(llegadaProc2); 

                int cpurestante=21;
                String cr2 = String.valueOf(cpurestante);  

                jLabelNombre.setText("3");
                jLabelLlegada.setText(lp2);
                jLabelCpuAsignado.setText("0");
                jLabelEnvejecimiento.setText("1");
                jLabelCpuRestante.setText(cr2);
                jLabelNPNombre.setText("4");
                
                //Cpu Asignado
                cpuAsignado++;
                cpuAsig = String.valueOf(cpuAsignado); 
                jLabelCpuAsignado.setText(cpuAsig);

                //Cpu Restante
                cpuRestante = Integer.parseInt(tiempoTotalEstimProc1);
                valRes=cpuRestante-cpuAsignado;
                cpuRes = String.valueOf(valRes); 
                jLabelCpuRestante.setText(cpuRes);  
                
                //Proceso 3
                int contPag2=0;
                temporalLlegada=26;
                temporalUltAcc=3;
                DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
                model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,cantAccPag1Proc3,nur1Pag1Proc3,nur2Pag1Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
                contPag2++;
                int reemplazo=1;
                model3.setValueAt(TiempoActual, 1, 3);
                model3.setValueAt(reemplazo, 1, 5);
                
            }
            
        } else if (MemoriaFifo.isSelected()&&CpuSjf.isSelected()) {
            
            if(pagEjecSrt==0){
                JOptionPane.showMessageDialog(null, "Ocurrió un fallo de página");
                DefaultTableModel model2=(DefaultTableModel)jTableDatos.getModel();
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                
                int llegadaProc2=13;
                String lp2 = String.valueOf(llegadaProc2); 

                int cpurestante=21;
                String cr2 = String.valueOf(cpurestante);  

                jLabelNombre.setText("3");
                jLabelLlegada.setText(lp2);
                jLabelCpuAsignado.setText("0");
                jLabelEnvejecimiento.setText("1");
                jLabelCpuRestante.setText(cr2);
                jLabelNPNombre.setText("4");

                //Proceso 3
                int contPag2=0;
                temporalLlegada=26;
                temporalUltAcc=3;
                DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
                model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,cantAccPag1Proc3,nur1Pag1Proc3,nur2Pag1Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
                contPag2++;
            }

        }else if (MemoriaFifo.isSelected()&&CpuHrrn.isSelected()) {
            
            if(pagEjecSrt==0){
                
                DefaultTableModel model2=(DefaultTableModel)jTableDatos.getModel();
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                model2.removeRow(jTableDatos.getRowMargin());
                
                int llegadaProc2=13;
                String lp2 = String.valueOf(llegadaProc2); 

                int cpurestante=21;
                String cr2 = String.valueOf(cpurestante);  

                jLabelNombre.setText("3");
                jLabelLlegada.setText(lp2);
                jLabelCpuAsignado.setText("0");
                jLabelEnvejecimiento.setText("1");
                jLabelCpuRestante.setText(cr2);
                jLabelNPNombre.setText("4");
                
                //Cpu Asignado
                cpuAsignado++;
                cpuAsig = String.valueOf(cpuAsignado); 
                jLabelCpuAsignado.setText(cpuAsig);

                //Cpu Restante
                cpuRestante = Integer.parseInt(tiempoTotalEstimProc1);
                valRes=cpuRestante-cpuAsignado;
                cpuRes = String.valueOf(valRes); 
                jLabelCpuRestante.setText(cpuRes);  
                
                //Proceso 3
                int contPag2=0;
                temporalLlegada=26;
                temporalUltAcc=3;
                DefaultTableModel model3=(DefaultTableModel) jTableDatos.getModel();
                model3.addRow(new Object[]{contPag2,1,9,temporalLlegada,temporalUltAcc,0,0});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag0Proc3,tiempoLlegadaPag0Proc3,tiempoUltAccPag0Proc3,cantAccPag0Proc3,nur1Pag0Proc3,nur2Pag0Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag1Proc3,tiempoLlegadaPag1Proc3,tiempoUltAccPag1Proc3,(cantAccPag1Proc3),nur1Pag1Proc3,nur2Pag1Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag2Proc3,tiempoLlegadaPag2Proc3,tiempoUltAccPag2Proc3,cantAccPag2Proc3,nur1Pag2Proc3,nur2Pag2Proc3});
                contPag2++;
                model3.addRow(new Object[]{contPag2,bitResPag3Proc3,tiempoLlegadaPag3Proc3,tiempoUltAccPag3Proc3,cantAccPag3Proc3,nur1Pag3Proc3,nur2Pag3Proc3});
                contPag2++;
                int reemplazo=1;
                model3.setValueAt(TiempoActual, 1, 3);
                model3.setValueAt(reemplazo, 1, 5);
                
            }

        }
    
    }//GEN-LAST:event_jButton1MouseClicked

    private void jSpinnerQuantumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerQuantumMouseClicked
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_jSpinnerQuantumMouseClicked

    private void jSpinnerQuantumStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerQuantumStateChanged
        // TODO add your handling code here:
        jLabelQuantumRestante.setText(jSpinnerQuantum.getValue().toString());        
    }//GEN-LAST:event_jSpinnerQuantumStateChanged

    private void MemoriaFifoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemoriaFifoActionPerformed
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_MemoriaFifoActionPerformed

    private void jSpinnerPaginaEjecutarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPaginaEjecutarStateChanged
        // TODO add your handling code here:
        
        int pagEjecRR=Integer.parseInt(jSpinnerPaginaEjecutar.getValue().toString());
        int pagEjecFifo=Integer.parseInt(jSpinnerPaginaEjecutar.getValue().toString());
        int pagEjecSrt=Integer.parseInt(jSpinnerPaginaEjecutar.getValue().toString());
        int pagEjecSjf=Integer.parseInt(jSpinnerPaginaEjecutar.getValue().toString());
        int pagEjecHrrn=Integer.parseInt(jSpinnerPaginaEjecutar.getValue().toString());
        
    }//GEN-LAST:event_jSpinnerPaginaEjecutarStateChanged

    private void CpuRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpuRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CpuRRActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if (MemoriaFifo.isSelected()&&CpuRR.isSelected()) {
            JOptionPane.showMessageDialog(null, "El proceso se ha terminado o tuvo un fallo de pagina y pasara a la lista de finish");
        }
        if (MemoriaFifo.isSelected()&&CpuFifo.isSelected()) {
            JOptionPane.showMessageDialog(null, "El proceso se ha terminado o tuvo un fallo de pagina y pasara a finish");
            JOptionPane.showMessageDialog(null, "Ha terminado la ejecucion del proceso actual."+ "\nTiempo de llegada: Running 6"+"\nTiempos de llegada de procesos en ready"+"\nProceso 3: 13");
        }
        
        if (MemoriaFifo.isSelected()&&CpuSrt.isSelected()) {
            JOptionPane.showMessageDialog(null, "El proceso actual ira a la fila de block y se cargara el siguiente proceso en ready en caso de que exista alguno");
        }
        
        if (MemoriaFifo.isSelected()&&CpuSjf.isSelected()) {
            JOptionPane.showMessageDialog(null, "El proceso se ha terminado o tuvo un fallo de pagina y pasara a la lista de finish");
            JOptionPane.showMessageDialog(null, "Ha terminado la ejecucion del proceso actual."+ "\nTiempo de llegada: Running 9"+"\nTiempos de llegada de procesos en ready"+"\nProceso 3: 21"+"\nProceso 1: 15");
        }
        
        if (MemoriaFifo.isSelected()&&CpuHrrn.isSelected()) {
            JOptionPane.showMessageDialog(null, "El primer proceso de la fila bloqued pasa a la fila ready");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
      	String archivo = "C:/archivinSO2.txt";
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
    private javax.swing.JRadioButton CpuFifo;
    private javax.swing.JRadioButton CpuHrrn;
    private javax.swing.JRadioButton CpuRR;
    private javax.swing.JRadioButton CpuSjf;
    private javax.swing.JRadioButton CpuSrt;
    private javax.swing.JRadioButton MemoriaFifo;
    private javax.swing.JRadioButton MemoriaLfu;
    private javax.swing.JRadioButton MemoriaLru;
    private javax.swing.JRadioButton MemoriaNur;
    private javax.swing.JButton ReseteoBits;
    private javax.swing.ButtonGroup grupoCpu;
    private javax.swing.ButtonGroup grupoMemoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCpuAsignado;
    private javax.swing.JLabel jLabelCpuRestante;
    private javax.swing.JLabel jLabelEnvejecimiento;
    private javax.swing.JLabel jLabelLlegada;
    private javax.swing.JLabel jLabelNPNombre;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelQuantumRestante;
    private javax.swing.JLabel jLabelTiempoActual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerPaginaEjecutar;
    private javax.swing.JSpinner jSpinnerPaginas;
    private javax.swing.JSpinner jSpinnerQuantum;
    private javax.swing.JSpinner jSpinnerTotalEjec;
    private javax.swing.JTable jTableDatos;
    // End of variables declaration//GEN-END:variables
}
