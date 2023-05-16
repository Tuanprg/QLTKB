/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tkb;

/**
 *
 * @author ASUS
 */
public class LopHoc {
    private int lId;
    private String lName;
    private int Ssl;

    public LopHoc(int lId, String lName, int Ssl){
        this.lId = lId;
        this.lName = lName;
        this.Ssl = Ssl;
    }

    //get methods
    public int getId(){
        return this.lId;
    }
    public String getName(){
        return this.lName;
    }
    public int getSsl(){
        return this.Ssl;
    }
}
