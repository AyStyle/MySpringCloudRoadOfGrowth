package ankang.springcloud.controller;

import ankang.springcloud.pojo.Resume;
import ankang.springcloud.service.ResumeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-12-30
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @SneakyThrows
    @GetMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
        // 模拟处理超时
        Thread.sleep((long) (Math.random() * 500));
        final Resume defaultResume = resumeService.findDefaultByUserId(userId);

        return defaultResume.getIsOpenResume();
    }

}
