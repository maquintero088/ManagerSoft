//Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package Model;

import Controller.Dataset;

/**
 *
 * @author Márcel
 */


public class Period {
    public String [] getPeriod(){        
        String[] M_Period = new Dataset().valores("T_period","name_period","name_period");
        return M_Period;        
    }
}
