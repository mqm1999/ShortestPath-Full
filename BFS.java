/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topology_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author HP Pavilion
 */
public class BFS {

    private Switch startNode;
    private Switch endNode;
    private double bwDemand;
    private Map<Integer, LinkedList<Switch>> shortestPath;
    private Map<Integer, LinkedList<Switch>> availablePath;
    private int i = 1;
    public static double MAX_BW = 1000;

    public BFS(Switch start, Switch end, double bw) {
        this.startNode = start;
        this.endNode = end;
        this.bwDemand = bw;
        shortestPath = new HashMap<>();
        availablePath = new HashMap<>();
    }

    public LinkedList<Switch> run(Topology topo, LinkedList<Switch> path) {
        LinkedList<Switch> visited = new LinkedList<>();
        visited.add(startNode);
        breadthFirst(topo, visited);
        getAvailablePath(topo);
        path = getShortestPath();
        return path;
    }

    public void breadthFirst(Topology topo, LinkedList<Switch> visited) {
        LinkedList<Switch> nodes = topo.adjacentNodes(visited.getLast());
        for (Switch node : nodes) {
            if (visited.contains(node)) {

            } else if (node.equals(endNode)) {
                visited.add(node);
                showPath(visited);
                visited.removeLast();
                break;
            }
        }

        for (Switch node : nodes) {
            if (visited.contains(node) || visited.equals(endNode)) {
                continue;
            }
            visited.addLast(node);
            breadthFirst(topo, visited);
            visited.removeLast();
        }
    }

    public LinkedList<Switch> getShortestPath() {
        int numMin = Integer.MAX_VALUE;
        LinkedList<Switch> tempPath = new LinkedList<Switch>();
        for (Entry<Integer, LinkedList<Switch>> entry : availablePath.entrySet()) {
            if (entry.getValue().size() < numMin) {
                numMin = entry.getValue().size();
                tempPath = entry.getValue();
            }
        }
        return tempPath;
    }

    public void getAvailablePath(Topology topo) {
        int count = 1;
        int size = shortestPath.size();
        for (int j = 1; j <= size; j++) {
            LinkedList<Switch> path = shortestPath.get(i);
            for (int k = 1; k <= (path.size() - 1); k++) {
                Switch a = path.get(k);
                Switch b = path.get(k + 1);
                String nameLink = a.getNameSwitch() + b.getNameSwitch();
                Map<String, Link> listLink = topo.getListLink();
                if (listLink == null) {
                    System.out.println("List not found!");
                }
                double usedBw = listLink.get(nameLink).getUsedBandwidth();
                if (bwDemand > MAX_BW - usedBw) {
                    System.out.println("Out of bandwidth");
                    break;
                }
                if (k == (path.size() - 2)) {
                    availablePath.put(count, path);
                    count++;
                }
            }
        }
    }

    public void showPath(LinkedList<Switch> visited) {
        LinkedList<Switch> list = new LinkedList<Switch>();
        for (int j = 0; j < visited.size(); j++) {
            list.add(visited.get(j));
        }
        shortestPath.put(i, list);
        i++;
        System.out.println(list);
    }
}
