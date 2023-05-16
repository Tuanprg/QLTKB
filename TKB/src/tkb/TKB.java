/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tkb;

/**
 *
 * @author ASUS
 */
public class TKB {

    //khai bao cac thuoc tinh cua thoi khoa bieu
    private int mId;
    private int lId;
    private int gId;
    private String day;

    //constructor
    public TKB(int mId,int lId, int gId, String day) {
        this.mId = mId;
        this.lId = lId;
        this.gId = gId;
        this.day = day;
    }

    //get methods
    public int getMid() {
        return this.mId;
    }

    public int getLid() {
        return this.lId;
    }
    
    public int getGId() {
        return this.gId;
    }

    public String getDay() {
        return this.day;
    }

}
