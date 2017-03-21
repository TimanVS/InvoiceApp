package ua.timan.invoice.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.timan.invoice.converters.LocalDateAttributeConverter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Proxy(lazy = false)
public class PackingList implements IdAware {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate issueDate;
	@ManyToOne
	private Provider provider;
	@ManyToOne
	private Storage store;
	@OneToMany
	@JoinColumn(name = "PACKINGLIST_ID")
	private List<PackingItem> items;
	private String comment;

}
