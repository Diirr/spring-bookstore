package com.wildcodeschool.spring.bookstore.entity;

import javax.persistence.Entity;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
        private List<Transportation> transportations;

	@ManyToMany(mappedBy = "cars", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        private List<Customer> customers = new ArrayList<>();
}
