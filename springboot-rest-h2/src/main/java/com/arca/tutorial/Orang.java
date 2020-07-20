package com.arca.tutorial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Orang {
	@Id
	@GeneratedValue
	Long id;
	String nama;
	Integer umur;
}
