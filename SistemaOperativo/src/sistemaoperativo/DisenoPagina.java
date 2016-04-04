package sistemaoperativo;

public class DisenoPagina {
    public int numPag;
    public boolean bResid;
    public boolean bLect;
    public boolean bRef;
    public int contAccesos;
    public String tEntrada;
    public String tUltimaLect;

    public DisenoPagina (int p_numPagina, boolean p_bitResidencia, String p_tiempoEntrada){
        numPag=p_numPagina;
        bResid=p_bitResidencia;
        bLect=false;
        bRef=false;
        contAccesos=0;
        tEntrada=p_tiempoEntrada;
        tUltimaLect=p_tiempoEntrada;
    }

    public void pasaMReal(String p_ultimoAcceso){
        bResid = true;
        //numAccesos++;
        tUltimaLect = p_ultimoAcceso;
    }
    public void saleMReal(){
        bResid=false;
    }

}

