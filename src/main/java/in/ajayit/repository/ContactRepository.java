package in.ajayit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ajayit.binding.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	// select * from CONTACT_DTLS where active_sw=:status
	public List<Contact> findByActiveSw(String status);

}
