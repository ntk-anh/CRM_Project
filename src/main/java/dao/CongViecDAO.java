package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.JDBCConnection;
import model.CongViec;
import model.Role;
import model.ThongKeCV1Member;
import model.TrangThaiCV_SoLuong;

public class CongViecDAO {

	// trả ra bảng cv có thêm 3 cột : tên dự án, tên user, tên trạng thái => để load danh sách cv cho admin
	public ArrayList<CongViec> getAllCongViec() {
		ArrayList<CongViec> models = new ArrayList<>();
		String query = "select  cv.id, cv.ten_cv, cv.ngay_bat_dau, cv.ngay_ket_thuc, cv.id_du_an, cv.id_user_thuc_hien, cv.id_trang_thai_cv, da.ten_du_an, u.ho_ten, tt.ten_trang_thai\r\n"
				+ "from cong_viec cv \r\n" + "inner join du_an da on cv.id_du_an=da.id\r\n"
				+ "inner join user u on cv.id_user_thuc_hien=u.id\r\n"
				+ "inner join trang_thai_cv tt on cv.id_trang_thai_cv=tt.id";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				CongViec model = new CongViec();
				model.setId(result.getInt("id"));
				model.setTenCongViec(result.getString("ten_cv"));
				model.setNgayBatDau(result.getString("ngay_bat_dau"));
				model.setNgayKetThuc(result.getString("ngay_ket_thuc"));
				model.setIdDuAn(result.getInt("id_du_an"));
				model.setIdUser(result.getInt("id_user_thuc_hien"));
				model.setIdTrangThaiCV(result.getInt("id_trang_thai_cv"));
				model.setTenDuAn(result.getString("ten_du_an"));
				model.setTenUser(result.getString("ho_ten"));
				model.setTenTrangThai(result.getString("ten_trang_thai"));

				models.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}
	
	//dùng cho việc load list cv của 1 leader
	public ArrayList<CongViec> getAllByIdleader(int idLeader) {
		ArrayList<CongViec> models = new ArrayList<>();
		String query = "select  cv.id, cv.ten_cv, cv.ngay_bat_dau, cv.ngay_ket_thuc, cv.id_du_an, cv.id_user_thuc_hien, cv.id_trang_thai_cv, da.ten_du_an, u.ho_ten, tt.ten_trang_thai \r\n"
				+ "		from cong_viec cv \r\n"
				+ "     inner join du_an da on cv.id_du_an=da.id \r\n"
				+ "		inner join user u on cv.id_user_thuc_hien=u.id \r\n"
				+ "		inner join trang_thai_cv tt on cv.id_trang_thai_cv=tt.id\r\n"
				+ "     where da.id_leader=?";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idLeader);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				CongViec model = new CongViec();
				model.setId(result.getInt("id"));
				model.setTenCongViec(result.getString("ten_cv"));
				model.setNgayBatDau(result.getString("ngay_bat_dau"));
				model.setNgayKetThuc(result.getString("ngay_ket_thuc"));
				model.setIdDuAn(result.getInt("id_du_an"));
				model.setIdUser(result.getInt("id_user_thuc_hien"));
				model.setIdTrangThaiCV(result.getInt("id_trang_thai_cv"));
				model.setTenDuAn(result.getString("ten_du_an"));
				model.setTenUser(result.getString("ho_ten"));
				model.setTenTrangThai(result.getString("ten_trang_thai"));

