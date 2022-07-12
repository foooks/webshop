package ee.mihkel.webshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;
import java.util.NoSuchElementException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ErrorHandler {
    //dejstvuet na vse controllerq ilovit vse oshibki
    @ExceptionHandler
    public ResponseEntity<CustomError> handleError(NoSuchElementException e){
        CustomError customError = new CustomError();
        customError.setTimeStamp(new Date());
        customError.setMessage("Otsitud elementi ei leitud");
        customError.setError(HttpStatus.NOT_FOUND);
        customError.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<CustomError> handleError(ProductNotFoundException e){
        CustomError customError = new CustomError();
        customError.setTimeStamp(new Date());
        customError.setMessage("Otsitud toodet ei leitud");
        customError.setError(HttpStatus.NOT_FOUND);
        customError.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler
//    public ResponseEntity<CustomError> handleError(HttpMessageNotReadableException e){
//       CustomError customError = new CustomError();
//        customError.setTimeStamp(new Date());
//        customError.setMessage("Numbri asemel s7mbol");
//        customError.setError(HttpStatus.BAD_REQUEST);
//        customError.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
//    }


    @ExceptionHandler
    public ResponseEntity<CustomError> handleError(HttpRequestMethodNotSupportedException e){
        CustomError customError = new CustomError();
        customError.setTimeStamp(new Date());
        customError.setMessage("Vale meetod");
        customError.setError(HttpStatus.BAD_REQUEST);
        customError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<CustomError> handleError(MethodArgumentTypeMismatchException e){
        CustomError customError = new CustomError();
        customError.setTimeStamp(new Date());
        customError.setMessage("Vale meetod");
        customError.setError(HttpStatus.BAD_REQUEST);
        customError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }
}
