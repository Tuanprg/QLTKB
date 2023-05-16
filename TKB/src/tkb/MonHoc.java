/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tkb;

/**
 *
 * @author ASUS
 */
public class MonHoc {
    //khai bao cac thuoc tinh cua mon hoc
    private int mId;
    private String mName;

    //constructor method
    public MonHoc(int mId, String mName){
        this.mId = mId;
        this.mName = mName;
    }

    //get methods
    public int getMId(){
        return this.mId;
    }
    public String getMname(){
        return this.mName;
    }
}
