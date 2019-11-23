package pe.edu.upc.autoplanet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients" , uniqueConstraints = { @UniqueConstraint(columnNames = { "dni" }) })
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
	@Size(max = 15,message="El nÃºmero de caracteres del campo nombre supera la cantidad permitida, por favor ingrese 15 caracteres como mÃ¡ximo.")
	@Column(name = "name", nullable = false, length = 15)
	private String name;
	
	@NotEmpty(message = "El dni no puede estar vacio.")
	@Size(min = 8, max = 8,message="El campo DNI debe tener 8 caracteres.")
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@NotEmpty(message = "El telefono no puede estar vacio.")
	@Size(min = 9, max = 9, message="El campo celular debe tener 9 caracteres")
	@Column(name = "phone", length = 9, nullable = false)
	private String phone;
	
	@NotEmpty(message = "La direccion no puede estar vacio.")
	@Size(max = 15,message="El nÃºmero de caracteres del campo direccion supera la cantidad permitida, por favor ingrese 15 caracteres como mÃ¡ximo.")
	@Column(name = "address", nullable = false, length = 15)
	private String address;
	
	
	
}
