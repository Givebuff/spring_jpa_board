package com.kcj.project.board.util;

import java.util.Locale;

public class LoginFailMessageUtil {

    public static String getFailTag(String code){

        if (code.equalsIgnoreCase("FOUND")) {
            return "ID/PW를 확인해주세요.";
        } else if (code.equalsIgnoreCase("LOCK")) {
            return "계정이 잠겼습니다. 관리자에게 문의주세요.";
        } else if (code.equalsIgnoreCase("DISABLE")) {
            return "계정이 비활성화 되었습니다. 관리자에게 문의주세요.";
        } else if (code.equalsIgnoreCase("CREDENTIAL")) {
            return "잘못 로그인 하셨습니다.";
        } else {
            return "확인할 수 없는 오류로 로그인이 불가합니다. 관리자에게 문의 주세요.";
        }
    }
}
