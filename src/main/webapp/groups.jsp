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
        <title>ManagerSoft - Groups</title>
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
                            <form action="groups.jsp" method="post">
                                <input type="hidden" name="action" value="Search"/>
                                <input type="submit" name="Groups" class="bt" value="Search"/>
                            </form>
                            <form action="groups.jsp" method="post">
                                <input type="hidden" name="action" value="Insert"/>
                                <input type="submit" name="Groups" class="bt" value="Insert"/>
                            </form>
                            <form action="groups.jsp" method="post">
                                <input type="hidden" name="action" value="Modify"/>
                                <input type="submit" name="Groups" class="bt" value="Modify"/>
                            </form>
                            <form action="groups.jsp" method="post">
                                <input type="hidden" name="action" value="Delete"/>
                                <input type="submit" name="Groups" class="bt" value="Delete"/>
                            </form>            
                        </aside>
                    </td>
                    <td>
                        <section class="td1">
                            <center>
                            <%if(request.getParameter("action")==null){%>
                                    <%@include file="WEB-INF/jsp/SearchGroup.jspf" %>                            
                            <%}else{
                                switch(request.getParameter("action")){      
                                    case "Search":%>
                                    <%@include file="WEB-INF/jsp/SearchGroup.jspf" %>
                                    <%break;
                                    case "Insert":%>
                                    <%@include file="WEB-INF/jsp/InsertGroup.jspf" %>
                                    <%break;                    
                                    case "Modify":%>
                                    <%@include file="WEB-INF/jsp/ModifyGroup.jspf" %>
                                    <%break;           
                                    case "Delete":%>
                                    <%@include file="WEB-INF/jsp/DeleteGroup.jspf"%>
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
