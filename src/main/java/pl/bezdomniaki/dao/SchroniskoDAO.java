package pl.bezdomniaki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;*/
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;

import pl.bezdomniaki.Pies;
import pl.bezdomniaki.Schronisko;

class SchroniskoDAO {
	private JdbcTemplate jdbcTemplate;
	Schronisko wczytaneSchronisko;
	/*Connection conn;
		public void setCon(Connection con) {
		this.conn = con;
	}*/
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void create(Schronisko schronisko) throws SQLException {
		getJdbcTemplate().update(
				"INSERT INTO Schronisko (nazwa, miejscowosc, telefon, email) VALUES (?, ?, ?, ?)",
				new Object[] { schronisko.getNazwa(), schronisko.getMiejscowosc(), schronisko.getTelefon(), schronisko.getEmail() });
	}

	public void update(Schronisko schronisko) throws SQLException{

		getJdbcTemplate().query("SELECT TOP 1 * FROM Schronisko", new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				wczytaneSchronisko = new Schronisko();
				wczytaneSchronisko.setId(rs.getInt("id"));
				wczytaneSchronisko.setNazwa(rs.getString("nazwa"));
				wczytaneSchronisko.setMiejscowosc(rs.getString("miejscowosc"));
				wczytaneSchronisko.setTelefon(rs.getString("telefon"));
				wczytaneSchronisko.setEmail(rs.getString("email"));
				System.out.println("Schronisko przed zmian¹: " + wczytaneSchronisko);
			}
		});

		getJdbcTemplate().update(
				"UPDATE Schronisko SET nazwa = ?, miejscowosc = ?, telefon = ?, email = ? WHERE id = ?",
				new Object[] { schronisko.getNazwa(), schronisko.getMiejscowosc(), schronisko.getTelefon(), schronisko.getEmail(),
						wczytaneSchronisko.getId() });
		}

	public void delete(Schronisko schronisko) throws SQLException{
	
	}

	public List<Schronisko> listAll() {
		List<Schronisko> listaSchronisk = getJdbcTemplate().query("SELECT * FROM Schronisko", 
				new RowMapper<Schronisko>() {
				public Schronisko mapRow(ResultSet rs, int no) throws SQLException {
						Schronisko schronisko1 = new Schronisko();
						schronisko1.setId(rs.getInt("id"));
						schronisko1.setNazwa(rs.getString("nazwa"));
						schronisko1.setMiejscowosc(rs.getString("miejscowosc"));
						schronisko1.setTelefon(rs.getString("telefon"));
						schronisko1.setEmail(rs.getString("email"));
						System.out.println("Schronisko przed zmian¹: " + schronisko1);
						return schronisko1;
				}

			});
			return listaSchronisk;
	}
	
	public List<Schronisko> findByCity(final String city) throws SQLException {
		/*List<Pies> listaPsow = getJdbcTemplate().query(

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
			System.out.println("Psy w schroniskach w miejscowoœci: " + city);*/
			return null;
	}

}
