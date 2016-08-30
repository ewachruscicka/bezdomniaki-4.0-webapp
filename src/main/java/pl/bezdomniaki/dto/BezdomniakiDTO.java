package pl.bezdomniaki.dto;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.bezdomniaki.Pies;
import pl.bezdomniaki.dao.PiesDAO;

public class BezdomniakiDTO {

	static ApplicationContext context;
	public Pies[] tablicaPsow;

	public Pies[] getPsy(String miejscowosc) throws SQLException {
		context = new ClassPathXmlApplicationContext("/bezdomniaki.xml"); 
		PiesDAO piesDAO = (PiesDAO)context.getBean("piesDAO");
		List<Pies> listaPsow = piesDAO.findByCity(miejscowosc);
		tablicaPsow = listaPsow.toArray(new Pies[0]);
		return tablicaPsow;
		}
}
