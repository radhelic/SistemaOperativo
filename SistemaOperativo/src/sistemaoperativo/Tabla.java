/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaoperativo;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import static sistemaoperativo.Interfaz.bitResPag0Proc1;

/**
 *
 * @author Erick
 */
public class Tabla extends DefaultTableCellRenderer{

    static void getTableCellRendererComponent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Component cell;

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
       cell= super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
    return cell;
    }
    
}
