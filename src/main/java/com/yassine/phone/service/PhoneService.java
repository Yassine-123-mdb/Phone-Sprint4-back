package com.yassine.phone.service;

import java.util.List;
import com.yassine.phone.entities.Phone;
import com.yassine.phone.entities.Type;

public interface PhoneService {
    Phone saveSmartPhone(Phone smartPhone);
    Phone updateSmartPhone(Phone smartPhone);
    void deleteSmartPhone(Phone smartPhone);
    void deleteSmartPhoneById(Long id);
    Phone getSmartPhone(Long id);
    
    List<Phone> getAllSmartPhones();
    List<Phone> findByMarque(String marque);
    List<Phone> findByPhoneContains(String marque);
    List<Phone> findByMarquePrix(String marque, Double prix);
    List<Phone> findByType(Type type);
    List<Phone> findByTypeId(Long id);
    List<Phone> findByOrderByMarqueAsc();
    List<Phone> trierPhonesNomsPrix();
}
