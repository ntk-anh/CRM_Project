package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.JDBCConnection;
import model.Role; 

public class RoleDAO {

	//trả ra list role
	public ArrayList<Role> getAllRole() {
		ArrayList<Role> models = new ArrayList<>();
		String query = "SELECT * FROM role";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Role model = new Role();
				model.setId(result.getInt("id"));
				model.setTenRole(result.getString("ten_role"));
				model.setMoTa(result.getString("mo_ta")); 
				models.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}

	//trả ra kq 1,0
	public int insertRole(Role model) {
		String query = "insert into role (ten_role, mo_ta) values (?,?)";
		try (Connection conn = JDBCConnection.getConnection()) { 
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, model.getTenRole());
			statement.setString(2, model.getMoTa()); 

			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;//nếu thành công trả về 1
	}
	
	//trả ra kq 1,0
	public int updateRole(Role model) {
		String query="update role set ten_role=?, mo_ta=? where id=?";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setString(1, model.getTenRole());
			statement.setString(2, model.getMoTa()); 
			statement.setInt(3, model.getId()); 
			
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;//sửa thất bại
	}
	
	//trả ra 1 Role
	public Role getRoleById(int id) {
		Role model=new Role();
		String query="select * from role where id=?";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				model.setId(result.getInt("id"));
				model.setTenRole(result.getString("ten_role"));
				model.setMoTa(result.getString("mo_ta"));  
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}
	
	//trả ra kết quả 1/0
	public int deleteRoleById(int id) {
		String query="delete from role where id=?";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;//thất bại thì trả ra 0
	}
	
	
}
