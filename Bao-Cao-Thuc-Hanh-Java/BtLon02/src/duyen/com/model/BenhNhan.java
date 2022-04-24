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
	
	public void inputInfo()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("-Mã bệnh nhân: ");
		maBN=in.nextLine();
		System.out.print("-Tên bệnh nhân: ");
		tenBN=in.nextLine();
		System.out.print("-Địa chỉ: ");
		diaChi=in.nextLine();
		System.out.print("-Điện thoại: ");
		dienThoai=in.nextLine();
		System.out.print("-Giới tính(nam/nữ): ");
		while(true)
		{
			String sexInput=in.nextLine();
			boolean check =setGioiTinh(sexInput);
			if(check)
				break;
		
		}
		System.out.print("-Ngày sinh(dd/MM/yyyy): ");
		while(true)
		{
			String ngaySinhInput=in.nextLine();
			boolean check =setNgaySinh(ngaySinhInput);
			if(check)
				break;
		
		}
		
		System.out.print("-Bảo hiểm y tế(đúng tuyến/trái tuyến/không tham gia): ");
		while(true)
		{
			String bhytInput=in.nextLine();
			boolean check =setBhyt(bhytInput);
			if(check)
				break;
		
		}
		
	}
	
	public void showInfo()
	{
		System.out.print("\n-Mã bệnh nhân: "+ maBN);
		System.out.print("\n-Tên bệnh nhân: "+ tenBN);
		System.out.print("\n-Địa chỉ: "+ diaChi);
		System.out.print("\n-Điện thoại: "+dienThoai);
		System.out.print("\n-Giới tính: "+ gioiTinh);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("\n-Ngày sinh: "+sdf.format(ngaySinh));
		System.out.print("\n-Bảo hiểm y tế: "+ bhyt);
		
	}
	
	public String getMaBN() {
		return maBN;
	}
	public void setMaBN(String maBN) {
		this.maBN = maBN;
	}
	public String getTenBN() {
		return tenBN;
	}
	public void setTenBN(String tenBN) {
		this.tenBN = tenBN;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public boolean setGioiTinh(String gioiTinh) {
		if(gioiTinh.contentEquals("nữ")==true|| gioiTinh.contentEquals("nam") == true) {
			this.gioiTinh = gioiTinh;
			return true;
		}
		else {
			System.err.println("=>Nhập lại giới tính('nam' hoặc 'nữ'): ");
			return false;
		}
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public boolean setNgaySinh(String ngaySinh) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.ngaySinh=sdf.parse(ngaySinh);
			return true;
		} catch (Exception e) {
			System.err.println("&Note: Ngày, tháng hoặc năm không hợp lệ!"
					+ "			\n=> Mời nhập lại: ");
			return false;
		}
	}
	public String getBhyt() {
		return bhyt;
	}
	public boolean setBhyt(String bhyt) {
		if(bhyt.contentEquals("đúng tuyến")==true||bhyt.contentEquals("trái tuyến")==true|| bhyt.contentEquals("không tham gia") == true) {
			this.bhyt = bhyt;
			return true;
		}
		else {
			System.err.println("=>Nhập lại thông tin bhyt('đúng tuyến' hoặc 'trái tuyến') hoặc 'không tham gia: ");
			return false;
		}
	}
	
	
}
