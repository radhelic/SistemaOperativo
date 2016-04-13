package sistemaoperativo;

/**
 * @(#)Principal.java
 *
 *
 * @author 
 * @version 1.00 2016/2/4
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;

public class LeeArchivo_1 {
	
	static String cantPagProcesos;
	static String cantProcesos;
	static String tiempoLlegadaProc1;
	static String tiempoTotalEstimProc1;
	static String estadoProc1;
	static String cantPagProc1;
	static String bitResPag0Proc1;
	static String tiempoLlegadaPag0Proc1;
	static String tiempoUltAccPag0Proc1;
	static String cantAccPag0Proc1;
	static String nur1Pag0Proc1;
	static String nur2Pag0Proc1;
	static String bitResPag1Proc1;
	static String tiempoLlegadaPag1Proc1;
	static String tiempoUltAccPag1Proc1;
	static String cantAccPag1Proc1;
	static String nur1Pag1Proc1;
	static String nur2Pag1Proc1;
	static String bitResPag2Proc1;
	static String tiempoLlegadaPag2Proc1;
	static String tiempoUltAccPag2Proc1;
	static String cantAccPag2Proc1;
	static String nur1Pag2Proc1;
	static String nur2Pag2Proc1;
	static String bitResPag3Proc1;
	static String tiempoLlegadaPag3Proc1;
	static String tiempoUltAccPag3Proc1;
	static String cantAccPag3Proc1;
	static String nur1Pag3Proc1;
	static String nur2Pag3Proc1;
	
	static String tiempoLlegadaProc2;
	static String tiempoTotalEstimProc2;
	static String estadoProc2;
	static String cantPagProc2;
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
	static String bitResPag4Proc3;
	static String tiempoLlegadaPag4Proc3;
	static String tiempoUltAccPag4Proc3;
	static String cantAccPag4Proc3;
	static String nur1Pag4Proc3;
	static String nur2Pag4Proc3;
    
	public LeeArchivo_1() {
    }
    
    public static void main (String[] args) throws IOException {
    	
    	ArrayList <String> ls = new ArrayList<String>();
    	    	
    	String cadena;
      	String archivo = "C:/Users/Jose Carmen/workspace/ProySO/src/SistOp/archivinSO2.txt";
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
      	JOptionPane.showMessageDialog(null, var);
      	
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
      		case 30: tiempoLlegadaProc2 	= var2[30].trim(); // L�nea 8
      		case 31: tiempoTotalEstimProc2 	= var2[31].trim(); // L�nea 8
      		case 32: estadoProc2 			= var2[32].trim(); // L�nea 8
      		case 33: cantPagProc2 			= var2[33].trim(); // L�nea 9
      		case 34: bitResPag0Proc2 		= var2[34].trim(); // L�nea 10
      		case 35: tiempoLlegadaPag0Proc2 = var2[35].trim(); // L�nea 10
      		case 36: tiempoUltAccPag0Proc2 	= var2[36].trim(); // L�nea 10
      		case 37: cantAccPag0Proc2 		= var2[37].trim(); // L�nea 10
      		case 38: nur1Pag0Proc2 			= var2[38].trim(); // L�nea 10
      		case 39: nur2Pag0Proc2 			= var2[39].trim(); // L�nea 10
      		case 40: bitResPag1Proc2 		= var2[40].trim(); // L�nea 11 
      		case 41: tiempoLlegadaPag1Proc2 = var2[41].trim(); // L�nea 11
      		case 42: tiempoUltAccPag1Proc2 	= var2[42].trim(); // L�nea 11
      		case 43: cantAccPag1Proc2 		= var2[43].trim(); // L�nea 11
      		case 44: nur1Pag1Proc2 			= var2[44].trim(); // L�nea 11
      		case 45: nur2Pag1Proc2 			= var2[45].trim(); // L�nea 11
      		case 46: bitResPag2Proc2 		= var2[46].trim(); // L�nea 12
      		case 47: tiempoLlegadaPag2Proc2 = var2[47].trim(); // L�nea 12
      		case 48: tiempoUltAccPag2Proc2 	= var2[48].trim(); // L�nea 12
      		case 49: cantAccPag2Proc2 		= var2[49].trim(); // L�nea 12
      		case 50: nur1Pag2Proc2 			= var2[50].trim(); // L�nea 12
      		case 51: nur2Pag2Proc2 			= var2[51].trim(); // L�nea 12
      		case 52: bitResPag3Proc2 		= var2[52].trim(); // L�nea 13
      		case 53: tiempoLlegadaPag3Proc2 = var2[53].trim(); // L�nea 13
      		case 54: tiempoUltAccPag3Proc2 	= var2[54].trim(); // L�nea 13
      		case 55: cantAccPag3Proc2 		= var2[55].trim(); // L�nea 13
      		case 56: nur1Pag3Proc2 			= var2[56].trim(); // L�nea 13
      		case 57: nur2Pag3Proc2 			= var2[57].trim(); // L�nea 13
      		case 58: tiempoLlegadaProc3 	= var2[58].trim(); // L�nea 14
      		case 59: tiempoTotalEstimProc3 	= var2[59].trim(); // L�nea 14
      		case 60: estadoProc3 			= var2[60].trim(); // L�nea 14
      		case 61: cantPagProc3 			= var2[61].trim(); // L�nea 15
      		case 62: bitResPag0Proc3 		= var2[62].trim(); // L�nea 16
      		case 63: tiempoLlegadaPag0Proc3 = var2[63].trim(); // L�nea 16
      		case 64: tiempoUltAccPag0Proc3 	= var2[64].trim(); // L�nea 16
      		case 65: cantAccPag0Proc3 		= var2[65].trim(); // L�nea 16
      		case 66: nur1Pag0Proc3 			= var2[66].trim(); // L�nea 16 
      		case 67: nur2Pag0Proc3 			= var2[67].trim(); // L�nea 16
      		case 68: bitResPag1Proc3 		= var2[68].trim(); // L�nea 17
      		case 69: tiempoLlegadaPag1Proc3 = var2[69].trim(); // L�nea 17
      		case 70: tiempoUltAccPag1Proc3 	= var2[70].trim(); // L�nea 17
      		case 71: cantAccPag1Proc3 		= var2[71].trim(); // L�nea 17
      		case 72: nur1Pag1Proc3 			= var2[72].trim(); // L�nea 17
      		case 73: nur2Pag1Proc3 			= var2[73].trim(); // L�nea 17
      		case 74: bitResPag2Proc3 		= var2[74].trim(); // L�nea 18
      		case 75: tiempoLlegadaPag2Proc3 = var2[75].trim(); // L�nea 18
      		case 76: tiempoUltAccPag2Proc3 	= var2[76].trim(); // L�nea 18
      		case 77: cantAccPag2Proc3 		= var2[77].trim(); // L�nea 18
      		case 78: nur1Pag2Proc3 			= var2[78].trim(); // L�nea 18
      		case 79: nur2Pag2Proc3 			= var2[79].trim(); // L�nea 18
      		case 80: bitResPag3Proc3 		= var2[80].trim(); // L�nea 19 
      		case 81: tiempoLlegadaPag3Proc3 = var2[81].trim(); // L�nea 19
      		case 82: tiempoUltAccPag3Proc3 	= var2[82].trim(); // L�nea 19
      		case 83: cantAccPag3Proc3 		= var2[83].trim(); // L�nea 19
      		case 84: nur1Pag3Proc3 			= var2[84].trim(); // L�nea 19
      		case 85: nur2Pag3Proc3 			= var2[85].trim(); // L�nea 19
      		case 86: bitResPag4Proc3 		= var2[86].trim(); // L�nea 20
      		case 87: tiempoLlegadaPag4Proc3 = var2[87].trim(); // L�nea 20
      		case 88: tiempoUltAccPag4Proc3 	= var2[88].trim(); // L�nea 20
      		case 89: cantAccPag4Proc3 		= var2[89].trim(); // L�nea 20
      		case 90: nur1Pag4Proc3 			= var2[90].trim(); // L�nea 20
      		case 91: nur2Pag4Proc3 			= var2[91].trim(); // L�nea 20
      		} // Fin del Switch 	
      	} // Fin del For      	

      	//System.out.print("\nCantidad de Procesos: "+cantProcesos + "\nEdo proceso 2: "+estadoProc2);      	
      	
	} // Fin del main        
} // Fin de la clase

