//Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.qcmarcel.ManagerSoft.Model;

import com.qcmarcel.ManagerSoft.Controller.Dataset;

/**
 *
 * @author Márcel
 */


public class Kind {
    public String [] getKind(){        
        String[] M_Kind = new Dataset().valores("T_kind","name_kind","name_kind");
        return M_Kind;        
    }
}
