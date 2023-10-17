import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@DemoQA",
        glue = "com.prueba.stepdefinitions",
        plugin = { "pretty",
                "html:target/cucumber-report/report.html",
                "json:target/cucumber-report/Cucumber.json" }
)
public class RunCucumberTest {
}

