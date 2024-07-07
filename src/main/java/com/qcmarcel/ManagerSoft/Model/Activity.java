//Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.qcmarcel.ManagerSoft.Model;

import com.qcmarcel.ManagerSoft.Controller.Dataset;

/**
 *
 * @author Márcel
 */


public class Activity {
    public void setActivity(String [] V_Activity){
        new Dataset().editar(
                "fk_kind,fk_group,date_activity,start_activity,fk_period,description_activity",
                "t_activity",
                V_Activity[2]+","+V_Activity[3]+",'"+V_Activity[0]+"','"+V_Activity[1]+"',"+V_Activity[4]+",'"+V_Activity[5]+"'",
                1);
    }
    public void updateActivity(String [] V_Activity){
        new Dataset().editar(
                "fk_kind = "+V_Activity[3]+" , fk_group = "+V_Activity[4]+" ,date_activity = '"+V_Activity[1]+"' ,start_activity = '"+V_Activity[2]+"' ,fk_period = "+V_Activity[5]+",description_activity = '"+V_Activity[6]+"'",
                "t_activity",
                "id_activity = "+V_Activity[0],
                2);
    }
    public String [] getActivity(String column){ 
        System.out.println("-> dentro de getActivity ("+column+")");                
        String[] v_Activity = new Dataset().valores("v_activity", column, column);
        return v_Activity;        
    }
    public String [][] getVActivity(String column,String value){ 
        System.out.println("-> dentro de getVActivity ("+column+","+value+")");
        int rows = new Dataset().rows("v_activity where "+column+" = '"+value+"' order by Id","Id");
        String[][] M_Activity = new String [rows][4];
        String [] 
                Activities_id_Strings = new Dataset().valores("v_activity where "+column+" = '"+value+"' order by Id", "Id", "Id"),
                Activities_date_Strings = new Dataset().valores("v_activity where "+column+" = '"+value+"' order by Id", "fecha_hora", "fecha_hora"),
                Activities_name_Strings = new Dataset().valores("v_activity where "+column+" = '"+value+"' order by Id", "actividad", "actividad"),
                Activities_group_Strings = new Dataset().valores("v_activity where "+column+" = '"+value+"' order by Id", "grupo", "grupo");
        for(int count = 0; count<Activities_id_Strings.length;count++){
            M_Activity[count][0]=Activities_date_Strings[count];
            M_Activity[count][1]=Activities_name_Strings[count];
            M_Activity[count][2]=Activities_group_Strings[count];
            M_Activity[count][3]=Activities_id_Strings[count];
        }
        return M_Activity;        
    }
    public String [][] getXActivity(String [] columns,String [] values){ 
        System.out.println("-> dentro de getXActivity ("+columns.length+","+values.length+")");
        String where = "";
        for(int count = 0; count < columns.length; count++){
            if(values[count].equals("0")){
                
            }else{
                if((count+1)==columns.length||count==0){                    
                    where = where+" ";
                }else{                    
                    where = where+" and ";
                }
                where = where+columns[count]+" = '"+values[count]+"'";
            }
        }
        int rows = new Dataset().rows("v_activity where "+where+" order by Id","Id");
        String[][] M_Activity = new String [rows][4];
        String [] 
                Activities_id_Strings = new Dataset().valores("v_activity where "+where+" order by Id", "Id", "Id"),
                Activities_date_Strings = new Dataset().valores("v_activity where "+where+" order by Id", "fecha_hora", "fecha_hora"),
                Activities_name_Strings = new Dataset().valores("v_activity where "+where+" order by Id", "actividad", "actividad"),
                Activities_group_Strings = new Dataset().valores("v_activity where "+where+" order by Id", "grupo", "grupo");
        for(int count = 0; count<Activities_id_Strings.length;count++){
            M_Activity[count][0]=Activities_date_Strings[count];
            M_Activity[count][1]=Activities_name_Strings[count];
            M_Activity[count][2]=Activities_group_Strings[count];
            M_Activity[count][3]=Activities_id_Strings[count];
        }
        return M_Activity;        
    }
    public String [][] getActivity(String column,String value){ 
        System.out.println("-> dentro de getActivity ("+column+","+value+")");
        int rows = new Dataset().rows("t_activity where "+column+" = '"+value+"' order by id_activity","id_activity");
        String[][] M_Activity = new String [rows][7];
        String [] 
                Activities_id_Strings = new Dataset().valores("t_activity where "+column+" = '"+value+"' order by id_activity", "id_activity", "id_activity"),
                Activities_kind_Strings = new Dataset().valores("t_activity where "+column+" = '"+value+"' order by id_activity", "fk_kind", "fk_kind"),
                Activities_group_Strings = new Dataset().valores("t_activity where "+column+" = '"+value+"' order by id_activity", "fk_group", "fk_group"),
                Activities_date_Strings = new Dataset().valores("t_activity where "+column+" = '"+value+"' order by id_activity", "date_activity", "date_activity"),
                Activities_start_Strings = new Dataset().valores("t_activity where "+column+" = '"+value+"' order by id_activity", "start_activity", "start_activity"),
                Activities_period_Strings = new Dataset().valores("t_activity where "+column+" = '"+value+"' order by id_activity", "fk_period", "fk_period"),
                Activities_description_Strings = new Dataset().valores("t_activity where "+column+" = '"+value+"' order by id_activity", "description_activity", "description_activity");
        for(int count = 0; count<Activities_id_Strings.length;count++){
            M_Activity[count][0]=Activities_kind_Strings[count];
            M_Activity[count][1]=Activities_group_Strings[count];            
            M_Activity[count][2]=Activities_date_Strings[count];
            M_Activity[count][3]=Activities_start_Strings[count];
            M_Activity[count][4]=Activities_period_Strings[count];            
            M_Activity[count][5]=Activities_description_Strings[count];
            M_Activity[count][6]=Activities_id_Strings[count];
        }
        return M_Activity;        
    }
}
