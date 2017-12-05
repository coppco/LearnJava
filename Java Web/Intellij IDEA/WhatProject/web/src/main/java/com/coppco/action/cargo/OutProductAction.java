package com.coppco.action.cargo;

import com.coppco.action.BaseAction;
import com.coppco.domain.ContractProduct;
import com.coppco.service.ContractProductService;
import com.coppco.utils.DownloadUtil;
import com.coppco.utils.UtilFuns;
import java.io.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.*;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Scope(value = "prototype")
@Controller(value = "outProductAction")
public class OutProductAction extends BaseAction {

    private String inputDate; //属性驱动

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * 货物
     */
    @Resource(name = "contractProductService")
    private ContractProductService contractProductService;

    /**
     * 出货表打印页面
     * @return
     * @throws Exception
     */
    public String toedit() throws Exception {
        return "toedit";
    }

    /**
     * 打印
     * @return
     * @throws Exception
     */
    public String print() throws Exception {
        //1.创建工作簿
        String path = ServletActionContext.getServletContext().getRealPath("/");
        path = path+"/make/xlsprint/tOUTPRODUCT.xls";   //得到模板文件所在位置

        InputStream is = new FileInputStream(path);     //根据文件路径，得到指定的文件流


        Workbook wb = new HSSFWorkbook(is);//根据文件流，加载指定的工作簿                        它只能操作excel2003版本

        //2.读取工作表
        Sheet sheet = wb.getSheetAt(0);   //0代表工作表的下标


        //抽取出一些公用变量
        Row nRow=null;
        Cell nCell = null;

        int rowNo=0;//行号
        int cellNo=1;//列号

        //3.创建行对象
        //==========================================大标题的制作
        nRow = sheet.getRow(rowNo++);//读取行对象

        nCell = nRow.getCell(cellNo);//读取单元格

        //设置单元格的内容
        nCell.setCellValue(inputDate.replace("-0", "-").replace("-", "年")+"月份出货表");  //2015-10      2015-01----->2015-1----->2015年1

        //============================================ 小标题
        rowNo++;   //跳过第二行，进入第三行（rowNo=2）


        //===========================================数据内容

        //先将第三行的样式读取出来
        nRow = sheet.getRow(rowNo);//读取第三行

        //客人	订单号	货号	数量	工厂	工厂交期	船期	贸易条款
        CellStyle customerCellStyle = nRow.getCell(cellNo++).getCellStyle();//读取单元格的样式
        String str = nRow.getCell(cellNo).getStringCellValue();//读取单元格的内容
        System.out.println(str);

        CellStyle orderNoCellStyle = nRow.getCell(cellNo++).getCellStyle();//读取单元格的样式
        CellStyle productNoCellStyle = nRow.getCell(cellNo++).getCellStyle();//读取单元格的样式
        CellStyle cNumberCellStyle = nRow.getCell(cellNo++).getCellStyle();//读取单元格的样式
        CellStyle factoryCellStyle = nRow.getCell(cellNo++).getCellStyle();//读取单元格的样式
        CellStyle deliveryPeriodCellStyle = nRow.getCell(cellNo++).getCellStyle();//读取单元格的样式
        CellStyle shipTimeCellStyle = nRow.getCell(cellNo++).getCellStyle();//读取单元格的样式
        CellStyle tradeTermsCellStyle = nRow.getCell(cellNo++).getCellStyle();//读取单元格的样式


        String hql = "from ContractProduct where contract.shipTime like '"+inputDate+"%'";   //2015-01%
        List<ContractProduct> list = contractProductService.find(hql, ContractProduct.class, null);//加载指定船期下的货物列表

        //遍历货物列表
        for(ContractProduct cp :list){
            //产生一个新行
            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24f);//设置行高

            cellNo=1;

            //产生单元格   客户
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getContract().getCustomName());//设置单元格内容
            nCell.setCellStyle(customerCellStyle);    //设置单元格样式

