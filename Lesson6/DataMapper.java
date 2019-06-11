package ru.constantin;

import java.util.*;

public class DataMapper implements DataMapperIface {

    private IdentityHashMap<Long, Data> identityHashMap;
    private Database database;

    public DataMapper(Database database) {
        this.database = database;
    }

    @Override
    public void saveOrUpdate(Data data) {
        if (identityHashMap.containsKey(data.getDataId())) {
            database.updateData(data.getDataId(), data.getDataDesc());
        } else {
            identityHashMap.put(data.getDataId(), data);
            database.addData(data.getDataId(), data.getDataDesc());
        }
    }

    @Override
    public void delete(Data data) {
        identityHashMap.remove(data.getDataId());
        database.deleteData(data.getDataId());
    }

    @Override
    public Data findById(Long id) {
        if (identityHashMap.get(id) != null) {
            return identityHashMap.get(id);
        } else {
            Map<Long, String> rs = database.getDataById(id);
            if (!rs.isEmpty()) {
                return new Data(id, rs.get(id));
            } else {
                return null;
            }
        }
    }

    @Override
    public List<Data> findAll() {
        ArrayList<Data> result = new ArrayList<>();
        Map<Long,String> rs = database.getAllData();

        Iterator<Map.Entry<Long, String>> entries = rs.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Long, String> entry = entries.next();
            Data data = new Data(entry.getKey(), entry.getValue());
            identityHashMap.put(data.getDataId(), data);
            result.add(data);
        }
        return result;
    }
}
