package controllers;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * @author Jesus
 *
 */
public class TestBuscar {

	static Logger log = Logger.getLogger(TestBuscar.class);
	
	private WebDriver driver = null;
	private Properties prop = new Properties();
	
	/**
	 * Constructor
	 */
	public TestBuscar()
	{
		log.info("********************TestBuscar*******************");
		try {
			prop.load(new FileReader("src/test/resources/EnumXpath.properties"));
		} catch (Exception e) {
			log.info(e.getMessage()); 
		}
		System.setProperty("webdriver.gecko.driver","D:\\Jesus\\workspace\\DRIVERS\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	/**
	 * Abre el navegador
	 */
	public void abrirNavegador()
	{
		log.info("SELENIUM: abrirNavegador");
		driver.get("https://sdos.es/");			
	}
	
	/**
	 * Click en el boton de buscar
	 */
	public void clickSearchButton()
	{
		log.info("SELENIUM: clickSearchButton");
		WebElement searchButton = driver.findElement(By.xpath(prop.getProperty("SEARCH_BUTTON")));
		searchButton.click();
	}
	
	/**
	 * @param search
	 */
	public void inputSearch(String search)
	{
		log.info("SELENIUM: inputSearch");
		WebElement searchInput = driver.findElement(By.xpath(prop.getProperty("SEARCH_INPUT")));
		log.info(search);
		searchInput.sendKeys(search);
		searchInput.sendKeys(Keys.ENTER);
	}
	
	/**
	 * @param url
	 * @return Comprueba que la url es correcta
	 */
	public boolean isWebPage(String url)
	{
		log.info("SELENIUM: isWebPage");
		boolean result = false;
		if(driver.getCurrentUrl().equals(url))
		{
			log.info(url);
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
