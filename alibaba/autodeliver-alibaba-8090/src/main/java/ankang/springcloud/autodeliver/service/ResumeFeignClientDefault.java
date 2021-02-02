package ankang.springcloud.autodeliver.service;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2021-02-02
 */
public class ResumeFeignClientDefault implements ResumeFeignClientService{
    @Override
    public Integer findDefaultResumeState(Long userId) {
        return -1;
    }
}
