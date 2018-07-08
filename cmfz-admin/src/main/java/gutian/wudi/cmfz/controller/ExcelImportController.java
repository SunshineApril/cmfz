package gutian.wudi.cmfz.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import gutian.wudi.cmfz.entity.Master;
import gutian.wudi.cmfz.service.MasterService;
import gutian.wudi.cmfz.utils.MasterExcelHandler;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: cmfz
 * @description: 导入excel
 * @author: gutian
 * @create: 2018-07-07 15:49
 **/
@Controller
@RequestMapping("/excel")
public class ExcelImportController {
    private static final Logger log = LoggerFactory.getLogger(ExcelImportController.class);
    @Autowired
    private MasterService ms;
    @RequestMapping(value = "/import")
    @ResponseBody
    public void excelImport(MultipartFile myFile ) {
        System.out.println("进入excel");
        ImportParams importParams = new ImportParams();
        // 数据处理
        IExcelDataHandler<Master> handler = new MasterExcelHandler();
        handler.setNeedHandlerFields(new String[] { "上师名称" });// 注意这里对应的是excel的列名。也就是对象上指定的列名。
        importParams.setDataHandler(handler);

        // 需要验证
        importParams.setNeedVerfiy(true);

        try {
            ExcelImportResult<Master> result = ExcelImportUtil.importExcelMore(myFile.getInputStream(), Master.class,
                    importParams);

            List<Master> successList = result.getList();
//            for (Master master : successList) {
//                ms.addMas(master);
//            }
            //批量插入mysql
            ms.addListMaster(successList);
            List<Master> failList = result.getFailList();

            log.info("是否存在验证未通过的数据:" + result.isVerfiyFail());
            log.info("验证通过的数量:" + successList.size());
            log.info("验证未通过的数量:" + failList.size());

            for (Master user : successList) {
                log.info("成功列表信息:ID=" + user.getMasterId() + user.getMasterName() + "-"
                        + user.getMasterPhoto()+"-"+user.getMasterSummary());
                System.out.println("xunhuanshuchu");
            }
            for (Master user : failList) {
                log.info("失败列表信息:" + user.getMasterName());
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
    @RequestMapping(value = "/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Master> masters = ms.qurryAllMasterByno();

        Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("上师花名册","上师信息表"),Master.class,masters);

        ServletOutputStream outputStream = response.getOutputStream();
        //响应头默认使用的编码格式默认ISO-8859-1
        String filename="上师信息.xls";
        String s = new String(filename.getBytes(), "iso-8859-1");
        response.setContentType("application/vnd.ms-excel");

        response.setHeader("content-disposition","attachment;fileName="+s);

        workbook.write(outputStream);

        outputStream.close();
    }
}
