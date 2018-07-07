package gutian.wudi.cmfz.utils;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import gutian.wudi.cmfz.entity.Master;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: cmfz
 * @description: excel导入
 * @author: gutian
 * @create: 2018-07-07 15:46
 **/

    public class MasterExcelHandler extends ExcelDataHandlerDefaultImpl<Master> {

        private static final Logger log = LoggerFactory.getLogger(MasterExcelHandler.class);


        @Override
        public Object importHandler(Master obj, String name, Object value) {
            log.info(name+":"+value);
            return super.importHandler(obj, name, value);
        }

    }

