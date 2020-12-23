/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.ticket.entites;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Ticket {

    private int id;
    private String passenger;
    private String phone;
    private int fromS;
    private int toS;
    private int type;
    private LocalDate startDate;
    private LocalDate endDate;
    private int adult;
    private int child;
    private String fromSName;
    private String toSName;

    public Ticket() {
    }

    public Ticket(int id, String passenger, String phone, int fromS, int toS, int type, LocalDate startDate, LocalDate endDate, int adult, int child, String fromSName, String toSName) {
        this.id = id;
        this.passenger = passenger;
        this.phone = phone;
        this.fromS = fromS;
        this.toS = toS;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adult = adult;
        this.child = child;
        this.fromSName = fromSName;
        this.toSName = toSName;
    }
    
    public Ticket(String passenger, String phone, int fromS, int toS, int type, LocalDate startDate, LocalDate endDate, int adult, int child) {
        this.passenger = passenger;
        this.phone = phone;
        this.fromS = fromS;
        this.toS = toS;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adult = adult;
        this.child = child;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFromS() {
        return fromS;
    }

    public void setFromS(int fromS) {
        this.fromS = fromS;
    }

    public int getToS() {
        return toS;
    }

    public void setToS(int toS) {
        this.toS = toS;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public String getFromSName() {
        return fromSName;
    }

    public void setFromSName(String fromSName) {
        this.fromSName = fromSName;
    }

    public String getToSName() {
        return toSName;
    }

    public void setToSName(String toSName) {
        this.toSName = toSName;
    }

    
    
}
