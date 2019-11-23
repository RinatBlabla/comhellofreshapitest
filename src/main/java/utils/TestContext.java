package utils;

import enums.TestContextKeyEnum;

import java.util.HashMap;

/**
 * Created by Rinat on 22.11.2019.
 */
public class TestContext {

    private static HashMap<String,Object> context = new HashMap<>();

    public static  <T> T get(String key) {
        return (T) context.get(key);
    }

    public static void put(String key, Object value) {
        context.put(key, value);
    }

    @Override
    public String toString() {
        return "TestContext" +  context.toString();
    }
}
