package com.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashokit.bindings.ContactForms;

@Service
public interface ContactService {

	String saveContact(ContactForms contactForms);

	List<ContactForms> viewContacts();

	ContactForms EditContact(Integer contactId);

	//ContactForms getSingleContact(Integer contactId);

	List<ContactForms> deleteContact(Integer contactId);

}
