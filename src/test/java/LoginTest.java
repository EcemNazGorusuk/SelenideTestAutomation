import com.codeborne.selenide.conditions.TextCondition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest {

    @Test
    public void loginSuccessful(){
        //Selenide ile test edilecek sitenin tarayıcı bilgisi & url adresine erişim bu şekilde:
        Configuration.browser="chrome";
        Selenide.open("https://www.trendyol.com/giris");
        $(By.id("login-email")).sendKeys("ecemnazgorusuk@gmail.com");
        // $(By.id("login-email")).setValue("ecemnazgorusuk@gmail.com"); -> setValue input alanını sildikten sonra texti girer
        $(By.id("login-password-input")).sendKeys("21012022Eb");
        $(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).submit();

        //Hesabım metninin varlığını tespit etmek:
        $("[class='link account-user'] p").shouldHave(Condition.text("Hesabım"));
    }
}
