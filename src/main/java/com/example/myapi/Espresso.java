package com.example.myapi;

import javax.persistence.*;

@Entity
public class Espresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esspresso_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String hotOrIced;

    @Column
    private String size;

    @Column
    private Boolean decaffein;

    @Column
    private String price;

    @Column
    private Boolean takeOut;
}
