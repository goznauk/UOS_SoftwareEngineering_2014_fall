package DRSOS.model;

import DRSOS.domain.BLOCKTYPE;
import DRSOS.domain.Coordinate;
import DRSOS.domain.DIRECTION;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by goznauk on 2014. 12. 15..
 */
public class ADDON {
    IRobot robot;
    ArrayList<Coordinate> path;
    HashSet<Integer> hazards;
    int index;

    public ADDON(IRobot robot) {
        this.robot = robot;
    }

    public void init() {
        path = new ArrayList<Coordinate>();
        hazards = new HashSet<Integer>();
        index = 1;
    }


    public void moveRobot(Coordinate i, Coordinate f) {
        path = getPath(findPath(i, f));
        Coordinate now;

        while (robot.sensorPosition().toID() != f.toID()) {
            robot.sensorColorBlob();
            now = robot.sensorPosition();
            final DIRECTION next = now.calculateDirection(path.get(index));
            if(robot.sensorHazard(next)) {
                index = 1;
                path = getPath(findPath(now, f));
                continue;
            }
            System.out.println("MOVE!");

            robot.move(next);

            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(robot.sensorPosition().calculateDirection(now) == null) {
                index = 1;
                path = getPath(findPath(robot.sensorPosition(), f));
                continue;
            }
            index++;
        }

    }



    private class Node {
        Node parent;
        Coordinate coordinate;

        public Node(Node parent, Coordinate coordinate) {
            this.parent = parent;
            this.coordinate = coordinate;
        }

        public Node getParent() {
            return parent;
        }

        public Coordinate getCoordinate() {
            return coordinate;
        }
    }



    private Node findPath(Coordinate i, Coordinate f) {
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Integer> coordinateHashSet = new HashSet<Integer>();

        queue.offer(new Node(null, i));

        while(queue.peek() != null) {
            Node n = queue.poll();

            if(n.coordinate.toID() == f.toID()) {
                return n;
            }

            for(int d = 0; d < 4; d++) {
                Coordinate c = n.coordinate.addDirection(DIRECTION.fromInteger(d));
                if(c == null || coordinateHashSet.contains(c.toID())) {
                    continue;
                }

                if(((BaseModel)robot).getMap().getBlocks()[c.toID()].getBlocktype() == BLOCKTYPE.HAZARD
                        && ((BaseModel)robot).getMap().getBlocks()[c.toID()].isVisible()) {
                    continue;
                }
                coordinateHashSet.add(c.toID());
                queue.offer(new Node(n, c));
            }
        }
        return null;
    }

    private ArrayList<Coordinate> getPath(Node n) {
        ArrayList<Coordinate> path = new ArrayList<Coordinate>();

        if(n==null) { return null; }

        Node lmt = null;

        while(n != lmt) {
            Node iter = n;

            while(iter.parent != lmt) {
                iter = iter.parent;
            }
            lmt = iter;
            path.add(iter.coordinate);
        }

/*
        for(Coordinate c : path) {
            System.out.println(c.toString());
        }*/

        return path;
    }
}
