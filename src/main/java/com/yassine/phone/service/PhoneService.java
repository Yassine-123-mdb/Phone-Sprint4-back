package com.yassine.phone.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.yassine.phone.dto.PhoneDTO;
import com.yassine.phone.entities.Phone;
import com.yassine.phones.entities.Type;

public interface PhoneService {
	PhoneDTO saveSmartPhone(PhoneDTO smartPhone);
	PhoneDTO updateSmartPhone(PhoneDTO smartPhone);
    void deleteSmartPhone(Phone smartPhone);
    void deleteSmartPhoneById(Long id);
    PhoneDTO getSmartPhone(Long id);
    
    List<PhoneDTO> getAllSmartPhones();
    List<Phone> findByMarque(String marque);
    List<Phone> findByPhoneContains(String marque);
    List<Phone> findByMarquePrix(String marque, Double prix);
    List<Phone> findByType(Type type);
    List<Phone> findByTypeId(Long id);
    List<Phone> findByOrderByMarqueAsc();
    List<Phone> trierPhonesNomsPrix();
    PhoneDTO convertEntityToDto (Phone phone);
	Phone convertDtoToEntity(PhoneDTO phoneDto);
	

}
