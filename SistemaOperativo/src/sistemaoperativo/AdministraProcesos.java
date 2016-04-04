package sistemaoperativo;


import java.util.ArrayList;

public class AdministraProcesos {
    public AdministraAlgoritmos adminAlgo;
    public ArrayList listaDeProcesos;
    public DisenoProceso procesoActual;
    private boolean comienza;
    public AdministraMemoria memoria;
    private AdministraTiempo tiempo;
    int contAux=0;
    int acumTotal=0;
    int avanceEjecucionSJF=0;
    int agregaInstr=0;

    public AdministraProcesos(AdministraAlgoritmos p_procesador, ArrayList p_procesos, AdministraTiempo p_tiempo){
        adminAlgo=p_procesador;
        listaDeProcesos=p_procesos;
        comienza=true;
        tiempo=p_tiempo;
        memoria= new AdministraMemoria(adminAlgo,listaDeProcesos);
    }

    public void registraTiempoEnBlocked(){
        DisenoProceso p = null;
        for(int i=0; i<listaDeProcesos.size();i++){
            p = (DisenoProceso)listaDeProcesos.get(i);
            if(p.estadoProceso.equalsIgnoreCase("Blocked")){
                p.tBloqueado++;
            }
        }
    }

    public void procesoTerminado(){
         for (int i = 0; i < listaDeProcesos.size(); i++) {
                if((((DisenoProceso)(listaDeProcesos.get(i))).instrXProceso)<=(((DisenoProceso)(listaDeProcesos.get(i))).acumInstrEjecutadas))
                    ((DisenoProceso)(listaDeProcesos.get(i))).estadoProceso="Finished";
            }
     }

     public void bloqueadoAListo(){
        DisenoProceso p = null;
        for(int i=0; i<listaDeProcesos.size();i++){
            p = (DisenoProceso)listaDeProcesos.get(i);
            if((p.estadoProceso.equalsIgnoreCase("Blocked"))&&(p.tBloqueado>=5)){
                p.estadoProceso="Ready";
                p.tBloqueado=0;
            }
        }
    }

     public void ejecutandoseAListo(){
        DisenoProceso p = null;
        for(int i=0; i<listaDeProcesos.size();i++){
            p = (DisenoProceso)listaDeProcesos.get(i);
            if((p.estadoProceso.equalsIgnoreCase("Running"))&&(p.quantumProceso>=adminAlgo.quantumSistema)){
                p.estadoProceso="Ready";
                p.quantumProceso=0;
            }
        }
    }

     public void validaTerminados(){
         for (int i = 0; i < listaDeProcesos.size(); i++) {
                if((((DisenoProceso)(listaDeProcesos.get(i))).instrXProceso)<=(((DisenoProceso)(listaDeProcesos.get(i))).acumInstrEjecutadas)){
                    ((DisenoProceso)(listaDeProcesos.get(i))).estadoProceso="Finished";
                }else{
                    if(!((DisenoProceso)(listaDeProcesos.get(i))).estadoProceso.equalsIgnoreCase("Ready")){
                        procesoActual.estadoProceso="Blocked";
                    } else {
                    }
                }
            }
     }

     public boolean noHayListos(){
         DisenoProceso p;
         int cont=0;
         for(int i=0;i<listaDeProcesos.size();i++){
             p = (DisenoProceso)listaDeProcesos.get(i);
             if(!p.estadoProceso.equalsIgnoreCase("Ready")){
                 cont++;
             }
         }
         if(cont>=listaDeProcesos.size())
             return true;
         else
             return false;
     }

