package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {

        super(driver);
    }

    By btnLoginNavigatorMenu = By.xpath("//a[@href='/login']");
    By inputEmailLoginForm = By.xpath("//input[@name='email']");
    By inputPasswordLoginForm = By.xpath("//input[@name='password']");
    By btnLoginForm = By.xpath("//button[@name='login']");
    By textSuccessLoginPopUp = By.xpath("//a[@href='/contacts']");

    By btnOpenRegForm = By.xpath("//a[@href='/login']");
    By inputEmailReg = By.xpath("//input[@name='email']");
    By inputPasswordReg = By.xpath("//input[@name='password']");
    By btnFormReg = By.xpath("//button[@name='registration']");
    By textPopUpSuccessRegH1 = By.xpath("//a[@href='/contacts']");



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

        return isTextEqual(textSuccessLoginPopUp, "CONTACTS");
    }

    public void fillRegistrationForm(UserDtoLombok user) {
        clickBase(btnOpenRegForm);
        typeTextBase(inputEmailReg, user.getEmail());
        typeTextBase(inputPasswordReg, user.getPassword());
        clickBase(btnFormReg);
    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {
        String expectedResult = "CONTACTS".toUpperCase();
        return isTextEqual(textPopUpSuccessRegH1, expectedResult);
    }
}
