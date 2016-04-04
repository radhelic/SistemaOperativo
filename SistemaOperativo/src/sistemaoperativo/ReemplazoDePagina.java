package sistemaoperativo;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MajoCarmen
 */
import java.util.ArrayList;

public class ReemplazoDePagina {
    public ArrayList procesosEnLista;
    public AdministraAlgoritmos algoritmo;
    public DisenoPagina paginaActual;
    public int maximosAccesos=999999;
    int varAux1,varAux2;

    public ReemplazoDePagina(AdministraAlgoritmos p_procesador,ArrayList p_procesos){
        procesosEnLista=p_procesos;
        algoritmo=p_procesador;
    }
    public DisenoPagina localizaPagina(DisenoProceso procesoActual, int numInstruccion){
        int pagBuscada=(int) Math.floor(((double)numInstruccion)/((double)algoritmo.tamPag));
        if(numInstruccion%algoritmo.tamPag==0)
            pagBuscada--;
        DisenoPagina pagina=procesoActual.arregloPaginas[pagBuscada];
        return pagina;
    }

    public int ejecutaReemplazo(DisenoProceso procesoActual, DisenoPagina paginaACargar, String p_ultimoAcceso){
        String s=algoritmo.algoritmoReemplazo;
        int i,r=0;
        int a,b=0;
        int n=procesoActual.pagXProceso;
        String tiempo="99:99:99";

        if(s.equalsIgnoreCase("FIFO")){
            for (i = 0; i < n; i++) {
                if(procesoActual.arregloPaginas[i].bResid){
                    if((tiempo.compareTo(procesoActual.arregloPaginas[i].tEntrada))>0){
                        tiempo=procesoActual.arregloPaginas[i].tEntrada;
                        r=i;
                    }
                }
            }
        }//Fin FIFO
        else{
            if(s.equalsIgnoreCase("LRU")){
                for (i = 0; i < n; i++) {
                        if(procesoActual.arregloPaginas[i].bResid){
                            if((tiempo.compareTo(procesoActual.arregloPaginas[i].tUltimaLect))>0){
                                tiempo=procesoActual.arregloPaginas[i].tUltimaLect;
                                r=i;
                                //TablaPaginas.cambioPag(String.valueOf(r));

                            }
                        }
                    }
            }//Fin LRU
            else{
                if(s.equalsIgnoreCase("LFU")){
                    for (i = 0; i < n; i++) {
                        if(procesoActual.arregloPaginas[i].bResid){
                            if(maximosAccesos>procesoActual.arregloPaginas[i].contAccesos){
                                maximosAccesos=procesoActual.arregloPaginas[i].contAccesos;
                                r=i;
                            }
                        }
                    }
                }else{
                    if(s.equalsIgnoreCase("NRU")){
                        for (i = 0; i < n; i++) {
                            if(procesoActual.arregloPaginas[i].bResid){
                                if(!procesoActual.arregloPaginas[i].bLect){
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
                        }else{
                            if(s.equalsIgnoreCase("LPN")){
                                for (i = 0; i < n; i++) {
                                    if(procesoActual.arregloPaginas[i].bResid){
                                        a=(puntosRecompensa(p_ultimoAcceso)-
                                                puntosRecompensa(procesoActual.arregloPaginas[i].tUltimaLect))+
                                                procesoActual.arregloPaginas[i].contAccesos;
                                        b=(puntosRecompensa(p_ultimoAcceso)-
                                                puntosRecompensa(procesoActual.arregloPaginas[r].tUltimaLect))+
                                                procesoActual.arregloPaginas[r].contAccesos;
                                        if(a<=b){
                                                r=i;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return r;
    }
    public int paginaAReemplazar(DisenoProceso procesoActual ,int numInstruccion,String p_ultimoAcceso){
        //boolean x=false;
        DisenoPagina pagina=null;
        int r=0;
        if(!procesosEnLista.isEmpty()){
            pagina= localizaPagina(procesoActual,numInstruccion);
            if(!pagina.bResid){
              r=ejecutaReemplazo(procesoActual,pagina,p_ultimoAcceso);
            } else{
                paginaActual=pagina;
                r=pagina.numPag;
            }
        }
       return r;
    }

    public int puntosRecompensa(String p_tiempo){
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
}

