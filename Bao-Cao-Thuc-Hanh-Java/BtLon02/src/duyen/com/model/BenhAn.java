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
		System.out.print("-Mã bệnh án: ");
		maBA=in.nextLine();
		System.out.print("-Tên bệnh án: ");
		tenBA=in.nextLine();
		System.out.print("-Khoa: ");
		khoa=in.nextLine();
		System.out.print("-Phòng: ");
		phong=Integer.parseInt(in.nextLine());
		System.out.print("-Ngày vào(dd/MM/yyyy): ");
		while(true)
		{
			String ngayVaoInput=in.nextLine();
			boolean check =setNgayVao(ngayVaoInput);
			if(check)
				break;
		
		}
		System.out.print("-Ngày ra(dd/MM/yyyy): ");
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
			return true;
		} catch (Exception e) {
			System.err.println("&Note: Ngày, tháng hoặc năm không hợp lệ!"
					+ "			\n=> Mời nhập lại: ");
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
			return true;
			} 
		catch (Exception e) {
			System.err.println("&Note: Ngày, tháng hoặc năm không hợp lệ!"
					+ "			\n=> Mời nhập lại: ");
			return false;
		}
	}
	public float getVienPhi() {
		float vp=SoNgayNamVien(ngayVao, ngayRa)*200;
		if(TuoiCuaBN()<5) {
			vienPhi=0;
		}
		else {
			if(bhyt.contentEquals("đúng tuyến")==true)
				vienPhi= (float) (vp-vp*0.8);
			else if(bhyt.contentEquals("trái tuyến")==true)
				vienPhi= (float) (vp-vp*0.5);
			else
				vienPhi=vp;
		}
		return vienPhi;

	}
	public void showInfo2() {
		//super.showInfo();
		System.out.print("\n-Mã bệnh án: "+ maBA);
		System.out.print("\n-Tên bệnh án: "+ tenBA);
		System.out.print("\n-Khoa: "+ khoa);
		System.out.print("\n-Phòng: "+phong);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("\n-Ngày vào: "+ sdf.format(ngayVao));
		System.out.print("\n-Ngày ra: "+sdf.format(ngayRa));
		System.out.print("\n-Viện phí: "+ vienPhi+" ngàn đồng");
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
	public long TuoiCuaBN() {
		Calendar cal= Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String dateNow= sdf.format(cal.getTime());
		long tuoi = 0;
		try {
			Date timeNow= sdf.parse(dateNow);
			long startValue= timeNow.getTime();
			long endValue= ngaySinh.getTime();
			long tmp=Math.abs(startValue-endValue);
			long result = tmp/(24*60*60*1000);
			tuoi=result/365;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tuoi;
		
	}
	
}
