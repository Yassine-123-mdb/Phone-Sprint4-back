package com.yassine.phone.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.phone.dto.PhoneDTO;
import com.yassine.phone.entities.Phone;
import com.yassine.phone.service.PhoneService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PhoneRESTController {
	@Autowired
	PhoneService phoneService;

	@RequestMapping(method = RequestMethod.GET)
	public List<PhoneDTO> getAllSmartPhones() {
		return phoneService.getAllSmartPhones();
	}
	@RequestMapping(value="/{id}",method =RequestMethod.GET)
		public PhoneDTO getPhoneById(@PathVariable("id") Long id) {
		return phoneService.getSmartPhone(id);
		}
	@RequestMapping(method=RequestMethod.POST)
	public PhoneDTO createPhone(@RequestBody PhoneDTO phoneDTO) {
		return phoneService.saveSmartPhone(phoneDTO);
	}
	@RequestMapping(method=RequestMethod.PUT)
	public PhoneDTO updatePhone(@RequestBody PhoneDTO phoneDTO) {
		return phoneService.updateSmartPhone(phoneDTO);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deletePhone(@PathVariable("id") Long id) {
		phoneService.deleteSmartPhoneById(id);
	}
	@RequestMapping(value="/phonstype/{type_id_type}", method=RequestMethod.GET)
	public List<Phone> getPhoneByIdType(@PathVariable("type_id_type") Long type_id_type){
	    return phoneService.findByTypeId(type_id_type);
	}
	@RequestMapping(value="/phonsByMarque/{marque}",method = RequestMethod.GET)
	public List<Phone> findByMarqueContains(@PathVariable("marque") String marque) {
	return phoneService.findByPhoneContains(marque);
	}
}

