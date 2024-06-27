package com.app.glorepay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PrivateTransport {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*
        task is to add a new column type of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false)
    private String type;
    /*
        task is to add a new column date of type Date.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false)
    private Date date;
    /*
        task is to add a new column miles of type Integer.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false)
    private Integer miles;
    /*
        task is to add a new column amount of type Integer.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false)
    private Integer amount;

    /*
        task is to establish the mapping between Employee and PrivateTransport
        it should be a appropriate mapping as per the diagram
     */
    @ManyToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "employee_id")
    Employee emp2;
}
