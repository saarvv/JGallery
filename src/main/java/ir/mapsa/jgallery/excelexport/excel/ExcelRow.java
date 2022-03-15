package ir.mapsa.jgallery.excelexport.excel;

import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
public class ExcelRow {
    List<String> Column;

    public Cell createCell(int columnCount) {
        return createCell(columnCount);
    }
}
