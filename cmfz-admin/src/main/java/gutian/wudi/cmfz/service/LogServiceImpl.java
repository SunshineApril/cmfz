package gutian.wudi.cmfz.service;

import gutian.wudi.cmfz.dao.LogDao;
import gutian.wudi.cmfz.dao.MasterDao;
import gutian.wudi.cmfz.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-09 20:48
 **/
@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao ld;

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public Map<String, Object> queryAllLog(int page, int single) {
        int begMes = (page-1) * single;
        int endMes = page * single;
        List<Log> allLo = ld.findAllLog(begMes,endMes);
        int totalLo =ld.getTotalLo();
        Map<String, Object> mapMas = new HashMap<String, Object>();
        mapMas.put("total", totalLo);
        mapMas.put("rows", allLo);
        return mapMas;
    }
}
