package com.citizen.person.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The address entity.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
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
    @ManyToOne
    @JoinColumn(name="city_id" ,nullable=false, updatable=false)
    private City city;
}
