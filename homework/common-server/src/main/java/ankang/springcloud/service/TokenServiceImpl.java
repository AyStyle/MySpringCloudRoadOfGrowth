package ankang.springcloud.service;

import ankang.springcloud.pojo.Token;
import ankang.springcloud.dao.TokenDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
@Service
public class TokenServiceImpl implements TokenService {

    private final TokenDao tokenDao;

    public TokenServiceImpl(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    @Override
    public Token create() {
        final Token token = new Token();
        token.setToken(LocalDateTime.now().toString());

        tokenDao.save(token);
        return token;
    }

    @Override
    public boolean check(Token token) {
        final Optional<Token> actual = tokenDao.findById(token.getId());

        return actual.isPresent() && actual.get().getToken().equals(token.getToken());
    }
}
