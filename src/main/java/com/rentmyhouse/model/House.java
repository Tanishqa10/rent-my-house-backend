package com.rentmyhouse.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "houses")
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "address_1", nullable = false)
	@JsonProperty("address_1")
	private String address1;

	@Column(name = "address_2")
	@JsonProperty("address_2")
	private String address2;

	@Column(name = "post_code", nullable = false, length = 5)
	@JsonProperty("post_code")
	private String postCode;

	@Column(name = "extras", columnDefinition = "TEXT")
	private String extras;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "creator_id")
	private User creator;
	
	@CreationTimestamp
	@Column(nullable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(nullable = false)
	private Date updatedAt;

}
