package gutian.wudi.cmfz.dao;

import gutian.wudi.cmfz.entity.Log;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 记录日志log
 * @author: gutian
 * @create: 2018-07-09 20:09
 **/
public interface LogDao {
    int insertLog(Log log);

    public List<Log> findAllLog(@Param("begMes") int begMes, @Param("endMes") int endMes);

    int getTotalLo();
}
