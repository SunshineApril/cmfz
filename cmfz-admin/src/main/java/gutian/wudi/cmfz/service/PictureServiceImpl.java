package gutian.wudi.cmfz.service;

import gutian.wudi.cmfz.dao.PictureDao;
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
 * @description: 轮播实现业务层
 * @author: gutian
 * @create: 2018-07-05 20:24
 **/
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pd;

    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    @Override
    public Map<String,Object> queryAllPicture(int page, int single) {
        int begMes = (page-1) * single;
        int endMes = page * single;
        List<Picture> allPicture = pd.findAllPicture(begMes,endMes);
        int totalPic = pd.getTotalPic();
        Map<String, Object> mapPic = new HashMap<String, Object>();
        mapPic.put("total", totalPic);
        mapPic.put("rows", allPicture);
        return mapPic;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public int addPic(Picture p) {
        return pd.insertPic(p);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public int modifyPic(Picture p) {
        int i = pd.updatePic(p);
        return i;
    }



}
