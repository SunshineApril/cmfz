package gutian.wudi.cmfz.dao;

import gutian.wudi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 轮播dao层
 * @author: gutian
 * @create: 2018-07-05 20:06
 **/
public interface PictureDao {
    public List<Picture> findAllPicture(@Param("begMes") int begMes, @Param("endMes") int endMes);

    int getTotalPic();

    int insertPic(Picture pic);

    int updatePic(Picture pic);
}
