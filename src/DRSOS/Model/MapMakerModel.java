package DRSOS.model;

import DRSOS.entity.Block;
import DRSOS.entity.Coordinate;
import DRSOS.entity.Map;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class MapMakerModel extends BaseModel {
    public MapMakerModel() {
        for(Block b : map.getBlocks()) {
            b.reveal();
        }
    }
}
