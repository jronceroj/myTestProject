package controllers;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Jesus
 *
 */
public class TestLogin {

	static Logger log = Logger.getLogger(TestLogin.class);
	
	private WebDriver driver = null;
	private Properties prop = new Properties();
	
	/**
	 * Constructor
	 */
	public TestLogin()
	{
		log.info("********************TestLogin*******************");
		try {
			prop.load(new FileReader("src/test/resources/EnumXpath.properties"));
		} catch (Exception e) {
			log.info(e.getMessage()); 
		}
		System.setProperty("webdriver.gecko.driver","D:\\Jesus\\workspace\\DRIVERS\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	/**
	 * Abre navegador a la web de SDOS
	 */
	public void abrirNavegador()
	{
		log.info("SELENIUM: abrirNavegador");
		driver.get("https://sdos.es/");			
	}
	
	/**
	 * Click en el boton del login
	 */
	public void clickLoginButton()
	{
		log.info("SELENIUM: clickLoginButton");
		WebElement loginButton = driver.findElement(By.xpath(prop.getProperty("LOGIN_BUTTON")));
		loginButton.click();
	}
	
	/**
	 * @param user
	 */
	public void inputUser(String user)
	{
		log.info("SELENIUM: inputUser");
		WebElement inputUser = driver.findElement(By.xpath(prop.getProperty("LOGIN_INPUT_USER")));
		log.info(user);
		inputUser.sendKeys(user);
	}
	
	/**
	 * @param pass
	 */
	public void inputPass(String pass)
	{
		log.info("SELENIUM: inputPass");
		WebElement inputPass = driver.findElement(By.xpath(prop.getProperty("LOGIN_INPUT_PASS")));
		log.info(pass);
		inputPass.sendKeys(pass);
	}
	
	/**
	 * Click en el boton de submit
	 */
	public void inputSubmit()
	{
		log.info("SELENIUM: inputSubmit");
		WebElement inputSubmit = driver.findElement(By.xpath(prop.getProperty("LOGIN_INPUT_SUBMIT")));
		inputSubmit.click();
	}
	
	/**
	 * @param url
	 * @return devuelve un boolean que indica si la url es la del login de error y aparece el mensaje de error.
	 * Comprobación de la url y de un mensaje de error en pantalla
	 */
	public boolean isWebPage(String url)
	{
		log.info("SELENIUM: isWebPage");
		boolean result = false;
		WebElement errorMessage;
		
		if(driver.getCurrentUrl().equals(url))
		{
			errorMessage = driver.findElement(By.xpath(prop.getProperty("LOGIN_ERROR")));
			
			if(errorMessage.isDisplayed())
			{
				log.info(url+"\nMessage: "+errorMessage.getText());
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Cierra el navegador
	 */
	public void cerrarNavegador()
	{
		log.info("SELENIUM: cerrarNavegador");
		driver.close();
		driver.quit();
	}
}
