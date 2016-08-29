package pl.bezdomniaki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;

import org.junit.internal.runners.model.EachTestNotifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import pl.bezdomniaki.Pies;

public class PiesDAO {

	private JdbcTemplate jdbcTemplate;
	Pies wczytanyPies;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(Pies pies) throws SQLException {
		getJdbcTemplate().update(
				"INSERT INTO Pies (imie, data_przyjecia, id_schroniska, nr_chipa) VALUES (?, ?, ?, ? )",
				new Object[] { pies.getImie(), pies.getDataPrzyjecia(), pies.getIdSchroniska(), pies.getNrChipa() });
	}

	public void update(Pies pies) throws SQLException {
		getJdbcTemplate().update(
				"UPDATE Pies SET imie = ?, data_przyjecia = ?, id_schroniska = ?, nr_chipa = ? WHERE id = ?",
				new Object[] { pies.getImie(), pies.getDataPrzyjecia(), pies.getIdSchroniska(), pies.getNrChipa(),
						pies.getId() });
	}

	public void delete(Pies pies) throws SQLException {

	}

	public List<Pies> listAll() {
		List<Pies> listaPsow = getJdbcTemplate().query("SELECT * FROM Pies", 
			new RowMapper<Pies>() {
			public Pies mapRow(ResultSet rs, int no) throws SQLException {
					Pies pies1 = new Pies();
					pies1.setId(rs.getInt("id"));
					pies1.setImie(rs.getString("imie"));
					pies1.setDataPrzyjecia(rs.getDate("data_przyjecia"));
					pies1.setIdSchroniska(rs.getInt("id_schroniska"));
					pies1.setNrChipa(rs.getString("nr_chipa"));
					return pies1;
			}

		});
		return listaPsow;
	}
	
	public List<Pies> findByCity(final String city) throws SQLException {
		List<Pies> listaPsow = getJdbcTemplate().query(

				 new PreparedStatementCreator() {
		             public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		                 PreparedStatement ps = connection.prepareStatement(
		                		 "SELECT p.imie, p.data_przyjecia, p.nr_chipa, p.id, p.id_schroniska, s.nazwa, s.miejscowosc"
		                					+ " FROM Pies as p JOIN Schronisko AS s ON s.id = p.id_schroniska"
		                					+ " WHERE s.miejscowosc = ?");
		                 ps.setString(1, city);
		                 return ps;
		             }
				 },
				
				new RowMapper<Pies>() {
				public Pies mapRow(ResultSet rs, int no) throws SQLException {
						Pies pies1 = new Pies();
						pies1.setId(rs.getInt("id"));
						pies1.setImie(rs.getString("imie"));
						pies1.setDataPrzyjecia(rs.getDate("data_przyjecia"));
						pies1.setIdSchroniska(rs.getInt("id_schroniska"));
						pies1.setNrChipa(rs.getString("nr_chipa"));
						return pies1;
				}
			});
			System.out.println("Psy w schronisku w miejscowości: " + city);
			return listaPsow;
	}

}
