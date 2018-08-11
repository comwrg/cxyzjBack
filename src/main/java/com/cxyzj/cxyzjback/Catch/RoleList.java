package com.cxyzj.cxyzjback.Catch;

import com.cxyzj.cxyzjback.Bean.user.Role;
import com.cxyzj.cxyzjback.Repository.UserRoleJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Package com.cxyzj.cxyzjback.Catch
 * @Author Yaser
 * @Date 2018/08/09 16:17
 * @Description: 预读取用户角色信息
 */
@Slf4j
@Component
public class RoleList {
    private static Map<Integer, String> UserRole;//角色信息表

    @Autowired
    private UserRoleJpaRepository userRoleJpaRepository;
    private static RoleList roles;

    @PostConstruct
    public void init() {//注入
        roles = this;
    }

    private RoleList() {
    }

    public static RoleList getRoles() {
        return roles;
    }

    private void getRoleList() {
        //将查找到的role列表转换成map
        UserRole = userRoleJpaRepository.findAll().stream().collect(Collectors.toMap(Role::getRoleId, Role::getRole));
        log.info(UserRole.toString());
    }

    public String getRole(int roleId) {
        if (UserRole == null) {
            getRoleList();
        }
        return UserRole.get(roleId);//通过id查找角色信息
    }
}