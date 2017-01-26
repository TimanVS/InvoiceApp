package ua.timan.invoice.domain;

import lombok.Data;

@Data
public class PackingItem {

	private int id;
	private int barcode;
	private String name;
	private String measure;
	private long quantity;
	private float price;
	private float sum;

}
