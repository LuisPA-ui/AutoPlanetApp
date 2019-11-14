package pe.edu.upc.autoplanet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ReserveManagement")
public class ReserveManagement {
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(Date expiredAt) {
		this.expiredAt = expiredAt;
	}

	public Date getEnteredAt() {
		return enteredAt;
	}

	public void setEnteredAt(Date enteredAt) {
		this.enteredAt = enteredAt;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Una fecha de caducidad debe ser especificado.")
	@Future(message = "La fecha de vencimiento de la cita debe ser en el futuro.")
	@Column(name = "expired_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiredAt;
	
	@Column(name = "entered_at")
	private Date enteredAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cita_id",nullable = false)
	private Cita cita;
	
}
