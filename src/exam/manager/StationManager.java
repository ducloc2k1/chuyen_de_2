/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.manager;

import exam.sql.SqlConnection;
import exam.station.entites.Station;
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
public class StationManager {

    public List<Station> getAllStation() {
        List<Station> listStation = new ArrayList<>();
        Station station;
        ResultSet rs = SqlConnection.exeQuery("{call getAllStation()}");
        try {
            while (rs.next()) {
                station = new Station(rs.getInt("id"), rs.getString("name"));
                listStation.add(station);
            }
            return listStation;
        } catch (SQLException ex) {
            Logger.getLogger(TicketManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Station getStaionById(int id){
        ResultSet rs = SqlConnection.exeQuery("{call getStaionById(?)}",id);
        try {
            rs.next();
            Station station = new Station(rs.getInt("id"), rs.getString("name"));
            return station;
        } catch (SQLException ex) {
            Logger.getLogger(TicketManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        StationManager st = new StationManager();
//        st.getStaionById(2);
//    }
}
