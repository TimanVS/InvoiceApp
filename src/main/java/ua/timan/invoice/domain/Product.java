package ua.timan.invoice.domain;

import lombok.Data;
import ua.timan.invoice.domain.enums.Measure;

@Data
public class Product {
	
	private int id;
	private String name;
	private ProductGroup group;
	private Measure measure;

}
