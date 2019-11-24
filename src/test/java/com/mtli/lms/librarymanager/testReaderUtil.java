package com.mtli.lms.librarymanager;

import com.mtli.lms.librarymanager.util.BookUtil;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-12 08:51
 */
public class testReaderUtil {


    public static void main(String[] args) {
        String r_type = "本科生";
        BookUtil readerUtil = new BookUtil();
        System.out.println(readerUtil.judgeType(r_type));

    }

}
