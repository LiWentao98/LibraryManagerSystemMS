package com.mtli.lms.librarymanager.model;

import lombok.Data;

/**
 * @Description:分类号实体类
 * @Author: Mt.Li
 * @Create: 2019-11-09 11:04
 */
@Data
public class BookCatelog  {
    private Integer c_id;//分类号id
    private String c_number;//分类号
    private String c_name;//分类号对应的名称
}
