/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topology_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author HP Pavilion
 */
public class Topology {

    private final int numOfSwitch;
    private final LinkedList<Switch> listSwitch;
    private final Map<String, Link> listLink;
    private final Map<Switch, LinkedList<Switch>> neighborOfNode;

    public Topology() {
        numOfSwitch = 7;
        listSwitch = new LinkedList<Switch>();
        listLink = new HashMap<>();
        neighborOfNode = new HashMap<>();
    }

    public int getNumOfSwitch() {
        return numOfSwitch;
    }

    public LinkedList<Switch> getListSwitch() {
        return listSwitch;
    }

    public Map<String, Link> getListLink() {
        return listLink;
    }

    public Map<Switch, LinkedList<Switch>> getNeighborOfNode() {
        return neighborOfNode;
    }

    public void initTopo() {
        listSwitch.add(0, null);
        for (int i = 1; i <= numOfSwitch; i++) {
            listSwitch.add(new Switch(String.valueOf(i)));
        }
        System.out.println("Size: " + (listSwitch.size() - 1));

        for (int i = 1; i <= numOfSwitch; i++) {
            LinkedList<Switch> neighbor = new LinkedList<Switch>();
            FindNeighbor(listSwitch.get(i), neighbor);
            neighborOfNode.put(listSwitch.get(i), neighbor);
            System.out.println(neighbor);
        }

        for (int i = 1; i <= numOfSwitch; i++) {
            Switch node = listSwitch.get(i);
            LinkedList<Switch> neighborNode = neighborOfNode.get(node);
            for (Switch node_temp : neighborNode) {
                String name = node.getNameSwitch() + node_temp.getNameSwitch();
                Link linkNode = new Link(node, node_temp);
                listLink.put(name, linkNode);
            }
        }
    }

    public LinkedList<Switch> adjacentNodes(Switch node) {
        LinkedList<Switch> adjacent = neighborOfNode.get(node);
        if (adjacent == null) {
            return new LinkedList<Switch>();
        }
        return new LinkedList<Switch>(adjacent);
    }

    public void FindNeighbor(Switch node, LinkedList<Switch> neighbor) {
        System.out.println("Name switch: " + node.getNameSwitch());
        switch (node.getNameSwitch()) {
            case "1":
                neighbor.add(listSwitch.get(2));
                neighbor.add(listSwitch.get(3));
                neighbor.add(listSwitch.get(5));
                break;
            case "2":
                neighbor.add(listSwitch.get(1));
                neighbor.add(listSwitch.get(7));
                break;
            case "3":
                neighbor.add(listSwitch.get(1));
                neighbor.add(listSwitch.get(4));
                neighbor.add(listSwitch.get(6));
                break;
            case "4":
                neighbor.add(listSwitch.get(3));
                neighbor.add(listSwitch.get(5));
                break;
            case "5":
                neighbor.add(listSwitch.get(1));
                neighbor.add(listSwitch.get(4));
                neighbor.add(listSwitch.get(6));
                break;
            case "6":
                neighbor.add(listSwitch.get(3));
                neighbor.add(listSwitch.get(5));
                neighbor.add(listSwitch.get(7));
                break;
            case "7":
                neighbor.add(listSwitch.get(2));
                neighbor.add(listSwitch.get(6));
                break;
            default:
                System.out.println("Cannot insert neighbor");
                break;
        }
    }

    public void CheckTopo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input node to check neighbor: ");
        int node = sc.nextInt();
        System.out.println("Input's neighbor are: " + neighborOfNode.get(listSwitch.get(node)));

    }

}
