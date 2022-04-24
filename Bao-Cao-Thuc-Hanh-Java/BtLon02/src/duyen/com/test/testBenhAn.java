package duyen.com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import duyen.com.model.BenhAn;
import duyen.com.model.BenhNhan;


public class testBenhAn {
	public static ArrayList<BenhAn> ds=new ArrayList<BenhAn>();

	static void Menu() 
	{
		System.out.println("\n----------------- MENU ----------------");
		System.out.println("1. Thêm bệnh án");
		System.out.println("2. Hiển thị thông tin bệnh án");
		System.out.println("3. Danh sách bệnh nhân dưới 5 tuổi ");
		System.out.println("4. Danh sách bệnh nhân trên 70 tuổi nằm 'khoa ngoại'");
		System.out.println("5. Danh sách bệnh nhân có tiền viện phí cao nhất");
		System.out.println("6. Tổng số bệnh nhân nằm viện từ ngày 20/2/2021 đến 13/4/2021");
		System.out.println("7. Tổng số bệnh nhân ra viện từ ngày 20/2/2021 đến 13/4/2021");
		System.out.println("8. tổng số tiền viện phí thu được trong quý 1 năm 2021(từ 1/1/2021-31/3/2021)");
		System.out.println("9. Danh sách bệnh nhân nam 30 tuổi nằm viện trong quý 1 năm 2021");
		System.out.println("10.Danh sách bệnh nhân có bảo hiểm y tế và có tiền viện phí>2 triệu");
		System.out.println("11.Danh sách bệnh nhân không có bảo hiểm y tế có viện phí >10 triệu");
		System.out.println("12.Danh sách bênh nhân dưới<30 tuổi trái tuyến bảo hiểm");
		System.out.println("13.Thoát");
		
	}
	public static void menu()
	{	
		 SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		 Scanner sc= new Scanner(System.in);
		 int dem;
		 int chon;
		
		do {
			Menu();
			System.out.print("\n==>Mời nhập lựa chọn?	");
			chon =Integer.parseInt(sc.nextLine());
			switch(chon)
			{
			case 1:
				int n;
				System.out.println("Nhập số lượng bệnh án: ");
				n=Integer.parseInt(sc.nextLine());
				for(int i=0; i<n;i++) {
					System.out.println("\n"+(i+1));
					BenhAn ba=new BenhAn();
					ba.inputInfo();
					
					ds.add(ba);
				}
				break;
			case 2:
				System.out.println("----- DANH SÁCH BỆNH NHÂN -----");	//- BỆNH NHÂN
				for(int i=0;i<ds.size();i++)
				{
					System.out.println((i+1));
					ds.get(i).getVienPhi();
					ds.get(i).showInfo();
					System.out.println("\n");
				}
				System.out.println("----- DANH SÁCH BỆNH ÁN -----");	//- BỆNH NHÂN
				for(int i=0;i<ds.size();i++)
				{
					System.out.println((i+1));
					ds.get(i).showInfo2();
					System.out.println("\n");
				}
				break;
			case 3:
				
				System.out.println("-------- DANH SÁCH BỆNH NHÂN DƯỚI 5 TUỔI --------");
				dem=0;
				for(int i=0;i<ds.size();i++) {
					if(ds.get(i).TuoiCuaBN() <5 )
					{
						dem+=1;
						System.out.print((dem+"."));
						ds.get(i).showInfo();
					}
				}
				break;
			case 4:
				System.out.println("-------- DANH SÁCH BỆNH NHÂN TRÊN 70 TUỔI NẰM KHOA NGOẠI --------");
				dem=0;
				for(int i=0;i<ds.size();i++) {
					if(ds.get(i).TuoiCuaBN()>70 && ds.get(i).getKhoa().compareToIgnoreCase("Ngoại")==0 )
					{
						dem+=1;
						System.out.print((dem+"."));
						ds.get(i).showInfo();
					}
					
				}
				
				break;
			case 5:
				float max=ds.get(0).getVienPhi();
				System.out.println("-------- DANH SÁCH BỆNH NHÂN CÓ TIỀN VIỆN PHÍ CAO NHẤT --------");
				for(int i=1;i<ds.size();i++) {
					if(ds.get(i).getVienPhi()>max)
					{
						max=ds.get(i).getVienPhi();
					}
					
				}
				dem=0;
				for(int i=0;i<ds.size();i++)
				{
					if(max==ds.get(i).getVienPhi())
					{
						dem+=1;
						System.out.print(("\n"+dem+"."));
						ds.get(i).showInfo();
					}
				}
				break;
			case 6:
				System.out.println("-------- TỔNG SỐ BỆNH NHÂN NẰM VIỆN TỪ 20/02/2021 ĐẾN 13/04/2021 --------");
				int tongNam=0;
				for(int i=0;i<ds.size();i++)
				{
					try {
						if(ds.get(i).getNgayVao().compareTo(sdf.parse("20/02/2021"))>=0 && ds.get(i).getNgayVao().compareTo(sdf.parse("13/04/2021"))<=0 )
						{
							tongNam+=1;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(">>>>>>>> Kết quả: "+tongNam+" bệnh nhân");
				break;
			case 7:
				System.out.println("-------- TỔNG SỐ BỆNH NHÂN RA VIỆN TỪ 20/02/2021 ĐẾN 13/04/2021 --------");
				int tongRa=0;
				for(int i=0;i<ds.size();i++)
				{
					try {
						if(ds.get(i).getNgayRa().compareTo(sdf.parse("20/02/2021"))>=0 && ds.get(i).getNgayRa().compareTo(sdf.parse("13/04/2021"))<=0 )
						{
							tongRa+=1;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(">>>>>> Kết quả: "+tongRa+" bệnh nhân");
				break;
			case 8:
				System.out.println("-------- TỔNG TIỀN VIỆN PHÍ THU ĐƯỢC TRONG QUÝ 1 NĂM 2021 --------");
				float tongTienVP=0;
				for(int i=0;i<ds.size();i++)
				{
					try {
						if(ds.get(i).getNgayRa().compareTo(sdf.parse("01/01/2021"))>=0 && ds.get(i).getNgayRa().compareTo(sdf.parse("31/03/2021"))<=0 )
						{
							tongTienVP+=ds.get(i).getVienPhi();
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Tổng tiền: "+ tongTienVP+" ngàn đồng");
				break;
			case 9:
				System.out.println("-------- DANH SÁCH BỆNH NHÂN NAM 30 TUỔI NẰM VIỆN TRONG QUÝ 1 NĂM 2021 --------");
				dem=0;
				for(int i=0;i<ds.size();i++)
				{
					try {
						if(ds.get(i).getGioiTinh().contains("nam")==true && ds.get(i).TuoiCuaBN()==30
							&& ds.get(i).getNgayVao().compareTo(sdf.parse("01/01/2021"))>=0 && ds.get(i).getNgayVao().compareTo(sdf.parse("31/03/2021"))<=0 )
						{
							dem+=1;
							System.out.print(("\n"+dem+"."));
							ds.get(i).showInfo();
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				break;
			case 10:
				System.out.println("-------- DANH SÁCH BỆNH NHÂN CÓ BHYT VÀ TIỀN VIỆN PHÍ TRÊN 2 TRIỆU --------");
				dem=0;
				for(int i=0;i<ds.size();i++)
				{
					if(ds.get(i).getBhyt().contains("không tham gia")==false && ds.get(i).getVienPhi()>2000)
					{
						dem+=1;
						System.out.print(("\n"+dem+"."));
						ds.get(i).showInfo();
					}
				}
				break;
			case 11:
				System.out.println("-------- DANH SÁCH BỆNH NHÂN KHÔNG CÓ BHYT VÀ TIỀN VIỆN PHÍ TRÊN 10 TRIỆU --------");
				dem=0;
				for(int i=0;i<ds.size();i++)
				{
					if(ds.get(i).getBhyt().contains("không tham gia")==true && ds.get(i).getVienPhi()>10000)
					{
						dem+=1;
						System.out.print(("\n"+dem+"."));
						ds.get(i).showInfo();
					}
				}
				break;
			case 12:
				System.out.println("-------- DANH SÁCH BỆNH NHÂN DƯỚI 20 TUỔI TRÁI TUYẾN BẢO HIỂM --------");
				dem=0;
				for(int i=0;i<ds.size();i++)
				{
					if(ds.get(i).getBhyt().contains("trái tuyến")==true && ds.get(i).TuoiCuaBN()<20 )
					{
						dem+=1;
						System.out.print(("\n"+dem+"."));
						ds.get(i).showInfo();
					}
				}
				break;
			case 13:
				System.out.println(">>>>>>>> SEE YOU <<<<<<<<");
				break;
			default:
				System.err.println("Nhập lụi rồi nha");
			}
			
		}while(chon!=13);
		
	}
	public static void main(String[] args) {
			menu();
		
	}

}
