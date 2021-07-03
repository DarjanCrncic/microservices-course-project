package com.darjan.microservices.currencyexchangeservice.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "from_id", "to_id" }) })
public class CurrencyRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long fromId;
	
	private Long toId;
	
	private BigDecimal conversionMultiple;

}
