package com.citizen.person.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The address entity.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String address1;
    private String address2;
    private String postCode;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="city_id", nullable=false, updatable=false)
    private City city;
}
