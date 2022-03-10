package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class InsertApp {

    /**
     * Connect to the test.db Movies
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insert(String name,String actor, String actress, String director,int year) {
    String sql = "INSERT INTO Movies(name,actor,actress,director,year) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,"name");
            pstmt.setString(2,"actor");
            pstmt.setString(3,"actress");
            pstmt.setString(4,"director");
            pstmt.setInt(5,year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }}
        

   
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        app.insert("ForrestGump","Tom_Hanks"," Robin_Wright", "Robert_Zemeckis",1994);
        app.insert("A_Beautiful_Mind", "Russel_Crowe", "Jennifer_Connely", "Ron_Howard",2001);
        app.insert("The_Pursyut_Of_Happiness","Will_Smith", "Thandiwe_Newton","Gabbbriele_Mucino",2006);
        app.insert("The_Shawshank_Redempltion","Tim_Robbins","Bob_Gunton","Frank_Darabount",1994);
        app.insert("Scheindlers_List","Liam_Neeson","Embedth_Davidtz","Steven _Spielberg",1994);
    }
}
