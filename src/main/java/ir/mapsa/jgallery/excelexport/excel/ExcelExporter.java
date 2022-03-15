package ir.mapsa.jgallery.excelexport.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class ExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<ExcelRow> rows;
    private ExcelRow ExcelRow;


    public ExcelExporter(List<ExcelRow> rowList){
        this.rows=rowList;
        workbook = new XSSFWorkbook();
    }

    private void createCell(ExcelRow row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell=row.createCell(columnCount);
        if(value instanceof Long) {
            cell.setCellValue((Long) value);
        }else if(value instanceof Integer){
                cell.setCellValue((Integer) value);
            }else if(value instanceof Boolean){
        cell.setCellValue((Boolean) value);
        }else{
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    private void writeHeaderLine(){
        sheet=workbook.createSheet("Artwork");

        XSSFRow row=sheet.createRow(0);
        CellStyle style=workbook.createCellStyle();
        XSSFFont font= workbook.createFont();
        font.setBold(true);
        font.setFontHeight(25);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(ExcelRow,0,"Artwork Information",style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
        font.setFontHeightInPoints((short)(8));

//        row=sheet.createRow(1);
//        font.setBold(true);
//        font.setFontHeight(15);
//        style.setFont(font);
//        createCell(row,0,"Artwork Id",style);
//        createCell(row,1,"Artwork Name",style);
//        createCell(row,2,"Artwork Price",style);
//        createCell(row,3,"Artwork Size",style);
//        createCell(row,4,"Artwork Artist",style);
//        createCell(row,5,"Artwork Genre",style);
   }

    private void writeDataLines(){
        int rowCount=2;

        CellStyle style=workbook.createCellStyle();
        XSSFFont font= workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

//        for(ExcelRow row:rows){
//            ExcelRow row=sheet.createRow(rowCount++);
//            int columnCount=0;
//            createCell(row,columnCount++,artwork.getId(),style);
//            createCell(row,columnCount++,artwork.getName(),style);
//            createCell(row,columnCount++,artwork.getPrice(),style);
//            createCell(row,columnCount++,artwork.getSize(),style);
//            createCell(row,columnCount++,artwork.getArtistEntity(),style);
//            //createCell(row,columnCount++,artwork.getGenre(),style);
//        }
    }
    public void export(HttpServletResponse response) throws IOException{
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    
}
