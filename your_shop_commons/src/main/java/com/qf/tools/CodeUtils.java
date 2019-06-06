package com.qf.tools;

import java.util.Random;

public class CodeUtils {
    public static String getCode(){
        Random random = new Random();
        int code = 0;
        StringBuffer sb = new StringBuffer();
        for(int i =1;i<=4;i++){
           code = random.nextInt(9);
           sb.append(code);
       }
       return sb.toString();
    }

    public static void main(String[] args) {
        String code = CodeUtils.getCode();
        System.out.println(code);
    }
}
