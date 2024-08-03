package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.bindings.ContactForms;
import com.ashokit.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactRest {
	
	@Autowired
	private ContactService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> createContact(@RequestBody ContactForms forms){
		
		System.out.println(forms);
		
		String msg = this.service.saveContact(forms);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<List<ContactForms>>viewAllContact(){
		List<ContactForms> allContacts = this.service.viewContacts();
		return new ResponseEntity<List<ContactForms>>(allContacts,HttpStatus.OK);
	}
	
	@PutMapping("/{contactId}")
	public ResponseEntity<ContactForms>editContact(@PathVariable Integer contactId){
		ContactForms contact = this.service.EditContact(contactId);
		return new ResponseEntity<ContactForms>(contact,HttpStatus.OK);
	}
	
	@DeleteMapping("/{contactId}")
	public ResponseEntity<List<ContactForms>>deleteContact(@PathVariable Integer contactId){
		List<ContactForms> deletedContact = this.service.deleteContact(contactId);
		return new ResponseEntity<List<ContactForms>>(deletedContact,HttpStatus.OK);
	}

}
