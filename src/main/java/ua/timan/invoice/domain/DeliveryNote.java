package ua.timan.invoice.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class DeliveryNote {

	private String id;
	private LocalDate issueDate;
	private Provider provider;
	private Storage store;
	private List<PackingList> packlist;
	private String comment;

}
