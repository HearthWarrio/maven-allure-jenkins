package settings;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:application.properties"})
public interface ConfigVars extends Config {
    @Key("correct_passport")
    String correct_passport();

    @Key("roleUser_login")
    String roleUser_login();

    @Key("actual_text1")
    String actual_text1();
}
