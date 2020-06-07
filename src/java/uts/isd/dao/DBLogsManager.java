/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.dao;

/**
 *
 * @author yoonkoo
 */

import uts.isd.model.*;
import java.sql.*;
import java.util.*;

public class DBLogsManager {
    private DBConnector connector;
    private Connection conn;
    private Statement st;

    public DBLogsManager(Connection conn) throws SQLException {
        st = conn.createStatement();
        this.conn = conn;
    }
    
    public ArrayList<UserRecords> findUserLogs(int userid) throws SQLException {
        String query = "SELECT * FROM IOTBAY.LOGS WHERE userId=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userid);
        
        ResultSet rs = ps.executeQuery();
        ArrayList<UserRecords> logs = new ArrayList<UserRecords>();
       
        while (rs.next()) {
            int logId = rs.getInt("logId");
            int userId = rs.getInt("userId");
            Timestamp timestamp = rs.getTimestamp("timestamp");
            String description = rs.getString("description");
            logs.add(new UserRecords(logId, userId, timestamp, description));
        }

        if (logs.isEmpty()) {
            throw new SQLException("No logs exists");
        }
        else{
        return logs;
        }
        
    }
    /*
    
        public void addUserLog(int userId, String description) throws SQLException {

        String query = "INSERT INTO LOGS (userid, timestamp, description) VALUES (?,?,?)";
        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        ps.setTimestamp(2, timestamp);
        ps.setString(3, description);
        
        ps.executeUpdate();
    }
    
  */
    
    public ArrayList<UserRecords> findUserLogs(Timestamp start, Timestamp end, int userid) throws SQLException {

        String query = "SELECT * FROM IOTBAY.LOGS WHERE TIMESTAMP >= ? AND TIMESTAMP <= ? AND USERID = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setTimestamp(1, start);
        ps.setTimestamp(2, end);
        ps.setInt(3, userid);
        ResultSet rs = ps.executeQuery();
        ArrayList<UserRecords> logs = new ArrayList<UserRecords>();
        
        // public UserRecords(int logId, int userId, Timestamp timestamp, String description
        while (rs.next()) {
            int logId = rs.getInt(1);
            int userId = rs.getInt(2);  
            Timestamp timestamp = rs.getTimestamp(3);
            String description = rs.getString(4);
            logs.add(new UserRecords(logId, userId, timestamp, description));
        }

        if (logs.isEmpty()) {
            throw new SQLException("No logs exists");
        }
        else {
            return logs;
        }
    }

}