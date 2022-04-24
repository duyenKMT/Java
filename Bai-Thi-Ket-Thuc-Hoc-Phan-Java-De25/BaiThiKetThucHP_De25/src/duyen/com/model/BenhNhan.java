package duyen.com.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BenhNhan {
	protected String maBN;
	protected String tenBN;
	protected String diaChi;
	protected String dienThoai;
	protected String gioiTinh;
	protected Date ngaySinh;
	protected String bhyt;
	public BenhNhan() {
		super();
	}
	public BenhNhan(String maBN, String tenBN, String diaChi, String dienThoai,
			String gioiTinh, Date ngaySinh,String bhyt) {
		super();
		this.maBN = maBN;
		this.tenBN = tenBN;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.bhyt = bhyt;
	}

    void inputInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void showInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}