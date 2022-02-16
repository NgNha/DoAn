package ConnectSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnData.KhachHang;

public class Connect {

	public static Connection getConnection() {
		Connection conn = null;
		try{
			   String userName = "root";
			   String password = "";
			   String DatabaseName = "test";
			   String url = "jdbc:mysql://localhost/" + DatabaseName;
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   conn = DriverManager.getConnection(url, userName, password);
		} catch(Exception e){
			  e.printStackTrace();
		}
		return conn;
	}

}