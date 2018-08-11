package com.cxyzj.cxyzjback.Controller;

import com.cxyzj.cxyzjback.Service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


/**
 * @Package com.cxyzj.cxyzjback.Controller
 * @Author Yaser
 * @Date 2018/07/29 15:34
 * @Description: 注意，仅供参考
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/v1/users")
public class TestController {
    @Autowired
    private ITestService userService;

    @GetMapping(value = "/{userId}")
    @PreAuthorize("hasRole('ROLE_USER') and principal.username.equals(#userId)")
//判断用户是否有USER权限，同时判断传来的userid是否与token里的id一致
    public String getUser(@PathVariable(name = "userId") String userId) {
        log.info(SecurityContextHolder.getContext().getAuthentication().getName());
        return userService.findByID(userId);
    }
}
