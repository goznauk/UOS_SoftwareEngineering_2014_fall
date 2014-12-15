package DRSOS.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class Map {
    private Coordinate robot, goal;
    private Block[] blocks;

    public Map() {
        blocks = new Block[400];
        String[] lines =
                { "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",
                "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0" };

        for(int y = 0; y < lines.length; y++) {
            // -1 is for Read Blank after last ','
            String[] token = lines[y].split(",", -1);

            for (int x = 0; x < token.length; x++) {
                blocks[x + y*20] = new Block(new Coordinate(x, y), BLOCKTYPE.fromInteger(Integer.parseInt(token[x])), false);
            }
        }
    }

    public Map(String path) {
        blocks = new Block[400];

        File csv = new File(path);
        BufferedReader br;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            int y = 0;
            while ((line = br.readLine()) != null) {
                // -1 is for Read Blank after last ','
                String[] token = line.split(",", -1);
                for (int x = 0; x < token.length; x++) {
                    blocks[x + y*20] = new Block(new Coordinate(x, y), BLOCKTYPE.fromInteger(Integer.parseInt(token[x])), false);
                }
                y++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map(File file) {
        blocks = new Block[400];

        File csv = file;
        BufferedReader br;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            int y = 0;
            while ((line = br.readLine()) != null) {
                // -1 is for Read Blank after last ','
                String[] token = line.split(",", -1);
                for (int x = 0; x < token.length; x++) {
                    blocks[x + y*20] = new Block(new Coordinate(x, y), BLOCKTYPE.fromInteger(Integer.parseInt(token[x])), false);
                }
                y++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void moveRobot(DIRECTION d) {

    }

    public void setBlock(Coordinate coordinate, BLOCKTYPE blocktype) {
        Block block = blocks[coordinate.toID()];
        block.setBlocktype(blocktype);
    }

    public void setBlock(Coordinate coordinate, boolean isVisible) {
        Block block = blocks[coordinate.toID()];
        if(isVisible) {
            block.reveal();
        } else {
            block.conceal();
        }
    }

    public void setBlock(Coordinate coordinate, BLOCKTYPE blocktype, boolean isVisible) {

    }



    public Block[] getBlocks() {
        return blocks;
    }

    public Coordinate getRobot() {
        return robot;
    }

    public void setRobot(Coordinate robot) {
        this.robot = robot;
    }

    public Coordinate getGoal() {
        return goal;
    }

    public void setGoal(Coordinate goal) {
        this.goal = goal;
    }

}
