 //Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Márcel
 */


public class Datasource {
    private Connection Connection;
    public String ipbase="10.69.32.175",paramuser= "rb80200308", parampass= "T!g02022",hostname;
    private String Username;

    public Datasource() {
        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
            //System.out.println(hostname);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public Connection setDatasource () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection = DriverManager.getConnection("jdbc:mysql://localhost/managersoftdata", "root", "");        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
        }        
       return Connection;   
   }  
   
   //
   public ResultSet Resultado(String query) {        
        Statement st;
        ResultSet rs=null;     
        try {  
            st = Connection.createStatement();
            rs = st.executeQuery(query);
            System.out.println(query);             
        }catch(SQLException e){
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, "$> "+query, e);
        }  
        return rs;
    }   
    public void Ejecutar(String query) {
        Statement st;                 
        try {  
            st= Connection.createStatement();
            st.executeUpdate(query);     
            System.out.println(query);
            st.execute("commit");
        }catch(SQLException e){            
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, "$> "+query, e);
        }        
    }    
    public boolean Cerrar() { 
        boolean ok =true;       
        try {  
           Connection.close();           
        }catch(SQLException e){
            ok = false;
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, "$> "+ok, e);
        }
        return ok;
    }
}
