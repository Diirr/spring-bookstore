package com.wildcodeschool.spring.bookstore.entity;

import java.util.*;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transportation {
	
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
	@Temporal(TemporalType.TIMESTAMP)
   	private java.util.Date transportation_end;
        @Temporal(TemporalType.TIMESTAMP)
        private java.util.Date transportation_start;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
        @JoinColumn(name = "car_id", nullable = false)
	@NotNull
        private Car car;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
        @JoinColumn(name = "passenger_id", nullable = false)
	@NotNull
        private Customer customer;
}
