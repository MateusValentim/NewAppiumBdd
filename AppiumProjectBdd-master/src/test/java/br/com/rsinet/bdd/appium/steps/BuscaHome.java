package br.com.rsinet.bdd.appium.steps;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import br.com.rsinet.bdd.appium.cucumber.TestContext;
import br.com.rsinet.bdd.appium.managers.PageObjectManager;
import br.com.rsinet.bdd.appium.screenpagefactory.FormPage;
import br.com.rsinet.bdd.appium.screenpagefactory.HomePage;
import br.com.rsinet.bdd.appium.screenpagefactory.HomeSearchPage;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BuscaHome {

	PageObjectManager pageObject;

	@Dado("^que estou na tela inicial do aplicativo$")
	public void que_estou_na_tela_inicial_do_aplicativo() throws Throwable {
		pageObject = new PageObjectManager(driver);
		homePage = pageObject.getHomePage();
	}

	@Quando("^clico em um tipo de produto$")
	public void clico_em_um_tipo_de_produto() throws Throwable {

		homePage.clickMicePositivo();

	}

	@Quando("^clico no produto desejado$")
	public void clico_no_produto_desejado() throws Throwable {
		homeSearchPage.clickChoose();
		homeSearchPage.addToCart();
	}

	@Quando("^insiro meu usuario e senha$")
	public void insiro_meu_usuario_e_senha(DataTable dadosusuariologin) throws Throwable {
		for (Map<String, String> dadosCadastro : dadosusuariologin.asMaps(String.class, String.class)) {
			formPage.userName(dadosCadastro.get("username"));
			formPage.password(dadosCadastro.get("password"));
		}
	}

	@Entao("^clico em login$")
	public void clico_em_login() throws Throwable {
		homeSearchPage.loginClickTo();
	}

	@Quando("^clico o produto desejado$")
	public void clico_o_produto_desejado() throws Throwable {
		homePage.clickProductNegative();
	}

	@Entao("^vou visualizar a mensagem \"([^\"]*)\" indicando que nao ha mais unidades disponiveis$")
	public void vou_visualizar_a_mensagem_indicando_que_nao_ha_mais_unidades_disponiveis(String arg1) throws Throwable {
		assertTrue(driver.getPageSource().contains("SOLD OUT"));
	}

	private TestContext context;
	private AppiumDriver<MobileElement> driver;
	private HomePage homePage;
	private FormPage formPage;
	private HomeSearchPage homeSearchPage;

	public BuscaHome(TestContext context) throws MalformedURLException {
		this.context = context;
		homePage = this.context.getPageObjectManager().getHomePage();
		formPage = this.context.getPageObjectManager().getFormPage();
		homeSearchPage = this.context.getPageObjectManager().getHomeSearchPage();
		driver = this.context.getWebDriverManager().takeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
