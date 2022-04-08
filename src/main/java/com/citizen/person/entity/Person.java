package com.citizen.person.entity;

import com.citizen.person.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

/**
 * The person entity.
 */
@Entity
@Data
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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="person_address")
    private List<Address> address;

}
