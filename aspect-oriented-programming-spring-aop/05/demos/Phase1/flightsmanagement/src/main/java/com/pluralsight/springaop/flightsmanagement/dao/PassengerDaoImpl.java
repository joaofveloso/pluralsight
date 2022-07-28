package com.pluralsight.springaop.flightsmanagement.dao;

import com.pluralsight.springaop.flightsmanagement.domain.Passenger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

	private static Map<Integer, Passenger> passengersMap = new HashMap<>();

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Passenger> rowMapper = (resultSet, rowNum) -> {
		Passenger passenger = new Passenger();
		passenger.setName(resultSet.getString("name"));
		passenger.setCountry(resultSet.getString("country"));
		return passenger;
	};

	public static Map<Integer, Passenger> getPassengersMap() {
		return passengersMap;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	public Passenger getPassenger(int id) {
		if (null != passengersMap.get(id)) {
			return passengersMap.get(id);
		}
		
		Passenger passenger = getById(id);
		return passenger;
	}

	private Passenger getById(int id) {
		String sql = "SELECT * FROM PASSENGERS WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

}
