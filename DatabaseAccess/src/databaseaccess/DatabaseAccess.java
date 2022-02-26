package databaseaccess;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import net.ucanaccess.jdbc.UcanaccessDriver;

public class DatabaseAccess {

    String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    String databasePath = "H:\\Unbackup\\JAVA\\DatabaseAccess\\db_pegawai.accdb";
    String url = UcanaccessDriver.URL_PREFIX + databasePath +";newDatabaseVersion=V2003";
    protected final String userLogin = "root";
    protected final String passLogin = "";

    protected Statement stmt;
    protected PreparedStatement prstmt;
    protected Connection conn;
    protected ResultSet rs;
    
    private void myTest() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, "", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM pegawai");
            
            while (rs.next()) {
                System.out.println(rs.getString("ID"));
                System.out.println(rs.getString("nama"));
                System.out.println(rs.getString("alamat"));
                System.out.println(rs.getString("umur"));
                System.out.println("");
            }

            rs.close();
            stmt.close();
            conn.close();
            
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new DatabaseAccess().myTest();
    }

}
