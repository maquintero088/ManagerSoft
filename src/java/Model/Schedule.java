// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package Model;

import Controller.Dataset;

/**
 *
 * @author Márcel
 */


public class Schedule {    
    private String page_Schedule;
    private int AAAA;
    private String NOW;
    private int MM;
    private int DD;
    private int Date_length;
    public String [] getSchedule(String column){        
        String[] M_Schedule = new Dataset().valores("v_schedule", column, column);
        return M_Schedule;        
    }
    public int compareDates(String compared,String comparison,String date){        
        String compare_value;
        String expr = "str_to_date('"+compared+"','%Y-%m-%d %h:%i:%s') "+comparison+" str_to_date('"+date+"','%Y-%m-%d %h:%i:%s')";
        compare_value = new Dataset().valor("v_schedule", "(case when ("+expr+") then 1 else 0 end)", "estado", "1");
        if(compare_value==null){
            compare_value="0";
        }
        return Integer.parseInt(compare_value); 
    }
    public String getMonth(String date){
        System.out.println("-> dentro de getMonth ("+date+")");   
        String This_Date = getDate(date);
        //System.out.println("-> This_Date = "+This_Date);
        String title = new Dataset().valorString("monthname('"+This_Date+"')")+" - "+AAAA;
        String [] Date_Strings = {AAAA+"",new Dataset().isDigit(MM),"01"} ;  
        String [] Time_Strings = {"00","00","00"} ; 
        String [] Date_Formats = {"date_add","1 month","- interval 1 day","9","2"};
        Date_length = new Dataset().FdateInt(Date_Strings,Time_Strings,Date_Formats);      
        //System.out.println("-> Date_length = "+Date_length);
        String Result_Month=""
                + "<tr>"
                + "     <td class=\"grisk\">"
                + "<h4>Sunday</h4>"
                + "     </td>"
                + "     <td class=\"grisk\">"
                + "<h4>Monday</h4>"
                + "     </td>"                
                + "     <td class=\"grisk\">"
                + "<h4>Tuesday</h4>"
                + "     </td>"                
                + "     <td class=\"grisk\">"
                + "<h4>Wednesday</h4>"
                + "     </td>"                
                + "     <td class=\"grisk\">"
                + "<h4>Thursday</h4>"
                + "     </td>"
                + "     <td class=\"grisk\">"
                + "<h4>Friday</h4>"
                + "     </td>"
                + "     <td class=\"grisk\">"
                + "<h4>Saturday</h4>"
                + "     </td>"
                + "<tr>";
        int DDD = new Dataset().valorInt("dayofweek('"+This_Date.substring(0, 8)+"01"+This_Date.substring(10, 19)+"')");
        for(int dayofweek = 1; dayofweek<=7 ; dayofweek++){                
            if(DDD > dayofweek){
                Result_Month=Result_Month+"<td class=\"square\"></td>\n";
            }
        }
        
        //for(int count = 1;count<=Date_length;count++){    
        int count=1;
        while(count<=Date_length){ 
            String Date_Digits = AAAA+"-"+new Dataset().isDigit(MM)+"-"+new Dataset().isDigit(count);
            String [][] Activities_Strings = new Activity().getVActivity("substring(fecha_hora,1,10)", Date_Digits);
            String Result_Activity = "";
            if(Activities_Strings.length==0){
                Result_Activity = ""
                        + "<p>---</p>";
            }else if(Activities_Strings.length==1){    
                Result_Activity = ""                      
                        + "<form action=\"activities.jsp\" method=\"post\">"
                        + " <input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                        + " <input type=\"hidden\" name=\"page\" value=\"event\"/>"
                        + "<input type=\"hidden\" name=\"input_activity_chosen\" value=\""+Activities_Strings[0][3]+"\"/>"
                        + "<input type=\"submit\" class=\""+Class(Date_Digits,"<","Verde","Rojo")+"\" name=\"submit_activity_chosen\" value=\""+Activities_Strings[0][0].substring(13, 21)+"\" />"
                        + "</form>\n";
            }else{                    
                for (String[] Activities_String : Activities_Strings) {
                    if (Activities_String[0] == null) {
                        
                    } else {
                        Result_Activity = Result_Activity+""
                                + "<form action=\"activities.jsp\" method=\"post\">"
                                + " <input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                                + " <input type=\"hidden\" name=\"page\" value=\"event\"/>"
                                + "     <input type=\"hidden\" name=\"input_activity_chosen\" value=\"" + Activities_String[3] + "\"/>" 
                                + "     <input type=\"submit\" class=\""+Class(Date_Digits,"<","Verde","Rojo")+"\" name=\"submit_activity_chosen\" value=\"" + Activities_String[0].substring(13, 21) + "\" />"
                                + "</form>\n";
                    }
                }
            }
            String Count=new Dataset().isDigit(count);
            Result_Month=Result_Month+"<td class=\""+Class(Date_Digits,"=","squared","square")+"\"><h3>"+count+"\n"+Result_Activity+"</h3></td>\n";
            int DW = new Dataset().valorInt("dayofweek('"+This_Date.substring(0, 8)+Count+This_Date.substring(10, 19)+"')");            
            if(DW == 7){
                Result_Month=Result_Month+""
                        + "</tr>"
                        + "<tr>\n";
            }            
            count++;
        }
        page_Schedule=""
                + "<div class=\"formo\">"
                + "<table>"
                + "<tr>"
                + "     <td>"
                + "         <table>"
                + "             <tr>"
                + "                 <td>"
                + "                     <form action=\"schedule.jsp\" method=\"post\">"
                + "                         <input type=\"hidden\" name=\"action\" value=\"Month\"/>"
                + "                         <input type=\"hidden\" name=\"page\" value=\"search\"/>"
                + "                         <input type=\"hidden\" name=\"input_schedule_values\" value=\""+This_Date+"\"/>"
                + "                         <input type=\"hidden\" name=\"input_schedule_values\" value=\"left\"/>"
                + "                         <input type=\"submit\" name=\"submit_schedule\" class=\"bt3\" value=\"PREVIOUS\"/>"
                + "                     </form>"
                + "                 </td>"
                + "                 <td>"
                + "                     <b>"+title+"<b>"
                + "                 </td>"
                + "                 <td>"
                + "                     <form action=\"schedule.jsp\" method=\"post\">"                
                + "                         <input type=\"hidden\" name=\"action\" value=\"Month\"/>"
                + "                         <input type=\"hidden\" name=\"page\" value=\"search\"/>"
                + "                         <input type=\"hidden\" name=\"input_schedule_values\" value=\""+This_Date+"\"/>"
                + "                         <input type=\"hidden\" name=\"input_schedule_values\" value=\"right\"/>"
                + "                         <input type=\"submit\" name=\"submit_schedule\" class=\"bt3\" value=\"NEXT\"/>"
                + "                     </form>"
                + "                 </td>"
                + "             </tr>"
                + "         </table>"
                + "     </td>"
                + "</tr>"
                + "<tr>"
                + " <td>"
                + "     <table class=\"verde\">"                
                + "         <tr>"
                + Result_Month
                + "         </tr>"
                + "     </table>"
                + " </td>"                
                + "</tr>"
                + "</table>"
                + "</div>";
        return page_Schedule;        
    }
    public String getWeek(String date){
        System.out.println("-> dentro de getWeek ("+date+")"); 
        String Date0="",Date1="";
        String This_Date = getDate(date);
        //System.out.println("-> This_Date = "+This_Date); 
        //String title = new Dataset().valorString("monthname('"+This_Date+"')")+" - "+AAAA;               
        String [] Weeks = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        String Result_Week="";          
        int Dd = 0;
        int DDW = new Dataset().valorInt("dayofweek('"+This_Date+"')");
        for(int dayofweek = 1; dayofweek<=7 ; dayofweek++){                
            if(DDW > dayofweek){
                Dd = Dd-1;
            }
        }
        int count=0;
        while(count<7){   
            Dd=count+Dd;
            String Date_Str = "";                       
            String [] Date_Formats = {"","","","",""}; 
            String [] Time_Strings = {"00","00","00"} ;
            String [] Date_Strings = {AAAA+"",new Dataset().isDigit(MM),new Dataset().isDigit(DD)} ;   
            // String [] Date_Formats = {"date_add","1 month","- interval 1 day","9","2"};
            if(Dd<0){            
                Date_Formats[0]="date_sub";
                Date_Formats[1]=(Dd*(-1))+" day";
                Date_Formats[3]="1";
                Date_Formats[4]="10";  
                Date_Str = new Dataset().FdateString(Date_Strings,Time_Strings,Date_Formats); 
            }else if(Dd>0){   
                Date_Formats[0]="date_add";
                Date_Formats[1]=Dd+" day";
                Date_Formats[3]="1";
                Date_Formats[4]="10";                
                Date_Str = new Dataset().FdateString(Date_Strings,Time_Strings,Date_Formats);                             
            }else{
                Date_Str = This_Date;
            }      
            if(count==0){
                Date0=Date_Str;
            }else if(count==6){
                Date1=Date_Str;
            }
            Result_Week=Result_Week+""                        
                        + "</tr>"
                        + "<tr>"
                        + "     <td class=\"grisk\">"
                        + "         <h4>"+Weeks[count]+"</h4>"
                        + "     </td>"
                        + "\n";
            System.out.println("-> Date_Str = "+Date_Str);   
            String Date_Digits = Date_Str.substring(0, 4)+"-"+Date_Str.substring(5, 7)+"-"+Date_Str.substring(8, 10);
            String [][] Activities_Strings = new Activity().getVActivity("substring(fecha_hora,1,10)", Date_Digits);
            String Result_Activity = "";
            if(Activities_Strings.length==0){
                Result_Activity = ""
                        + "<p>---</p>";
            }else if(Activities_Strings.length==1){    
                Result_Activity = ""                      
                        + "<form action=\"activities.jsp\" method=\"post\">"
                        + " <input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                        + " <input type=\"hidden\" name=\"page\" value=\"event\"/>"
                        + "<input type=\"hidden\" name=\"input_activity_chosen\" value=\""+Activities_Strings[0][3]+"\"/>"
                        + "<input type=\"submit\" class=\""+Class(Date_Digits,"<","Verde","Rojo")+"\" name=\"submit_activity_chosen\" value=\""+Activities_Strings[0][0].substring(13, 21)+"\" />"
                        + "</form>\n";
            }else{                    
                for (String[] Activities_String : Activities_Strings) {
                    if (Activities_String[0] == null) {
                        
                    } else {
                        Result_Activity = Result_Activity+""
                                + "<form class=\"left\" action=\"activities.jsp\" method=\"post\">"
                                + " <input type=\"hidden\" name=\"action\" value=\"Search\"/>"
                                + " <input type=\"hidden\" name=\"page\" value=\"event\"/>"
                                + "     <input type=\"hidden\" name=\"input_activity_chosen\" value=\"" + Activities_String[3] + "\"/>" 
                                + "     <input type=\"submit\" class=\""+Class(Date_Digits,"<","Verde","Rojo")+"\" name=\"submit_activity_chosen\" value=\"" + Activities_String[0].substring(13, 21) + "\" />"
                                + "</form>\n";
                    }
                }
            }
            Result_Week=Result_Week+"<td class=\""+Class(Date_Str,"=","squared","square")+"\">"+Result_Activity+"</td>\n";
            count++;
        }           
        String title = "Sunday "+Date0+" --> Saturday "+Date1;
        page_Schedule=""
                + "<div class=\"formo\">"
                + "<table>"
                + "<tr>"
                + "     <td>"
                + "         <table>"
                + "             <tr>"
                + "                 <td>"
                + "                     <form action=\"schedule.jsp\" method=\"post\">"
                + "                         <input type=\"hidden\" name=\"action\" value=\"Week\"/>"
                + "                         <input type=\"hidden\" name=\"page\" value=\"search\"/>"
                + "                         <input type=\"hidden\" name=\"input_schedule_values\" value=\""+This_Date+"\"/>"
                + "                         <input type=\"hidden\" name=\"input_schedule_values\" value=\"left\"/>"
                + "                         <input type=\"submit\" name=\"submit_schedule\" class=\"bt3\" value=\"PREVIOUS\"/>"
                + "                     </form>"
                + "                 </td>"
                + "                 <td>"
                + "                     <b>"+title+"<b>"
                + "                 </td>"
                + "                 <td>"
                + "                     <form action=\"schedule.jsp\" method=\"post\">"                
                + "                         <input type=\"hidden\" name=\"action\" value=\"Week\"/>"
                + "                         <input type=\"hidden\" name=\"page\" value=\"search\"/>"
                + "                         <input type=\"hidden\" name=\"input_schedule_values\" value=\""+This_Date+"\"/>"
                + "                         <input type=\"hidden\" name=\"input_schedule_values\" value=\"right\"/>"
                + "                         <input type=\"submit\" name=\"submit_schedule\" class=\"bt3\" value=\"NEXT\"/>"
                + "                     </form>"
                + "                 </td>"
                + "             </tr>"
                + "         </table>"
                + "     </td>"
                + "</tr>"
                + "<tr>"
                + " <td>"
                + "     <table class=\"verde\">"                
                + "         <tr>"
                + Result_Week
                + "         </tr>"
                + "     </table>"
                + " </td>"                
                + "</tr>"
                + "</table>"
                + "</div>";
        return page_Schedule;        
    }
    public String getDay(String date){
        System.out.println("-> dentro de getDay ("+date+")");   
        String This_Date = getDate(date);
        return page_Schedule;        
    }
    private String getDate(String date) {        
        System.out.println("-> dentro de getDate ("+date+")");   
        NOW = new Dataset().valorString("now()"); 
        //System.out.println("-> NOW = "+NOW);
        String Date;
        //System.out.println("-> dentro de if (date == "+date+")");   
        if(date==null||date.equals("")){
            //System.out.println("-> if");
            AAAA = Integer.parseInt(NOW.substring(0,4));
            MM = Integer.parseInt(NOW.substring(5,7));
            DD = Integer.parseInt(NOW.substring(8,10));
            Date = NOW;
        }else{
            //System.out.println("-> else");
            AAAA = Integer.parseInt(date.substring(0,4));
            MM = Integer.parseInt(date.substring(5,7));
            DD = Integer.parseInt(date.substring(8,10));
            Date = date;
        }        
        //System.out.println("-> return "+Date+".replace('.0', '')");//" -> (AAAA = "+AAAA+", MM = "+MM+", DD = "+DD+");");
        return Date.replace(".0", "");
    }    

    private String Class(String Date,String expr,String si,String no) {
        System.out.println("-> dentro de Class("+Date+","+expr+","+si+","+no+")");   
        String Result_Class = new Dataset().valorString("(case when ('"+NOW.substring(0, 10)+"' "+expr+" '"+Date+"') then '"+si+"' else '"+no+"'end)");        
        return Result_Class;
    }
}
