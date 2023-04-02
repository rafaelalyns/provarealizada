package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.ContasPage;
import PageObjects.GenericPage;
import Validations.ContasValidation;

public class ContasTask {
	private WebDriver driver;
    private ContasPage contasPage;
    private ContasValidation contasValidation;
   private GenericPage genericPage;
    
    public ContasTask(WebDriver driver) {
        this.driver = driver;
        ContasPage contasPage = new ContasPage(this.driver);
        ContasValidation contasValidation = new ContasValidation(this.driver);
        GenericPage genericPage = new GenericPage(this.driver);
    }
    public void criarConta() {
        contasValidation.validationContasPage();
        contasPage.getNomeConta().sendKeys("Despesa");
        contasPage.getBotaoSalvar().click();
       genericPage.getCriarMovimentacao().click();
    }
}
