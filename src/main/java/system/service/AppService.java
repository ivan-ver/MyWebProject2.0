package system.service;

import system.entity.Detail;
import system.entity.Type;

import java.util.List;

public interface AppService {
    int getNumberOfComputers();
    List<Detail> findAll();
    List<Type> getDetailType();

    List<Detail> showByType(String type);

    Detail getById(int id);

    void addDetail(Detail detail);
    void deleteDetail(Integer id);
    void updateDetail (Detail detail);

    Object findAllByName(String request);
}
