package testProject;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.TestBlog;
import controllers.TestBuscar;
import controllers.TestContacto;
import controllers.TestEquipo;
import controllers.TestLogin;

public class sdosTest {

	
	String search = "";
	String url_search = "";
	
	
	String url_loginError = "";
	String user = "";
	String pass = "";
	
	
	String url_contacto = "";
	String name = "";
	String email = "";
	String message = "";
	
	String url_equipo = "";
	String job = "";
	String file = "";
	String url_trabajaConNosotros = "";
	
	String url_blog = "";
	String url_section_ccma = "";
	String comment = "";
	String url = "";
	String url_blog_error = "";
	
	@Before
	public void setUp() {
	   
		this.search = "PRODUCTOS";   
		this.url_search = "https://sdos.es/?s="+search;
		
		this.user = "test";
		this.pass = "pass";
		this.url_loginError = "https://sdos.es/administration-pg/";
		
		this.url_contacto = "https://sdos.es/contacto/";
		this.name = "Jesus";
		this.email = "testJesus";
		this.message = "Prueba Automatizada";
		
		this.url_equipo = "https://sdos.es/equipo/";
		this.job = "Programador Junior";
		this.file = "D:\\Jesus\\workspace\\PruebaAuto.odt";
		this.url_trabajaConNosotros = "https://sdos.es/contacto/trabaja-con-nosotros/";
		
		this.url_blog = "https://sdos.es/blog/";
		this.url_section_ccma = "https://sdos.es/sdos-nuevo-partner-digital-de-la-ccma/";
		this.comment = "Comentario Automatizado";
		this.url = "www.prueba.com";
		this.url_blog_error = "https://sdos.es/wp-comments-post.php";
	}
	
	@Test
	public void Search() {
		TestBuscar oBuscar = new TestBuscar();
		
		oBuscar.abrirNavegador();
		oBuscar.clickSearchButton();
		oBuscar.inputSearch(this.search);
		Assert.assertTrue(oBuscar.isWebPage(this.url_search));
		
		oBuscar.cerrarNavegador();
	}

	@Test
	public void Login_Error() {
		TestLogin oLogin = new TestLogin();
		
		oLogin.abrirNavegador();
		oLogin.clickLoginButton();
		oLogin.inputUser(this.user);
		oLogin.inputPass(this.pass);
		oLogin.inputSubmit();
		Assert.assertTrue(oLogin.isWebPage(this.url_loginError));
		
		oLogin.cerrarNavegador();
	}
	
	@Test
	public void Contacto_EnviaMensaje_Error() {
		TestContacto oContacto = new TestContacto();
		
		oContacto.abrirNavegador();
		oContacto.clickContactoButton();
		Assert.assertTrue(oContacto.isWebPage(this.url_contacto));
		
		oContacto.inputName(this.name);
		oContacto.inputEmail(this.email);
		oContacto.inputMessage(this.message);
		oContacto.inputSubmit();
		Assert.assertTrue(oContacto.isErrorMessageDisplayed());
		
		oContacto.cerrarNavegador();
	}
	
	@Test
	public void Equipo_mandarCV() {
		TestEquipo oEquipo = new TestEquipo();
		
		oEquipo.abrirNavegador();
		oEquipo.clickEquipoButton();
		Assert.assertTrue(oEquipo.isWebPage(this.url_equipo));
		
		oEquipo.clickEmpleoButton();
		Assert.assertTrue(oEquipo.isWebPage(this.url_trabajaConNosotros));
		
		oEquipo.inputName(this.name);
		oEquipo.inputEmail(this.email);
		oEquipo.inputJob(this.job);
		oEquipo.importFile(this.file);
		oEquipo.inputSubmit();
		Assert.assertTrue(oEquipo.isErrorMessageDisplayed());
		
		oEquipo.cerrarNavegador();
	}
	
	@Test
	public void Blog_section_ccma() {
		TestBlog oBlog = new TestBlog();
		
		oBlog.abrirNavegador();
		oBlog.clickBlogButton();
		Assert.assertTrue(oBlog.isWebPage(this.url_blog));
		
		oBlog.clickSectionButton();
		Assert.assertTrue(oBlog.isWebPage(this.url_section_ccma));
		
		oBlog.inputComment(this.comment);
		oBlog.inputName(this.name);
		oBlog.inputEmail(this.email);		
		oBlog.inputURL(this.url);
		oBlog.inputSubmit();
		Assert.assertTrue(oBlog.isWebPage(this.url_blog_error));
		Assert.assertTrue(oBlog.isErrorMessageDisplayed());
		
		oBlog.cerrarNavegador();
	}
}
