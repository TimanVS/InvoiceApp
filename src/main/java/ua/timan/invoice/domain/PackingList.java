package ua.timan.invoice.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PackingList {

	@Id
	private int id;
	private LocalDate issueDate;
	@ManyToOne
	private Provider provider;
	@ManyToOne
	private Storage store;
	@ManyToOne(targetEntity = PackingItem.class)
	private List<PackingItem> items;
	private String comment;

}
