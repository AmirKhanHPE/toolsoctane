package automated;

/**
 * Created by khanami on 05.05.2017.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
import com.hpe.alm.octane.OctaneCucumber;


@RunWith(OctaneCucumber.class)

@CucumberOptions(features={"Features"},
        plugin = {"pretty" ,
                "json:RunResults/cucumber.json",
                "junit:RunResults/cucumber.xml",
                "junit:RunResults/cucumber.html"},
        glue={"automated"}
)
//        tags = {"@TID63003REV1.1.0","@TID73001REV0.2.0"},


public class Testrunner {
    @Test
    public void test(){}
}
