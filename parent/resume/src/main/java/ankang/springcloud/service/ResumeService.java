package ankang.springcloud.service;

import ankang.springcloud.pojo.Resume;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
public interface ResumeService {

    Resume findDefaultByUserId(Long userId);

}
