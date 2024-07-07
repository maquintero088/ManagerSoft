// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package View;

import Controller.Dataset;
import Model.Activity;
import Model.Group;
import Model.Kind;

/**
 *
 * @author Márcel
 */


public class Delete {
    private String page_string;
    public String init(int Model){     
        switch(Model){
            case 1:
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
                            + "<input type=\"hidden\" name=\"action\" value=\"Delete\"/>"
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
                break;
            case 2:
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
                            + "<input type=\"hidden\" name=\"action\" value=\"Delete\"/>"
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
                break;
        }
        return page_string;        
    }
    public String search(String column,String value,int Model){   
        System.out.println("-> dentro de search("+column+","+value+","+Model+")");  
        switch(Model){
            case 1:
                String[][] Group_Strings = new Group().getGroup(column,value);
                String Result_Group = "";
                if(Group_Strings.length==0){
                    Result_Group = "<tr><td> empty </td></tr>"
                            + "<tr><td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp\"/></td></tr>";                
                }else if(Group_Strings.length==1){    
                    Result_Group = ""
                            + "<tr>"
                            + "<td>"
                            + "<input type=\"hidden\" name=\"input_group_chosen\" value=\""+Group_Strings[0][2]+"\"/>"
                            + "<input type=\"submit\" class=\"list\" name=\"submit_group_chosen\" value=\""+Group_Strings[0][0]+"\" />"
                            + "</td>"
                            + "</tr>\n";  
                }else{                    
                    for (int count = 0;count<Group_Strings.length;count++) {
                        if(Group_Strings[count][0]==null){
                        }else{
                            Result_Group = Result_Group+""
                                    + "<tr>"
                                    + "<td>"
                                    + "<input type=\"hidden\" name=\"input_group_chosen\" value=\""+Group_Strings[count][2]+"\"/>"
                                    + "<input type=\"submit\" class=\"list\" name=\"submit_group_chosen\" value=\""+Group_Strings[count][0]+"\" />"
                                    + "</td>"
                                    + "</tr>\n";              
                        }                   
                    }
                }
                page_string=""
                        + "<form action=\"groups.jsp\" method=\"post\">"
                        + "<input type=\"hidden\" name=\"action\" value=\"Delete\"/>"
                        + "<input type=\"hidden\" name=\"page\" value=\"confirm\"/>"
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
                break;
            case 2:
                String[][] Activity_Strings = new Activity().getVActivity(column,value);
                String Result_Activity = "";
                if(Activity_Strings.length==0){
                    Result_Activity = "<tr><td> empty </td></tr>"
                            + "<tr><td><input type=\"button\" class=\"bt3\" value=\"Back\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp'\"/></td></tr>";
                }else if(Activity_Strings.length==1){    
                    Result_Activity = ""
                                    + "<tr>"
                                    + "<td>"
                                    + "<input type=\"hidden\" name=\"input_activity_chosen\" value=\""+Activity_Strings[0][3]+"\"/>"
                                    + "<input type=\"submit\" class=\"list\" name=\"submit_activity_chosen\" value=\""+Activity_Strings[0][0]+"|"+Activity_Strings[0][1]+"|"+Activity_Strings[0][2]+"\" />"
                                    + "</td>"
                                    + "</tr>\n";  
                    }else{                    
                        for (int count = 0;count<Activity_Strings.length;count++) {
                            if(Activity_Strings[count][0]==null){
                            }else{
                            Result_Activity = Result_Activity+""
                                    + "<tr>"
                                    + "<td>"
                                    + "<input type=\"hidden\" name=\"input_activity_chosen\" value=\""+Activity_Strings[count][3]+"\"/>"
                                    + "<input type=\"submit\" class=\"list\" name=\"submit_activity_chosen\" value=\""+Activity_Strings[count][0]+"|"+Activity_Strings[count][1]+"|"+Activity_Strings[count][2]+"\" />"
                                    + "</td>"
                                    + "</tr>\n";              
                            }                   
                        }
                    }
                    page_string=""
                            + "<form action=\"activities.jsp\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"action\" value=\"Delete\"/>"
                            + "<input type=\"hidden\" name=\"page\" value=\"confirm\"/>"
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
                break;
        }
        return page_string;        
    }
    public String confirm(String value,int Model){
        switch(Model){
            case 1:
                page_string=""
                        + "<article>"
                        + "     <table>"
                        + "         <tr>"
                        + "             <td colspan=\"2\"><h3>3. Confirm this action.</h3></td>"
                        + "         </tr>"
                        + "         <tr>"
                        + "             <td colspan=\"2\">"
                        + "                 <p>¿Do you want to delete this group?</p>"
                        + "             </td>"
                        + "         </tr>"
                        + "         <tr>"
                        + "             <td>"
                        + "                 <form action=\"groups.jsp\" method=\"post\">"
                        + "                     <input type=\"hidden\" name=\"action\" value=\"Delete\"/>"
                        + "                     <input type=\"hidden\" name=\"page\" value=\"event\"/>"
                        + "                     <input type=\"hidden\" name=\"input_group_chosen\" value=\""+value+"\"/>"
                        + "                     <input type=\"submit\" class=\"bt3\" name=\"submit_delete_event\" value=\"Yes\"/>"
                        + "                 </form>"
                        + "             </td>"
                        + "             <td>"
                        + "                 <form action=\"groups.jsp\" method=\"post\">"
                        + "                     <input type=\"hidden\" name=\"action\" value=\"Delete\"/>"
                        + "                     <input type=\"submit\" class=\"bt3\" name=\"submit_delete_event\" value=\"No\"/>"
                        + "                 </form>"
                        + "             </td>"
                        + "         </tr>"
                        + "     </table>"
                        + "</article>";
                break;
            case 2:
                page_string=""
                        + "<article>"
                        + "     <table>"
                        + "         <tr>"
                        + "             <td colspan=\"2\"><h3>3. Confirm this action.</h3></td>"
                        + "         </tr>"
                        + "         <tr>"
                        + "             <td colspan=\"2\">"
                        + "                 <p>¿Do you want to delete this activity?</p>"
                        + "             </td>"
                        + "         </tr>"
                        + "         <tr>"
                        + "             <td>"
                        + "                 <form action=\"activities.jsp\" method=\"post\">"
                        + "                     <input type=\"hidden\" name=\"action\" value=\"Delete\"/>"
                        + "                     <input type=\"hidden\" name=\"page\" value=\"event\"/>"
                        + "                     <input type=\"hidden\" name=\"input_activity_chosen\" value=\""+value+"\"/>"
                        + "                     <input type=\"submit\" class=\"bt3\" name=\"submit_delete_event\" value=\"Yes\"/>"
                        + "                 </form>"
                        + "             </td>"
                        + "             <td>"
                        + "                 <form action=\"activities.jsp\" method=\"post\">"
                        + "                     <input type=\"hidden\" name=\"action\" value=\"Delete\"/>"
                        + "                     <input type=\"submit\" class=\"bt3\" name=\"submit_delete_event\" value=\"No\"/>"
                        + "                 </form>"
                        + "             </td>"
                        + "         </tr>"
                        + "     </table>"
                        + "</article>";
                break;
        }
        return page_string;
    }
    public String event(String value,int Model){
        switch(Model){
            case 1:
                new Dataset().editar("id_group", "t_group", value, 6);                
                page_string=""
                        + "<article>"
                        + " <h3>Action succefully.</h3>"
                        + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/groups.jsp?action=Delete'\"/>"
                        + "</article>";
                break;
            case 2:
                new Dataset().editar("id_activity", "t_activity", value, 6);                
                page_string=""
                        + "<article>"
                        + " <h3>Action succefully.</h3>"
                        + " <input type=\"button\" class=\"bt3\" value=\"OK\" onclick=\"document.location='http://localhost:8080/ManagerSoft/activities.jsp?action=Delete'\"/>"
                        + "</article>";
                break;
        }
        return page_string;
    }
}
