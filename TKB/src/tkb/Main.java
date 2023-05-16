/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tkb;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        helpers helper = new helpers();
        boolean flag1 = true;
        ArrayList<GiaoVien> GvList = new ArrayList<GiaoVien>();
        ArrayList<LopHoc> LhList = new ArrayList<LopHoc>();
        ArrayList<MonHoc> MhList = new ArrayList<MonHoc>();
        ArrayList<TKB> TkbList = new ArrayList<TKB>();
        Scanner sc = new Scanner(System.in);

        // Tạo phần đăng nhập theo tk mk mặc định
        boolean isLoggedIn = false;
        System.out.println("[  Đăng nhập tài khoản  ]");
        System.out.println("-------------------------");
        while (!isLoggedIn) {
            System.out.print("Tên đăng nhập: ");
            String username = sc.nextLine();
            System.out.print("Mật khẩu: ");
            String password = sc.nextLine();

            // Kiểm tra thông tin đăng nhập
            if (username.equals("admin") && password.equals("admin")) {
                System.out.println("    Đăng nhập thành công!");
                isLoggedIn = true;
            } else {
                System.out.println("    Tên đăng nhập hoặc mật khẩu không đúng, vui lòng nhập lại!");
            }
        }

        // Chương trình chính
        while (flag1) {
            System.out.println("----------QUẢN LÝ THỜI KHÓA BIỂU----------");
            System.out.println("                  *****                   ");
            System.out.println("1. Quản lý môn học");
            System.out.println("2. Quản Lý lớp học");
            System.out.println("3. Quản Lý giáo viên");
            System.out.println("4. Quản lý Thời khóa biểu");
            System.out.println("5. EXIT");
            String choice = sc.nextLine();
            if (helper.isValidMenuChoice(choice, 4)) {
                int choiceNum = Integer.parseInt(choice);
                switch (choiceNum) {
                    case 3:
                        boolean gvFlag = true;
                        while (gvFlag) {
                            System.out.println("----------Quản lý giáo viên----------");
                            System.out.println("1. Thêm giáo viên");
                            System.out.println("2. Danh sách giáo viên");
                            System.out.println("3. Thoát");
                            String gvChoice = sc.nextLine();
                            if (helper.isValidMenuChoice(gvChoice, 3)) {
                                int gvChoiceNum = Integer.parseInt(gvChoice);
                                switch (gvChoiceNum) {
                                    case 1:
                                        System.out.println("Nhập mã giáo viên: ");
                                        String gvID = sc.nextLine();
                                        try {
                                            int gvIDNum = Integer.parseInt(gvID);
                                            if (!helper.checkExistingGiaoVien(GvList, gvIDNum)) {
                                                System.out.println("Nhập tên giáo viên: ");
                                                String gvName = sc.nextLine();
                                                System.out.println("Nhập mã MH: ");
                                                String mId = sc.nextLine();
                                                if (helper.isNumber(mId) && helper.isNumber(gvID)) {
                                                    if (helper.checkExistingMonHoc(MhList, mId)) {
                                                        GiaoVien newGV = new GiaoVien(gvIDNum, gvName, Integer.parseInt(mId));
                                                        GvList.add(newGV);
                                                        System.out.println("--> Thêm giáo viên thành công!\n");
                                                    } else {
                                                        System.out.println("LỖI: Môn học không tồn tại!");
                                                    }
                                                } else {
                                                    System.out.println("Nhập sai định dạng...(Lưu ý: Nhập số tự nhiên)");
                                                }
                                            } else {
                                                System.out.println("ID đã tồn tại");
                                            }

                                        } catch (Exception e) {
                                            System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                                        }
                                        break;
                                    case 2:
                                        helper.danhSachGiaoVien(GvList, MhList);
                                        break;
                                    case 3:
                                        gvFlag = false;
                                        break;
                                }
                            } else {
                                System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                            }
                        }
                        break;
                    case 2:
                        boolean lhFlag = true;
                        while (lhFlag) {
                            System.out.println("----------Quản lý lớp học----------");
                            System.out.println("1. Thêm lớp học");
                            System.out.println("2. Danh sách lớp học");
                            System.out.println("3. Thoát");
                            String lhChoice = sc.nextLine();
                            if (helper.isValidMenuChoice(lhChoice, 3)) {
                                int lhChoiceNum = Integer.parseInt(lhChoice);
                                switch (lhChoiceNum) {
                                    case 1:
                                        System.out.println("Nhập mã lớp: ");
                                        String lhID = sc.nextLine();
                                        try {
                                            int lhIDNum = Integer.parseInt(lhID);
                                            if (!helper.checkExistingLopHoc(LhList, lhIDNum)) {
                                                System.out.println("Nhập tên lớp: ");
                                                String lhName = sc.nextLine();
                                                System.out.println("Nhập sĩ số: ");
                                                String Ssl = sc.nextLine();
                                                if (helper.isNumber(Ssl) && helper.isNumber(lhID)) {
                                                    LopHoc newLH = new LopHoc(lhIDNum, lhName, Integer.parseInt(Ssl) );
                                                    LhList.add(newLH);
                                                    System.out.println("--> Thêm lớp học thành công!\n");
                                                } else {
                                                    System.out.println("Nhập sai định dạng...(Lưu ý: Nhập số tự nhiên)");
                                                }
                                            } else {
                                                System.out.println("ID đã tồn tại");
                                            }

                                        } catch (Exception e) {
                                            System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                                        }
                                        break;
                                    case 2:
                                        helper.danhSachLopHoc(LhList);
                                        break;
                                    case 3:
                                        lhFlag = false;
                                        break;
                                }
                            } else {
                                System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                            }
                        }
                        break;
                    case 1:
                        Boolean mhFlag = true;
                        while (mhFlag) {
                            System.out.println("----------Quản lý môn học----------");
                            System.out.println("1. Thêm môn học");
                            System.out.println("2. Danh sách môn học");
                            System.out.println("3. Thoát");
                            String mhChoice = sc.nextLine();
                            if (helper.isValidMenuChoice(mhChoice, 3)) {
                                int mhChoiNum = Integer.parseInt(mhChoice);
                                switch (mhChoiNum) {
                                    case 1:
                                        System.out.println("Nhập ID môn học: ");
                                        String mhID = sc.nextLine();
                                        try {
                                            int mhIdNum = Integer.parseInt(mhID);
                                            if (!helper.checkExistingMonHoc(MhList, mhID)) {
                                                System.out.println("Nhập tên môn học: ");
                                                String mhName = sc.nextLine();
                                                MonHoc newMH = new MonHoc(mhIdNum, mhName);
                                                MhList.add(newMH);
                                                System.out.println("--> Thêm môn học thành công!\n");
                                            } else {
                                                System.out.println("LỖI: Môn học đã tồn tại...");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                                        }
                                        break;
                                    case 2:
                                        helper.danhSachMonHoc(MhList);
                                        break;
                                    case 3:
                                        mhFlag = false;
                                        break;
                                }
                            } else {
                                System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                            }
                        }
                        break;
                    case 4:
                        boolean tkbFlag = true;
                        while (tkbFlag) {
                            System.out.println("----------Quản lý Thời khóa biểu----------");
                            System.out.println("1. Thêm TKB");
                            System.out.println("2. Danh sách TKB");
                            System.out.println("3. Thoát");
                            String tkbChoice = sc.nextLine();
                            try {
                                int tkbChoiceNum = Integer.parseInt(tkbChoice);
                                switch (tkbChoiceNum) {
                                    case 1:
                                        System.out.println("----------Thêm Thời khóa biểu----------");
                                        System.out.println("Chọn thứ: ");
                                        helper.danhSachNgayTrongTuan();
                                        String dayChoice = sc.nextLine();
                                        try {
                                            int dayChoiceNum = Integer.parseInt(dayChoice);
                                            if (helper.isValidMenuChoice(dayChoice, 6)) {
                                                System.out.println("Lựa chọn môn học: ");
                                                helper.danhSachMonHoc2(MhList);
                                                String tkbLH = sc.nextLine();   
                                                try {
                                                    int tkbLHChoice = Integer.parseInt(tkbLH);
                                                    if(helper.checkExistingLopHoc(LhList, tkbLHChoice));
                                                    System.out.println("Lựa chọn lớp: ");
                                                    helper.danhSachLopHoc2(LhList);
                                                    System.out.println("(Lưu ý: Nhập mã lớp)");
                                                    String tkbMH = sc.nextLine();
                                                    try {
                                                        int tkbMHChoice = Integer.parseInt(tkbMH);
                                                        if (helper.checkExistingMonHoc(MhList, tkbMH)) {
                                                            System.out.println("Lựa chọn giáo viên: ");
                                                            System.out.println("(Lưu ý: Nhập mã GV)");
                                                            helper.timGiaoVienBangMonHoc(GvList, tkbMHChoice);
                                                            String tkbGvChoice = sc.nextLine();
                                                            try {
                                                                int tkbGvChoiceNum = Integer.parseInt(tkbGvChoice);
                                                                if (helper.checkExistingGiaoVien(GvList, tkbGvChoiceNum)) {
                                                                    for (GiaoVien gv : GvList) {
                                                                        if (gv.getId() == tkbGvChoiceNum) {
                                                                            for (MonHoc mh : MhList) {
                                                                                if (mh.getMId() == tkbMHChoice) {
                                                                                    String d = "";
                                                                                    switch (dayChoiceNum) {
                                                                                        case 1:
                                                                                            d = "Thứ hai";
                                                                                            break;
                                                                                        case 2:
                                                                                            d = "Thứ ba";
                                                                                            break;
                                                                                        case 3:
                                                                                            d = "Thứ tư";
                                                                                            break;
                                                                                        case 4:
                                                                                            d = "Thứ năm";
                                                                                            break;
                                                                                        case 5:
                                                                                            d = "Thứ sáu";
                                                                                            break;
                                                                                        case 6:
                                                                                            d = "Thứ bảy";
                                                                                            break;
                                                                                    }
                                                                                    TKB newTKB = new TKB(tkbMHChoice, tkbLHChoice, tkbGvChoiceNum, d);
                                                                                    TkbList.add(newTKB);
                                                                                    System.out.println("--> Thêm vào thời khóa biểu thành công! \n");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    System.out.println("Giáo viên không tồn tại...");
                                                                }
                                                            } catch (Exception e) {
                                                                System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                                                            }
                                                        } else {
                                                            System.out.println("Môn học không tồn tại...");
                                                        }
                                                    } catch (Exception e) {
                                                        System.out.println("Nhập sai ... Vui lòng nhập lại...");
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                                                }
                                            } 
                                        } catch (Exception ex) {
                                            System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                                        }
                                        break;
                                    case 2:
                                        helper.danhSachThoiKhoaBieu(GvList,LhList, MhList, TkbList);
                                        break;
                                    case 3:
                                        tkbFlag = false;
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Nhập sai định dạng... Vui lòng nhập lại...");
                            }
                        }
                        break;
                    case 5:
                        flag1 = false;
                        break;
                }
            } else {
                System.out.println("Nhập sai định dạng... vui lòng nhập lại...");
            }
        }
    }
}
