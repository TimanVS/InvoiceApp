package ua.timan.invoice.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PackingList {

    private String id;
    private LocalDate issueDate;
    
}
