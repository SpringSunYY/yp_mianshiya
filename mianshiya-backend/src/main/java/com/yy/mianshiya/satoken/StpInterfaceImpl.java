package com.yy.mianshiya.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.yy.mianshiya.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.yy.mianshiya.constant.UserConstant.USER_LOGIN_STATE;

/**
 * @Project: mianshiya-backend
 * @Package: com.yy.mianshiya.satoken
 * @Author: YY
 * @CreateTime: 2024-10-22  21:53
 * @Description: StpInterfaceImpl
 * 自定义权限加载接口实现类
 * @Version: 1.0
 */
@Component // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {

    /**
     * 返回一个账号所拥有的权限码集合（目前没用）
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return new ArrayList<>();
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 从当前登录用户信息中获取角色
        User user = (User) StpUtil.getSessionByLoginId(loginId).get(USER_LOGIN_STATE);
        return Collections.singletonList(user.getUserRole());
    }

}
