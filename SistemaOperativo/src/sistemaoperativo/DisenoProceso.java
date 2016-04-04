package sistemaoperativo;


public class DisenoProceso {
    public int idProceso;
    public int instrXProceso;
    public int pagXProceso;
    public int cantMarcPag;
    public int identificaProcesoEjecucion;
    public int quantumProceso; //para RR
    public int acumInstrEjecutadas; //para SJF
    public int tEspera;
    public DisenoPagina arregloPaginas [];
    public int contIO;
    public int idInstr;
    public String estadoProceso;
    public int contInstrSolicitadas;
    public int tBloqueado;
    public int arregloSigInstr [];
    
    public DisenoProceso(int p_numProceso, int p_numInstrucciones, int p_numPaginas, int p_numMarcosdePagina, AdministraTiempo p_tiempo){
        boolean residencia;
        idProceso=p_numProceso;
        instrXProceso=p_numInstrucciones;
        pagXProceso=p_numPaginas;
        cantMarcPag=p_numMarcosdePagina;
        identificaProcesoEjecucion=idProceso;
        quantumProceso=0;
        acumInstrEjecutadas=1;
        tEspera=0;
        contIO=0;
        idInstr=1;
        estadoProceso="Ready";
        contInstrSolicitadas=0;
        tBloqueado=0;

        arregloPaginas = new DisenoPagina[pagXProceso];
        arregloSigInstr = new int [2];
        arregloSigInstr[0]=1;
        arregloSigInstr[1]=2;
        
        for (int i = 0; i < pagXProceso; i++) {
            if(i>cantMarcPag)
                residencia=false;
            else
                residencia=true;
            //TENER QUE CORREGIR AL RATOa ver si no es -1
            arregloPaginas[i]=new DisenoPagina(i, residencia, p_tiempo.tiempoSistema);
            p_tiempo.aumentaTiempo(); //Aumenta el numero de tiempo
        }
    }
}

