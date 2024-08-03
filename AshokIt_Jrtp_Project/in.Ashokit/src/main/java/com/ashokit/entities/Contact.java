package com.ashokit.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table (name = "All_CONTACT_DTLS")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactId;
	
	private String contactName;
	private Long contactNumber;
	private String activeSwitch;
	private String email_Id;
	
	@CreationTimestamp
	private LocalDate cretedDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	

}
