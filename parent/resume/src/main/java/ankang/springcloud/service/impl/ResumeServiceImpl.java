package ankang.springcloud.service.impl;

import ankang.springcloud.dao.ResumeDao;
import ankang.springcloud.pojo.Resume;
import ankang.springcloud.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeDao resumeDao;

    public ResumeServiceImpl(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    @Override
    public Resume findDefaultByUserId(Long userId) {
        final Resume resume = new Resume();
        resume.setUserId(userId);
        resume.setIsDefault(1);

        final Example<Resume> example = Example.of(resume);
        return resumeDao.findOne(example).get();
    }
}
