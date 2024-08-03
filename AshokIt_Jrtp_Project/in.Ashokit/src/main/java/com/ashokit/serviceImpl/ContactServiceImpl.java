package com.ashokit.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.bindings.ContactForms;
import com.ashokit.entities.Contact;
import com.ashokit.repository.ContactRepository;
import com.ashokit.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForms contactForms) {

		// We have received forms binding object as parameters.
		// Repository save(entity) method expecting entity object.
		// So copy the data from binding object to entity object.

		Contact entity = new Contact();
         	
		BeanUtils.copyProperties(contactForms, entity);
		entity.setActiveSwitch("Y");	
		entity = this.contactRepo.save(entity);
		if (entity.getContactId() != null) {
			return "Saved Success..!!";
		}
		return "Failure....!!";
	}

	@Override
	public List<ContactForms> viewContacts() {

		List<ContactForms> dataList = new ArrayList<>();

		List<Contact> findAll = contactRepo.findAll();

		for (Contact entity : findAll) {
			ContactForms form = new ContactForms();

			BeanUtils.copyProperties(entity, form);
			dataList.add(form);

		}

		return dataList;
	}

	@Override
	public ContactForms EditContact(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			Contact entity = findById.get();
			
			
			ContactForms form = new ContactForms();
			BeanUtils.copyProperties(entity, form);
			
			return form;
		}

		return null;
	}

	@Override
	public List<ContactForms> deleteContact(Integer contactId) {

		this.contactRepo.deleteById(contactId);

		List<ContactForms> dataList = new ArrayList<>();

		List<Contact> findAll = contactRepo.findAll();

		for (Contact entity : findAll) {
			ContactForms form = new ContactForms();

			BeanUtils.copyProperties(entity, form);
			dataList.add(form);

		}

		return dataList;
	}

}
