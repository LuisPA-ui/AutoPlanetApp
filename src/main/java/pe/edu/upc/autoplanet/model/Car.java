package pe.edu.upc.autoplanet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cars")
public class Car {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "La placa no puede estar vacio.")
	@Column(name = "placa", length = 20, nullable = false)
	private String placa;
	
	@NotEmpty(message = "El color no puede estar vacio.")
	@Column(name = "color", length = 50, nullable = false)
	private String color;
	
	@NotEmpty(message = "La marca no puede estar vacio.")
	@Column(name = "brand", nullable = false)
	private String brand;
	
	@NotEmpty(message = "El modelo no puede estar vacio.")
	@Column(name = "model", length = 120, nullable = false)
	private String model;
	
	@NotEmpty(message = "El anio no puede estar vacio.")
	@Column(name = "year", length = 20, nullable = false)
	private String year;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

}
