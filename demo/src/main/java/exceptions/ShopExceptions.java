package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

//@ResponseBody (HttpStatus.NOT_FOUND)
public class ShopExceptions extends RuntimeException {
    public ShopExceptions(String message){}
}
