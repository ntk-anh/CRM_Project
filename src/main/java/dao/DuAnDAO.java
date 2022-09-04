package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import connection.JDBCConnection;
import model.CongViec;
import model.DuAn;

public class DuAnDAO {
	// trả danh sách dự án (nhóm việc)
	public ArrayList<DuAn> getAllDuAn() {
		ArrayList<DuAn> models = new ArrayList<>();
		String query = "select da.*, u.ho_ten from du_an da join user u where da.id_leader=u.id;";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				DuAn model = new DuAn();
				model.setId(result.getInt("id"));
				model.setTenDuAn(result.getString("ten_du_an"));
				model.setMoTa(result.getString("mo_ta"));
				model.setNgayBatDau(result.getString("ngay_bat_dau"));
				model.setNgayKetThuc(result.getString("ngay_ket_thuc"));
				model.setIdLeader(result.getInt("id_leader"));
				model.setTenLeader(result.getString("ho_ten"));
				models.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}
	
	// trả danh sách dự án do 1 leader quan ly
		public ArrayList<DuAn> getAllByIdLeader(int idLeader) {
			ArrayList<DuAn> models = new ArrayList<>();
			String query = "select da.*, u.ho_ten from du_an da join user u on da.id_leader=u.id where da.id_leader=?;";
			try (Connection conn = JDBCConnection.getConnection()) {
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setInt(1, idLeader);
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					DuAn model = new DuAn();
					model.setId(result.getInt("id"));
					model.setTenDuAn(result.getString("ten_du_an"));
					model.setMoTa(result.getString("mo_ta"));
					model.setNgayBatDau(result.getString("ngay_bat_dau"));
					model.setNgayKetThuc(result.getString("ngay_ket_thuc"));
					model.setIdLeader(result.getInt("id_leader"));
					model.setTenLeader(result.getString("ho_ten"));
					models.add(model);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return models;
		}

	// trả ra 1,0
	public int insertDuAn(DuAn duAn) {
		String query = "insert into du_an (ten_du_an, mo_ta, ngay_bat_dau, ngay_ket_thuc, id_leader ) values (?,?,?,?,?)";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, duAn.getTenDuAn());
			statement.setString(2, duAn.getMoTa());
			statement.setString(3, duAn.getNgayBatDau());
			statement.setString(4, duAn.getNgayKetThuc());
			statement.setInt(5, duAn.getIdLeader());
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	// trả ra 1,0
	public int updateDuAn(DuAn duAn) {
		String query = "update du_an set ten_du_an=?, mo_ta=?, ngay_bat_dau=?, ngay_ket_thuc=?, id_leader=? where id=?";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, duAn.getTenDuAn());
			statement.setString(2, duAn.getMoTa());
			statement.setString(3, duAn.getNgayBatDau());
			statement.setString(4, duAn.getNgayKetThuc());
			statement.setInt(5, duAn.getIdLeader());
			statement.setInt(6, duAn.getId());

			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	// trả ra 1 dự án => dùng cập nhật
	public DuAn getDuAnById(int id) {
		DuAn model = new DuAn();
		String query = "select * from du_an where id=?";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				model.setId(result.getInt("id"));
				model.setTenDuAn(result.getString("ten_du_an"));
				model.setMoTa(result.getString("mo_ta"));
				model.setNgayBatDau(result.getString("ngay_bat_dau"));
				model.setNgayKetThuc(result.getString("ngay_ket_thuc"));
				model.setIdLeader(result.getInt("id_leader"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	// trả ra 1,0
	public int deleteDuAnById(int id) {
		String query = "delete from du_an where id=?";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	/*CÁC HÀM KHÁC NGOÀI CRUD*/
	
	
	public ArrayList<DuAn> getListById(int userId){
		ArrayList<DuAn> models=new ArrayList<>();
		String query="select da.*, u.ho_ten from du_an da join user u where da.id_leader=u.id and da.id_leader=?";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, userId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				DuAn model = new DuAn();
				model.setId(result.getInt("id"));
				model.setTenDuAn(result.getString("ten_du_an"));
				model.setMoTa(result.getString("mo_ta"));
				model.setNgayBatDau(result.getString("ngay_bat_dau"));
				model.setNgayKetThuc(result.getString("ngay_ket_thuc"));
				model.setIdLeader(result.getInt("id_leader"));
				model.setTenLeader(result.getString("ho_ten"));
				models.add(model);
			}
			System.out.println("So du an: "+models.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}
}























