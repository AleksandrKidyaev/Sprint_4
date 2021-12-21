import io.qameta.allure.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    private static final String USERNAME_PATTERN =
            "(?=.{3,19}$)[а-яА-Яa-zA-Z]+\\s{1}[а-яА-Яa-zA-Z]+";

    private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

    @Step("Выполнение метода checkNameToEmboss.")
    public boolean checkNameToEmboss(final String name) {

        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }

}
