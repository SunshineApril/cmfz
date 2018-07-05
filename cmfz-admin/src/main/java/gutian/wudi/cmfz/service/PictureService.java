package gutian.wudi.cmfz.service;

import gutian.wudi.cmfz.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: 轮播业务层
 * @author: gutian
 * @create: 2018-07-05 20:22
 **/
public interface PictureService {
    public Map<String,Object> queryAllPicture(int page, int single);
}
