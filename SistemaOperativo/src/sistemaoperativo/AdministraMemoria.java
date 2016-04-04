package sistemaoperativo;

import java.util.ArrayList;

public class AdministraMemoria {
    public ArrayList listaProcesos;
    public AdministraAlgoritmos administrador;
    public DisenoPagina paginaCargada;
    public int maxAccesos=999999;
    int aux1,aux2;
    
    public AdministraMemoria(AdministraAlgoritmos p_procesador,ArrayList p_procesos){
        listaProcesos=p_procesos;
        administrador=p_procesador;
    }
    public DisenoPagina buscaPagina(DisenoProceso procesoActual, int numInstruccion){
        int pagBuscada=(int) Math.floor(((double)numInstruccion)/((double)administrador.tamPag));
        if(numInstruccion%administrador.tamPag==0)
            pagBuscada--;
        DisenoPagina pagina=procesoActual.arregloPaginas[pagBuscada];
        return pagina;
    }
    public boolean obtenerPagina(DisenoProceso procesoActual, int numInstruccion,String p_ultimoAcceso){
        DisenoPagina pagina= buscaPagina(procesoActual,numInstruccion);
        boolean b2=false;
        if(!pagina.bResid){
          reemplazoProcesos(procesoActual,pagina,p_ultimoAcceso);
        } else{
            paginaCargada=pagina;
            b2=true;
        }
        return b2;
    }
    private void reemplazoProcesos(DisenoProceso procesoActual, DisenoPagina paginaACargar, String p_ultimoAcceso){
        String s=administrador.algoritmoReemplazo;
        int i,r=0;
        int a,b=0;
        int n=procesoActual.pagXProceso;
        String tiempo="99:99:99";
        maxAccesos=999999;

        if(s.equalsIgnoreCase("FIFO")){
            for (i = 0; i < n; i++) {
                if(procesoActual.arregloPaginas[i].bResid){
                    if((tiempo.compareTo(procesoActual.arregloPaginas[i].tEntrada))>0){
                        tiempo=procesoActual.arregloPaginas[i].tEntrada;
                        r=i;
                    }
                }
            }
            procesoActual.arregloPaginas[r].saleMReal();
            paginaACargar.pasaMReal(p_ultimoAcceso);
        }//Fin FIFO
        else{
            if(s.equalsIgnoreCase("LRU")){
                for (i = 0; i < n; i++) {
                        if(procesoActual.arregloPaginas[i].bResid){
                            if((tiempo.compareTo(procesoActual.arregloPaginas[i].tUltimaLect))>0){
                                tiempo=procesoActual.arregloPaginas[i].tUltimaLect;
                                r=i;
                            
                            }
                        }
                    }
                procesoActual.arregloPaginas[r].saleMReal();
                paginaACargar.pasaMReal(p_ultimoAcceso);
            }//Fin LRU
            else{
                if(s.equalsIgnoreCase("LFU")){
                    for (i = 0; i < n; i++) {
                        if(procesoActual.arregloPaginas[i].bResid){
                            if(maxAccesos>procesoActual.arregloPaginas[i].contAccesos){
                                maxAccesos=procesoActual.arregloPaginas[i].contAccesos;
                                r=i;
                            }
                        }
                    }
                    procesoActual.arregloPaginas[r].saleMReal();
                    paginaACargar.pasaMReal(p_ultimoAcceso);
                }else{
                    if(s.equalsIgnoreCase("NRU")){
                        for (i = 0; i < n; i++) {
                            if(procesoActual.arregloPaginas[i].bResid){
                                if(!procesoActual.arregloPaginas[i].bLect){
                                    r=i;
                                }
                            }
                        }
                        procesoActual.arregloPaginas[r].saleMReal();
                        paginaACargar.pasaMReal(p_ultimoAcceso);
                    }else{
                        if(s.equalsIgnoreCase("2dC")){
                            boolean seguir=true;
                            do{
                                for (i = 0; i < n; i++){
                                    //encuentra la p�gina m�s vieja con BR true
                                    if(procesoActual.arregloPaginas[i].bResid){
                                        if((tiempo.compareTo(procesoActual.arregloPaginas[i].tEntrada))>0){
                                            tiempo=procesoActual.arregloPaginas[i].tEntrada;
                                            r=i;
                                        }
                                    }
                                }
                                if(procesoActual.arregloPaginas[r].bRef){
                                    //limpia el bit de referencia y cambia TE por el tiempo actual
                                    procesoActual.arregloPaginas[r].bRef=false;
                                    procesoActual.arregloPaginas[r].tEntrada=p_ultimoAcceso;
                                    tiempo="99:99:99";
                                }else{
                                    seguir=false;
                                }
                            }while(seguir);

                            procesoActual.arregloPaginas[r].saleMReal();
                            paginaACargar.pasaMReal(p_ultimoAcceso); 
                        }else{
                            //
                        }
                    }
                }
            }
        }
    }
    public boolean ejecutarInstruccion(DisenoProceso procesoActual ,int numInstruccion,String p_ultimoAcceso){
        boolean x=false;
        if(!listaProcesos.isEmpty()){
            if(obtenerPagina(procesoActual,numInstruccion,p_ultimoAcceso)){
            paginaCargada.bLect=true;
            paginaCargada.contAccesos++;
            paginaCargada.tUltimaLect = p_ultimoAcceso;
            paginaCargada.bRef=true;
            x=true;
            }
        }
       return x;
    }

