package anakang.springcloud.alibaba.resume.service;


import ankang.springcloud.alibaba.resume.pojo.Resume;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
public interface ResumeService {

    Resume findDefaultByUserId(Long userId);

}
