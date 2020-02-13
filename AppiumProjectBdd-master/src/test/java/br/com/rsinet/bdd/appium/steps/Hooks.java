package br.com.rsinet.bdd.appium.steps;

import br.com.rsinet.bdd.appium.cucumber.TestContext;
import cucumber.api.java.After;

public class Hooks {
	private TestContext contexto;

	public Hooks(TestContext contexto) {
		this.contexto = contexto;
	}

	@After()
	public void finaliza() {
		contexto.getWebDriverManager().closeDriver();
	}

}
