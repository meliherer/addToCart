package commonFunctions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.datatransfer.Clipboard;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ReusableFunctions {

    //static WebDriver driver;


    public static void copyValueToClipboard(WebDriver driver, String value) {

        WebElement element = driver.findElement(By.className(value));

        String productPrice = element.getText();

        // Get the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Create a StringSelection object
        StringSelection selection = new StringSelection(productPrice);

        // Set the contents of the clipboard to the StringSelection
        clipboard.setContents(selection, null);
        // Get the clipboard content


        //System.out.println("Text has been copied to clipboard." + selection);

    }

    public static String getValueFromClipboard() {


        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        Transferable transferable = clipboard.getContents(null);

        try {
            // Get the clipboard content as a String
            String clipboardContent = (String) transferable.getTransferData(DataFlavor.stringFlavor);
            //System.out.println("Clipboard content: " + clipboardContent);
            return clipboardContent;

        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }



    }

    public static void isCopiedValueSame(String clipboardValue, String actualValue) {


            Assert.assertEquals(clipboardValue, actualValue );
            System.out.println("product price are same -> " + clipboardValue +" = "+actualValue);


    }

    public static void saveToFile(String filePath, String content) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            System.out.println("Element değeri dosyaya kaydedildi: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String mergeString(String value1,String value2){


        return value1 +" "+ value2;

    }

    public static void saveToTxt(String filePath, String element1, String element2) {

        String combinedString = element1 +" " + element2;


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write(combinedString);
            System.out.println("product informations have been saved. " + combinedString);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

