package com.yassine.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.phone.entities.Phone;
import com.yassine.phone.entities.Type;
import com.yassine.phone.repos.PhoneRepository;
import com.yassine.phone.repos.ImageRepository;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository smartPhoneRepository;
    
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Phone saveSmartPhone(Phone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public Phone updateSmartPhone(Phone smartPhone) {
       // Long oldProdImageId = this.getSmartPhone(smartPhone.getId()).getImages().getIdImage();
        //Long newProdImageId = smartPhone.getImages().getIdImage();
        Phone updatedPhone = smartPhoneRepository.save(smartPhone);
        
        /*if (!oldProdImageId.equals(newProdImageId)) {
            imageRepository.deleteById(oldProdImageId);
        }*/
        return updatedPhone;
    }

    @Override
    public void deleteSmartPhone(Phone smartPhone) {
        smartPhoneRepository.delete(smartPhone);
    }

    @Override
    public void deleteSmartPhoneById(Long id) {
        Phone phone = getSmartPhone(id);
        
        /*Delete the image before deleting the phone
        if (phone.getImages() != null) {
            imageRepository.deleteById(phone.getImages().getIdImage());
        }*/
        
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public Phone getSmartPhone(Long id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Phone> getAllSmartPhones() {
        return smartPhoneRepository.findAll();
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
    public List<Phone> findByType(Type type) {
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
}
