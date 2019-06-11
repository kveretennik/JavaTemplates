package ru.constantin;

import java.util.List;

public interface DataMapperIface {
    void saveOrUpdate(Data data);
    void delete(Data data);
    Data findById(Long id);
    List<Data> findAll();
}
