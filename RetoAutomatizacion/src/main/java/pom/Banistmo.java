package pom;

import org.openqa.selenium.By;
import utils.Utilities;

public class Banistmo {
    private final By PRODUCTOS = By.xpath("//a[@href='#productosYserviciosPersonas']");
    private final By TARJETAS = By.xpath("//a[@href='/wps/portal/banistmo/personas/productos-y-servicios/tarjetas-credito/']");


    public Banistmo bN(){
        Utilities.wt(2000);
        Utilities.click(PRODUCTOS);
        Utilities.wt(2000);
        Utilities.click(TARJETAS);

        return this;

    }


}
