package com.mtli.lms.librarymanager.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 图书实体类
 * @Author: Mt.Li
*/
@Data
public class Book {
    private Integer b_id;//图书序号
    private String b_code;//图书编号或条码号
    private String b_name;//书名
    private String b_author;//作者
    private String b_press;//出版社
    private Date b_date_press;//出版日期
    private String b_isbn;//ISBN书号
    private String b_catalog;//分类号（如：TP316-21/123）
    private Integer b_language;//语言，0-中文，1-英文，2-日文，3-俄文，
    private Integer b_pages;//页数
    private BigDecimal b_price;//价格
    private Date b_date_in;//入馆日期
    private String b_brief;//内容简介
    private byte[] b_cover;//图书封面照片
    private String b_status;//图书状态，在馆、借出、遗失、变卖、销毁

}
