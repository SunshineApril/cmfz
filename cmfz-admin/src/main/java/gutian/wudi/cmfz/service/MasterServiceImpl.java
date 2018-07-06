package gutian.wudi.cmfz.service;

import gutian.wudi.cmfz.dao.MasterDao;
import gutian.wudi.cmfz.entity.Master;
import gutian.wudi.cmfz.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: Master业务实现层
 * @author: gutian
 * @create: 2018-07-06 20:09
 **/
@Service
@Transactional
public class MasterServiceImpl implements MasterService {
    @Autowired
    private MasterDao masterDao;
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public Map<String, Object> queryAllMaster(int page, int single) {
        int begMes = (page-1) * single;
        int endMes = page * single;
        List<Master> allMaster = masterDao.findAllMaster(begMes,endMes);
        int totalMas =masterDao.getTotalMas();
        Map<String, Object> mapMas = new HashMap<String, Object>();
        mapMas.put("total", totalMas);
        mapMas.put("rows", allMaster);
        return mapMas;
    }
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public Map<String, Object> selectMas(String value, String name, Integer page, Integer rows) {
        int begin = (page - 1) * rows ;
        int end =  rows;
        List<Master> masters = masterDao.selectMas(value, name, begin, end);
        int total = masterDao.getTotalMast(value, name);
        Map<String, Object> mapmas = new HashMap<String, Object>();
        mapmas.put("total", total);
        mapmas.put("rows", masters);
        return mapmas;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public int addMas(Master m) {
        int i = masterDao.insertMas(m);
        return i;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public int modifyMas(Master m) {
        int i = masterDao.insertMas(m);
        return i;
    }


}
