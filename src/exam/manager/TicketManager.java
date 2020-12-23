/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.manager;

import exam.sql.SqlConnection;
import exam.ticket.entites.Ticket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hai Phuong
 */
public class TicketManager {
    private Connection conn = SqlConnection.getConn();
    
    public List<Ticket> getAllTicket(){
        List<Ticket> listTicket = new ArrayList<>();
        Ticket ticket;
        ResultSet rs = SqlConnection.exeQuery("{call getAllTicket()}");
        StationManager st = new StationManager();
        try {
            while (rs.next()) {
                String fromS  = st.getStaionById(rs.getInt("fromS")).getName();
                String toS  = st.getStaionById(rs.getInt("toS")).getName();
                ticket = new Ticket(rs.getInt("id"),rs.getString("passenger"),
                                    rs.getString("phone"),rs.getInt("fromS"),
                                    rs.getInt("toS"),rs.getInt("type"),rs.getDate("startDate").toString(),
                                    rs.getDate("endDate").toString(), rs.getInt("adult"),
                                    rs.getInt("child"),fromS,toS);
                listTicket.add(ticket);
            }
            return listTicket;
        } catch (SQLException ex) {
            Logger.getLogger(TicketManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Ticket getTicketById(int id){
        ResultSet rs = SqlConnection.exeQuery("{call getTicketById(?)}",id);
        StationManager st = new StationManager();
        try {
            rs.next();
            String fromS  = st.getStaionById(rs.getInt("fromS")).getName();
            String toS  = st.getStaionById(rs.getInt("toS")).getName();
            Ticket ticket = new Ticket(rs.getInt("id"),rs.getString("passenger"),
                                rs.getString("phone"),rs.getInt("fromS"),
                                rs.getInt("toS"),rs.getInt("type"),rs.getDate("startDate").toString(),
                                rs.getDate("endDate").toString(), rs.getInt("adult"),
                                rs.getInt("child"),fromS,toS);
            return ticket;
        } catch (SQLException ex) {
            Logger.getLogger(TicketManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