    public DisenoProceso ejecutaProcesos(){
        String s=adminAlgo.algoritmoScheduling;
        int i,r=0;
        int m=0;
        double a,b=0;
        boolean bandera=true;
        int n=listaDeProcesos.size(); //numero de procesos
        int p_numInstrucciones=99999;// :S
        DisenoProceso p = null,pr,pm;
        pr=(DisenoProceso)listaDeProcesos.get(r);
        pm=(DisenoProceso)listaDeProcesos.get(m);

        int aux=0;
        acumTotal=0;

        for (i = 0; i < listaDeProcesos.size(); i++) {
            acumTotal=acumTotal+((DisenoProceso)(listaDeProcesos.get(i))).instrXProceso;
            if(((((DisenoProceso)(listaDeProcesos.get(i))).instrXProceso)-(((DisenoProceso)(listaDeProcesos.get(i))).acumInstrEjecutadas))==0){
                aux++;
            }
        }

        if(aux==listaDeProcesos.size()){
            int variable=0;
            for (int j = 0; j < listaDeProcesos.size(); j++) {
                ((DisenoProceso)listaDeProcesos.get(j)).estadoProceso="Finished";
                System.out.println("---Proceso "+((DisenoProceso)listaDeProcesos.get(j)).idProceso+" ---" );
                System.out.println("numInst: "+((DisenoProceso)listaDeProcesos.get(j)).instrXProceso);
                System.out.println("Marcos: "+((((DisenoProceso)listaDeProcesos.get(j)).cantMarcPag)+1));
                System.out.println("I/Os: "+((DisenoProceso)listaDeProcesos.get(j)).contIO);
                
            }
            System.out.println();
            System.out.println("Tama�o de pagina: "+adminAlgo.tamPag);
            System.out.println();
            System.out.println("SE TERMINARON TODOS LOS PROCESOS");
            System.out.println("TIEMPO TOTAL: "+(acumTotal+contAux));

            listaDeProcesos.clear();
            PantallaProcesos.siguienteInstruccion("--");
            return null;

        }else{

        if(s.equalsIgnoreCase("FIFO")){
            if(comienza){
                procesoActual=(DisenoProceso)listaDeProcesos.get(0);
            }
            else{
                do{
                    procesoActual.estadoProceso="Blocked";
                    p=(DisenoProceso) listaDeProcesos.remove(0);
                    listaDeProcesos.add(p);
                    p=(DisenoProceso)listaDeProcesos.get(0);
                    if(todosBloqueados()){
                        if(listaDeProcesos.isEmpty())
                            bandera=false;
                        registraTiempoEnBlocked();
                        tiempo.aumentaTiempo();
                        break;
                    }else{
                        if(p.estadoProceso.equalsIgnoreCase("Ready")){
                           procesoActual.estadoProceso = "Running";
                           bandera=false;
                        }
                    }
                }while(bandera);
            }
            comienza=false;
            validaTerminados();
            procesoActual=(DisenoProceso)listaDeProcesos.get(0);
        }else{
            if(s.equalsIgnoreCase("RR")){
                if(comienza){
                    procesoActual=(DisenoProceso)listaDeProcesos.get(0);
                }
                else{
                    do{
                        procesoActual.estadoProceso="Blocked";
                        p=(DisenoProceso) listaDeProcesos.remove(0);
                        listaDeProcesos.add(p);
                        p=(DisenoProceso)listaDeProcesos.get(0);
                        if(todosBloqueados()){
                            if(listaDeProcesos.isEmpty()){
                                bandera=false;
                            }
                            registraTiempoEnBlocked();
                            tiempo.aumentaTiempo();
                            break;
                        }else{
                            if(p.estadoProceso.equalsIgnoreCase("Ready")){
                               procesoActual.estadoProceso = "Running";
                               bandera=false;
                            }
                        }
                    }while(bandera);
                }
                comienza=false;
                ejecutandoseAListo();
                validaTerminados();
                procesoActual=(DisenoProceso)listaDeProcesos.get(0);
            }else{
                if(s.equalsIgnoreCase("SJF")){
                   if(comienza){
                        for (i = 0; i < n; i++){
                            p=(DisenoProceso) listaDeProcesos.get(i);
                            if(p.instrXProceso<p_numInstrucciones){
                                r=i;
                                p_numInstrucciones=p.instrXProceso;
                                pr=(DisenoProceso)listaDeProcesos.get(r);
                                procesoActual=pr;
                            }
                        }
                    }else{
                        if(procesoActual.instrXProceso<=procesoActual.acumInstrEjecutadas){
                            procesoActual.estadoProceso="Finished";
                        }else{
                            procesoActual.estadoProceso="Blocked";
                        }
                        if(todosBloqueados()){
                            registraTiempoEnBlocked();
                            bloqueadoAListo();
                            tiempo.aumentaTiempo();
                        }
                        if(!todosBloqueados()){
                            for (i = 0; i < n; i++){
                                p=(DisenoProceso) listaDeProcesos.get(i);
                                if((p.instrXProceso<p_numInstrucciones)&&(p.estadoProceso.equalsIgnoreCase("Ready"))){
                                    r=i;
                                    p_numInstrucciones=p.instrXProceso;
                                    pr=(DisenoProceso)listaDeProcesos.get(r);
                                    procesoActual=pr;
                                }
                            }
                            if(!procesoActual.estadoProceso.equalsIgnoreCase("Blocked"))
                                procesoActual.estadoProceso="Running";
                        }
                    }
                    procesoTerminado();
                    comienza=false;
                }else{

                    if(s.equalsIgnoreCase("SRT")){
                        
                        if(comienza){
                        for (i = 0; i < n; i++){
                            p=(DisenoProceso) listaDeProcesos.get(i);
                            if(p.instrXProceso<p_numInstrucciones){
                                r=i;
                                p_numInstrucciones=p.instrXProceso;
                                pr=(DisenoProceso)listaDeProcesos.get(r);
                                procesoActual=pr;
                            }
                        }
                    }else{
                        if(procesoActual.acumInstrEjecutadas>=procesoActual.instrXProceso){
                            procesoActual.estadoProceso="Finished";
                        }
                        procesoActual.estadoProceso="Blocked";
                        
                        if(todosBloqueados()){
                            registraTiempoEnBlocked();
                            bloqueadoAListo();
                            tiempo.aumentaTiempo();
                        }
                        if(!todosBloqueados()){
                            agregaInstr=0;
                            for(i=0;i<n;i++){
                                p=(DisenoProceso)listaDeProcesos.get(i);
                                if(p.instrXProceso>agregaInstr){
                                    agregaInstr = p.instrXProceso;
                                    pr=p;
                                }
                            }

                            for (i = 0; i < n; i++){
                                p=(DisenoProceso) listaDeProcesos.get(i);
                                if(((p.instrXProceso-p.acumInstrEjecutadas)<(pr.instrXProceso-pr.acumInstrEjecutadas))&&p.estadoProceso.equalsIgnoreCase("Ready")){
                                    pr=(DisenoProceso)listaDeProcesos.get(i);
                                    procesoActual=pr;                      
                                }else{
                                    procesoActual=pr;
                                }
                            }
                            if(!procesoActual.estadoProceso.equalsIgnoreCase("Blocked"))
                                procesoActual.estadoProceso="Running";
                        }
                    }
                    procesoTerminado();
                    comienza=false;
                    }else{
                        if(s.equalsIgnoreCase("HRRN")){
                            if(comienza){
                                    for (i = 0; i < n; i++){
                                        p=(DisenoProceso) listaDeProcesos.get(i);
                                        if(p.instrXProceso<p_numInstrucciones){
                                                p_numInstrucciones=p.instrXProceso;
                                                pr=(DisenoProceso)listaDeProcesos.get(i);
                                        }
                                    }
                                    comienza=false;
                                }else{
                                    for (i = 0; i < n; i++){
                                        if(todosBloqueados()){
                                            if(!listaDeProcesos.isEmpty())
                                                registraTiempoEnBlocked();

                                        }else{
                                            p=(DisenoProceso) listaDeProcesos.get(i);
                                            a=((double)(p.tEspera+p.instrXProceso))/((double)(p.instrXProceso));
                                            b=((double)(pr.tEspera+pr.instrXProceso))/((double)(pr.instrXProceso));
                                            if(a>=b){
                                                if(p.acumInstrEjecutadas<p.instrXProceso&&p.estadoProceso.equalsIgnoreCase("Ready")){
                                                    pr=(DisenoProceso)listaDeProcesos.get(i);
                                                }else{
                                                    validaTerminados();
                                                }
                                            }
                                        }
                                    }
                                }
                            validaTerminados();
                            procesoActual=pr;         
                        }else{
                            //
                        }
                    }
                }
            }
        }
        if(!todosBloqueados()){
        procesoActual.estadoProceso = "Running";
        }
        return procesoActual;
    }
    }

