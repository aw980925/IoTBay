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
import java.sql.Connection;
/**
 *
 * @author yoonkoo
 */
public abstract class DB {
    protected String URL="jdbc:derby://localhost:1527/users_DB[IoTBay on IOTBAY]";
    protected String db="users_DB";
    protected String dbuser="IoTBay";
    protected String dbpass = "admin";
    protected String driver = "org.apach.derby.jdbc.ClientDriver";
    protected Connection conn;
    

}