package anakang.springcloud.alibaba.resume.controller;

import anakang.springcloud.alibaba.resume.service.ResumeService;
import ankang.springcloud.alibaba.resume.pojo.Resume;
import lombok.SneakyThrows;
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
        final Resume defaultResume = resumeService.findDefaultByUserId(userId);

        return defaultResume.getIsOpenResume();
    }

}
