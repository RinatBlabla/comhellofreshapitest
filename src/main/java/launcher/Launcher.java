package launcher;

/**
 * Created by Rinat on 22.11.2019.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags={"@Regress"},
        glue="steps",
        features = "classpath:features",
        plugin = {"html:target/cucumber-report/", "io.qameta.allure.cucumberjvm.AllureCucumberJvm"}
)
public class Launcher {

    public static void main(String[] args){
        JUnitCore.main("launcher.Launcher");
    }
}
