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
public class Link implements java.io.Serializable{
    private Switch startSwitch;
    private Switch endSwitch;
    private double usedBandwidth;
    private String linkName;
    public Link(){
        startSwitch = new Switch();
        endSwitch = new Switch();
        usedBandwidth = 0;
    }
    
    public Link(Switch startSwitch, Switch endSwitch){
        this.startSwitch = startSwitch;
        this.endSwitch = endSwitch;
        this.usedBandwidth = 0;
        this.setLinkName(startSwitch.getNameSwitch() + endSwitch.getNameSwitch());
    }

    public Switch getStartSwitch() {
        return startSwitch;
    }

    public void setStartSwitch(Switch startSwitch) {
        this.startSwitch = startSwitch;
    }

    public Switch getEndSwitch() {
        return endSwitch;
    }

    public void setEndSwitch(Switch endSwitch) {
        this.endSwitch = endSwitch;
    }

    public double getUsedBandwidth() {
        return usedBandwidth;
    }

    public void setUsedBandwidth(double usedBandwidth) {
        this.usedBandwidth += usedBandwidth;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    
}
