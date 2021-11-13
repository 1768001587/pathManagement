package com.hust.hospital.util;

import com.hust.hospital.entity.detail.Stage1;
import com.hust.hospital.entity.detail.Stage2;
import com.hust.hospital.entity.detail.Stage3;
import lombok.Data;

import java.util.List;

public class CheckMedicalNormsUtils {

    @Data
    public static class Message{
        int code;
        String msg;
        public Message(int code,String msg){
            this.code = code;
            this.msg = msg;
        }
    }

    public static Message checkMedicalNorms(List cheakList) {
        int size = cheakList.size();
        Stage1 stage1 = (Stage1) cheakList.get(0);
        Stage2 stage2 = (Stage2) cheakList.get(1);
        Stage3 stage3 = (Stage3) cheakList.get(2);
        String stage2CheckedCities = stage2.getCheckedCities();
        String stage3CheckedCities = stage3.getCheckedCities();
        if(stage2CheckedCities.contains("骨髓形态学、病理、免疫组化") && stage3CheckedCities.contains("甲泼尼龙")){
            return new Message(400,"骨髓形态学、病理、免疫组化 与 甲泼尼龙 不能一起使用");
        }
        if(stage3CheckedCities.contains("利妥昔单抗") && stage3CheckedCities.contains("甲泼尼龙")){
            return new Message(400,"利妥昔单抗 与 甲泼尼龙 不能一起使用");
        }
        return new Message(200,"");
    }
}
