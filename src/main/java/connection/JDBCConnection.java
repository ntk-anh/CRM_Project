/*
 * Mục đích: Lớp kết nối database bằng JDBC
 */

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() {
		final String database = "jdbc:mysql://localhost:3306/crm";
		final String username = "root";
		final String password = "123456789";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// gọi jdbc ra xài
			try {
				return DriverManager.getConnection(database, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;// nếu lỗi
	}
}
