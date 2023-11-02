/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Equipo3
 */
public class conexionDAO {

    private String USERNAME = "root";
    private String PASSWORD = "linda";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "transito";
    private String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

  protected Connection con;

 

    public conexionDAO(){
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Error en: " + e);
        } catch (SQLException e) {
            System.err.println("Error en: " + e);
        }
    }

    public Connection getConexion() {
        return con;
    }
}
