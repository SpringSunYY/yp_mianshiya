package com.yy.mainshiya.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户登录请求
 *
 *  @author YY
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;
}
