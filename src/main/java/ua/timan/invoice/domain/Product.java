package ua.timan.invoice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private ProductGroup group;
    private Measure measure;

}
