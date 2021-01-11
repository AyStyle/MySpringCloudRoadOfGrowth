package ankang.springcloud.homework.user.exception;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public class UserExistsException extends UserException{

    public UserExistsException() {
        super();
    }

    public UserExistsException(String message) {
        super(message);
    }

    public UserExistsException(String message , Throwable cause) {
        super(message , cause);
    }

    public UserExistsException(Throwable cause) {
        super(cause);
    }

    protected UserExistsException(String message , Throwable cause , boolean enableSuppression , boolean writableStackTrace) {
        super(message , cause , enableSuppression , writableStackTrace);
    }
}
