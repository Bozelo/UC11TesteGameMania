package teste.gamemania;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	
private WebDriver driver;
	
	@Before
	public void ConfigurarTeste() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\CrohmeDriver\\chromedriver.exe");
		//Objeto do CrohmeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/");
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]")).click();
		
	}
	
	@Test
	public void TestarLogin() {
		
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement campoSenha = driver.findElement(By.id("senha"));
		WebElement botaoEnviar = driver.findElement(By.id("botao-enviar"));
		
		String[] listaEmails = {"Valentina@email.com","Jorge@email.com","Jorge@email.com"};
		String[] listaSenhas = {"senhadaValentina","senhadojorg","senhadojorge"};
		//Estrutura try catch
		try {
			
			for(int contador= 0; contador < 3; contador++) {
				campoEmail.sendKeys(listaEmails[contador]);
				campoSenha.sendKeys(listaSenhas[contador]);
				botaoEnviar.click();
				
				Thread.sleep(3000);
				
				campoEmail.clear();
				campoSenha.clear();
			}
			
			
			/*
			//caso de teste de Email Incorreto
			campoEmail.sendKeys("Valentina@email.com");
			campoSenha.sendKeys("senhadaValentina");
			botaoEnviar.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			//Caso de Teste de senha incorreta para um email cadastrado.
			campoEmail.sendKeys("Jorge@email.com");
			campoSenha.sendKeys("senhadojorg");
			botaoEnviar.click();
			
			Thread.sleep(3000);
			campoEmail.clear();
			campoSenha.clear();
			
			//Caso de teste de usuário correto
			campoEmail.sendKeys("Jorge@email.com");
			campoSenha.sendKeys("senhadojorge");
			botaoEnviar.click();
			*/
			Thread.sleep(5000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	@After
	public void EncerrarTeste() {
		driver.quit();
	}

}
