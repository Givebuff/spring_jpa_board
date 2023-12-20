package com.kcj.project.board.util;

public class DatabaseUtil {

    /**
     * DataBase Like Search Util <br>
     * idx = 01 => str% <br>
     * idx = 10 => %str <br>
     * idx = 11 => %str% <br>
     * default => str
     * @param str Search String
     * @param idx Like point index
     * @return Setting Like Character
     */
    public static String like(String str, int idx){
        return switch (idx) {
            case 10 -> "%" + str;
            case 01 -> str + "%";
            case 11 -> "%" + str + "%";
            default -> str;
        };
    }
}
