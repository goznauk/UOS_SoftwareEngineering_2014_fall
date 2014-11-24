package DRSOS.model;

import DRSOS.data.Map;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class MapMakerModel extends BaseModel {
    public MapMakerModel() {

    }

    public MapMakerModel(Map map) {
        super(map);
    }

    public boolean save() {
        return true;
    }
}
