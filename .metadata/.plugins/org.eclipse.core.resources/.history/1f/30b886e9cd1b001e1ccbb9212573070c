package in.onesoft.car;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="car")
public class CarEntity {

	@Id     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String brand;
	@Column
	private String model;
	@Column
	private int enginecc;
	@Column
	private Date date;
	
	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getEnginecc() {
		return enginecc;
	}
	public void setEnginecc(int enginecc) {
		this.enginecc = enginecc;
	}
	public Date getDate() {
		return date;	
	}
	public void setDate(Date date) {
		this.date=date;
	}
	@Override
	public String toString() {
		return "CarEntity [id=" + id + ", brand=" + brand + ", model=" + model + ", enginecc=" + enginecc + ", date="
				+ date + "]";
	}
}