            //产生单元格订单号
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getContract().getContractNo());//设置单元格内容
            nCell.setCellStyle(orderNoCellStyle);    //设置单元格样式

            //产生单元格货号
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getProductNo());//设置单元格内容
            nCell.setCellStyle(productNoCellStyle);    //设置单元格样式

            //产生单元格数量
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getCnumber());//设置单元格内容
            nCell.setCellStyle(cNumberCellStyle);    //设置单元格样式

            //产生单元格工厂
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getFactoryName());//设置单元格内容
            nCell.setCellStyle(factoryCellStyle);    //设置单元格样式

            //产生单元格工厂交期
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getDeliveryPeriod()));//设置单元格内容
            nCell.setCellStyle(deliveryPeriodCellStyle);    //设置单元格样式

            //产生单元格船期
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getShipTime()));//设置单元格内容
            nCell.setCellStyle(shipTimeCellStyle);    //设置单元格样式


            //产生单元格贸易条款
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getContract().getTradeTerms());//设置单元格内容
            nCell.setCellStyle(tradeTermsCellStyle);    //设置单元格样式

        }

        //输出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//内存的缓冲区
        wb.write(byteArrayOutputStream);

        //提供response对象
        HttpServletResponse response = ServletActionContext.getResponse();

        DownloadUtil downloadUtil = new DownloadUtil();
        downloadUtil.download(byteArrayOutputStream, response, "出货表.xls");
        return NONE;
    }


    /***
     * 没有使用模板进行打印
     * @return
     * @throws Exception
     */
    public String printNotTemplate() throws Exception {
        //1.创建工作簿
        Workbook wb = new HSSFWorkbook();//它只能操作excel2003版本

        //2.创建工作表
        Sheet sheet = wb.createSheet();

        //设置列宽   本身就是bug
        sheet.setColumnWidth(0, 3*256);
        sheet.setColumnWidth(1, 26*256);
        sheet.setColumnWidth(2, 11*256);
        sheet.setColumnWidth(3, 29*256);
        sheet.setColumnWidth(4, 12*256);
        sheet.setColumnWidth(5, 15*256);
        sheet.setColumnWidth(6, 10*256);
        sheet.setColumnWidth(7, 10*256);
        sheet.setColumnWidth(8, 8*256);



        //抽取出一些公用变量
        Row nRow=null;
        Cell nCell = null;

        int rowNo=0;//行号
        int cellNo=1;//列号

        //3.创建行对象
        //==========================================大标题的制作
        nRow = sheet.createRow(rowNo++);//创建行对象
        nRow.setHeightInPoints(36.26f);//设置行高
        nCell = nRow.createCell(cellNo);

        //设置单元格的内容
        nCell.setCellValue(inputDate.replace("-0", "-").replace("-", "年")+"月份出货表");  //2015-10      2015-01----->2015-1----->2015年1
        //设置单元格样式
        nCell.setCellStyle(bigTitle(wb));

        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,8));



        //============================================ 小标题
        nRow = sheet.createRow(rowNo++);//创建行对象
        nRow.setHeightInPoints(26f);//设置行高

        String titles [] = {"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};
        for(String title :titles){
            nCell = nRow.createCell(cellNo++);//创建小标题上的单元格

            nCell.setCellValue(title);//设置单元格内容
            nCell.setCellStyle(this.title(wb));//小标题样式的设置
        }


        //===========================================数据内容
        String hql = "from ContractProduct where contract.shipTime like '"+inputDate+"%'";   //2015-01%
        List<ContractProduct> list = contractProductService.find(hql, ContractProduct.class, null);//加载指定船期下的货物列表

        //遍历货物列表
        for(ContractProduct cp :list){
            //产生一个新行
            nRow = sheet.createRow(rowNo++);
            nRow.setHeightInPoints(24f);//设置行高

            cellNo=1;

            //产生单元格   客户
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getContract().getCustomName());//设置单元格内容
            nCell.setCellStyle(text(wb));    //设置单元格样式

            //产生单元格订单号
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getContract().getContractNo());//设置单元格内容
            nCell.setCellStyle(text(wb));    //设置单元格样式

            //产生单元格货号
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getProductNo());//设置单元格内容
            nCell.setCellStyle(text(wb));    //设置单元格样式

            //产生单元格数量
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getCnumber());//设置单元格内容
            nCell.setCellStyle(text(wb));    //设置单元格样式

            //产生单元格工厂
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getFactoryName());//设置单元格内容
            nCell.setCellStyle(text(wb));    //设置单元格样式

            //产生单元格工厂交期
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getDeliveryPeriod()));//设置单元格内容
            nCell.setCellStyle(text(wb));    //设置单元格样式

            //产生单元格船期
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(UtilFuns.dateTimeFormat(cp.getContract().getShipTime()));//设置单元格内容
            nCell.setCellStyle(text(wb));    //设置单元格样式


            //产生单元格贸易条款
            nCell = nRow.createCell(cellNo++);//创建单元格
            nCell.setCellValue(cp.getContract().getTradeTerms());//设置单元格内容
            nCell.setCellStyle(text(wb));    //设置单元格样式

        }

        //输出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//内存的缓冲区
        wb.write(byteArrayOutputStream);

        //提供response对象
        HttpServletResponse response = ServletActionContext.getResponse();

        DownloadUtil downloadUtil = new DownloadUtil();
        downloadUtil.download(byteArrayOutputStream, response, "a.xls");
        return NONE;
    }

    //大标题的样式
    public CellStyle bigTitle(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short)16);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        return style;
    }
    //小标题的样式
    public CellStyle title(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)12);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }

    //文字样式
    public CellStyle text(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short)10);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }
}

