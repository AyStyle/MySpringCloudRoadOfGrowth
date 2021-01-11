package ankang.springcloud.homework.user.exception;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
public class UserAccountOrPasswordException extends UserException{

    public UserAccountOrPasswordException() {
        super();
    }

    public UserAccountOrPasswordException(String message) {
        super(message);
    }

    public UserAccountOrPasswordException(String message , Throwable cause) {
        super(message , cause);
    }

    public UserAccountOrPasswordException(Throwable cause) {
        super(cause);
    }

    protected UserAccountOrPasswordException(String message , Throwable cause , boolean enableSuppression , boolean writableStackTrace) {
        super(message , cause , enableSuppression , writableStackTrace);
    }
}
