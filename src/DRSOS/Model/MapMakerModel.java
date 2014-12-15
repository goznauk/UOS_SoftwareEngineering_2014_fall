package DRSOS.model;

import DRSOS.domain.Block;

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
