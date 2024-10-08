package com.yassine.phone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yassine.phone.dto.PhoneDTO;
import com.yassine.phone.entities.Phone;
import com.yassine.phone.entities.Type;
import com.yassine.phone.repos.PhoneRepository;


@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository smartPhoneRepository;
   
    @Autowired
    ModelMapper modelMapper;


    @Override
    public PhoneDTO convertEntityToDto(Phone phone) {
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    PhoneDTO produitDTO = modelMapper.map(phone, PhoneDTO.class);
     return produitDTO;
     }

    @Override
    public PhoneDTO saveSmartPhone(PhoneDTO smartPhone) {
        return convertEntityToDto(smartPhoneRepository.save(convertDtoToEntity(smartPhone)));
    }

    @Override
    public PhoneDTO updateSmartPhone(PhoneDTO smartPhone) {
        return convertEntityToDto(smartPhoneRepository.save(convertDtoToEntity(smartPhone)));
    }

    @Override
    public void deleteSmartPhone(Phone smartPhone) {
        smartPhoneRepository.delete(smartPhone);
    }

    @Override
    public void deleteSmartPhoneById(Long id) {
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public PhoneDTO getSmartPhone(Long id) {
        return convertEntityToDto(smartPhoneRepository.findById(id).orElse(null));
    }

    @Override
    public List<PhoneDTO> getAllSmartPhones() {
        return smartPhoneRepository.findAll().stream()
        		.map(this::convertEntityToDto)
        		.collect(Collectors.toList());
    }

    @Override
    public List<Phone> findByMarque(String marque) {
        return smartPhoneRepository.findByMarque(marque);
    }

    @Override
    public List<Phone> findByMarquePrix(String marque, Double prix) {
        return smartPhoneRepository.findByMarquePrix(marque, prix);
    }

    @Override
    public List<Phone> findByType(com.yassine.phones.entities.Type type) {
        return smartPhoneRepository.findByType(type);
    }
 
    @Override
    public List<Phone> findByTypeId(Long idt) {
        return smartPhoneRepository.findByType_IdType(idt);
    }

    @Override
    public List<Phone> findByOrderByMarqueAsc() {
        return smartPhoneRepository.findByOrderByMarqueAsc();
    }

    @Override
    public List<Phone> findByPhoneContains(String marque) {
        return smartPhoneRepository.findByMarqueContains(marque);
    }

    @Override
    public List<Phone> trierPhonesNomsPrix() {
        return smartPhoneRepository.trierPhonesNomsPrix();
    }
    
    @Override
    public Phone convertDtoToEntity(PhoneDTO phoneDto) {
    	Phone phone = new Phone();
    	phone = modelMapper.map(phoneDto, Phone.class);
     return phone;
    }

    
  
    
}
