package project1.com.messenger.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setFirstName(rs.getString("first_name"));
		customer.setLastName(rs.getString("last_name"));
		customer.setPhoneNumber(rs.getString("phone_number"));
		customer.setAvatar(rs.getString("first_name"));
		customer.setGender(rs.getString("gender"));
		customer.setAddress(rs.getString("address"));
		customer.setEmail(rs.getString("email"));
		customer.setPassword(rs.getString("password"));
		customer.setCreateAt(rs.getInt("create_at"));
		return customer;
	}
}
