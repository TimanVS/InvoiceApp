package ua.timan.invoice.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PackingList {

	private String id;
	private LocalDate issueDate;
	private Provider provider;
	private Storage store;
	private List<PackingItem> items;
	private String comment;

}
