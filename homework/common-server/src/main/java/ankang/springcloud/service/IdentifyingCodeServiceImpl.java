package ankang.springcloud.service;

import ankang.springcloud.dao.IdentifyingCodeDao;
import ankang.springcloud.pojo.IdentifyingCode;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-01-11
 */
@Service
public class IdentifyingCodeServiceImpl implements IdentifyingCodeService {

    private static final int CODE_LENGTH = 6;
    private static final Random RANDOM = new Random();

    private final IdentifyingCodeDao identifyingCodeDao;

    public IdentifyingCodeServiceImpl(IdentifyingCodeDao identifyingCodeDao) {
        this.identifyingCodeDao = identifyingCodeDao;
    }

    @Override
    public IdentifyingCode create() {
        final StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0 ; i < sb.capacity() ; i++) {
            sb.append(RANDOM.nextInt(10));
        }

        final IdentifyingCode code = new IdentifyingCode();
        code.setCode(sb.toString());

        identifyingCodeDao.save(code);
        return code;
    }

    @Override
    public boolean check(IdentifyingCode code) {
        final Optional<IdentifyingCode> actual = identifyingCodeDao.findById(code.getId());

        return actual.isPresent() && actual.get().getCode().equals(code.getCode());
    }

}
