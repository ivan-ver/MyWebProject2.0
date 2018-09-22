package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.DAO;
import system.entity.Detail;
import system.entity.Type;

import java.awt.print.Pageable;
import java.util.*;

@Service
public class AppServiceImpl implements AppService {


    @Autowired
    public DAO dao;

    @Override
    public int getNumberOfComputers(){
        List<Type> types = getDetailType();
        int numberOfComp = types.get(1).getCount();
        for (Type t : types) {
            if (t.getNecessity() == "true"){
                if (t.getCount()<numberOfComp){
                    numberOfComp = t.getCount();
                }
            }
        }
        return numberOfComp;
    }

    public List<Detail> findAll() {
        return dao.findAll();
    }



    @Override
    public List<Type> getDetailType() {
        Map<String,Type> map = new TreeMap<>();
        for (Detail detail : findAll()) {
            if (!map.containsKey(detail.getType())){
                map.put(detail.getType(),new Type(detail.getType(),detail.getCount(),(detail.getNecessity()==1? "true" : "false")));
            }else {
                map.get(detail.getType()).setCount(map.get(detail.getType()).getCount()+detail.getCount());
            }
        }
        List<Type> result = new ArrayList<>();
        for (Type type : map.values()){
            result.add(type);
        }
        return result;
    }

    @Override
    public List<Detail> showByType(String type) {
        Map<String,List<Detail>> map = new TreeMap<>();
        for (Detail detail : findAll()) {
            if (!map.containsKey(detail.getType())){
                map.put(detail.getType(),new ArrayList<Detail>(){{
                    add(detail);
                }});
            }else {
                map.get(detail.getType()).add(detail);
            }
        }
        return map.get(type);
    }

    @Override
    public Detail getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void addDetail(Detail detail) {
        dao.addDetail(detail);
    }

    @Override
    public void deleteDetail(Integer id) {
        dao.deleteDetail(id);
    }

    @Override
    public void updateDetail(Detail detail) {
        dao.updateDetail(detail);
    }

    @Override
    public Object findAllByName(String request) {
        List<Detail> res = new ArrayList<>();
        for (Detail d : findAll()) {
            if (d.getName().toLowerCase().contains(request.toLowerCase()))
                res.add(d);
        }
        return res;
    }

    @Override
    public List<Detail> list(Integer offset, Integer maxResults){
        return dao.getAll(offset, maxResults);
    }

    @Override
    public Long count() {
        return dao.count();
    }
}
