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

    By inputEmailReg = xpath("//input[@name='email']");
    By inputPasswordReg = xpath("//input[@name='password']");
    By btnFormReg = xpath("//button[@name='registration']");
    By textPopUpSuccessRegH1 = xpath("//a[@href='/contacts']");
    By BtnAddForm = xpath("//a[@href='/add']");
    By BtnSignOutForm = xpath("//button[text()='Sign Out']");


    public void openLoginPage(){

        clickBase(btnLoginNavigatorMenu);
    }


    public void login(UserDTO userDTO) {

        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
    }

    public void login(UserDTOWith userDTO) {

        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
    }

    public void loginUserDtoLombok(UserDtoLombok user) {

        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnLoginForm);



    }
    public boolean validatePopUpMessageSuccessAfterLogin() {
//        clickByXY(BtnAddForm, 2, 2);
        return isTextEqual(textSuccessLoginPopUp, "CONTACTS");

    }

    public boolean validateAlertMessageLoginIncorrect() {
        String expectedResult = "WRONG EMAIL OR PASSWORD";
        String actualResult = getTextAlert();

        return isTextContainsGetToStrings(expectedResult, actualResult);
    }

    public boolean validateAlertMessageLoginIncorrectReg() {

        String expectedResult = "WRONG EMAIL OR PASSWORD FORMAT";
        String actualResult = getTextAlert();

        return isTextContainsGetToStrings(expectedResult,actualResult);
    }

    public void fillRegistrationForm(UserDtoLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailReg, user.getEmail());
        typeTextBase(inputPasswordReg, user.getPassword());
        clickBase(btnFormReg);


    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {
//        clickByXY(BtnAddForm, 2, 2);
        String expectedResult = "CONTACTS".toUpperCase();
        return isTextEqual(textPopUpSuccessRegH1, expectedResult);

    }

    public void SignOut() {

        clickBase(BtnSignOutForm);
    }
}
