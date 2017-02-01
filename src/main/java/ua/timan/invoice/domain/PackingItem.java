package ua.timan.invoice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PackingItem {

	@Id
	private int id;
	private int barcode;
	private String name;
	private String measure;
	private long quantity;
	private float price;
	private float sum;

}
