package com.mtli.lms.librarymanager.model;

import lombok.Data;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-10-25 09:02
 */
@Data
public class admin {
    private Integer a_id;
    private String a_name;
    private Integer a_phone;
    private String a_email;
    private byte[] a_photo;
    private String a_username;
    private String a_password;
}
