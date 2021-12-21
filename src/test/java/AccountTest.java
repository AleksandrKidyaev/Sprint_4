import io.qameta.allure.*;
import io.qameta.allure.junit4.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String testName;
    private final boolean expectedResult;

    public AccountTest(String testName, boolean expectedResult) {
        this.testName = testName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getNameAndResultData() {
        return new Object[][] {
                {"Полуэктов Полуэкт", true}, //Стандартное имя на кириллице
                {"Полуэктов Полуэкт ", false}, //Пробел в конце имени
                {" Полуэктов Полуэкт", false}, //Пробел в начале имени
                {"По", false}, //Имя менее трех символов
                {"Полуэктов Кристофер", true}, //В имени ровно 19 символов
                {"Велкопоповицкий Варфоламей", false}, //В имени более 19 символов
                {"Ю Ю", true}, // В имени ровно 3 символа
                {"John Waters", true}, //Стандартное имя на латинице
                {"", false}, //Пустое имя
                {"John  Waters", false}, //Два пробела в середине имени вместо одного
                {"2233 4466", false}, //Имя из цифр
                {"$$№% &&^^", false}, //Имя не из букв
                {"Полуэктов", false}, //Имя без пробела и из одного слова
                {"Вим Биль Дан", false}, //Имя из трех слов
        };
    }


    @Test
    @DisplayName("Проверка имени по заданным параметрам.")
    @Description("Параметризированный тест на корректность вносимого имени.")
    @Owner(value = "Кидяев Александр Дмитриевич")
    @Severity(value = SeverityLevel.NORMAL)
    public void checkNameToEmbossTest() {
        Account account = new Account(testName);
        boolean actualResult = account.checkNameToEmboss(testName);
        assertEquals(expectedResult, actualResult);
    }
}