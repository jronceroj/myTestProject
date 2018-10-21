package controllers;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestContacto {

	static Logger log = Logger.getLogger(TestContacto.class);
	
	private WebDriver driver = null;
	private Properties prop = new Properties();
	
	/**
	 * Constructor
	 */
	public TestContacto()
	{
		log.info("********************TestContacto*******************");
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
	 * Click en el boton de contacto
	 */
	public void clickContactoButton()
	{
		log.info("SELENIUM: clickContactoButton");
		WebElement loginButton = driver.findElement(By.xpath(prop.getProperty("CONTACTO_BUTTON")));
		loginButton.click();
	}
	
	
	/**
	 * @param name
	 */
	public void inputName(String name)
	{
		log.info("SELENIUM: inputName");
		WebElement inputUser = driver.findElement(By.xpath(prop.getProperty("CONTACTO_INPUT_NOMBRE")));
		log.info(name);
		inputUser.sendKeys(name);
	}
	
	/**
	 * @param email
	 */
	public void inputEmail(String email)
	{
		log.info("SELENIUM: inputEmail");
		WebElement inputPass = driver.findElement(By.xpath(prop.getProperty("CONTACTO_INPUT_EMAIL")));
		log.info(email);
		inputPass.sendKeys(email);
	}
	
	/**
	 * @param message
	 */
	public void inputMessage(String message)
	{
		log.info("SELENIUM: inputMessage");
		WebElement inputPass = driver.findElement(By.xpath(prop.getProperty("CONTACTO_TEXTAREA")));
		log.info(message);
		inputPass.sendKeys(message);
	}
	
	/**
	 * Click en el boton de submit
	 */
	public void inputSubmit()
	{
		log.info("SELENIUM: inputSubmit");
		WebElement inputSubmit = driver.findElement(By.xpath(prop.getProperty("CONTACTO_BUTTON_ENVIAR")));
		inputSubmit.click();
	}
	
	/**
	 * @param url
	 * @return Devuelve un booelan que comprueba que la url es correcta
	 */
	public boolean isWebPage(String url)
	{
		log.info("SELENIUM: isWebPage");
		boolean result = false;
		
		if(driver.getCurrentUrl().equals(url))
		{
			result = true;
			log.info(url);
		}
		return result;
	}
	
	/**
	 * @return Devuelve un boolean que comprueba si aparece el mensaje de error
	 */
	public boolean isErrorMessageDisplayed()
	{
		log.info("SELENIUM: isErrorMessageDisplayed");
		boolean result = false;
		WebElement errorMessage;
		
		try
		{
			Thread.sleep(5000);
		}
		catch (Exception e)
		{
			Thread.currentThread().interrupt();
		}
		errorMessage = driver.findElement(By.xpath(prop.getProperty("CONTACTO_MESSAGE_ERROR")));
		if(errorMessage.isDisplayed())
		{
			result = true;
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
