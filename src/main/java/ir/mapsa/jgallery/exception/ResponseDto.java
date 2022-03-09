package ir.mapsa.jgallery.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm;ss")

    private Date timestamp;

    private int status;

    private String error;

    private String message;

    private String stackTrace;

    private Object data;

}
