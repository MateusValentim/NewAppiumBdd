package br.com.rsinet.bdd.appium.steps;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import br.com.rsinet.bdd.appium.cucumber.TestContext;
import br.com.rsinet.bdd.appium.screenpagefactory.FormPage;
import br.com.rsinet.bdd.appium.screenpagefactory.GlassPage;
import br.com.rsinet.bdd.appium.screenpagefactory.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BuscaLupa {

	@Quando("^quando clico na lupa$")
	public void quando_clico_na_lupa() throws Throwable {
		homePage.clicandoParaPesquisa();

	}

	@Quando("^digito o produto desejado$")
	public void digito_o_produto_desejado(DataTable dadosProd) throws Throwable {
		for (Map<String, String> dado : dadosProd.asMaps(String.class, String.class))
			homePage.writeGlass(dado.get("produto"));

	}

	@Quando("^clico no produto pesquisado$")
	public void clico_no_produto_pesquisado() throws Throwable {
		glassPage.clickProductSelectedGlass();
	}

	@Quando("^clico em \"([^\"]*)\"$")
	public void clico_em(String arg1) throws Throwable {
		glassPage.addTo();
	}

	@Entao("^entro com meu usuario e senha$")
	public void entro_com_meu_usuario_e_senha(DataTable dadosuser) throws Throwable {
		for (Map<String, String> dadosCadastro : dadosuser.asMaps(String.class, String.class)) {
			formPage.userName(dadosCadastro.get("username"));
			formPage.password(dadosCadastro.get("password"));
		}
	}

	@Quando("^digito o nome do produto desejado$")
	public void digito_o_nome_do_produto_desejado(DataTable dadosProd) throws Throwable {
		for (Map<String, String> dado : dadosProd.asMaps(String.class, String.class))
			glassPage.writeGlass(dado.get("produtoIncorreto"));
	}

	@Entao("^vou receber a mensagem \"([^\"]*)\"$")
	public void vou_receber_a_mensagem(String not) throws Throwable {
		assertTrue(glassPage.messageNothingFound(not));
	}

	private TestContext context;
	private AppiumDriver<MobileElement> driver;
	private HomePage homePage;
	private FormPage formPage;
	private GlassPage glassPage;

	public BuscaLupa(TestContext context) throws MalformedURLException {
		this.context = context;
		homePage = this.context.getPageObjectManager().getHomePage();
		glassPage = this.context.getPageObjectManager().getGlassPage();
		formPage = this.context.getPageObjectManager().getFormPage();
		driver = this.context.getWebDriverManager().takeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
