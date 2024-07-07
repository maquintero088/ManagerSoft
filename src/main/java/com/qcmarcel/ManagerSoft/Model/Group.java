 //Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.qcmarcel.ManagerSoft.Model;

import com.qcmarcel.ManagerSoft.Controller.Dataset;

/**
 *
 * @author Márcel
 */


public class Group {
    public void setGroup(String [] V_Group){        
        new Dataset().editar("name_group,state_group","t_group","'"+V_Group[0]+"','"+V_Group[1]+"'",1);
    }
    public void updateGroup(String [] V_Group){        
        new Dataset().editar("name_group = '"+V_Group[1]+"' ,state_group = '"+V_Group[2]+"'","t_group","id_group = "+V_Group[0],2);
    }
    public String [] getGroup(String column){        
        System.out.println("-> dentro de getGroup ("+column+")");        
        String[] v_Group = new Dataset().valores("t_group", column, column);
        return v_Group;        
    }
    public String [][] getGroup(String column,String value){        
        System.out.println("-> dentro de getGroup ("+column+","+value+")");   
        int rows = new Dataset().rows("t_group where lower("+column+") like '"+value.toLowerCase().substring(0, 1)+"%' order by id_group","id_group");
        String[][] M_Group = new String [rows][3];
        String [] 
                Groups_id_Strings = new Dataset().valores("t_group where lower("+column+") like '"+value.toLowerCase().substring(0, 1)+"%' order by id_group", "id_group", "id_group"),
                Groups_name_Strings = new Dataset().valores("t_group where lower("+column+") like '"+value.toLowerCase().substring(0, 1)+"%' order by id_group", "name_group", "name_group"),
                Groups_state_Strings = new Dataset().valores("t_group where lower("+column+") like '"+value.toLowerCase().substring(0, 1)+"%' order by id_group", 
                        "(case when (state_group = 1) then 'activo' else 'inactivo' end)", "(case when (state_group = 1) then 'activo' else 'inactivo' end)");
        for(int count = 0; count<Groups_id_Strings.length;count++){
            M_Group[count][0]=Groups_name_Strings[count];
            M_Group[count][1]=Groups_state_Strings[count];
            M_Group[count][2]=Groups_id_Strings[count];
        }
        return M_Group;         
    }
    public String [][] getXGroup(String [] columns,String [] values){        
        System.out.println("-> dentro de getXGroup ("+columns.length+","+values.length+")");   
        String where = "lower("+columns[0]+") like '"+values[0].toLowerCase().substring(0, 1)+"%' and "+columns[1]+" = "+values[1];
        int rows = new Dataset().rows("t_group where "+where+" order by id_group","id_group");
        String[][] M_Group = new String [rows][3];
        String [] 
                Groups_id_Strings = new Dataset().valores("t_group where "+where+" order by id_group", "id_group", "id_group"),
                Groups_name_Strings = new Dataset().valores("t_group where "+where+" order by id_group", "name_group", "name_group"),
                Groups_state_Strings = new Dataset().valores("t_group where "+where+" order by id_group", 
                        "(case when (state_group = 1) then 'activo' else 'inactivo' end)", "(case when (state_group = 1) then 'activo' else 'inactivo' end)");
        for(int count = 0; count<Groups_id_Strings.length;count++){
            M_Group[count][0]=Groups_name_Strings[count];
            M_Group[count][1]=Groups_state_Strings[count];
            M_Group[count][2]=Groups_id_Strings[count];
        }
        return M_Group;         
    }
    public String [][] getVGroup(String column,String value){        
        System.out.println("-> dentro de getGroup ("+column+","+value+")");   
        int rows = new Dataset().rows("t_group where "+column+" = '"+value+"' order by id_group","id_group");
        String[][] M_Group = new String [rows][3];
        String [] 
                Groups_id_Strings = new Dataset().valores("t_group where "+column+" = '"+value+"' order by id_group", "id_group", "id_group"),
                Groups_name_Strings = new Dataset().valores("t_group where "+column+" = '"+value+"' order by id_group", "name_group", "name_group"),
                Groups_state_Strings = new Dataset().valores("t_group where "+column+" = '"+value+"' order by id_group", 
                        "state_group", "state_group");
        for(int count = 0; count<Groups_id_Strings.length;count++){
            M_Group[count][0]=Groups_name_Strings[count];
            M_Group[count][1]=Groups_state_Strings[count];
            M_Group[count][2]=Groups_id_Strings[count];
        }
        return M_Group;         
    }
}