    public boolean consumeInstruccion(int numInstruccion){
        boolean b=true;
        DisenoProceso p = null;
        String s=adminAlgo.algoritmoScheduling;
        registraTiempoEnBlocked();
        bloqueadoAListo();
  
        if(!todosBloqueados()){
            b=true;
            if(!s.equalsIgnoreCase("SJF")||!s.equalsIgnoreCase("SRT")){
                procesoActual.estadoProceso = "Running";
            }

        if (!memoria.ejecutarInstruccion(procesoActual, numInstruccion, tiempo.tiempoSistema))
        {
            procesoActual.contIO++;
            procesoActual.tEspera=0;
            procesoActual.idInstr=numInstruccion-1;
            procesoActual=ejecutaProcesos();
            procesoActual.quantumProceso=0; //inicializa su tiempo
            contAux++;
        }else{
            //procesoActual.instruccionPedida++;
            if(s.equalsIgnoreCase("RR")){
                procesoActual.quantumProceso++; 
                if(procesoActual.quantumProceso>=adminAlgo.quantumSistema){
                    procesoActual=ejecutaProcesos();
                }
                if(procesoActual.acumInstrEjecutadas>=procesoActual.instrXProceso){
                    if(!listaDeProcesos.isEmpty())
                        procesoActual=ejecutaProcesos();
                        procesoActual.quantumProceso=0;
                }
            }else{
                if(s.equalsIgnoreCase("SJF")||(s.equalsIgnoreCase("SRT"))){
                    if(procesoActual.acumInstrEjecutadas>=procesoActual.instrXProceso){
                        procesoActual=ejecutaProcesos();
                    }
                }else{
                    if(s.equalsIgnoreCase("HRRN")){
                        if(procesoActual.acumInstrEjecutadas>=procesoActual.instrXProceso){
                            procesoActual=ejecutaProcesos();
                        }else{
                            for (int i= 0; i < listaDeProcesos.size(); i++) {
                                if((i+1)==procesoActual.idProceso){
                                    procesoActual.tEspera=0;
                                }else{
                                    p=(DisenoProceso)listaDeProcesos.get(i);
                                    p.tEspera++;
                                }
                            }
                        }
                    }else{
                        if(s.equalsIgnoreCase("Prueba")){
                        //
                    }else{
                        if(s.equalsIgnoreCase("FIFO")){
                            if(procesoActual.acumInstrEjecutadas>=procesoActual.instrXProceso){
                                ejecutaProcesos();
                            }
                        }
                    }
                }
            }
        }
    }
    }else{
            b=false;
    }
       tiempo.aumentaTiempo();
       return b;
    }

    public boolean todosBloqueados(){
        boolean b;
        int cont=0;

        for (int i=0; i<listaDeProcesos.size();i++) {
            if(((DisenoProceso)(listaDeProcesos.get(i))).estadoProceso.equalsIgnoreCase("Blocked")||((DisenoProceso)(listaDeProcesos.get(i))).estadoProceso.equalsIgnoreCase("Finished"))
            cont++;
        }
        if(cont>=listaDeProcesos.size()){
            b=true;
        }else{
            b=false;
        }
        return b;
    }
}
