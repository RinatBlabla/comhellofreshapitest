package utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;

/**
 * Created by Rinat on 22.11.2019.
 */
public class Utils {

    public static <T> T convertJSONtoObject(String json, Class<T> t){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        T t1  = gson.fromJson(json, t);
        return t1;
    }
}
