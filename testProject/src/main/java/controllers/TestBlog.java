package controllers;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBlog {

	
	static Logger log = Logger.getLogger(TestBlog.class);
	
	private WebDriver driver = null;
	private Properties prop = new Properties();
	
	/**
	 * Constructor
	 */
	public TestBlog()
	{
		log.info("********************TestBlog*******************");
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
	 * Click en el boton de blog
	 */
	public void clickBlogButton()
	{
		log.info("SELENIUM: clickEquipoButton");
		WebElement loginButton = driver.findElement(By.xpath(prop.getProperty("BLOG_BUTTON")));
		loginButton.click();
	}
	
	/**
	 * Click en una seccion
	 */
	public void clickSectionButton()
	{
		log.info("SELENIUM: clickEmpleoButton");
		WebElement loginButton = driver.findElement(By.xpath(prop.getProperty("BLOG_SECTION")));
		loginButton.click();
	}
	
	/**
	 * @param comment
	 */
	public void inputComment(String comment)
	{
		log.info("SELENIUM: inputComment");
		WebElement inputPass = driver.findElement(By.xpath(prop.getProperty("BLOG_TEXTAREA_COMENTARIO")));
		log.info(comment);
		inputPass.sendKeys(comment);
	}
	
	/**
	 * @param name
	 */
	public void inputName(String name)
	{
		log.info("SELENIUM: inputName");
		WebElement inputUser = driver.findElement(By.xpath(prop.getProperty("BLOG_INPUT_NAME")));
		log.info(name);
		inputUser.sendKeys(name);
	}
	
	/**
	 * @param email
	 */
	public void inputEmail(String email)
	{
		log.info("SELENIUM: inputEmail");
		WebElement inputPass = driver.findElement(By.xpath(prop.getProperty("BLOG_INPUT_EMAIL")));
		log.info(email);
		inputPass.sendKeys(email);
	}
	
	
	/**
	 * @param url
	 */
	public void inputURL(String url)
	{
		log.info("SELENIUM: inputURL");
		WebElement inputPass = driver.findElement(By.xpath(prop.getProperty("BLOG_INPUT_URL")));
		log.info(url);
		inputPass.sendKeys(url);
	}
	
	/**
	 * Click en el boton de submit
	 */
	public void inputSubmit()
	{
		log.info("SELENIUM: inputSubmit");
		WebElement inputSubmit = driver.findElement(By.xpath(prop.getProperty("BLOG_BUTTON_SUBMIT")));
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
		errorMessage = driver.findElement(By.xpath(prop.getProperty("BLOG_ERROR")));
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
