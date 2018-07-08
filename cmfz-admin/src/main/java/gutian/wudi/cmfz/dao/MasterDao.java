package gutian.wudi.cmfz.dao;

import gutian.wudi.cmfz.entity.Master;
import gutian.wudi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 上师Dao层
 * @author: gutian
 * @create: 2018-07-06 20:05
 **/
public interface MasterDao {
    public List<Master> findAllMaster(@Param("begMes") int begMes, @Param("endMes") int endMes);

    int getTotalMas();

    List<Master>  selectMas(@Param("value") String value, @Param("name") String name, @Param("begin") Integer begin, @Param("end") Integer end);

    int getTotalMast(@Param("value") String value, @Param("name") String name);

    int insertMas(Master m);

    int updateMas(Master m);

    public List<Master> findAllMasterByno();

    int inseertMaster(@Param("list") List<Master> masters);
}
