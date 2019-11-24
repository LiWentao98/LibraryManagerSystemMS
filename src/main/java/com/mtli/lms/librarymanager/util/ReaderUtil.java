package com.mtli.lms.librarymanager.util;

import com.mtli.lms.librarymanager.model.Reader;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-16 12:59
 */
public class ReaderUtil {
    private Reader reader;
    private Integer type1 = 0;

    public Integer readerTypeChange(String type){
        if("本科生".equals(type)){
            return type1=10;
        }
        if("专科生".equals(type)){
            return type1=20;
        }
        if("硕士生".equals(type)){
            return type1=30;
        }
        if("教师".equals(type)){
            return type1=40;
        }
        return 0;
    }
}
