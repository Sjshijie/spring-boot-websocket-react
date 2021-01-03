package com.sj.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sj.pojo.ResultMessage;

public class MessageUtils {
    public static String getMessage(String fromName,Object message){
        try {
            ResultMessage result = new ResultMessage();
            result.setMessage(message);
            if(fromName !=null){
                result.setFromName(fromName);
                ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsString(result);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
