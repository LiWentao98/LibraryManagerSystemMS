package com.mtli.lms.librarymanager.util;

import com.mtli.lms.librarymanager.model.Reader;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-12 08:20
 */
@Data
public class BookUtil {
    private int type1;


//
//    public Reader packagingPro(Integer r_type, String r_dept,
//                        String r_name, String r_sex,
//                        String r_phone, Integer r_id,
//                        String r_email, Date r_date_reg){
//        reader.setR_type(r_type);
//        reader.setR_dept(r_dept);
//        reader.setR_name(r_name);
//        reader.setR_sex(r_sex);
//        reader.setR_phone(r_phone);
//        reader.setR_id(r_id);
//        reader.setR_email(r_email);
//        reader.setR_date_reg(r_date_reg);
//        return reader;
//    }

    public int judgeType(String lan){
        if (lan!=null) {
            if ("中文".equals(lan)) {
                type1 = 0;
                return type1;
            }
            if ("英文".equals(lan)) {
                type1 = 1;
                return type1;
            }
            if ("日文".equals(lan)) {
                type1 = 2;
                return type1;
            }
            if ("俄文".equals(lan)) {
                type1 = 3;
                return type1;
            }
            if ("德文".equals(lan)) {
                type1 = 4;
                return type1;
            }
            if ("法文".equals(lan)) {
                type1 = 5;
                return type1;
            }
        }
        return type1;
    }
}
