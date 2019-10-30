package com.mtli.lms.librarymanager.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 借阅记录实体类
 * @Author: Mt.Li
*/
@Data
public class Borrow {
    private BigDecimal borrow_id;//借书顺序号
    private Integer r_id;//读者序号
    private Integer b_id;//图书序号
    private Integer id_continue_times;//续借次数（第一次借时，记为0）
    private Date id_date_out;//借书日期
    private Date id_date_ret_plan;//应还日期
    private Date id_date_ret_real;//实际还书日期
    private Integer id_over_day;//超期天数
    private BigDecimal id_over_money;//超期金额（应罚款金额）
    private BigDecimal id_punish_money;//罚款金额
    private Integer is_has_return;//是否已经还书，缺省为0-未还
    private String operator_lend;//还书操作员
    private String operator_ret;//借书操作员
}
