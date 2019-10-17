package project1.com.messenger.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project1.com.messenger.dao.CustomerDAO;
import project1.com.messenger.entities.Customer;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	public Customer findByEmail(String email) {
		return customerDAO.findByEmail(email);
	}
	
	public Customer login(Customer customer){
		Customer tcustomer = findByEmail(customer.getEmail());
		if(tcustomer == null ) 
			return null;
		else
			try {
				if(MD5(customer.getPassword()).equals(tcustomer.getPassword()))
						return tcustomer;
					 else
						return null;
			} catch (NoSuchAlgorithmException e) {
				return null;
			}
	}
	
	public Customer register(Customer customer){
		if(checkEmail(customer.getEmail()) == false)
			return null;
		else {
			Customer tcustomer = findByEmail(customer.getEmail());
			if(tcustomer == null) {
				if(customer.getPassword().equals(customer.getConfirmPassword()))
					try {
						customer.setPassword(MD5(customer.getPassword()));
						customerDAO.save(customer);
						return customer;
					} catch (NoSuchAlgorithmException e) {
						return null;
					}
				else
					return null;	
			} else {
				return null;
			}
		}
	}
	
	private boolean checkEmail(String email) {
        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern regex = Pattern.compile(emailPattern);
        Matcher matcher = regex.matcher(email);
        if (matcher.find()) {
            return true;
        } else {
           return false; 
        }
    }
	
	 private String MD5(String text) throws NoSuchAlgorithmException {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] messageDigest = md.digest(text.getBytes());
	        return convertByteToHex(messageDigest);
	 }
	 private String convertByteToHex(byte[] data) {
		  BigInteger number = new BigInteger(1, data);
		  String hashtext = number.toString(16);
		  // Now we need to zero pad it if you actually want the full 32 chars.
		  while (hashtext.length() < 32) {
		    hashtext = "0" + hashtext;
		  }
		  return hashtext;
	}
}
