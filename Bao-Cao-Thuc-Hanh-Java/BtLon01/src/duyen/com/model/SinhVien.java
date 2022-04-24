package duyen.com.model;

import java.util.Scanner;

public class SinhVien {
	private String mssv;
	private String hoTen;
	private String diaChi;
	private String sex;
	private String que;
	private	String email;
	private double diem1;
	private double diem2;
	private double diem3;
	private double diemTB;
	public SinhVien() {
		super();
	}
	public SinhVien(String mssv, String hoTen, String diaChi, String sex, String que, String email, double diem1,
			double diem2, double diem3, double diemTB) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sex = sex;
		this.que = que;
		this.email = email;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.diemTB = diemTB;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSex() {
		return sex;
	}
	public boolean setSex(String sex) {
		if(sex.contentEquals("nữ")==true|| sex.contentEquals("nam") == true) {
			this.sex = sex;
			return true;
		}
		else {
			System.err.println("=>Nhập lại giới tính('nam' hoặc 'nữ'): ");
			return false;
		}
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public String getEmail() {
		return email;
	}
	public boolean setEmail(String email) {
		if(email!=null && email.contains("@")&& !email.contains(" ")) {
			this.email = email;
			return true;
		}
		else {
			System.err.println("=>Nhập lại email(email#null và chứa @): ");
			return false;
		}
		
	}	
	public double getDiem1() {
		return diem1;
	}
	public boolean setDiem1(double diem1) {
		if(diem1>=0 && diem1<=10) {
			this.diem1 = diem1;
			return true;
		}
		else {
			System.err.println("Nhập lại điểm(0<=điểm<=10): ");
			return false;
		}
	}
	public double getDiem2() {
		return diem2;
	}
	public boolean setDiem2(double diem2) {
		if(diem1>=0 && diem1<=10) {
			this.diem2 = diem2;
			return true;
		}
		else {
			System.err.println("Nhập lại điểm(0<=điểm<=10): ");
			return false;
		}
	}
	public double getDiem3() {
		return diem3;
	}
	public boolean setDiem3(double diem3) {
		if(diem3>=0 && diem3<=10) {
			this.diem3 = diem3;
			return true;
		}
		else {
			System.err.println("Nhập lại điểm(0<=điểm<=10): ");
			return false;
		}
	}
	
	public void setDiemTB(double d1, double d2, double d3) {
		diemTB = (d1+d2+d3)/3;
	}
	public double getDiemTB() {
		return diemTB;
	}
	public void inputInfo()
	{
		Scanner input= new Scanner(System.in);
		System.out.print("-MSSV: ");
		mssv=input.nextLine();
		System.out.print("-Tên sinh viên: ");
		hoTen=input.nextLine();
		System.out.print("-Địa chỉ: ");
		diaChi=input.nextLine();
		System.out.print("-Giới tính: ");
		while(true)
		{
			String sexInput=input.nextLine();
			boolean check =setSex(sexInput);
			if(check)
				break;
		
		}
		
		System.out.print("-Quê quán: ");
		que=input.nextLine();
		System.out.print("-Email: ");
		while(true)
		{
			String emailInput=input.nextLine();
			boolean check =setEmail(emailInput);
			if(check)
				break;
		
		}
		
		System.out.print("-Điểm 1: ");
		while(true) {
			Double diem1Input=Double.parseDouble(input.nextLine());
			boolean check1 =setDiem1(diem1Input);
			if(check1)
				break;
		}
		System.out.print("-Điểm 2: ");
		while(true) {
			Double diem2Input=Double.parseDouble(input.nextLine());
			boolean check2 =setDiem2(diem2Input);
			if(check2)
				break;
		}
		System.out.print("-Điểm 3: ");
		while(true) {
			Double diem3Input=Double.parseDouble(input.nextLine());
			boolean check3 =setDiem3(diem3Input);
			if(check3)
				break;
		}
		setDiemTB(diem1, diem2, diem3);
		
	}
	public void showInfo()
	{
		System.out.print("\n-MSSV: "+mssv);
		System.out.print("\n-Tên sinh viên: "+hoTen);
		System.out.print("\n-Địa chỉ: "+diaChi);
		System.out.print("\n-Giới tính: "+sex);
		System.out.print("\n-Quê quán: "+que);
		System.out.print("\n-Email: "+email);
		System.out.print("\n-Điểm 1: "+diem1);
		System.out.print("\n-Điểm 2: "+diem2);
		System.out.print("\n-Điểm 3: "+diem3);
		System.out.print("\n-Điểm TB = "+ diemTB+"\n\n");
	}
	public boolean checkHocBong()
	{
		if(diemTB>=7 && diem1>5 && diem2>5 &&diem3>5) {
			return true;
		}
		return false;
	}
	public boolean checkGioiTinh() {
		if(sex.contentEquals("nữ")==true) {
			return true;
		}
		else return false;
	}
	
}
