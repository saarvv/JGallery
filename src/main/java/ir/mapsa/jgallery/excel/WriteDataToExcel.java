package ir.mapsa.jgallery.excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;
import java.util.TreeMap;

public class WriteDataToExcel {
    public static void main(String[] args) throws Exception {

        //Create a blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet("Artwork Info");

        //Create row object
        XSSFRow row;

        //This data needs to be written (Object[])
        Map<String,Object[]> empinfo = new TreeMap<String,Object[]>();
        empinfo.put("1",new Object[]){

        }





    }
}
