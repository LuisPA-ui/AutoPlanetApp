package pe.edu.upc.autoplanet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "clients")
public class Client {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El nombre no puede estar vacio.")
	@Column(name = "name", nullable = false, length = 120)
	private String name;
	
	@NotEmpty(message = "El dni no puede estar vacio.")
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@NotEmpty(message = "El telefono no puede estar vacio.")
	@Column(name = "phone", length = 9, nullable = false)
	private String phone;
	
	@NotEmpty(message = "La direccion no puede estar vacio.")
	@Column(name = "address", nullable = false, length = 150)
	private String address;
	
}
