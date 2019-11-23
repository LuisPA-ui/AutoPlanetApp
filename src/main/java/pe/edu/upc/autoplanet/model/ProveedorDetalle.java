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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "proveedorDetalles")
public class ProveedorDetalle {
	
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

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
	
	@NotEmpty(message = "La descripcion no puede estar vacio.")
	@Column(name = "name", unique=true, nullable = false)
	private String name;
	
	
	@DecimalMin("1.00")
	@DecimalMax("5.00")
	@Column(name = "calificacion", nullable = false)
	private Double calificacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;


	
}
