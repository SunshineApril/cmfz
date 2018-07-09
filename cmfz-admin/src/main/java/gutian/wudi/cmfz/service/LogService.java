package gutian.wudi.cmfz.service;

import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-09 20:38
 **/
public interface LogService {

    public Map<String,Object> queryAllLog(int page, int single);
}
