package com.mtli.lms.librarymanager.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:借阅实体类
 * @Author: Mt.Li
 * @Create: 2019-11-16 16:26
 */
@Data
public class Borrow  {
    private Integer borrow_id;
    private Integer r_id;
    private Integer b_id;
    private Integer id_continue_times;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date id_date_out;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date id_date_ret_plan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date id_date_ret_act;
    private Integer id_over_day;
    private BigDecimal id_over_money;
    private BigDecimal id_punish_money;
    private boolean is_has_return;
    private String b_name;
    private String b_author;
    private String r_name;
}
