package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {

        super(driver);
    }

    By btnLoginNavigatorMenu = xpath("//a[@href='/login']");
    By inputEmailLoginForm = xpath("//input[@name='email']");
    By inputPasswordLoginForm = xpath("//input[@name='password']");
    By btnLoginForm = xpath("//button[@name='login']");
    By textSuccessLoginPopUp = xpath("//a[@href='/contacts']");

    By btnOpenRegForm = xpath("//a[@href='/login']");
    By inputEmailReg = xpath("//input[@name='email']");
    By inputPasswordReg = xpath("//input[@name='password']");
    By btnFormReg = xpath("//button[@name='registration']");
    By textPopUpSuccessRegH1 = xpath("//a[@href='/contacts']");
    By BtnAddForm = xpath("//a[@href='/add']");
    By BtnSignOutForm = xpath("//button");


    public void login(UserDTO userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
    }

    public void login(UserDTOWith userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
    }

    public void loginUserDtoLombok(UserDtoLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnLoginForm);



    }
    public boolean validatePopUpMessageSuccessAfterLogin() {
        clickByXY(BtnAddForm, 2, 2);
        return isTextEqual(textSuccessLoginPopUp, "CONTACTS");

    }

    public boolean validateAlertMessageLoginIncorrect() {
        String expectedResult = "WRONG EMAIL OR PASSWORD";
        String actualResult = getTextAlert();

        return isTextEqualGetToStrings(expectedResult, actualResult);
    }

    public boolean validateAlertMessageLoginIncorrectReg() {

//        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//        Alert alerts2 = driver.switchTo().alert();
//        System.out.println(alert2.getText());
//        alerts2.dismiss();
//        if(driver.getPageSource().contains("you clicked: Cancel"))
//            System.out.println("you clicked: Cancel");

        String expectedResult = "WRONG EMAIL OR PASSWORD FORMAT\n" +
                "            EMAIL MUST CONTAINS ONE @ AND MINIMUM 2 SYMBOLS AFTER LAST DOT\n" +
                "            PASSWORD MUST CONTAIN AT LEAST ONE UPPERCASE LETTER!\n" +
                "            PASSWORD MUST CONTAIN AT LEAST ONE LOWERCASE LETTER!\n" +
                "            PASSWORD MUST CONTAIN AT LEAST ONE DIGIT!\n" +
                "            PASSWORD MUST CONTAIN AT LEAST ONE SPECIAL SYMBOL FROM [‘$’,’~’,’-‘,’_’]!".toUpperCase().trim();
        String actualResult = getTextAlert().toUpperCase().trim();

        return isTextEqualGetToStrings(expectedResult, actualResult);
    }

    public void fillRegistrationForm(UserDtoLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailReg, user.getEmail());
        typeTextBase(inputPasswordReg, user.getPassword());
        clickBase(btnFormReg);


    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {
        clickByXY(BtnAddForm, 2, 2);
        String expectedResult = "CONTACTS".toUpperCase();
        return isTextEqual(textPopUpSuccessRegH1, expectedResult);

    }

    public boolean btnSignOutExist() {

        return isElementExist(BtnSignOutForm);
    }

    public void SignOut() {

        clickBase(BtnSignOutForm);
    }
}
