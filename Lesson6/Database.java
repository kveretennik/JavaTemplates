package ru.constantin;


import java.util.HashMap;
import java.util.Map;

public class Database {
    private Long sequence = 0L;
    private Map<Long, String> db;

    public Database() {
        db = new HashMap<>();
    }

    public Long getNextValue() {
        return ++sequence;
    }

    public void addData(Long id, String str) {
        db.put(id, str);
    }

    public void updateData(Long id, String str) {
        db.replace(id, str);
    }

    public Map<Long, String> getDataById(Long id) {

        Map<Long, String> result;
        result = new HashMap<>();
        result.put(id, db.get(id));
        return result;
    }

    public Map<Long, String> getAllData() {
        Map<Long, String> result;
        result = new HashMap<>(db);
        return result;
    }

    public void deleteData(Long id) {
        db.remove(id);
    }
}