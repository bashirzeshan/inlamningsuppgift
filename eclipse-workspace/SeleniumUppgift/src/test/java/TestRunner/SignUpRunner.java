package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;		


@RunWith(Cucumber.class)
@CucumberOptions(
		features =   {"src/test/resources/Feature/SignUp.feature"},
		glue={"StepDefs"}, tags =("@NewUser")
		)
 
/*******************************************************************************************
 * SignUpRunner - Test Class Runner File for SignUp Page
 *
 *******************************************************************************************/
public class SignUpRunner {

}
