package io.github.rexmolo.utils;

import io.github.rexmolo.config.ErrMsg;

public class verify {

    public static void arguments(String fieldName, String fieldValue){
        String[] fn = {fieldName};
        String[] fv = {fieldValue};
        verify.arguments(fn, fv, 0);
    }

    public static void arguments(String[] fieldName, String[] fieldValue){
        verify.arguments(fieldName, fieldValue, 0);
    }

    public static void arguments(String[] fieldName, String[] fieldValue, int index){

        if (fieldValue.length != fieldName.length) throw new IllegalArgumentException("check both filedName and fieldValue");
        if (index > fieldValue.length - 1) return;

        if (fieldValue[index] == null || fieldValue[index].isEmpty() || fieldValue[index] == "null")
            throw new IllegalArgumentException(ErrMsg.IllegalArgument(fieldName[index]));
        verify.arguments(fieldName, fieldValue, ++index);
    }
}
