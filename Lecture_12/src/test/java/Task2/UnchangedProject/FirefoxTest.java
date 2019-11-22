package Task2.UnchangedProject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirefoxTest {
    Firefox firefox = new Firefox();
    private String[] service = {"ПРОГРАМНЕ ЗАБЕЗПЕЧЕННЯ", "ХМАРНІ ТЕХНОЛОГІЇ", "ВЕЛИКІ ДАНІ", "ШТУЧНИЙ ІНТЕЛЕКТ", "ІНТЕРНЕТ РЕЧЕЙ (IOT)", "СЕРВІСНИЙ ДИЗАЙН", "КІБЕРБЕЗПЕКА", "ЦИФРОВІ ПЛАТФОРМИ", "РОЗШИРЕНА РЕАЛЬНІСТЬ (XR)"};

    @Test
    public void areTheCorrectValuesStoredInTheList() {
        String resultService = firefox.firefox();
        Assert.assertEquals(service.toString(), resultService);
    }

}

