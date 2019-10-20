package project1.com.messenger.dao;

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
		String sql = "INSERT INTO user "
					+ "(first_name, last_name, address, phone_number, avatar, gender, email, password, create_at)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,customer.getFirstName(),
								customer.getLastName(),
								customer.getAddress(),
								customer.getPhoneNumber(),
								customer.getAvatar(),
								customer.getGender(), 
								customer.getEmail(), 
								customer.getPassword(),
								customer.getCreateAt());
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
