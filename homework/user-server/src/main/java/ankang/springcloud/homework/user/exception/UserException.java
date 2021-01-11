package ankang.springcloud.homework.user.exception;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public class UserException extends Exception {

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message , Throwable cause) {
        super(message , cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message , Throwable cause , boolean enableSuppression , boolean writableStackTrace) {
        super(message , cause , enableSuppression , writableStackTrace);
    }
}
