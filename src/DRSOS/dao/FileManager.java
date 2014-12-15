package DRSOS.dao;

import DRSOS.domain.Coordinate;
import DRSOS.domain.Map;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by goznauk on 2014. 12. 15..
 */
public class FileManager {
    public static void saveMapAsCsv(Map map) {
        try {
            File mapDirectory = new File("DRSOS_Maps");
            File[] mapFiles = mapDirectory.listFiles();
            String filename = Integer.toString(mapFiles.length+2000) + ".csv";

            File csv = new File(mapDirectory.getPath() + "/" + filename);
            int i = 0;
            while(csv.exists()) {
                i++;
                filename = Integer.toString(mapFiles.length+2000+(i*1000)) + ".csv";
                csv = new File(mapDirectory.getPath() + "/" + filename);
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));

            for(int y = 0; y < 20; y++) {
                String line = "";
                for (int x = 0; x < 20; x++) {
                    int type = map.getBlocks()[new Coordinate(x, y).toID()].getBlocktype().ordinal();
                    line += map.getBlocks()[new Coordinate(x, y).toID()].getBlocktype().ordinal() + ",";
                }
                line = line.substring(0, line.length()-1);
                bw.write(line + "\n");
            }

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteMapByName(String name) {
        File mapDirectory = new File("DRSOS_Maps");
        File target = new File(mapDirectory.getPath() + "/" + name + ".csv");
        target.delete();
    }
}
