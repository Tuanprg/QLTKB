/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tkb;

/**
 *
 * @author ASUS
 */
public class GiaoVien {
    //khai báo các thuộc tính của giáo viên
    private int gId;
    private String gName;
    private int mId;

    public GiaoVien(int gId, String gName, int mId){
        this.gId = gId;
        this.gName = gName;
        this.mId = mId;
    }

    //get methods
    public int getId(){
        return this.gId;
    }
    public String getName(){
        return this.gName;
    }
    public int getMId(){
        return this.mId;
    }
}
