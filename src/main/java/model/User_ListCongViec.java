package model;

import java.util.List;
//class này dùng cho trang xem chi tiết cv
public class User_ListCongViec {

	private String hoTen;
	private List<CongViec> congViecs;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public List<CongViec> getCongViecs() {
		return congViecs;
	}

	public void setCongViecs(List<CongViec> congViecs) {
		this.congViecs = congViecs;
	}

}
