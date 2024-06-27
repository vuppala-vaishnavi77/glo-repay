package com.app.glorepay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
    task is to add the required annotation to make this class a JPA entity
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*
        task is to add a new column name of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(nullable = false)
    private String name;
    /*
        task is to add a new column email of type String.
        It should not be null.
        It should be unique.
        Use appropriate annotation.
     */
    @Column(nullable = false,unique = true)
    private String email;

    private final Integer maxLimit = 5000;

    /*
        task is to establish the mapping between Employee and PublicTransport
        it should be a appropriate mapping as per the diagram
     */
    @OneToMany(mappedBy = "emp3", cascade = CascadeType.ALL)
    List<PublicTransport> publicTransports;


    /*
        task is to establish the mapping between Employee and PrivateTransport
        it should be a appropriate mapping as per the diagram
     */
    @OneToMany(mappedBy = "emp2", cascade = CascadeType.ALL)
    List<PrivateTransport> privateTransports;

    /*
        task is to establish the mapping between Employee and Food
        it should be a appropriate mapping as per the diagram
     */

    @OneToMany(mappedBy = "emp1", cascade = CascadeType.ALL)
    List<Food> food;
}
