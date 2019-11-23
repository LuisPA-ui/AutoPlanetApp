package pe.edu.upc.autoplanet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "suppliers")
public class Supplier {
	
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El nombre no puede estar vacio.")
	@Size(max = 15,message="El nÃºmero de caracteres del campo nombre supera la cantidad permitida, por favor ingrese 15 caracteres como mÃ¡ximo.")
	@Column(name = "name", length = 15, unique=true, nullable = false)
	private String name;
	
	@NotEmpty(message = "La direccion no puede estar vacio.")
	@Size(max = 15,message="El nÃºmero de caracteres del campo direccion supera la cantidad permitida, por favor ingrese 15 caracteres como mÃ¡ximo.")
	@Column(name = "address", length = 15, nullable = false)
	private String address;

	@NotEmpty(message = "El ruc no puede estar vacio.")
	@Size(min = 11, max = 11,message="El campo RUC debe tener 11 caracteres.")
	@Column(name = "ruc", unique=true, length = 11, nullable = false)
	private String ruc;
	
	@NotEmpty(message = "El telefono no puede estar vacio.")
	@Size(min = 9, max = 9, message="El campo celular debe tener 9 caracteres")
	@Column(name = "phone", length = 9, nullable = false)
	private String phone;

	@NotEmpty(message = "El pais no puede estar vacio.")
	@Size(max = 15,message="El nÃºmero de caracteres del campo PAIS supera la cantidad permitida, por favor ingrese 10 caracteres como mÃ¡ximo.")
	@Column(name = "country", length = 10, nullable = false)
	private String country;
	
	@NotEmpty(message = "El distrito no puede estar vacio.")
	@Size(max = 15,message="El nÃºmero de caracteres del campo DISTRITO supera la cantidad permitida, por favor ingrese 15 caracteres como mÃ¡ximo.")
	@Column(name = "district", length = 15, nullable = false)
	private String district;

}
