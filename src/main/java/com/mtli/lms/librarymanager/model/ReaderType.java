package com.mtli.lms.librarymanager.model;

import lombok.Data;

/**
 * @Description: 读者类型实体类
 * @Author: Mt.Li
*/
@Data
public class ReaderType{
    private Integer r_type;//读者类别
    private String r_type_name;//读者类别名称
    private Integer c_lend_q;//可借书数量
    private Integer c_lend_d;//可借书天数
    private Integer c_continue_times;//可续借次数
    private Float punish_rate;//罚款率/天
    private Integer date_valid;//证书有效期（年）(非空，0表示永久有效
}
