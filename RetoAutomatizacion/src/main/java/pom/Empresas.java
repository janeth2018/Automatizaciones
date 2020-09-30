package pom;

import org.openqa.selenium.By;
import utils.Utilities;

public class Empresas {
    private final By LINK = By.linkText("//li[@id='linkEmpresas']");

    public Empresas eP(){
        Utilities.wt(2000);
        Utilities.click(LINK);

        return this;

    }

}
