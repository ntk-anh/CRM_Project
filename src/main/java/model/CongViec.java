package model;

public class CongViec {

	private int id;
	private String tenCongViec; 
	private String ngayBatDau;
	private String ngayKetThuc;
	private int idUser;
	private int idDuAn;
	private int idTrangThaiCV;
	//
	private String tenUser;
	private String tenDuAn;
	private String tenTrangThai;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenCongViec() {
		return tenCongViec;
	}
	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	} 
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdDuAn() {
		return idDuAn;
	}
	public void setIdDuAn(int idDuAn) {
		this.idDuAn = idDuAn;
	}
	public int getIdTrangThaiCV() {
		return idTrangThaiCV;
	}
	public void setIdTrangThaiCV(int idTrangThaiCV) {
		this.idTrangThaiCV = idTrangThaiCV;
	}
	public String getTenUser() {
		return tenUser;
	}
	public void setTenUser(String tenUser) {
		this.tenUser = tenUser;
	}
	public String getTenDuAn() {
		return tenDuAn;
	}
	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	} 
}
