package ua.timan.invoice.domain;

import java.time.LocalDate;

import lombok.Data;
import ua.timan.invoice.enums.Storage;

@Data
public class PackingList {

    private String id;
    private LocalDate issueDate;
    private String provider;
    private Storage store;
    
    private int SerialNumber;
    private int barcode;
    private String name;
    private String measure;
    private long quantity;
    private float price;
    private float sum;
    
    
}
