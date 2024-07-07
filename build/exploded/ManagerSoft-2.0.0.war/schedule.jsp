<%-- 
    Document   : groups
    Created on : 24/02/2015, 01:17:51 PM
    Author     : Márcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=11" />
        <link href="css/css.css" rel="stylesheet" type="text/css"/>
        <title>ManagerSoft - Schedule</title>
    </head>
    <body>
        <div id="page-wrap">
        <header>
            <b>ManagerSoft Beta version 1.0</b>
            <hr>
            <a href="http://localhost:8080/ManagerSoft/groups.jsp" class="bt2">Groups</a>
             <a href="http://localhost:8080/ManagerSoft/activities.jsp" class="bt2">Activities</a>
             <a href="http://localhost:8080/ManagerSoft/schedule.jsp" class="bt2">Schedule</a>
        </header>
            <table>
                <tr>
                    <td>
                        <aside>
                            <form action="schedule.jsp" method="post">
                                <input type="hidden" name="action" value="Day"/>
                                <input type="submit" name="Activities" class="bt" value="Days view"/>
                            </form>
                            <form action="schedule.jsp" method="post">
                                <input type="hidden" name="action" value="Week"/>
                                <input type="submit" name="Activities" class="bt" value="Weeks view"/>
                            </form>
                            <form action="schedule.jsp" method="post">
                                <input type="hidden" name="action" value="Month"/>
                                <input type="submit" name="Activities" class="bt" value="Months view"/>
                            </form>  
                        </aside>
                    </td>
                    <td>
                        <section class="td1">
                            <center>
                            <%if(request.getParameter("action")==null){%>
                                <%@include file="WEB-INF/jsp/MonthSchedule.jspf" %>
                            <%}else{
                                switch(request.getParameter("action")){      
                                    case "Day":%>
                                    <%@include file="WEB-INF/jsp/DaySchedule.jspf" %>
                            <%break;
                                    case "Week":%>
                                    <%@include file="WEB-INF/jsp/WeekSchedule.jspf" %>
                            <%break;         
                                    case "Month":%>
                                    <%@include file="WEB-INF/jsp/MonthSchedule.jspf"%>
                            <%break;                              
                                }%>            
                            <%}%>
                            </center>
                        </section>
                    </td>
                </tr>                
            </table>             
        </div>
        <footer>
            <center>
            <h4>.. ManagerSoft Beta version 1.0 ..</h4>
            <h4>...Márcel Quintero - Prueba Técnica JAVA..</h4>
            <p>Ingeneo S.A. - 2015</p>
            </center>
        </footer>
    </body>
</html>
