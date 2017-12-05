package com.coppco.test;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class POITest {

    @Test
    public void testPOI01() throws Exception {
        //01. 创建工作簿
        Workbook workbook = new HSSFWorkbook();

        //02. 创建sheet
        Sheet sheet = workbook.createSheet();

        //03. 创建行对象(下标从0开始)
        Row row = sheet.createRow(3);

        //04. 创建单元格对象(下标从0开始)
        Cell cell = row.createCell(1);

        //05. 设置单元格内容
        cell.setCellValue("向弘杰");

        //06. 设置单元格样式
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("华文行楷");//设置字体
        font.setFontHeightInPoints((short) 48);//字体大小

        style.setFont(font); //设置字体
        cell.setCellStyle(style);

        //07. 保存关闭流
        OutputStream outputStream = new FileOutputStream("/Users/apple/Desktop/name.xls");

        workbook.write(outputStream);

        //08. 关闭流
        outputStream.close();

        //09. 下载
    }
}