				models.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}
	
			// trả ra bảng cv có thêm 3 cột : tên dự án, tên user, tên trạng thái => để load danh sách cv cho member
			public ArrayList<CongViec> getAllCongViecByUserId(int id) {
				ArrayList<CongViec> models = new ArrayList<>();
				String query = "select  cv.id, cv.ten_cv, cv.ngay_bat_dau, cv.ngay_ket_thuc, cv.id_du_an, cv.id_user_thuc_hien, cv.id_trang_thai_cv, da.ten_du_an, u.ho_ten, tt.ten_trang_thai \r\n"
						+ " from cong_viec cv \r\n"
						+ " inner join du_an da on cv.id_du_an=da.id \r\n"
						+ " inner join user u on cv.id_user_thuc_hien=u.id\r\n"
						+ " inner join trang_thai_cv tt on cv.id_trang_thai_cv=tt.id\r\n"
						+ " where cv.id_user_thuc_hien=?";
				try (Connection conn = JDBCConnection.getConnection()) {
					PreparedStatement statement = conn.prepareStatement(query);
					statement.setInt(1, id);
					ResultSet result = statement.executeQuery();
					while (result.next()) {
						CongViec model = new CongViec();
						model.setId(result.getInt("id"));
						model.setTenCongViec(result.getString("ten_cv"));
						model.setNgayBatDau(result.getString("ngay_bat_dau"));
						model.setNgayKetThuc(result.getString("ngay_ket_thuc"));
						model.setIdDuAn(result.getInt("id_du_an"));
						model.setIdUser(result.getInt("id_user_thuc_hien"));
						model.setIdTrangThaiCV(result.getInt("id_trang_thai_cv"));
						model.setTenDuAn(result.getString("ten_du_an"));
						model.setTenUser(result.getString("ho_ten"));
						model.setTenTrangThai(result.getString("ten_trang_thai"));

						models.add(model);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return models;
			}

	// trả ra kq 1,0
	public int insertCongViec(CongViec model) {
		String query = "insert into cong_viec (ten_cv, ngay_bat_dau,ngay_ket_thuc,id_user_thuc_hien,id_du_an,id_trang_thai_cv) values (?,?,?,?,?,?)";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, model.getTenCongViec());
			statement.setString(2, model.getNgayBatDau());
			statement.setString(3, model.getNgayKetThuc());
			statement.setInt(4, model.getIdUser());
			statement.setInt(5, model.getIdDuAn());
			statement.setInt(6, model.getIdTrangThaiCV());

			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;// nếu thành công trả về 1
	}

	// trả ra kq 1,0
	public int updateCongViec(CongViec model) {
		String query = "update cong_viec set ten_cv=?,   ngay_bat_dau=?,ngay_ket_thuc=?,id_user_thuc_hien=?,id_du_an=?,id_trang_thai_cv=? where id=?";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, model.getTenCongViec());
			statement.setString(2, model.getNgayBatDau());
			statement.setString(3, model.getNgayKetThuc());
			statement.setInt(4, model.getIdUser());
			statement.setInt(5, model.getIdDuAn());
			statement.setInt(6, model.getIdTrangThaiCV());
			statement.setInt(7, model.getId());

			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;// sửa thất bại
	}

	// trả ra 1 cv có thêm 3 cột : tên dự án, tên user, tên trạng thái => để load
	public CongViec getCongViecById(int id) {
		CongViec model = new CongViec();
		String query = "select  cv.id, cv.ten_cv, cv.ngay_bat_dau, cv.ngay_ket_thuc, cv.id_du_an, cv.id_user_thuc_hien, cv.id_trang_thai_cv, da.ten_du_an, u.ho_ten, tt.ten_trang_thai\r\n"
				+ "from cong_viec cv \r\n" + "inner join du_an da on cv.id_du_an=da.id\r\n"
				+ "inner join user u on cv.id_user_thuc_hien=u.id\r\n"
				+ "inner join trang_thai_cv tt on cv.id_trang_thai_cv=tt.id " + "where cv.id=?";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				model.setId(result.getInt("id"));
				model.setTenCongViec(result.getString("ten_cv"));
				model.setNgayBatDau(result.getString("ngay_bat_dau"));
				model.setNgayKetThuc(result.getString("ngay_ket_thuc"));
				model.setIdDuAn(result.getInt("id_du_an"));
				model.setIdUser(result.getInt("id_user_thuc_hien"));
				model.setIdTrangThaiCV(result.getInt("id_trang_thai_cv"));
				model.setTenDuAn(result.getString("ten_du_an"));
				model.setTenUser(result.getString("ho_ten"));
				model.setTenTrangThai(result.getString("ten_trang_thai"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	// trả ra kết quả 1/0
	public int deleteCongViecById(int id) {
		String query = "delete from cong_viec where id=?";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;// thất bại thì trả ra 0
	}

	/* HÀM KHÁC CRUD */
	// trả ra 1 list công việc
	public ArrayList<CongViec> getByDuAnIdAndUserId(int duAnId, int userId) {
		ArrayList<CongViec> models = new ArrayList<CongViec>();
		String query = "select  cv.id, cv.ten_cv, cv.ngay_bat_dau, cv.ngay_ket_thuc, cv.id_du_an, cv.id_user_thuc_hien, cv.id_trang_thai_cv, u.ho_ten, tt.ten_trang_thai from cong_viec cv	inner join user u on cv.id_user_thuc_hien=u.id	 inner join trang_thai_cv tt on cv.id_trang_thai_cv=tt.id	where  cv.id_du_an=? and cv.id_user_thuc_hien=? ";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, duAnId);
			statement.setInt(2, userId);

			ResultSet res = statement.executeQuery();
			while (res.next()) {
				CongViec model = new CongViec();
				model.setId(res.getInt("id"));
				model.setTenCongViec(res.getString("ten_cv"));
				model.setNgayBatDau(res.getString("ngay_bat_dau"));
				model.setNgayKetThuc(res.getString("ngay_ket_thuc"));
				model.setIdDuAn(res.getInt("id_du_an"));
				model.setIdUser(res.getInt("id_user_thuc_hien"));
				model.setIdTrangThaiCV(res.getInt("id_trang_thai_cv"));
				model.setTenUser(res.getString("ho_ten"));
				model.setTenTrangThai(res.getString("ten_trang_thai"));
				models.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (models.size() == 0) {
			System.out.println("truy van that bai");
		} else {
			System.out.println("truy van thanh cong");
		}
		return models;
	}

	// trả ra list userId
	public ArrayList<Integer> getUserIdByDuAnId(int duAnId) {
		ArrayList<Integer> models = new ArrayList<>();
		String query = "select distinct id_user_thuc_hien from cong_viec where id_du_an=? order by id_du_an asc";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, duAnId);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				models.add(res.getInt("id_user_thuc_hien"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}

	// trả ra list congViec
	public ArrayList<CongViec> getByDuAnId(int duAnId) {
		ArrayList<CongViec> models = new ArrayList<>();
		String query = "select  cv.id, cv.ten_cv, cv.ngay_bat_dau, cv.ngay_ket_thuc, cv.id_du_an, cv.id_user_thuc_hien, cv.id_trang_thai_cv, da.ten_du_an, u.ho_ten, tt.ten_trang_thai "
				+ "from cong_viec cv  " + "inner join du_an da on cv.id_du_an=da.id "
				+ "inner join user u on cv.id_user_thuc_hien=u.id  "
				+ "inner join trang_thai_cv tt on cv.id_trang_thai_cv=tt.id where  cv.id_du_an=? ";
		try (Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, duAnId);

			ResultSet res = statement.executeQuery();
			while (res.next()) {
				CongViec model = new CongViec();
				model.setId(res.getInt("id"));
				model.setTenCongViec(res.getString("ten_cv"));
				model.setNgayBatDau(res.getString("ngay_bat_dau"));
				model.setNgayKetThuc(res.getString("ngay_ket_thuc"));
				model.setIdDuAn(res.getInt("id_du_an"));
				model.setIdUser(res.getInt("id_user_thuc_hien"));
				model.setIdTrangThaiCV(res.getInt("id_trang_thai_cv"));
				model.setTenUser(res.getString("ho_ten"));
				model.setTenDuAn(res.getString("ten_du_an"));
				model.setTenTrangThai(res.getString("ten_trang_thai"));

				models.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}

	// trả ra list TrangThaiCV_SoLuong:id_trang_thai_cv,soLuongCV
	public ArrayList<TrangThaiCV_SoLuong> getTrangThaiCV_SoLuongByDuAnId(int duAnId) {
		ArrayList<TrangThaiCV_SoLuong> models = new ArrayList<>();
		String query="select  id_trang_thai_cv, count(id) as soLuongCV from cong_viec where id_du_an=? group by id_trang_thai_cv";
		try (Connection conn=JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, duAnId);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				TrangThaiCV_SoLuong model=new TrangThaiCV_SoLuong();
				model.setIdTrangThai(res.getInt("id_trang_thai_cv"));
				model.setSoLuongCV(Integer.parseInt(res.getString("soLuongCV")));
				models.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}
	
	//trả ra list cv của 1 user id: id_trang_thái, soLuongCV
	public ArrayList<ThongKeCV1Member> getThongKeCV1Member(int userId) {
		ArrayList<ThongKeCV1Member> models=new ArrayList<>();
		
		String query = "select  id_trang_thai_cv, count(id) as soLuongCV from cong_viec where id_user_thuc_hien=? group by id_trang_thai_cv";
		try (Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ThongKeCV1Member model=new ThongKeCV1Member();
				model.setIdTrangThaiCV(resultSet.getInt("id_trang_thai_cv"));
				model.setSoLuong(resultSet.getInt("soLuongCV"));
				models.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return models;
	}

}
