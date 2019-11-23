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
@Table(name = "categories")
public class Category {
	
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El nombre no puede estar vacio.")
	@Size(max = 15,message="El nÃºmero de caracteres del campo nombre supera la cantidad permitida, por favor ingrese 15 caracteres como mÃ¡ximo.")
	@Column(name = "name", unique=true, nullable = false, length = 15)
	private String name;

}