    public int restaValor(String p_tiempo){
        int h=0;
        int m=0;
        int s=0;
        int tiempoNum=0;

        h=  (Integer.parseInt(String.valueOf(p_tiempo.charAt(0)))*10)+
            (Integer.parseInt(String.valueOf(p_tiempo.charAt(1))));
        m=  (Integer.parseInt(String.valueOf(p_tiempo.charAt(3)))*10)+
            (Integer.parseInt(String.valueOf(p_tiempo.charAt(4))));
        s=  (Integer.parseInt(String.valueOf(p_tiempo.charAt(6)))*10)+
            (Integer.parseInt(String.valueOf(p_tiempo.charAt(7))));

        tiempoNum=(h*10000)+(m*100)+(s);

        return tiempoNum;
    }

    //SUPER CODIGO SUPER REPETIDO SUPER (BORRABLE)
    public int reemplazoProcesosV2(DisenoProceso xprocesoActual, String xp_ultimoAcceso){
        String s=administrador.algoritmoReemplazo;
        int i,r=0;
        int a,b=0;
        int n=xprocesoActual.pagXProceso;
        String tiempo="99:99:99";
        maxAccesos=999999;

        if(s.equalsIgnoreCase("FIFO")){
            for (i = 0; i < n; i++) {
                if(xprocesoActual.arregloPaginas[i].bResid){
                    if((tiempo.compareTo(xprocesoActual.arregloPaginas[i].tEntrada))>0){
                        tiempo=xprocesoActual.arregloPaginas[i].tEntrada;
                        r=i;
                    }
                }
            }
        }//Fin FIFO
        else{
            if(s.equalsIgnoreCase("LRU")){
                for (i = 0; i < n; i++) {
                        if(xprocesoActual.arregloPaginas[i].bResid){
                            if((tiempo.compareTo(xprocesoActual.arregloPaginas[i].tUltimaLect))>0){
                                tiempo=xprocesoActual.arregloPaginas[i].tUltimaLect;
                                r=i;
                            }
                        }
                    }
            }//Fin LRU
            else{
                if(s.equalsIgnoreCase("LFU")){
                    for (i = 0; i < n; i++) {
                        if(xprocesoActual.arregloPaginas[i].bResid){
                            if(maxAccesos>xprocesoActual.arregloPaginas[i].contAccesos){
                                maxAccesos=xprocesoActual.arregloPaginas[i].contAccesos;
                                r=i;
                            }
                        }
                    }
                }else{
                    if(s.equalsIgnoreCase("NRU")){
                        for (i = 0; i < n; i++) {
                            if(xprocesoActual.arregloPaginas[i].bResid){
                                if(!xprocesoActual.arregloPaginas[i].bLect){
                                    r=i;
                                }
                            }
                        }
                    }else{
                        if(s.equalsIgnoreCase("2dC")){
                            boolean seguir=true;
                            do{
                                for (i = 0; i < n; i++){
                                    //encuentra la p�gina m�s vieja con BR true
                                    if(xprocesoActual.arregloPaginas[i].bResid){
                                        if((tiempo.compareTo(xprocesoActual.arregloPaginas[i].tEntrada))>0){
                                            tiempo=xprocesoActual.arregloPaginas[i].tEntrada;
                                            r=i;
                                        }
                                    }
                                }
                                if(xprocesoActual.arregloPaginas[r].bRef){
                                    //limpia el bit de referencia y cambia TE por el tiempo actual
                                    xprocesoActual.arregloPaginas[r].bRef=false;
                                    xprocesoActual.arregloPaginas[r].tEntrada=xp_ultimoAcceso;
                                    tiempo="99:99:99";
                                }else{
                                    seguir=false;
                                }
                            }while(seguir);
                        }else{
                            //
                        }
                    }
                }
            }
        }
        return r;
    }
    public int identificaReemplazo(DisenoProceso procesoActual ,int numInstruccion,String p_ultimoAcceso){
        //boolean x=false;
        DisenoPagina xpagina=null;
        int r=0;
        if(!listaProcesos.isEmpty()){
            xpagina= regresaPagina(procesoActual,numInstruccion);
//            if(!xpagina.bitResidencia){
              r=reemplazoProcesosV2(procesoActual,p_ultimoAcceso);
//            }
//            else{
                //paginaActual=pagina;
//                r=-1;
                        //xpagina.numPagina;
//            }
        }
       return r;
    }
    public DisenoPagina regresaPagina(DisenoProceso xprocesoActual, int xnumInstruccion){
        int pagBuscada=(int) Math.floor(((double)xnumInstruccion)/((double)administrador.tamPag));
        if(xnumInstruccion%administrador.tamPag==0)
            pagBuscada--;
        DisenoPagina xpagina=xprocesoActual.arregloPaginas[pagBuscada];
        return xpagina;
    }
    //HASTA AQU� CODIGO SUPER SUPER BORRABLE ALIAS PARCHEZOTE 2
}
