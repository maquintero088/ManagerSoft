// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.qcmarcel.ManagerSoft.View;

import com.qcmarcel.ManagerSoft.Controller.Dataset;
import com.qcmarcel.ManagerSoft.Model.Activity;
import com.qcmarcel.ManagerSoft.Model.Group;
import com.qcmarcel.ManagerSoft.Model.Kind;
import com.qcmarcel.ManagerSoft.Model.Schedule;


/**
 *
 * @author Márcel
 */


public class Modify {
   private String page_string; 
    private int validate;
    public String init(int Model){ 
        switch(Model){
            case 1 -> {
                String [] isGroup = new Group().getGroup("id_group");
                if(isGroup==null){
                    page_string=""
                            + "<div>"
                            + "     <p>Sr. :</p>"
                            + "     <p>There are no any Groups enable.</p>"
                            + "</div>";
                }else{
                    page_string=""
                            + "<form action=\"groups.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"search\"/>"
                            + "<div>"
                            + "     <table>"
                            + "         <tr>"
                            + "             <td colspan=\"2\"><h3>1. type group name.</h3></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td><label>Group Name: </label></td>"
                            + "             <td><input type=\"text\" name=\"input_name_group\" pattern=\"[A-z- ]+\" required/></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td> </td>"
                            + "             <td><input type=\"submit\" class=\"bt3\" name=\"submit_init_group\" value=\"Search\"/> </td>"
                            + "         </tr>"
                            + "     </table>"
                            + "</div>"
                            + "</form>";
                }
           }
            case 2 -> {
                String [] isActivity = new Activity().getActivity("Id");
                if(isActivity==null){
                    page_string=""
                            + "<div>"
                            + "     <p>Sr. :</p>"
                            + "     <p>There are no any Activities enable.</p>"
                            + "</div>";
                }else{
                    String [] kind_Strings = new Kind().getKind();
                    String Result_kind="";
                    if(kind_Strings==null){
                        Result_kind = "<option> empty </option>";
                    }else{                    
                        for (String kind_String : kind_Strings) {
                            Result_kind = Result_kind+"<option value=\"" + kind_String + "\">" + kind_String + "</option>\n";
                        }
                    }
                    page_string=""
                            + "<form action=\"activities.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"search\"/>"
                            + "<div>"
                            + "     <table>"
                            + "         <tr>"
                            + "             <td colspan=\"2\"><h3>1. Choose a kind of activity.</h3></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td><label>Kind of Activity: </label></td>"
                            + "             <td><select name=\"select_kind_activity\">"
                            + "                     "+Result_kind
                            + "                 </select></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td></td>"
                            + "             <td><input type=\"submit\" class=\"bt3\" name=\"submit_init_activity\" value=\"Search\"/> </td>"
                            + "         </tr>"
                            + "     </table>"
                            + "</div>"
                            + "</form>";
                }
           }
        }
        return page_string;  
    }
    public String search(String column,String value,int Model){
        System.out.println("-> dentro de search("+column+","+value+","+Model+")");  
        switch(Model){
            case 1 -> {
                String[][] Group_Strings = new Group().getGroup(column,value);
                String Result_Group = "";
            switch (Group_Strings.length) {
                case 0 -> Result_Group = "<tr><td> empty </td></tr>"
                            + "<tr><td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp\"/></td></tr>";
                case 1 -> Result_Group = ""
                            + "<tr>"
                            + "<td>"
                            + "<input type=\"hidden\" name=\"input_group_chosen\" value=\""+Group_Strings[0][2]+"\"/>"
                            + "<input type=\"submit\" class=\"list\" name=\"submit_group_chosen\" value=\""+Group_Strings[0][0]+"\" />"
                            + "</td>"
                            + "</tr>\n";
                default -> {
                    for (String[] Group_String : Group_Strings) {
                        if (Group_String[0] == null) {
                        } else {
                            Result_Group = Result_Group+""
                                    + "<tr>"
                                    + "<td>"
                                    + "<input type=\"hidden\" name=\"input_group_chosen\" value=\"" + Group_String[2] + "\"/>" + "<input type=\"submit\" class=\"list\" name=\"submit_group_chosen\" value=\"" + Group_String[0] + "\" />" + "</td>" + "</tr>\n";
                        }
                    }
                }
            }
                page_string=""
                        + "<form action=\"groups.jsp\" method=\"post\">"
                        + "<input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"edit\"/>"
                        + "<div class=\"blanco\">"
                        + "     <table class=\"marco\">"
                        + "         <tr>"
                        + "             <td class=\"Verde\">"
                        + "                 <h2>Groups</h2>"
                        + "                 <hr>"
                        + "             </td>"
                        + "         </tr>"
                        + "         <tr>"
                        + "             <td colspan=\"2\"><h3>2. Choose group item.</h3></td>"
                        + "         </tr>"
                        + "         <tr><td><table>"
                        + Result_Group
                        + "         </table></td></tr>"  
                        + "     </table>"
                        + "</div>"
                        + "</form>";
           }
            case 2 -> {
                String[][] Activity_Strings = new Activity().getVActivity(column,value);
                String Result_Activity = "";
            switch (Activity_Strings.length) {
                case 0 -> Result_Activity = "<tr><td> empty </td></tr>"
                            + "<tr><td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp'\"/></td></tr>";
                case 1 -> Result_Activity = ""
                            + "<tr>"
                            + "<td>"
                            + "<input type=\"hidden\" name=\"input_activity_chosen\" value=\""+Activity_Strings[0][3]+"\"/>"
                            + "<input type=\"submit\" class=\"list\" name=\"submit_activity_chosen\" value=\""+Activity_Strings[0][0]+"|"+Activity_Strings[0][1]+"|"+Activity_Strings[0][2]+"\" />"
                            + "</td>"
                            + "</tr>\n";
                default -> {
                    for (String[] Activity_String : Activity_Strings) {
                        if (Activity_String[0] == null) {
                        } else {
                            Result_Activity = Result_Activity+""
                                    + "<tr>"
                                    + "<td>"
                                    + "<input type=\"hidden\" name=\"input_activity_chosen\" value=\"" + Activity_String[3] + "\"/>" + "<input type=\"submit\" class=\"list\" name=\"submit_activity_chosen\" value=\"" + Activity_String[0] + "|" + Activity_String[1] + "|" + Activity_String[2] + "\" />" + "</td>" + "</tr>\n";                   
                        }
                    }
                }
            }
                page_string=""
                        + "<form action=\"activities.jsp\" method=\"post\">"
                        + "<input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"edit\"/>"
                        + "<div class=\"blanco\">"
                        + "     <table class=\"marco\">"
                        + "         <tr>"
                        + "             <td class=\"Verde\">"
                        + "                 <h2>Activities</h2>"
                        + "                 <hr>"
                        + "             </td>"
                        + "         </tr>"
                        + "         <tr>"
                        + "             <td colspan=\"2\"><h3>2. Choose activity item.</h3></td>"
                        + "         </tr>"
                        + "         <tr><td><table>"
                        + Result_Activity
                        + "         </table></td></tr>"
                        + "     </table>"
                        + "</div>"
                        + "</form>";
           }
        }
        return page_string; 
    }
    public String edit(String value,int Model){
        System.out.println("-> dentro de switch = "+Model);
        switch(Model){            
            case 1 -> {                
                System.out.println("-> dentro de validate");
                String [][] this_Group = new Group().getVGroup("id_group",value);
                String Result_State_Group;
                if("1".equals(this_Group[0][1])){
                    Result_State_Group = ""
                            + " <option selected value=\"1\">On</option>"
                            + "<option value=\"0\">Off</option>";
                }else{
                    Result_State_Group = ""
                            + " <option value=\"1\">On</option>"
                            + "<option selected value=\"0\">Off</option>";
                }
                page_string=""
                        + "<form action=\"groups.jsp\" method=\"post\">"
                        + "<input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"                        
                        + "<input type=\"hidden\" name=\"input_group_values\" value=\""+value+"\"/>"
                        + "<div class=\"formo\">"
                        + "<table>"
                        + "     <tr>"
                        + "             <td class=\"grisk\"colspan=\"2\"><h3>2. type group fields.</h3></td>"
                        + "     </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <label>Group Name:</label>"
                        + "         <input type=\"text\" name=\"input_group_values\" pattern=\"[A-z- ]+\" value=\""+this_Group[0][0]+"\" required/>"
                        + "     </td>"
                        + "     <td>"
                        + "         <label>State:</label>"
                        + "         <select name=\"input_group_values\">"
                        + Result_State_Group
                        + "         </select>"
                        + "     </td>"
                        + " </tr>"
                        + " <tr>"
                        + "     <td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp?action=Modify'\"/></td>"
                        + "     <td><input type=\"submit\" class=\"bt3\" name=\"submit_validate_group\" value=\"Next\"/> </td>"
                        + " </tr>"
                        + "</table>"
                        + "</div>"
                        + "</form>";
           }
            case 2 -> {
                String Result_Group="",Result_Kind="",Result_Period="";
                String [][] this_Activity = new Activity().getActivity("id_activity",value);
                String []
                        Group_Strings = new Dataset().valores("t_group order by id_group", "name_group", "name_group"),
                        Kind_Strings = new Dataset().valores("t_kind order by id_kind", "name_kind", "name_kind"),
                        Period_Strings = new Dataset().valores("t_period order by id_period", "name_period", "name_period"),
                        Group_Ints = new Dataset().valores("t_group order by id_group", "id_group", "id_group"),
                        Kind_Ints = new Dataset().valores("t_kind order by id_kind", "id_kind", "id_kind"),
                        Period_Ints = new Dataset().valores("t_period order by id_period", "id_period", "id_period");
                for(int count=0;count<Group_Ints.length;count++){
                    if(this_Activity[0][1].equals(Group_Ints[count]+"")){
                        Result_Group = Result_Group+""
                                + "<option selected value=\""+Group_Ints[count]+"\">"+Group_Strings[count]+"</option>\n";
                    }else{
                        Result_Group = Result_Group+""
                                + "<option value=\""+Group_Ints[count]+"\">"+Group_Strings[count]+"</option>\n";
                    }
                }
                for(int count=0;count<Kind_Ints.length;count++){
                    if(this_Activity[0][0].equals(Kind_Ints[count]+"")){
                        Result_Kind = Result_Kind+""
                                + "<option selected value=\""+Kind_Ints[count]+"\">"+Kind_Strings[count]+"</option>\n";
                    }else{
                        Result_Kind = Result_Kind+""
                                + "<option value=\""+Kind_Ints[count]+"\">"+Kind_Strings[count]+"</option>\n";
                    }
                }
                for(int count=0;count<Period_Ints.length;count++){
                    if(this_Activity[0][4].equals(Period_Ints[count]+"")){
                        Result_Period = Result_Period+""
                                + "<option selected value=\""+Period_Ints[count]+"\">"+Period_Strings[count]+"</option>\n";
                    }else{
                        Result_Period = Result_Period+""
                                + "<option value=\""+Period_Ints[count]+"\">"+Period_Strings[count]+"</option>\n";
                    }
                }
                page_string=""
                        + "<form action=\"activities.jsp\" method=\"post\">"
                        + "<input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"
                        + "<input type=\"hidden\" name=\"input_activity_values\" value=\""+value+"\"/>"
                        + "<div class=\"formo\">"
                        + "<table>"
                        + "         <tr>"
                        + "             <td class=\"grisk\"colspan=\"2\"><h3>2. type activity fields.</h3></td>"
                        + "         </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <label>Date:</label>"
                        + "         <input type=\"date\" name=\"input_activity_values\" value=\""+this_Activity[0][2]+"\" pattern=\"[0-9]{4}-[0-9]{2}-[0-9]{2}\" />"
                        + "     </td>"
                        + "     <td>"
                        + "         <label>Start time:</label>"
                        + "         <input type=\"time\" name=\"input_activity_values\" value=\""+this_Activity[0][3]+"\" pattern=\"[0-9]{2}:[0-9]{2}:[0-9]{2}\" />"
                        + "     </td>"
                        + " </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <label>Kind of Activity:</label>"
                        + "         <select name=\"input_activity_values\">"
                        + Result_Kind
                        + "         </select>"
                        + "     </td>"
                        + "     <td>"
                        + "         <label>Group:</label>"
                        + "         <select name=\"input_activity_values\">"
                        + Result_Group
                        + "         </select>"
                        + "     </td>"
                        + " </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <label>Period of Activity:</label>"
                        + "         <select name=\"input_activity_values\">"
                        + Result_Period
                        + "         </select>"
                        + "     </td>"
                        + "     <td>"
                        + "         <label>Description:</label>"
                        + "         <textarea rows=\"3\" cols=\"80\" name=\"input_activity_values\" required>"+this_Activity[0][5]+"</textarea>"
                        + "     </td>"
                        + " </tr>"
                        + " <tr>"
                        + "     <td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp?action=Modify'\"/></td>"
                        + "     <td><input type=\"submit\" class=\"bt3\" name=\"submit_validate_activity\" value=\"Next\"/> </td>"
                        + " </tr>"
                        + "</table>"
                        + "</div>"
                        + "</form>";
           }
        }
        return page_string;
    }
    public String event(String[] values,int Model){
        switch(Model){            
            case 1 -> {  
                String [] Name_Group = new Group().getGroup("name_group");
                for (String Name_Group1 : Name_Group) {
                    if (Name_Group1.toLowerCase().equals(values[1].toLowerCase())&&values[2].equals(new Group().getVGroup("id_group", values[0])[0][2])) {
                        validate=1;
                    }
                }    
                if(validate==1){
                    page_string=""
                            + "<article>"
                            + "     <table>"
                            + "         <tr>"
                            + "             <td colspan=\"2\"><h3>This action can´t do, the group name is repeated.</h3></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td colspan=\"2\">"
                            + "                 <p>¿Do you come back to group form?</p>"
                            + "             </td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td>"
                            + "                 <form action=\"groups.jsp\" method=\"post\">"
                            + "                     <input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                            + "                     <input type=\"hidden\" name=\"page\" value=\"edit\"/>"
                            + "                     <input type=\"hidden\" name=\"input_group_chosen\" value=\""+values[0]+"\"/>"
                            + "                     <input type=\"submit\" class=\"bt3\" name=\"submit_delete_event\" value=\"Yes\"/>"
                            + "                 </form>"
                            + "             </td>"
                            + "             <td>"
                            + "                 <form action=\"groups.jsp\" method=\"post\">"
                            + "                     <input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                            + "                     <input type=\"submit\" class=\"bt3\" name=\"submit_delete_event\" value=\"No\"/>"
                            + "                 </form>"
                            + "             </td>"
                            + "         </tr>"
                            + "     </table>"
                            + "</article>";
                }else{
                    new Group().updateGroup(values);                
                    page_string=""
                            + "<article>"
                            + " <h3>Action succefully.</h3>"
                            + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp'\"/>"
                            + "</article>";
                }
           }
            case 2 -> {
                String 
                        value = values[3]+" "+values[4],
                        Start_Activity_String = new Dataset().valor("v_schedule","fecha_hora","fecha_hora","'"+value+"'"),
                        End_Activity_String = new Dataset().valor("v_schedule","fecha_hora_fin","fecha_hora_fin","'"+value+"'");
                String []
                        Start_Activity_Strings = new Schedule().getSchedule("fecha_hora"),
                        End_Activity_Strings = new Schedule().getSchedule("fecha_hora_fin"); 
                if(value.equals(Start_Activity_String)||value.equals(End_Activity_String)){
                    validate=1;
                }else{
                    for(int count = 0;count<Start_Activity_Strings.length;count++){
                        if(new Schedule().compareDates(value, ">=", Start_Activity_Strings[count])==1||new Schedule().compareDates(value, "<", End_Activity_Strings[count])==1){
                            validate=1;
                        }
                    }
                }
                if(validate==0){
                    new Activity().updateActivity(values);                
                    page_string=""
                            + "<article>"
                            + " <h3>Action succefully.</h3>"
                            + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp'\"/>"
                            + "</article>";
                }else{
                    page_string=""
                            + "<article>"
                            + "     <table>"
                            + "         <tr>"
                            + "             <td colspan=\"2\"><h3>This action can´t do, the activity date is colissioned on schedule.</h3></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td colspan=\"2\">"
                            + "                 <p>¿Do you come back to activity form?</p>"
                            + "             </td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td>"
                            + "                 <form action=\"activities.jsp\" method=\"post\">"
                            + "                     <input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                            + "                     <input type=\"hidden\" name=\"page\" value=\"edit\"/>"
                            + "                     <input type=\"hidden\" name=\"input_activity_chosen\" value=\""+values[0]+"\"/>"
                            + "                     <input type=\"submit\" class=\"bt3\" name=\"submit_delete_event\" value=\"Yes\"/>"
                            + "                 </form>"
                            + "             </td>"
                            + "             <td>"
                            + "                 <form action=\"activities.jsp\" method=\"post\">"
                            + "                     <input type=\"hidden\" name=\"action\" value=\"Modify\"/>"
                            + "                     <input type=\"submit\" class=\"bt3\" name=\"submit_delete_event\" value=\"No\"/>"
                            + "                 </form>"
                            + "             </td>"
                            + "         </tr>"
                            + "     </table>"
                            + "</article>";
                }
           }
        }
        return page_string;
    }
}
