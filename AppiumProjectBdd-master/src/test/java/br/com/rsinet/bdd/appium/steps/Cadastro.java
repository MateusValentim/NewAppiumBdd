package br.com.rsinet.bdd.appium.steps;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import br.com.rsinet.bdd.appium.cucumber.TestContext;
import br.com.rsinet.bdd.appium.screenpagefactory.FormPage;
import br.com.rsinet.bdd.appium.screenpagefactory.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Cadastro {

	@Dado("^que estou na tela inicial do aplicativo e clico no botao superior esquerdo$")
	public void que_estou_na_tela_inicial_do_aplicativo_e_clico_no_botao_superior_esquerdo() throws Throwable {
		homePage.initClickPage();
	}

	@Quando("clico no botao de login")
	public void clico_no_botao_de_login() {
		homePage.btnLogin();

	}

	@Quando("^clico no campo 'sign up today' localizado na parte inferior da tela$")
	public void clico_no_campo_sign_up_today_localizado_na_parte_inferior_da_tela() throws Throwable {
		homePage.btnSignUpToday();
	}

	@Quando("^preencho os campos com os meus dados para o cadastro$")
	public void preencho_os_campos_com_os_meus_dados_para_o_cadastro(DataTable dadosusuario) throws Throwable {
		for (Map<String, String> dadosCadastro : dadosusuario.asMaps(String.class, String.class)) {
			formPage.userName(dadosCadastro.get("userName"));
			formPage.email(dadosCadastro.get("email"));
			formPage.password(dadosCadastro.get("password"));
			formPage.confirmPass(dadosCadastro.get("passConfirm"));
			formPage.firstName(dadosCadastro.get("firstName"));
			formPage.lastName(dadosCadastro.get("lastName"));
			formPage.country(dadosCadastro.get("country"));
			formPage.city(dadosCadastro.get("city"));
			formPage.address(dadosCadastro.get("address"));
			formPage.state(dadosCadastro.get("state"));
			formPage.postalCode(dadosCadastro.get("postalCode"));

		}
	}

	@Quando("^clico no botao \"([^\"]*)\" localizado na parte inferior da tela$")
	public void clico_no_botao_localizado_na_parte_inferior_da_tela(String texto) throws Throwable {
		formPage.registerButton();

	}

	@Entao("^vou verificar se o meu nome de usuario esta conforme o registro realizado$")
	public void vou_verificar_se_o_meu_nome_de_usuario_esta_conforme_o_registro_realizado(String uName) {
		homePage.initClickPageConfirm();
		assertTrue(homePage.takeConfirmLog().contains(uName));

	}

	@Entao("^vou receber a mensagem \"([^\"]*)\" e vou permanecer na tela de registro$")
	public void vou_receber_a_mensagem_e_vou_permanecer_na_tela_de_registro() throws Throwable {
		assertTrue(formPage.askCorrectPassword("Password do not match"));
	}

	private TestContext context;
	private AppiumDriver<MobileElement> driver;
	private HomePage homePage;
	private FormPage formPage;

	public Cadastro(TestContext context) throws MalformedURLException {
		this.context = context;
		homePage = this.context.getPageObjectManager().getHomePage();
		formPage = this.context.getPageObjectManager().getFormPage();
		driver = this.context.getWebDriverManager().takeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
