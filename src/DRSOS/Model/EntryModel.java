package DRSOS.model;

import java.util.ArrayList;

/**
 * Created by goznauk on 2014. 11. 23..
 */
public class EntryModel extends BaseModel {
    private ArrayList<Integer> mapIdList;

    public EntryModel() {
        setMapIdList();
    }

    public ArrayList<Integer> getMapIdList() {
        return mapIdList;
    }

    private void setMapIdList() {
        // get list from db
    }

    public void setMapById(int id) {
        // get map from db by id
    }
}
