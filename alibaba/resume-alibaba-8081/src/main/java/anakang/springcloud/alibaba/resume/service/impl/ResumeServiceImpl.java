package anakang.springcloud.alibaba.resume.service.impl;

import anakang.springcloud.alibaba.resume.dao.ResumeDao;
import anakang.springcloud.alibaba.resume.service.ResumeService;
import ankang.springcloud.alibaba.resume.pojo.Resume;
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
