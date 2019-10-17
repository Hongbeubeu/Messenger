package project1.com.messenger.dao;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project1.com.messenger.entities.Customer;
import project1.com.messenger.entities.CustomerMapper;

@Repository
@Transactional
public class CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Customer customer) {
		String sql = "INSERT INTO user (name, address, email, password) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getEmail(), customer.getPassword());
	}
	public Customer findByEmail(String email) {
		String sql = "SELECT * FROM user WHERE email = ?";
		try {
			Customer customer =  jdbcTemplate.queryForObject(sql, new CustomerMapper(), email);
			return customer;
		} catch (EmptyResultDataAccessException e) {
			return null;
		  }
	}
}
