package gutian.wudi.cmfz.service;

import gutian.wudi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: Master业务层
 * @author: gutian
 * @create: 2018-07-06 20:08
 **/
public interface MasterService {
    public Map<String,Object> queryAllMaster(int page, int single);

    Map<String,Object> selectMas(String value, String name, Integer page, Integer rows);

    int addMas(Master m);

    int modifyMas(Master m);

    public List<Master> qurryAllMasterByno();

    int addListMaster(List<Master> masters);
}
