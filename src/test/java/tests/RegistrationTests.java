package tests;

import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{

    boolean flagIsAlertPresent = false;
    boolean flagIsUserLogin = false;


    @BeforeClass
    public void preconditionsBeforeClass() {
        // refresh // go main page // click btn login
        app.navigateToMainPage();
        app.getUserHelper().refresh();
        app.getUserHelper().openLoginPage();
    }
    @BeforeMethod
    public void preconditionsBeforeMethod() {
        if(flagIsAlertPresent) {
            // app.getUserHelper().refresh();
            flagIsAlertPresent = false;
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            app.getUserHelper().clickAcceptAlert();
        }
        if (flagIsUserLogin) {
            flagIsUserLogin = false;
            app.getUserHelper().SignOut();
        }
        app.getUserHelper().refresh();
        // login
        // sign out
        // alert
    }




    @Test
    public void positiveRegistration() {
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("123456Aa$")
                .build();

        flagIsUserLogin = true;
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }
    @Test
    public void negativePasswordWithoutSymbolRegistration() {
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("123456Aa")
                .build();

        flagIsAlertPresent = true;
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateAlertMessageLoginIncorrectReg());
    }

    @Test
    public void negativePasswordWithoutDigitsRegistration() {
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("djhsdf$Aa")
                .build();

        flagIsAlertPresent = true;
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateAlertMessageLoginIncorrectReg());
    }

    @Test
    public void negativePasswordWithoutLettersRegistration() {
        String email = randomUtils.generateEmail(7);

        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("12345651$!")
                .build();

        flagIsAlertPresent = true;
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateAlertMessageLoginIncorrectReg());
    }


}
