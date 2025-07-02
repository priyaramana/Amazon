package amazonUtils;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	
	public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destfolder = "/Users/lt535j/eclipse-workspace/Amazon/Images";
		screenshotName = screenshotName.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
		File dest = new File(destfolder,driver.getTitle()+".png");
		FileUtils.copyFile(src, dest);
		System.out.println(dest.getAbsolutePath());
	}
}
