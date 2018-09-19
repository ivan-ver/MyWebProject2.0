package system.dao;

import system.entity.Detail;

import java.util.List;

public interface DAO {
    void addDetail(Detail detail);
    void deleteDetail(Integer id);
    void updateDetail (Detail detail);
    Detail getById (Integer id);

    List<Detail> findAll();
}
