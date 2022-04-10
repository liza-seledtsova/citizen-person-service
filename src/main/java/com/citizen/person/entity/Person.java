package com.citizen.person.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The person entity.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String surname;
    @Column(columnDefinition = "varchar(1)")
    private String gender;
    private Date dateOfBirth;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name="person_address")
    private List<Address> address;


}
