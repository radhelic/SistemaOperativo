package sistemaoperativo;


public class AdministraAlgoritmos {
        public int tamPag = 0;
        public int quantumSistema=0;
        public String algoritmoScheduling;
        public String algoritmoReemplazo;
        
        AdministraAlgoritmos (int p_tamanoPagina, int p_quantum, String p_scheduleAlgorithm, String p_replaceAlgorithm){
            tamPag = p_tamanoPagina;
            quantumSistema = p_quantum;
            algoritmoScheduling = p_scheduleAlgorithm;
            algoritmoReemplazo = p_replaceAlgorithm;
        }
}

