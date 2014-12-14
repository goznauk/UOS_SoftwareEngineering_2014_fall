package DRSOS.model;

import DRSOS.entity.Map;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class EntryModel extends BaseModel {
    private ArrayList<String> mapNameList;
    File[] mapFiles;

    public EntryModel() {
        File mapDirectory = new File("DRSOS_Maps");

        if (!mapDirectory.exists()) {
            mapDirectory.mkdirs();
            System.out.println("mkdir");
            try {
                File csv = new File(mapDirectory.getPath() + "/sample.csv");
                BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
                for (String s : sampleMap) {
                    bw.write(s + "\n");
                }
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File[] mapFiles = mapDirectory.listFiles();
        this.mapFiles = mapFiles;

        setMapNameList();
    }



    private void setMapNameList() {
        // get list from db
        mapNameList = new ArrayList<String>();

        for (File f : mapFiles) {
            mapNameList.add(f.getName().split("\\.")[0]);
        }
    }

    public void setMapByName(String name) {
        // get map from db by id
        for (File f : mapFiles) {
            System.out.println(f.getName().split("\\.")[0]);

            if(f.getName().split("\\.")[0].equals(name)) {
                System.out.println("DIDI");
                map = new Map(f);
                callbackEvent.onMapChanged(map);
            }
        }
    }


    static String[] sampleMap = { "0,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1,1,1,1,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "1,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,0,0,0,0",
            "1,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0",
            "1,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,1,1,2,0,1,1,2,1,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,2,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,2,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,2,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,2,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0",
            "1,0,1,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0",
            "0,1,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0" };

    public ArrayList<String> getMapNameList() {
        return mapNameList;
    }
}