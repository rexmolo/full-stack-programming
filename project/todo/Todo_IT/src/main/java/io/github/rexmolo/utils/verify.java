package io.github.rexmolo.utils;

import io.github.rexmolo.config.ErrMsg;

import java.time.LocalDate;

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

        if (fieldValue.length != fieldName.length) throw new IllegalArgumentException("the length of filedName and fieldValue should be equal");
        if (index > fieldValue.length - 1) return;// out of bounds

//        String type;
//        if (fieldName[index].indexOf("|") < 0) {
//            type = "string";
//        }
//        else {
//            String[] fieldNameArr = fieldName[index].split("|");
//            type = fieldNameArr[1];
//        }
        if (!verify.checkString(fieldValue[index]))
            throw new IllegalArgumentException(ErrMsg.IllegalArgument(fieldName[index]));

        verify.arguments(fieldName, fieldValue, ++index);
    }


    public static boolean checkString(String val){
        if (val == null || val.isBlank() || val == "null")
            return false;
        return true;
    }


    //    public static void arguments(String[] fieldName, String[] fieldValue, int index, String type){
//
//        if (fieldValue.length != fieldName.length) throw new IllegalArgumentException("the length of filedName and fieldValue should be equal");
//        if (index > fieldValue.length - 1) return;// out of bounds
//
//        if (!verify.checkString(fieldValue[index]))
//            throw new IllegalArgumentException(ErrMsg.IllegalArgument(fieldName[index]));
//
//        verify.arguments(fieldName, fieldValue, ++index);
//    }


}
