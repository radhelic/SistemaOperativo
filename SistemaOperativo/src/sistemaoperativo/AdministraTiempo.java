package sistemaoperativo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;

/**
 *
 * @author JCMA
 */
public class AdministraTiempo {
    public String tiempoSistema;
    
  //Asigna la hora de entrada
    public String horaLlegada(){
        Calendar horario= Calendar.getInstance();
        String hh=""+horario.get(Calendar.HOUR_OF_DAY);
        String mm=""+horario.get(Calendar.MINUTE);
        String ss=""+horario.get(Calendar.SECOND);

        if(horario.get(Calendar.HOUR_OF_DAY)<10) hh="0"+hh;
        if(horario.get(Calendar.MINUTE)<10) mm="0"+mm;
        if(horario.get(Calendar.SECOND)<10) ss="0"+ss;
        tiempoSistema=hh+":"+mm+":"+ss;
        return tiempoSistema;
    }

    public void aumentaTiempo(){
        int hora=0;
        int minuto=0;
        int segundo=0;
        String hs="";
        String ms="";
        String ss="";
        hora 	=  (Integer.parseInt(String.valueOf(tiempoSistema.charAt(0)))*10)+
        		   (Integer.parseInt(String.valueOf(tiempoSistema.charAt(1))));
        minuto  =  (Integer.parseInt(String.valueOf(tiempoSistema.charAt(3)))*10)+
        		   (Integer.parseInt(String.valueOf(tiempoSistema.charAt(4))));
        segundo =  (Integer.parseInt(String.valueOf(tiempoSistema.charAt(6)))*10)+
                   (Integer.parseInt(String.valueOf(tiempoSistema.charAt(7))));

        segundo = segundo + 1;

        if(segundo == 60){
            segundo=0;
            minuto++;
            if(minuto==60){
                minuto=0;
                hora++;
            }
        }

        if((hora < 10)&&(hora > 0)){ hs = "0"+hora;}
        else{
            if(hora==0) hs="00";
            else{
                hs = "" + hora;
            }
        }

           if((minuto<10)&&(minuto>0)){ ms="0"+minuto;}
           else{
               if(minuto==0){ms="00";}
               else{ms=""+minuto;}
           }

           if((segundo<10)&&(segundo>0)){ ss="0"+segundo;}
           else{
               if(segundo==0){ss="00";}
               else{ss=""+segundo;}
           }

           tiempoSistema = hs+":"+ms+":"+ss;
    }    
}

