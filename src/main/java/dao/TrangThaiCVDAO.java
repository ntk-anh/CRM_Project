package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.JDBCConnection;
import model.TrangThaiCV;

public class TrangThaiCVDAO {
	//trả ra list trạng thái
		public ArrayList<TrangThaiCV> getAllTrangThaiCV() {
			ArrayList<TrangThaiCV> models = new ArrayList<>();
			String query = "SELECT * FROM crm.trang_thai_cv;";
			try (Connection conn = JDBCConnection.getConnection()) {
				PreparedStatement statement = conn.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					TrangThaiCV model = new TrangThaiCV();
					model.setId(result.getInt("id"));
					model.setTenTrangThaiCV(result.getString("ten_trang_thai")); 
					models.add(model);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return models;
		}

		//trả ra kq 1,0
		public int insertTrangThaiCV(TrangThaiCV model) {
			String query = "insert into trang_thai_cv (ten_trang_thai) values (?)";
			try (Connection conn = JDBCConnection.getConnection()) { 
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, model.getTenTrangThaiCV()); 

				return statement.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 0;//nếu thành công trả về 1
		}
		
		//trả ra kq 1,0
		public int updateTrangThaiCV(TrangThaiCV model) {
			String query="update trang_thai_cv set ten_trang_thai=?  where id=?";
			try (Connection conn=JDBCConnection.getConnection()){
				PreparedStatement statement=conn.prepareStatement(query);
				statement.setString(1, model.getTenTrangThaiCV()); 
				statement.setInt(3, model.getId()); 
				
				return statement.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 0;//sửa thất bại
		}
		
		//trả ra 1 trạng thái
		public TrangThaiCV getTrangThaiCVById(int id) {
			TrangThaiCV model=new TrangThaiCV();
			String query="select * from trang_thai_cv where id=?";
			try (Connection conn=JDBCConnection.getConnection()){
				PreparedStatement statement=conn.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					model.setId(result.getInt("id"));
					model.setTenTrangThaiCV(result.getString("ten_role")); 
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return model;
		}
		
		//trả ra kết quả 1/0
		public int deleteTrangThaiCVById(int id) {
			String query="delete from trang_thai_cv where id=?";
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
