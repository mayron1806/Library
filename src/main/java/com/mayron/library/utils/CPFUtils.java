package com.mayron.library.utils;

public class CPFUtils {
    public static String removeSpecialChars(String cpf){
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        return cpf;
    }

    public static String AddSpecialChars(String cpf){
        cpf = CPFUtils.removeSpecialChars(cpf);
        int[] positions = {3,7,11};
        for (int i = 0; i < positions.length; i++) {
            if(i + 1 == positions.length){
                cpf = StringUtils.addCharAtPosition(cpf,'-', positions[i]);     
                continue;
            }
            cpf = StringUtils.addCharAtPosition(cpf,'.', positions[i]);     
        }
        return cpf;
    }
}
