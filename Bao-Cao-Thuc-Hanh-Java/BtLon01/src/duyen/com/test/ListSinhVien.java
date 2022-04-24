package duyen.com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import duyen.com.model.SinhVien;


public class ListSinhVien {
	static void menu()
	{
		System.out.println("\n>>>>>>>>>>>>>>> MENU <<<<<<<<<<<<<<<");
		System.out.println("1. Nhập n sinh viên");
		System.out.println("2. Hiển thị thông tin sinh viên");
		System.out.println("3. Thông tin sinh viên có điểm TB max ");
		System.out.println("4. Danh sách sinh viên đạt học bổng");
		System.out.println("5. Danh sách sinh viên theo thứ tự điểm trung bình tăng dần");
		System.out.println("6. Danh sách sinh viên theo thứ tự từ điển");
		System.out.println("7. Danh sách sinh viên nữ có điểm TB >7.0 và điểm 2>6");
		System.out.println("8. Thoát");
	}
	public static void main(String[] args) {
		ArrayList<SinhVien> ds=new ArrayList<>();
		int choose,dem;
		Scanner sc= new Scanner(System.in);
		do {
			menu();
			System.out.println("Choose: ");
			choose =Integer.parseInt(sc.nextLine());
			switch(choose)
			{
			case 1:
				int n;
				System.out.println("Nhập số lượng sinh viên: ");
				n=Integer.parseInt(sc.nextLine());
				for(int i=0; i<n;i++) {
					System.out.println("\n"+(i+1));
					SinhVien std= new SinhVien();
					std.inputInfo();
					ds.add(std);
				}
				break;
			case 2:
				System.out.println("=====DANH SÁCH SINH VIÊN=====");
				for(int i=0;i<ds.size();i++)
				{
					System.out.print( (i+1)+".");
					ds.get(i).showInfo();
				}
				break;
			case 3:
				
				int maxIndex=0;
				double maxDTB;
				maxDTB=ds.get(0).getDiemTB();
				for(int i=1;i<ds.size();i++)
				{
					if(ds.get(i).getDiemTB()>maxDTB) {
						maxDTB=ds.get(i).getDiemTB();
						maxIndex=i;
					}
				}
				System.out.println("--------Thông tin SV có ĐTB cao nhất--------");
				ds.get(maxIndex).showInfo();
				break;
			case 4:
				System.out.println("--------DSSV đạt học bổng--------");
				dem=0;
				for(int i=0;i<ds.size();i++) {
					if(ds.get(i).checkHocBong()==true)
					{
						dem+=1;
						System.out.print(dem+".");
						ds.get(i).showInfo();
						
					}
				}
				break;
			case 5:
				Collections.sort(ds,new Comparator<SinhVien>() {

					@Override
					public int compare(SinhVien o1, SinhVien o2) {
						return o1.getDiemTB()>=o2.getDiemTB()?1:-1;
					}
				});
				System.out.println("--------DSSV theo thứ tự điểm trung bình tăng dần--------");
				dem=0;
				for(int i=0; i<ds.size();i++) {
					dem+=1;
					System.out.print(dem+".");
					ds.get(i).showInfo();
				}
				break;
			case 6:
				Collections.sort(ds,new Comparator<SinhVien>() {

					@Override
					public int compare(SinhVien o1, SinhVien o2) {
						int cmp=o1.getHoTen().compareTo(o2.getHoTen());
						if(cmp>=0) 
						{
							return 1;
						}
						return -1;
					}
					
				});
				System.out.println("--------DSSV theo thứ tự từ điển--------");
				for(int i=0; i<ds.size();i++) {
					System.out.print((i+1)+".");
					ds.get(i).showInfo();
				}
				break;
			case 7:
				System.out.println("-------- DSSV nữ có điểm TB lớn hơn 7.0 và điểm 2 lớn hơn 6.0 --------");
				dem=0;
				for(int i=0;i<ds.size();i++) {
					if(ds.get(i).checkGioiTinh()==true && ds.get(i).getDiemTB()>7.0 && ds.get(i).getDiem2()>6)
					{
						dem+=1;
						System.out.print((dem+"."));
						ds.get(i).showInfo();
					}
				}
				break;
			case 8:
				System.out.println("      Goodbye!!!!!!!!!!");
				break;
			default:
				System.err.println("Nhập lụi rồi nha");
			} 
		}while(choose!=8);
	}

}
