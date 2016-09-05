package pl.bezdomniaki;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pies {
	private int id;
	private String imie;
	private Date dataPrzyjecia;
	private int idSchroniska;
	private String nrChipa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public Date getDataPrzyjecia() {
		return dataPrzyjecia;
	}
	public void setDataPrzyjecia(Date fdf) {
		this.dataPrzyjecia = fdf;
	}
	public void setDataPrzyjecia(String fdf) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		Date date;
		try {
			date = format.parse(fdf);
			System.out.println(date); 
			this.dataPrzyjecia = date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public int getIdSchroniska() {
		return idSchroniska;
	}
	public void setIdSchroniska(int idSchroniska) {
		this.idSchroniska = idSchroniska;
	}
	public String getNrChipa() {
		return nrChipa;
	}
	public void setNrChipa(String nrChripa) {
		this.nrChipa = nrChripa;
	}
	
	@Override
	public String toString() {
		return "Pies [id=" + id + ", imie=" + imie + ", dataPrzyjecia=" + dataPrzyjecia + ", idSchroniska="
				+ idSchroniska + ", nrChipa=" + nrChipa + "]";
	}
	
}
