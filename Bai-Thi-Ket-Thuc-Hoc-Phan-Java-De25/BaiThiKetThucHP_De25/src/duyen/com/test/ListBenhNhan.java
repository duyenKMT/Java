
package duyen.com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import duyen.com.model.BenhAn;
import duyen.com.model.BenhNhan;

1
public class ListBenhNhan {
	public static ArrayList<BenhAn> ds=new ArrayList<BenhAn>();

	static void Menu() 
	{
		System.out.println("\n\t-------------------------------- MENU -------------------------------");
		System.out.println("\t--\t1. Thêm bệnh án                                            --");
		System.out.println("\t--\t2. Hiển thị thông tin bệnh án                              --");
		System.out.println("\t--\t3. Danh sách bệnh nhân trên 70 tuổi nằm khoa 'Ngoại'       --");
		System.out.println("\t--\t4. Danh sách bệnh nhân có tiền viện phí cao nhất           --");
		System.out.println("\t--\t5. Tổng số tiền viện phí thu được trong quý 2 năm 2021     --\n"
						 + "\t--\t   (từ 1/4/2021-30/6/2021)                                 --");
		System.out.println("\t--\t6.Thoát                                                    --");
		System.out.println("\t---------------------------------------------------------------------\n");
		
	}
	public static void menu()
	{	
		 SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		 Scanner sc= new Scanner(System.in);
		 int dem;
		 int chon;
		
		do {
			Menu();
			System.out.print("\n==>Mời nhập lựa chọn[1-6] của bạn:	");
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
				
				System.out.println("\n\t----------------------->   DANH SÁCH BỆNH ÁN   <-----------------------");	//- BỆNH NHÂN
				for(int i=0;i<ds.size();i++)
				{
					System.out.println("\t"+(i+1)+".");
					ds.get(i).showInfo();
				}
				break;
			
			case 3:
				System.out.println("\n\t--------->  DANH SÁCH BỆNH NHÂN TRÊN 70 TUỔI NẰM KHOA NGOẠI  <---------");
				dem=0;
				for(int i=0;i<ds.size();i++) {
					if(ds.get(i).TuoiCuaBN()>70 && ds.get(i).getKhoa().compareToIgnoreCase("Ngoại")==0 )
					{
						dem+=1;
						System.out.print("\t"+dem+".\n");
						ds.get(i).showInfo();
					}
					
				}
				if(dem==0)
					System.out.println("\t-Không có bệnh nhân nào");
				
				break;
			case 4:
				float max=ds.get(0).getVienPhi();
				System.out.println("\n\t---------->  DANH SÁCH BỆNH NHÂN CÓ TIỀN VIỆN PHÍ CAO NHẤT  <----------");
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
						System.out.println(("\t"+dem+"."));
						ds.get(i).showInfo();
					}
				}
				
				break;
			
			case 5:
				System.out.println("\n\t--------->  TỔNG TIỀN VIỆN PHÍ THU ĐƯỢC TRONG QUÝ 2 NĂM 2021  <---------");
				int tongTienVP=0;
				for(int i=0;i<ds.size();i++)
				{
					try {
						if(ds.get(i).getNgayRa().compareTo(sdf.parse("01/04/2021"))>=0 && ds.get(i).getNgayRa().compareTo(sdf.parse("30/06/2021"))<=0 )
						{
							tongTienVP+=ds.get(i).getVienPhi();
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("\t-Tổng tiền: "+ tongTienVP+" đồng");
				break;
			
			case 6:
				System.out.println("\n\t CẢM ƠN BẠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH, HẸN GẶP LẠI!");
				break;
			default:
				System.err.println("\nLựa chọn không hợp lệ!\nHãy nhập lựa chọn trong khoảng [1-6], lại nào:");
			}
			
		}while(chon!=6);
		
	}
	public static void main(String[] args) {
			menu();
		
	}

}