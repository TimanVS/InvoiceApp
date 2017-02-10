package ua.timan.invoice.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    @ManyToOne
    private Product product;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal sum;

}
