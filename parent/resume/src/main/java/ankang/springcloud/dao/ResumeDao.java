package ankang.springcloud.dao;

import ankang.springcloud.pojo.Resume;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
public interface ResumeDao extends JpaRepositoryImplementation<Resume, Long> {
}
