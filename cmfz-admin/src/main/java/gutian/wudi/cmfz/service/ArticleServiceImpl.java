package gutian.wudi.cmfz.service;

import gutian.wudi.cmfz.dao.ArticleDao;
import gutian.wudi.cmfz.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: cmfz
 * @description:
 * @author: gutian
 * @create: 2018-07-08 22:15
 **/
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private  ArticleDao ad;
    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public int addArticle(Article a) {
        int i = ad.insertArt(a);
        return i;
    }
}
