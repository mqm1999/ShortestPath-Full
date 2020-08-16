/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topology_2;

/**
 *
 * @author HP Pavilion
 */
public class Switch implements java.io.Serializable{
    private String nameSwitch;
    public Switch(){
        
    }
    
    public Switch(String name){
        this.nameSwitch = name;
    }

    public String getNameSwitch() {
        return nameSwitch;
    }

    public void setNameSwitch(String nameSwitch) {
        this.nameSwitch = nameSwitch;
    }
    
}
