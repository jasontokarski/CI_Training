package ci.training;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ci.training.beans.Customer;
import ci.training.beans.Wallet;
import ci.training.repo.WalletRepo;
import ci.training.repo.WalletRepoImpl;
import ci.training.service.WalletService;
import ci.training.service.WalletServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalletStepDefinitions {
	
	private Customer customer, customerResult;
	private WalletService ws = new WalletServiceImpl(new WalletRepoImpl());
	private WalletRepo repo;
	
	@Before
	public void init(){
		ws = new WalletServiceImpl(repo);
	}
	
	@Given("^I want to create a new account$")
	public void i_want_to_create_a_new_account() throws Throwable {
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
	
	@Given("^I have an account with name \"(.*?)\", phone number \"(.*?)\", balance \"(.*?)\"$")
	public void i_have_an_account_with_name_phone_number_balance(String name, String number, String balance) throws Throwable {
		customer = ws.createWallet(name, number, new BigDecimal(balance));
	}

	@When("^I search the phone number \"(.*?)\"$")
	public void i_search_the_phone_number(String number) throws Throwable {
		customerResult = ws.showBalance(number);
	}

	@Then("^The balance displayed should be \"(.*?)\"$")
	public void the_balance_displayed_should_be(String balance) throws Throwable {
		assertEquals(customerResult, customer);
	}
	
	@When("^I withdraw \"(.*?)\" from an account with phone number \"(.*?)\"$")
	public void i_withdraw_from_an_account_with_phone_number(String amount, String number) throws Throwable {
		customerResult = ws.withdraw(number, new BigDecimal(amount));
	}

	@Then("^The current balance should equal \"(.*?)\"$")
	public void the_current_balance_should_equal(String amount) throws Throwable {
		assertEquals(new BigDecimal(amount), customerResult.getWallet().getBalance());
	}

}
