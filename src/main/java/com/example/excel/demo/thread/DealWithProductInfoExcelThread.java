package com.example.excel.demo.thread;

import com.example.excel.demo.entity.ProductInformationExcelEntity;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @apiNote 处理Excel线程类
 * @author linshanghua
 * @date 2019-07-11 21:33:00
 */
public class DealWithProductInfoExcelThread implements Runnable{

    private static Logger log = LoggerFactory.getLogger(DealWithProductInfoExcelThread.class);
    /**
     * 初始化原子类型
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private String fileAddress;

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public DealWithProductInfoExcelThread(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    @Override
    public void run() {
        try {
            List<ProductInformationExcelEntity> productInformationExcelEntities = new ArrayList<>();
            //读取Excel文档对象
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(fileAddress));
            while (true){
                //如果一张表为空则则结束该线程
                HSSFSheet sheet = hssfWorkbook.getSheetAt(atomicInteger.get());
                if (sheet.getLastRowNum() == 0 && sheet.getPhysicalNumberOfRows() == 0){
                    return;
                }
                int lastRowNum = sheet.getLastRowNum();
                for (int i = 0; i <= lastRowNum; i++){
                    //获得要解析的行
                    HSSFRow row = sheet.createRow(i);
                    //如果第二列的内容为空则跳过此循环
                    if (row.getCell(1).getStringCellValue() == null){
                        continue;
                    }
                    ProductInformationExcelEntity excelEntity = new ProductInformationExcelEntity();
                    //获得每个单元格的内容
                    excelEntity.setTransactionDate(row.getCell(0).getStringCellValue());
                    excelEntity.setProductName(row.getCell(1).getStringCellValue());
                    excelEntity.setProductNo(row.getCell(2).getStringCellValue());
                    excelEntity.setNatValueOfUnit(row.getCell(3).getStringCellValue());
                    excelEntity.setAccumulatedNetValue(row.getCell(4).getStringCellValue());
                    excelEntity.setFundManager(row.getCell(5).getStringCellValue());
                    excelEntity.setCompanyName(row.getCell(6).getStringCellValue());
                    excelEntity.setProductSize(row.getCell(7).getStringCellValue());
                    excelEntity.setNetBelongsToWeeks(row.getCell(8).getStringCellValue());
                    log.info("当前线程为：{}，获取到表格内容为：{}",Thread.currentThread().getName(),excelEntity.toString());
                    productInformationExcelEntities.add(excelEntity);
                    int index = atomicInteger.incrementAndGet();
                    log.info("执行完毕原子类中的计数值为：{}",index);
                }
            }
        } catch (IOException e) {
            log.error("IO流异常，未找到相应的Excel文档",e);
        }

    }
}
