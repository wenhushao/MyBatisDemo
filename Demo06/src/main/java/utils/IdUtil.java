package utils;

import org.junit.Test;

import java.util.UUID;

public class IdUtil {

    //生成随机数
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void TestGetIdUtil() {
        System.out.println(IdUtil.getId());
    }
}
