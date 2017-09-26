package automated;

/**
 * Created by khanami on 05.05.2017.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


//@RunWith(Cucumber.class)
import com.hpe.alm.octane.OctaneCucumber;


@RunWith(OctaneCucumber.class)

@CucumberOptions(features={"Features"},
        plugin = {"junit:junitResult.xml"},
        glue={"automated"}
)


public class Testrunner {
    @Test
    public void test(){}
}
