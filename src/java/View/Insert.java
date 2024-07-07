// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package View;

import Controller.Dataset;
import Model.Activity;
import Model.Group;
import Model.Schedule;
import java.text.ParseException;

/**
 *
 * @author Márcel
 */


public class Insert {
    private String page_string;
    private int validate;
    public String init(int Model){
        switch(Model){
            case 1:
               /* page_string=""
                            + "<form action=\"groups.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Insert\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"validate\"/>"
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
                            + "             <td><input type=\"submit\" class=\"bt3\" name=\"submit_init_group\" value=\"Next\"/> </td>"
                            + "         </tr>"
                            + "     </table>"
                            + "</div>"
                            + "</form>";*/
                
                    page_string=""
                            + "<form action=\"groups.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Insert\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"
                            + "<div class=\"formo\">"
                            + "<table>"
                            + "     <tr>"
                            + "             <td class=\"grisk\"colspan=\"2\"><h3>2. type group fields.</h3></td>"
                            + "     </tr>"
                            + " <tr>"                            
                            + "     <td>"
                            + "         <label>Group Name:</label>"
                            + "         <input type=\"text\" name=\"input_group_values\" pattern=\"[A-z- ]+\" />"
                            + "     </td>"
                            + "     <td>"
                            + "         <label>State:</label>"
                            + "         <select name=\"input_group_values\">"
                            + "             <option value=\"1\">On</option>"
                            + "             <option value=\"0\">Off</option>"
                            + "         </select>"
                            + "     </td>"
                            + " </tr>"                            
                            + " <tr>"
                            + "     <td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp'\"/></td>"
                            + "     <td><input type=\"submit\" class=\"bt3\" name=\"submit_validate_group\" value=\"Next\"/> </td>"
                            + " </tr>"
                            + "</table>"
                            + "</div>"
                            + "</form>";
                break;
            case 2:
                page_string=""
                            + "<form action=\"activities.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Insert\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"validate\"/>"
                            + "<div>"
                            + "     <table>"
                            + "         <tr>"
                            + "             <td colspan=\"2\"><h3>1. type activity datetime.</h3></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td><label>Activity date: </label></td>"
                            + "             <td><input type=\"datetime\" name=\"input_datetime_activity\" pattern=\"[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}\" required/></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td> </td>"
                            + "             <td><input type=\"submit\" class=\"bt3\" name=\"submit_init_activity\" value=\"Next\"/> </td>"
                            + "         </tr>"
                            + "     </table>"
                            + "</div>"
                            + "</form>";
                break;
        }                
        return page_string;
    }
    public String validate(String value,int Model) throws ParseException{
        System.out.println("-> dentro de switch = "+Model);
        switch(Model){            
            case 1:                
                System.out.println("-> dentro de validate");
                String [] Name_Group = new Group().getGroup(value);
                for (String Name_Group1 : Name_Group) {
                    if (Name_Group1.toLowerCase().equals(value.toLowerCase())) {
                        validate=1;
                    }
                }                
                if(validate==1){
                    page_string=""
                            + "<article>"
                            + " <h3>This action can´t do, the group name is repeated.</h3>"
                            + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp?action=Delete'\"/>"
                            + "</article>";
                }else{
                    page_string=""
                            + "<form action=\"groups.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Insert\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"
                            + "<div class=\"formo\">"
                            + "<table>"
                            + "     <tr>"
                            + "             <td class=\"grisk\"colspan=\"2\"><h3>2. type group fields.</h3></td>"
                            + "     </tr>"
                            + " <tr>"                            
                            + "     <td>"
                            + "         <label>Group Name:</label>"
                            + "         <input type=\"text\" name=\"input_group_values\" value=\""+value+"\" readonly/>"
                            + "     </td>"
                            + "     <td>"
                            + "         <label>State:</label>"
                            + "         <select name=\"input_group_values\">"
                            + "             <option value=\"1\">On</option>"
                            + "             <option value=\"0\">Off</option>"
                            + "         </select>"
                            + "     </td>"
                            + " </tr>"                            
                            + " <tr>"
                            + "     <td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp'\"/></td>"
                            + "     <td><input type=\"submit\" class=\"bt3\" name=\"submit_validate_group\" value=\"Next\"/> </td>"
                            + " </tr>"
                            + "</table>"
                            + "</div>"
                            + "</form>";
                    
                }
                break;
            case 2:                
                String 
                        Value_Date = value.substring(0, 10),
                        Value_Time = value.substring(11, 19),
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
                    String Result_Group="",Result_Kind="",Result_Period="";
                    String []
                            Group_Strings = new Dataset().valores("t_group order by id_group", "name_group", "name_group"),
                            Kind_Strings = new Dataset().valores("t_kind order by id_kind", "name_kind", "name_kind"),
                            Period_Strings = new Dataset().valores("t_period order by id_period", "name_period", "name_period"),
                            Group_Ints = new Dataset().valores("t_group order by id_group", "id_group", "id_group"),
                            Kind_Ints = new Dataset().valores("t_kind order by id_kind", "id_kind", "id_kind"),
                            Period_Ints = new Dataset().valores("t_period order by id_period", "id_period", "id_period");
                   for(int count=0;count<Group_Ints.length;count++){
                       Result_Group = Result_Group+""
                               + "<option value=\""+Group_Ints[count]+"\">"+Group_Strings[count]+"</option>\n";
                   }
                   for(int count=0;count<Kind_Ints.length;count++){
                       Result_Kind = Result_Kind+""
                               + "<option value=\""+Kind_Ints[count]+"\">"+Kind_Strings[count]+"</option>\n";
                   }
                   for(int count=0;count<Period_Ints.length;count++){
                       Result_Period = Result_Period+""
                               + "<option value=\""+Period_Ints[count]+"\">"+Period_Strings[count]+"</option>\n";
                   }
                   page_string=""
                            + "<form action=\"activities.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Insert\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"
                            + "<div class=\"formo\">"
                            + "<table>"                            
                            + "         <tr>"
                            + "             <td class=\"grisk\"colspan=\"2\"><h3>2. type activity fields.</h3></td>"
                            + "         </tr>"
                            + " <tr>"
                            + "     <td>"
                            + "         <label>Date:</label>"
                            + "         <input type=\"date\" name=\"input_activity_values\" value=\""+Value_Date+"\" pattern=\"[0-9]{4}-[0-9]{2}-[0-9]{2}\" readonly/>"
                            + "     </td>"
                            + "     <td>"
                            + "         <label>Start time:</label>"
                            + "         <input type=\"time\" name=\"input_activity_values\" value=\""+Value_Time+"\" pattern=\"[0-9]{2}:[0-9]{2}:[0-9]{2}\" readonly/>"
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
                            + "         <textarea rows=\"3\" cols=\"80\" name=\"input_activity_values\" required></textarea>"
                            + "     </td>"
                            + " </tr>"
                            + " <tr>"
                            + "     <td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp?action=Insert'\"/></td>"
                            + "     <td><input type=\"submit\" class=\"bt3\" name=\"submit_validate_activity\" value=\"Next\"/> </td>"
                            + " </tr>"
                            + "</table>"
                            + "</div>"
                            + "</form>";
                }else{
                    page_string=""
                            + "<article>"
                            + " <h3>This action can´t do, the activity date is colissioned on schedule.</h3>"
                            + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp?action=Insert'\"/>"
                            + "</article>";
                }
                break;
        }
        return page_string;
    }
    public String event(String [] values,int Model){
        switch(Model){
            case 1:                
                String [] Name_Group = new Group().getGroup("name_group");
                for (String Name_Group1 : Name_Group) {
                    if (Name_Group1.toLowerCase().equals(values[0].toLowerCase())) {
                        validate=1;
                    }
                }    
                if(validate==1){
                    page_string=""
                            + "<article>"
                            + " <h3>This action can´t do, the group name is repeated.</h3>"
                            + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp?action=Insert'\"/>"
                            + "</article>";
                }else{
                    new Group().setGroup(values);                
                    page_string=""
                            + "<article>"
                            + " <h3>Action succefully.</h3>"
                            + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp?action=Insert'\"/>"
                            + "</article>";
                }                
                break;
            case 2:
                //String value = values[2]+" "+values[3];
                new Activity().setActivity(values);                
                page_string=""
                        + "<article>"
                        + " <h3>Action succefully.</h3>"
                        + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp?action=Insert'\"/>"
                        + "</article>";
                break;
        }
        return page_string;
    }
}
