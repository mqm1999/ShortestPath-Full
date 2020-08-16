/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topology_2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author HP Pavilion
 */
public class Topology_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Topology topo = new Topology();
        topo.initTopo();
//        topo.CheckTopo();
        Scanner sc = new Scanner(System.in);
        Switch startNode = new Switch("1");
        Switch endNode = new Switch("6");
        double bw;
        topo.adjacentNodes(startNode);
//        System.out.println(startNode.getNameSwitch());
    }

}
