package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.JDBCConnection;
import model.User;

public class UserDAO {

	//trả ra list user
	public ArrayList<User> getAllUser() {
		ArrayList<User> models = new ArrayList<>();
		String query = "SELECT u.*, r.ten_role FROM crm.user u inner join role r on u.id_role=r.id";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				User model = new User();
				model.setId(result.getInt("id"));
				model.setHoTen(result.getString("ho_ten"));
				model.setEmail(result.getString("email"));
				model.setPassword(result.getString("password"));
				model.setDiaChi(result.getString("dia_chi"));
				model.setSoDienThoai(result.getString("so_dien_thoai"));
				model.setId_role(result.getInt("id_role"));
				model.setTenRole(result.getString("ten_role"));
				models.add(model);
			}
		} catch (Exception e) { 
		}
		return models;
	}
	
	//trả ra list user là nhân viên => cho việc leader add vào dự án do leader đó ql
		public ArrayList<User> getAllMemberUser( ) {
			ArrayList<User> models = new ArrayList<>();
			String query = "SELECT * FROM crm.user where id_role=3";
			try (Connection conn = JDBCConnection.getConnection()) {
				PreparedStatement statement = conn.prepareStatement(query); 
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					User model = new User();
					model.setId(result.getInt("id"));
					model.setHoTen(result.getString("ho_ten"));
					model.setEmail(result.getString("email")); 
					model.setDiaChi(result.getString("dia_chi"));
					model.setSoDienThoai(result.getString("so_dien_thoai"));
					model.setId_role(result.getInt("id_role")); 
					models.add(model);
				}
			} catch (Exception e) { 
			}
			return models;
		}
	
	

	//trả ra kq 1,0
	public int insertUser(User user) {
		String query = "insert into user (ho_ten, email, password, dia_chi, so_dien_thoai, id_role) values (?,?,?,?,?,?)";
		try (Connection conn = JDBCConnection.getConnection()) { 
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getHoTen());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getDiaChi());
			statement.setString(5, user.getSoDienThoai());
			statement.setInt(6, user.getId_role());

			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;//nếu thành công trả về 1
	}
	
	//trả ra kq 1,0
	public int updateUser(User model) {
		String query="update user set ho_ten=?, email=?, dia_chi=?,so_dien_thoai=?, id_role=? where id=?";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setString(1, model.getHoTen()); 
			statement.setString(2, model.getEmail()); 
			statement.setString(3, model.getDiaChi()); 
			statement.setString(4, model.getSoDienThoai()); 
			statement.setInt(5, model.getId_role()); 
			statement.setInt(6, model.getId()); 
			
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;//sửa thất bại
	}
	
	//trả ra 1 user
	public User getUserById(int id) {
		User model=new User();
		String query="select u.*, r.ten_role from user u inner join role r on u.id_role=r.id where u.id=?";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				model.setId(result.getInt("id"));
				model.setHoTen(result.getString("ho_ten"));
				model.setEmail(result.getString("email"));
				model.setPassword(result.getString("password"));
				model.setDiaChi(result.getString("dia_chi"));
				model.setSoDienThoai(result.getString("so_dien_thoai"));
				model.setId_role(result.getInt("id_role"));
				model.setTenRole(result.getString("ten_role"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}
	
	//trả ra kết quả 1/0
	public int deleteUserById(int id) {
		String query="delete from user where id=?";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;//thất bại thì trả ra 0
	}
	/**
	 * Hàm kiểm tra login
	 * @param email
	 * @param password
	 * @return
	 */
	//trả ra user khi có email, password => kiểm tra đăng nhập
	public User checkLogin(String email, String password) {
		
		String query="select * from user where email=? and password=?";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2,password);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				User model =new User();
				model.setId(result.getInt("id"));
				model.setHoTen(result.getString("ho_ten"));
				model.setEmail(result.getString("email"));
				model.setPassword(result.getString("password"));
				model.setDiaChi(result.getString("dia_chi"));
				model.setSoDienThoai(result.getString("so_dien_thoai"));
				model.setId_role(result.getInt("id_role"));
				return model;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
