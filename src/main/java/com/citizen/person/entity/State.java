package com.citizen.person.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The state entity.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class State {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, updatable = false)
    private Country country;
}
