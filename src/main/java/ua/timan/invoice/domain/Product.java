package ua.timan.invoice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.timan.invoice.domain.enums.Measure;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	@Id
	private int id;
	private String name;
	private ProductGroup group;
	private Measure measure;

}
