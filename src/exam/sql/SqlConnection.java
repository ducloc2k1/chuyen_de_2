/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hai Phuong
 */
public class SqlConnection {
    public static Connection getConn(){
        try {
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ticket_management","sa","1234$");
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet exeQuery(String sql, Object... object){
        Connection conn = SqlConnection.getConn();
        try {
            int i = 1;
            CallableStatement cs = conn.prepareCall(sql);
            if (object.length > 0) {
                for (Object object1 : object) {
                    cs.setObject(i, object1);
                    i++;
                }
            }
            return cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public static int exeUpdate(String sql, Object... object){
        Connection conn = SqlConnection.getConn();
        try {
            int i = 1;
            CallableStatement cs = conn.prepareCall(sql);
            if (object.length > 0) {
                for (Object object1 : object) {
                    cs.setObject(i, object1);
                    i++;
                }
            }
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
}
