package ci.training.repo;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import ci.training.beans.Customer;

public class WalletRepoImpl implements WalletRepo {
	
	public List<Customer> customerDatabase = new ArrayList<Customer>();
	
	public boolean save(Customer c) {
		return customerDatabase.add(c);
	}
	
	public Customer find(String phoneNumber) {
//		for(Customer c : customerDatabase) {
//			if(c.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
//				return c;
//			}
//		}
		return null;
	}
}
