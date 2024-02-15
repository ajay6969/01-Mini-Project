package in.ajayit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ajayit.binding.Contact;
import in.ajayit.service.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "This Contact API")
public class ContactRestController {

	@Autowired
	private ContactService service;

	@ApiOperation("This operation is used to store new contact")
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact contact) {
		String status = service.saveContact(contact);
		return status;
	}

	@ApiOperation("This operation is used to get all contacts")
	@GetMapping("/contacts")
	public List<Contact> getAllContacts() {
		return service.getAllContacts();
	}

	@ApiOperation("This operation is used to get contact using id")
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
	}

	@ApiOperation("This operation is used to update existing contact")
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}

	@ApiOperation("This operation is used to delete contact using id")
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		return service.deleteContactById(contactId);
	}
}
