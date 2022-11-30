package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.JoinColumn;
import com.masai.dto.AddressDto;
import com.masai.dto.ProductDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_order",joinColumns = @JoinColumn(name="order_id",referencedColumnName = "orderId"))
	private Customer customer;
	
	@Embedded
	private AddressDto orderAddress;
	
	@ElementCollection
	@CollectionTable(name = "order_productlist", joinColumns = @JoinColumn(name="order_id",referencedColumnName = "orderId"))
	private List<ProductDto> productList = new ArrayList<>();

	public Orders(LocalDate orderDate, String orderStatus, Customer customer, AddressDto orderAddress,
			List<ProductDto> productList) {
		super();
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.orderAddress = orderAddress;
		this.productList = productList;
	}
	
	
	
	
	
	
}


