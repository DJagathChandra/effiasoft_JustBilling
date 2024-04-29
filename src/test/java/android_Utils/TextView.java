package android_Utils;

import org.openqa.selenium.By;

import java.io.IOException;

public class TextView {

    private By by;
    private String text;

    public TextView(String text, int index) {
        this.text = text;
        by = By.xpath(String.format("(//android.widget.TextView[@text='%s'])[%d]", text,index));
    }

    public By getBy() {
        return this.by;
    }

    public void Click() throws IOException {
        new MobileActions().click(by, String.format("Click on Text view '%s'", text));
    }

    public void getText() throws IOException {
        new MobileActions().getText(by, String.format("Get %s's Text", text));
    }

    public boolean isDisplayed() throws IOException {
       return new MobileActions().isDisplayed(by, String.format("Verify visibility of %s Text", text));
    }

    public static TextView get(String text, int index){
        return new TextView(text, index);
    }



}
