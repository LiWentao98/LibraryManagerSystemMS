package com.mtli.lms.librarymanager.model;

import lombok.Data;

/**
 * @Description:管理员实体类
 * @Author: Mt.Li
 * @Create: 2019-10-25 09:02
 */
@Data
public class Admin {
    private Integer a_id;
    private String name;
    private String phone;
    private String email;
    private byte[] photo;
    private String username;
    private String password;
}
