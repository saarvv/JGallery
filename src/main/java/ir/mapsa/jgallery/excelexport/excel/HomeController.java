package ir.mapsa.jgallery.excelexport.excel;

import ir.mapsa.jgallery.artwork.Artwork;
import ir.mapsa.jgallery.artwork.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/web")
public class HomeController {
    @RequestMapping("/home")
    public String homePage(){
        return "HomePage";
    }

    @Autowired
    private ArtworkRepository artworkRepository;

    @GetMapping("export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headerValue="attachment; filename=Artwork_info.xlsx";

        response.setHeader(headerKey,headerValue);
        List<Artwork> listArtwork= (List<Artwork>) artworkRepository.findAll();
        ExcelExporter exporter= new ExcelExporter(listArtwork);
        exportToExcel(response);
    }

}
