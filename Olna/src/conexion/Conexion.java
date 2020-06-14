package conexion;


import java.sql.*;



public class Conexion {

	private static Connection conn;
	private static final String driver ="com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/olna?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "root" ;
	
	PreparedStatement ps;
	ResultSet rs;
	
    public Conexion() {
        
    	Connection conn = null;
    	
    	try {
    		Class.forName(driver);
    		conn = DriverManager.getConnection(url,user,password);
    		if(conn!=null) {
    			System.out.println("Conexión establecida");
    		}
    		}catch (ClassNotFoundException | SQLException e) {
    			System.out.println("Error al conectar" + e);
    		}
    }
    
    public Connection conexion() {
    	
    	
    	Connection conn = null;
    	
    	try {
    		Class.forName(driver);
    		conn = DriverManager.getConnection(url,user,password);
    		if(conn!=null) {
    			System.out.println("Conexión establecida");
    		}
    		}catch (ClassNotFoundException | SQLException e) {
    			System.out.println("Error al conectar" + e);
    		}
		return conn;
    	//Con este método nos retorna la conexion
    }
public static void main(String[] args) 
{
    new Conexion();
}

}


