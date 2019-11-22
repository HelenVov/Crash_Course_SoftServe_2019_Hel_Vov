package Task1.Tests;

import Task1.Chrome.Chrome;
import Task1.Firefox.Firefox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchGitHub {

    String searchGitHub = "GitHub";
    Chrome chrome = new Chrome();
    Firefox firefox = new Firefox();

    @Test
    public void chrome() {
        Assert.assertTrue(chrome.chromeSearch(searchGitHub));
    }

    @Test
    public void firefox() {
        Assert.assertTrue(firefox.firefoxSearch(searchGitHub));
    }

}
