package ru.netology.tests.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.tests.data.DataHelper;
import ru.netology.tests.data.SQLHelper;
import ru.netology.tests.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.tests.data.SQLHelper.deleteEverything;

public class SQLTest {

    @AfterAll
    static void teardown() {
        deleteEverything();
    }

    @Test
    void shouldLoginwithValidData() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verificationPage();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }
}
