package ir.mapsa.jgallery.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ResponseDto> handleBaseException(BaseException ex){
        ResponseDto response = ResponseDto.builder()
                .status(ex.getHttpStatus().value())
                .message(ex.getHttpStatus().getReasonPhrase())
                .error(ex.getHttpStatus().getReasonPhrase())
                .timestamp(new Date())
                .stackTrace(convertStack(ex))
                .build();
        return new ResponseEntity<>(response, ex.getHttpStatus());

    }

    private String convertStack(Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();
        return stackTrace;

    }



}

