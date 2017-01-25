package ua.timan.invoice.domain;

import lombok.Data;
import ua.timan.invoice.enums.Measure;
import ua.timan.invoice.enums.ProductGroup;

@Data
public class Product {
	
	private int id;
	private String name;
	private ProductGroup group;
	private Measure measure;

}
