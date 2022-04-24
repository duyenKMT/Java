package duyen.com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class BenhAn extends BenhNhan {
	private String maBA;
	private String tenBA;
	private String khoa;
	private int phong;
	private Date ngayVao;
	private Date ngayRa;
	private float vienPhi;
	
	public BenhAn() {
		super();
	}
	public BenhAn(String maBA, String tenBA, String khoa, int phong, Date ngayVao, Date ngayRa, float vienPhi) {
		super();
		this.maBA = maBA;
		this.tenBA = tenBA;
		this.khoa = khoa;
		this.phong = phong;
		this.ngayVao = ngayVao;
		this.ngayRa = ngayRa;
		this.vienPhi = vienPhi;
	}
	
	
	@Override
	public  void inputInfo() {
		// TODO Auto-generated method stub
		super.inputInfo();
		Scanner in=new Scanner(System.in);
		System.out.print("-Ma benh an: ");
		maBA=in.nextLine();
		System.out.print("-Ten benh an: ");
		tenBA=in.nextLine();
		System.out.print("-Khoa: ");
		khoa=in.nextLine();
		System.out.print("-Phong: ");
		phong=Integer.parseInt(in.nextLine());
		System.out.print("-Ngay vao(dd/MM/yyyy): ");
		while(true)
		{
			String ngayVaoInput=in.nextLine();
			boolean check =setNgayVao(ngayVaoInput);
			if(check)
				break;
		
		}
		System.out.print("-Ngay ra(dd/MM/yyyy): ");
		while(true)
		{
			String ngayRaInput=in.nextLine();
			boolean check =setNgayRa(ngayRaInput);
			if(check)
				break;
		
		}

	}
	
	public String getMaBA() {
		return maBA;
	}
	public void setMaBA(String maBA) {
		this.maBA = maBA;
	}
	public String getTenBA() {
		return tenBA;
	}
	public void setTenBA(String tenBA) {
		this.tenBA = tenBA;
	}
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public int getPhong() {
		return phong;
	}
	public void setPhong(int phong) {
		this.phong = phong;
	}
	public Date getNgayVao() {
		return ngayVao;
	}
	public boolean setNgayVao(String ngayVao) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.ngayVao=sdf.parse(ngayVao);
			if((this.ngayVao.compareTo(this.ngaySinh)) <=0)
			{
				System.err.println("Ngay vao vien khong hop le!\nNote:Ngay vao vien phai sau ngay sinh chu, moi nhap lai:");
				return false;
			}
			else
				return true;
		} catch (Exception e) {
			System.err.println("&Note: Ngay, thang hoac nam khong hop le!"
					+ "			\n=> Moi nhap lai: ");
			return false;
		}
	}
	public Date getNgayRa() {
		return ngayRa;
	}
	public boolean setNgayRa(String ngayRa) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.ngayRa=sdf.parse(ngayRa);
			if((this.ngayRa.compareTo(this.ngayVao)) <=0)
			{
				System.err.println("Ngay ra vien khong hop le!\nNote:Ngay ra phai sau ngay vao chu, moi nhap lai:");
				return false;
			}	
			else
				return true;
			} 
		catch (Exception e) {
			System.err.println("&Note: Ngay, thang hoac nam khong hop le!"
					+ "			\n=> Moi nhap lai: ");
			return false;
		}
	}
	public float getVienPhi() {
		float vp=SoNgayNamVien(ngayVao, ngayRa)*200000;
		if(TuoiCuaBN()<5) {
			vienPhi=0;
		}
		else {
			if(bhyt.contentEquals("dung tuyen")==true)
				vienPhi= (float) (vp-vp*0.8);
			else if(bhyt.contentEquals("trai tuyen")==true)
				vienPhi= (float) (vp-vp*0.5);
			else
				vienPhi=vp;
		}
		return vienPhi;

	}
	public void showInfo() {
		super.showInfo();
		System.out.println("\t-Ma benh an: "+ maBA);
		System.out.println("\t-Ten benh an: "+ tenBA);
		System.out.println("\t-Khoa: "+ khoa);
		System.out.println("\t-Phong: "+phong);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("\t-Ngay vao: "+ sdf.format(ngayVao));
		System.out.println("\t-Ngay ra: "+sdf.format(ngayRa));
		System.out.println("\t-Vien phi: "+ (int)getVienPhi()+"VND");
	}
	public long SoNgayNamVien(Date d1, Date d2) {
		// chuyển 2 thời điểm sang mili giây
		long startValue= d1.getTime();
		long endValue= d2.getTime();
		//tính mili giây hiệu 2 thời điểm
		long tmp=Math.abs(startValue-endValue);
		//chia hiệu đó cho 1 ngày=> số ngày chênh lệch
		long result = tmp/(24*60*60*1000);
		return result;
	}
	//Tuổi của bệnh nhân= Ngày vào viện - Ngày sinh của bệnh nhân
	public long TuoiCuaBN() {
		long tuoi = 0;
		
		long startValue= getNgayVao().getTime();
		long endValue= ngaySinh.getTime();
		long tmp=Math.abs(startValue-endValue);
		long result = tmp/(24*60*60*1000);
		tuoi=result/365;
		
		return tuoi;
		
	}
	
}