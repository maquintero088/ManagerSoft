// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.qcmarcel.ManagerSoft.View;

import com.qcmarcel.ManagerSoft.Controller.Dataset;
import com.qcmarcel.ManagerSoft.Model.Activity;
import com.qcmarcel.ManagerSoft.Model.Group;
import com.qcmarcel.ManagerSoft.Model.Kind;
import com.qcmarcel.ManagerSoft.Model.Period;

/**
 *
 * @author Márcel
 */


public class Search {
    private String page_string;
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
                            + "<input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"search\"/>"
                            + "<input type=\"hidden\" name=\"input_group_columns\" value=\"name_group\"/>"
                            + "<input type=\"hidden\" name=\"input_group_columns\" value=\"state_group\"/>"
                            + "<div>"
                            + "     <table>"
                            + "         <tr>"
                            + "             <td colspan=\"2\"><h3>1. type group name.</h3></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "     <td>"
                            + "         <label>Group Name:</label>"
                            + "         <input type=\"text\" name=\"input_group_values\" pattern=\"[A-z- ]+\" required/>"
                            + "     </td>"
                            + "     <td>"
                            + "         <label>State:</label>"
                            + "         <select name=\"input_group_values\">"
                            + "             <option value=\"1\">On</option>"
                            + "             <option value=\"0\">Off</option>"
                            + "         </select>"
                            + "     </td>"
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
                    String [] Period_Strings = new Period().getPeriod();
                    String Result_Period="<option value=\"0\">undefined</option>\n";
                    String [] Group_Strings = new Group().getGroup("name_group");
                    String Result_Group="<option value=\"0\">undefined</option>\n";
                    if(Group_Strings==null){
                        Result_Group = "<option> empty </option>";
                    }else{                    
                        for (String kind_String : kind_Strings) {
                            Result_kind = Result_kind+"<option value=\"" + kind_String + "\">" + kind_String + "</option>\n";
                        }
                        for (String Period_String : Period_Strings) {
                            Result_Period = Result_Period+"<option value=\"" + Period_String + "\">" + Period_String + "</option>\n";
                        }
                        for (String Group_String : Group_Strings) {
                            Result_Group = Result_Group+"<option value=\"" + Group_String + "\">" + Group_String + "</option>\n";
                        }
                    }
                    page_string=""
                            + "<form action=\"activities.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"search\"/>"                            
                            + "<input type=\"hidden\" name=\"input_activity_columns\" value=\"actividad\"/>"
                            + "<input type=\"hidden\" name=\"input_activity_columns\" value=\"grupo\"/>"
                            + "<input type=\"hidden\" name=\"input_activity_columns\" value=\"duracion\"/>"
                            + "<div>"
                            + "     <table>"
                            + "         <tr>"
                            + "             <td colspan=\"3\"><h3>1. Choose a kind of activity.</h3></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td><label>Kind of Activity: </label>"
                            + "                 <select name=\"input_activity_values\">"
                            + "                     "+Result_kind
                            + "                 </select></td>"
                            + "             <td><label>Group: </label>"
                            + "                 <select name=\"input_activity_values\">"
                            + "                     "+Result_Group
                            + "                 </select></td>"
                            + "             <td><label>Period: </label>"
                            + "                 <select name=\"input_activity_values\">"
                            + "                     "+Result_Period
                            + "                 </select></td>"
                            + "         </tr>"
                            + "         <tr>"
                            + "             <td colspan=\"2\"></td>"
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
    public String search(String [] columns,String [] values,int Model){
        System.out.println("-> dentro de search("+columns.length+","+values.length+","+Model+")");  
        switch(Model){
            case 1 -> {
                String[][] Group_Strings = new Group().getXGroup(columns,values);
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
                        + "<input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"
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
                String[][] Activity_Strings = new Activity().getXActivity(columns,values);
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
                        + "<input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"
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
     public String event(String value,int Model){
        System.out.println("-> dentro de switch = "+Model);
        switch(Model){            
            case 1 -> {                
                System.out.println("-> dentro de validate");
                String [][] this_Group = new Group().getGroup("id_group",value);                
                page_string=""
                        + "<form action=\"groups.jsp\" method=\"post\">"
                        + "<input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"                  
                        + "<div class=\"formo\">"
                        + "<table>"
                        + "     <tr>"
                        + "             <td class=\"grisk\"colspan=\"2\"><h3>2. type group fields.</h3></td>"
                        + "     </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <label>Group Name:</label>"
                        + "         <b>"+this_Group[0][0]+"</b>"
                        + "     </td>"
                        + "     <td>"
                        + "         <label>State:</label>"
                        + "         <b>"+this_Group[0][1]+"</b>"
                        + "     </td>"
                        + " </tr>"
                        + " <tr>"
                        + "     <td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp'\"/></td>"
                        + "     <td>"
                        + "          <input type=\"button\" class=\"bt3\" value=\"Modify\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp?action=Modify&page=edit&input_group_chosen="+value+"'\"/>"
                        + "          <input type=\"button\" class=\"bt3\" value=\"Delete\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp?action=Delete&page=confirm&input_group_chosen="+value+"'\"/>"
                        + "     </td>"
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
                        Result_Group = "<b>"+Group_Strings[count]+"</b>\n";
                    }
                }
                for(int count=0;count<Kind_Ints.length;count++){
                    if(this_Activity[0][0].equals(Kind_Ints[count]+"")){
                        Result_Kind = "<b>"+Kind_Strings[count]+"</b>\n";
                    }
                }
                for(int count=0;count<Period_Ints.length;count++){
                    if(this_Activity[0][4].equals(Period_Ints[count]+"")){
                        Result_Period = "<b>"+Period_Strings[count]+"</b>\n";
                    }
                }
                page_string=""
                        + "<form action=\"activities.jsp\" method=\"post\">"
                        + "<input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"event\"/>"
                        + "<div class=\"formo\">"
                        + "<table>"
                        + "         <tr>"
                        + "             <td class=\"grisk\"colspan=\"2\"><h3>2. type activity fields.</h3></td>"
                        + "         </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <label>Date:</label>"
                        + "         <b>"+this_Activity[0][2]+"</b>"
                        + "     </td>"
                        + "     <td>"
                        + "         <label>Start time:</label>"
                        + "         <b>"+this_Activity[0][3]+"</b>"
                        + "     </td>"
                        + " </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <label>Kind of Activity:</label>"
                        + Result_Kind
                        + "     </td>"
                        + "     <td>"
                        + "         <label>Group:</label>"
                        + Result_Group
                        + "     </td>"
                        + " </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <label>Period of Activity:</label>"
                        + Result_Period
                        + "     </td>"
                        + "     <td>"
                        + "         <label>Description:</label>"
                        + "         <b>"+this_Activity[0][5]+"</b>"
                        + "     </td>"
                        + " </tr>"
                        + " <tr>"
                        + "     <td>"
                        + "         <input type=\"button\" class=\"bt3\" value=\"Back to Search\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp'\"/></td>"
                        + "         <input type=\"button\" class=\"bt3\" value=\"Go to Schedule\" onclick=\"document.location='http://localhost:8080/ManagerSoft/schedule.jsp'\"/></td>"
                        + "     <td>"
                        + "          <input type=\"button\" class=\"bt3\" value=\"Modify\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp?action=Modify&page=edit&input_activity_chosen="+value+"'\"/>"
                        + "          <input type=\"button\" class=\"bt3\" value=\"Delete\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp?action=Delete&page=confirm&input_activity_chosen="+value+"'\"/>"
                        + "     </td>"
                        + " </tr>"
                        + "</table>"
                        + "</div>"
                        + "</form>";
            }
        }
        return page_string;
    }
}
