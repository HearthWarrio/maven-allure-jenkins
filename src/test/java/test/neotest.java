package test;

import org.testng.annotations.Test;
import settings.WebDriverSettings;

import static pages.SignInPage.*;

public class neotest extends WebDriverSettings {

    @Test
    public void JustEnterMail() throws Exception{
        authorizaton("start_driver");
    }
}
