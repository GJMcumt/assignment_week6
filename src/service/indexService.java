package service;

import dao.indexDao;
import dao.indexDaoimpl;
import entity.Good;
import java.util.List;

public class indexService {
    private indexDao indexDao;
    public void setIndexDao(){
        this.indexDao = new indexDaoimpl();
    }
    public List<Good> getAll(){
        return indexDao.getAll();
    }
}
