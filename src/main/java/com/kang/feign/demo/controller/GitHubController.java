package com.kang.feign.demo.controller;

import com.kang.feign.demo.service.GitHubFeign;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author weikang.di
 * @date 2021/6/30 11:36
 */
@RestController
@RequestMapping(
        value = "/github",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class GitHubController {

    @Resource
    private GitHubFeign gitHubFeign;

    @RequestMapping(
            value = "/search/repositories",
            method = RequestMethod.GET
    )
    String searchRepo(@RequestParam("q") String q) {
        return gitHubFeign.searchRepo(q);
    }
}
