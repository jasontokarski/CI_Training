package ci.training;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import ci.training.beans.Customer;
import ci.training.beans.Wallet;
import ci.training.repo.WalletRepoImpl;
import ci.training.service.WalletService;
import ci.training.service.WalletServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalletStepDefinitions {
	
	private Customer customer;
	private WalletService ws;
	
	@Given("^I want to create a new account$")
	public void i_want_to_create_a_new_account() throws Throwable {
		ws = new WalletServiceImpl(new WalletRepoImpl());
		customer = new Customer();
	}

	@When("^I enter name \"(.*?)\", phone number \"(.*?)\", balance \"(.*?)\"$")
	public void i_enter_name_phone_number_balance(String name, String number, String amount) throws Throwable {
		customer = ws.createWallet(name, number, new BigDecimal(amount));
	}

	@Then("^A new customer account with name \"(.*?)\", phone number \"(.*?)\", balance \"(.*?)\" should be created$")
	public void a_new_customer_account_with_name_phone_number_balance_should_be_created(String name, String number, String amount) throws Throwable {
		assertEquals(customer, new Customer(name, number, new Wallet(new BigDecimal(amount))));
	}

}
