package ir.mapsa.jgallery.excelexport.excel;

import ir.mapsa.jgallery.artwork.Artwork;
import ir.mapsa.jgallery.orderandartwork.OrderAndArtwork;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcelExporter {

    public ExcelExporter() {

    }

    public static <T> void writeToExcel(String fileName, List<T> data) {
        OutputStream fos = null;
        XSSFWorkbook workbook = null;
        try {
            File file = new File(fileName);
            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            List<String> fieldNames = getFieldNamesForClass(data.get(0).getClass());
            int rowCount = 0;
            int columnCount = 0;
            Row row = sheet.createRow(rowCount++);
            for (String fieldName : fieldNames) {
                Cell cell = row.createCell(columnCount++);
                cell.setCellValue(fieldName);
            }
            Class<? extends Object> classz = data.get(0).getClass();
            for (T t : data) {
                row = sheet.createRow(rowCount++);
                columnCount = 0;
                for (String fieldName : fieldNames) {
                    Cell cell = row.createCell(columnCount);
                    Method method = null;
                    try {
                        method = classz.getMethod("get" + capitalize(fieldName));
                    } catch (NoSuchMethodException nme) {
                        method = classz.getMethod("get" + fieldName);
                    }
                    Object value = method.invoke(t, (Object[]) null);
                    if (value != null) {
                        if (value instanceof String) {
                            cell.setCellValue((String) value);
                        } else if (value instanceof Long) {
                            cell.setCellValue((Long) value);
                        } else if (value instanceof Integer) {
                            cell.setCellValue((Integer) value);
                        } else if (value instanceof Double) {
                            cell.setCellValue((Double) value);
                        }
                    }
                    columnCount++;
                }
            }
            fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
            }
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
            }
        }
    }

    private static List<String> getFieldNamesForClass(Class<?> clazz) throws Exception{
        List<String> fieldNames = new ArrayList<String>();
        Field[] fields=clazz.getDeclaredFields();
        for (int i=0; i<fields.length; i++){
            fieldNames.add(fields[i].getName());
        }
        return fieldNames;
    }
    private static String capitalize(String s){
        if(s.length()==0)
            return s;
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<Artwork> artwork;

    public ExcelExporter(List<Artwork> listArtwork){
        this.artwork=listArtwork;
        workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
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

        Row row=sheet.createRow(0);
        CellStyle style=workbook.createCellStyle();
        XSSFFont font= workbook.createFont();
        font.setBold(true);
        font.setFontHeight(25);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row,0,"Artwork Information",style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
        font.setFontHeightInPoints((short)(8));

        row=sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(15);
        style.setFont(font);
        createCell(row,0,"Artwork Id",style);
        createCell(row,1,"Artwork Name",style);
        createCell(row,2,"Artwork Price",style);
        createCell(row,3,"Artwork Size",style);
        createCell(row,4,"Artwork Artist",style);
        createCell(row,5,"Artwork Genre",style);
    }

    private void writeDataLines(){
        int rowCount=2;

        CellStyle style=workbook.createCellStyle();
        XSSFFont font= workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(Artwork artwork:artwork){
            Row row=sheet.createRow(rowCount++);
            int columnCount=0;
            createCell(row,columnCount++,artwork.getId(),style);
            createCell(row,columnCount++,artwork.getName(),style);
            createCell(row,columnCount++,artwork.getPrice(),style);
            createCell(row,columnCount++,artwork.getSize(),style);
            createCell(row,columnCount++,artwork.getArtistEntity(),style);
            //createCell(row,columnCount++,artwork.getGenre(),style);
        }
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
