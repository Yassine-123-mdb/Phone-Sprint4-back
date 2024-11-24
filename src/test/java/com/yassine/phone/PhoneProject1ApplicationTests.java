package com.yassine.phone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.yassine.phone.entities.Phone;
import com.yassine.phone.repos.PhoneRepository;
import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.entities.Type;

@SpringBootTest
class PhoneProject1ApplicationTests {

	@Autowired
	private PhoneRepository phoneRepository;

	@Test
	public void testCreateProduit() {
		Phone phon = new Phone("Bleu", new Date(), "apple", 2200.500, 8, 32);
		phoneRepository.save(phon);
	}

	@Test
	public void testFindProduit() {
		Phone p = phoneRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Phone p = phoneRepository.findById(1L).get();
		p.setPrix(1000.0);
		phoneRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {
		phoneRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Phone> phons = phoneRepository.findAll();
		for (Phone p : phons) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomPhone() {
		List<Phone> phons = phoneRepository.findByMarque("apple");
		for (Phone p : phons) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomPhoneContains() {
		List<Phone> prods = phoneRepository.findByMarqueContains("iphone");
		for (Phone p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Phone> prods = phoneRepository.findByMarquePrix("apple", 2200.500);
		for (Phone p : prods) {
			System.out.println(p);
		}
	}
	/*@Test
	public void testFindByType() {
		Type type = new Type();
		type.setIdType(1L);
		List<Phone> phone = phoneRepository.findByType(type);
		for (Phone p : phone) {
			System.out.println(p);
		}
	}*/
	@Test
	public void findByTypeId() {
		List<Phone> phone = phoneRepository.findByType_IdType(1L);
		for (Phone p : phone) {
			System.out.println(p);
		}
	}
	@Test
	public void testFindByOrderByMarqueAsc() {
		List<Phone> phone = phoneRepository.findByOrderByMarqueAsc();
		for (Phone p : phone) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierPhonesNomsPrix() {
		List<Phone> phone = phoneRepository.trierPhonesNomsPrix();
		for (Phone p : phone) {
			System.out.println(p);
		}
	}
}
