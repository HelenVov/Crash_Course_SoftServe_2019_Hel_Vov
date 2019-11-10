package Lec10;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public interface InrFTest {
    ArrayList<String> servise = new ArrayList<String>();
    List<String> result = new ArrayList<String>();

    void testCount(WebDriver driver);

    void setupTest();

    void setupClass();
}
