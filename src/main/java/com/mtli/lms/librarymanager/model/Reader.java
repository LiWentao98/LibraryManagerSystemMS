package com.mtli.lms.librarymanager.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description: 读者实体类
 * @Author: Mt.Li
*/
@Data
public class Reader  {
    private Integer r_id;//读者编号/借书证号
    private String r_name;//读者姓名
    private String r_sex;//性别，男/女
    private String r_dept;//单位名称
    private String r_phone;//电话号码
    private String r_email;//电子邮箱
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date r_date_reg;//读者办证日期
    private byte[] r_photo;//读者照片
    private String r_status;//证书状态：有效、挂失、注销
    private Integer r_borrow_q;//已借书数量
    private String r_pwd;//读者密码
    private Integer a_id;//管理员
    private Integer r_type;//读者类型
}
