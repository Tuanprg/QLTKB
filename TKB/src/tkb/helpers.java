/* * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package tkb;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class helpers {
    public static boolean isValidMenuChoice(String choice, int maxChoice){
        try {
            int choiceNum = Integer.parseInt(choice);
            return choiceNum > 0 && choiceNum <= maxChoice;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean isNumber(String val){
        try{
            int n = Integer.parseInt(val);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    public static boolean checkExistingGiaoVien(ArrayList<GiaoVien> gvList, int gvId){
        for(GiaoVien g : gvList){
            if(g.getId() == gvId){
                return true;
            }
        }
        return false;
    }
    public static boolean checkExistingLopHoc(ArrayList<LopHoc> lhList, int lhId){
        for(LopHoc l : lhList){
            if(l.getId() == lhId){
                return true;
            }
        }
        return false;
    }
    public static boolean checkExistingMonHoc(ArrayList<MonHoc> MhList, String id){
        try{
            int mhID = Integer.parseInt(id);
            for(MonHoc m : MhList){
                if(m.getMId() == mhID){
                    return true;
                }
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }
    public static void danhSachGiaoVien(ArrayList<GiaoVien> gvList, ArrayList<MonHoc> mhList){
        System.out.println(String.format("%-10s %-15s %-15s", "ID","Tên giáo viên","Môn Học"));
        for(GiaoVien g : gvList){
            for(MonHoc m : mhList){
                if(g.getMId() == m.getMId()){
                    System.out.println(String.format("%-10s %-15s %-15s", g.getId(),g.getName(), m.getMname()));
                }
            }
        }
    }
    public static void danhSachLopHoc(ArrayList<LopHoc> lhList){
        System.out.println(String.format("%-10s %-15s %-15s", "ID","Tên lớp","Sĩ số"));
        for(LopHoc l : lhList){
            System.out.println(String.format("%-10s %-15s %-15s", l.getId(),l.getName(), l.getSsl()));
        }
    }
    public static void danhSachMonHoc(ArrayList<MonHoc> mhList){
        System.out.println(String.format("%-10s %-15s", "Mã môn","Môn học"));
        for(MonHoc m : mhList){
            System.out.println(String.format("%-10s %-15s", m.getMId(), m.getMname()));
        }
    }
    public static void danhSachNgayTrongTuan(){
        System.out.println("1. Thứ Hai");
        System.out.println("2. Thứ Ba");
        System.out.println("3. Thứ Tư");
        System.out.println("4. Thứ Năm");
        System.out.println("5. Thứ Sáu");
        System.out.println("6. Thứ Bảy");
    }
    public static void danhSachLopHoc2(ArrayList<LopHoc> lhList){
        int i = 1;
        for(LopHoc l : lhList){
            System.out.println(i + ". " + l.getName());
            i++;
        }
    }
    public static void danhSachMonHoc2(ArrayList<MonHoc> mhList){
        int i = 1;
        for(MonHoc m : mhList){
            System.out.println(i + ". " + m.getMname());
            i++;
        }
    }
    public static void timGiaoVienBangMonHoc(ArrayList<GiaoVien> gvList, int mhID){
        int i = 1;
        for(GiaoVien gv: gvList){
            if(gv.getMId() == mhID){
                System.out.println(i +". "+ gv.getName());
                i++;
            }
        }
    }
    public static void danhSachThoiKhoaBieu(ArrayList<GiaoVien> gvList, ArrayList<LopHoc> lhList, ArrayList<MonHoc> mhList, ArrayList<TKB> tkbList ){
        System.out.println(String.format("%-15s %-15s %-15s %-15s", "Thứ","Lớp","Môn học", "Giáo viên"));
        for(TKB t : tkbList){
            for(LopHoc l : lhList){
                if (t.getLid() == l.getId()){
                    for(MonHoc m : mhList){
                        if(t.getMid() == m.getMId()){
                            for(GiaoVien g : gvList){
                                if(g.getMId() == m.getMId()){
                                    System.out.println(String.format("%-15s %-15s %-15s %-15s", t.getDay(), l.getName(),m.getMname(), g.getName()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

