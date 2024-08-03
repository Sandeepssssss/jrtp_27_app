package com.ashokit.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForms {

	private Integer contactId;
	private String contactName;
	private Long contactNumber;
	private String email_Id;
	private String activeSwitch;
	private LocalDate cretedDate;
	private LocalDate updatedDate;

}
