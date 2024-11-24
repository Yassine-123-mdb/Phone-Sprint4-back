package com.yassine.phone.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.phone.entities.Phone;
import com.yassine.phone.service.PhoneService;
import org.springframework.security.core.Authentication;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class PhoneRESTController {

    @Autowired
    PhoneService phoneService;

    @GetMapping("/auth")
    Authentication getAuth(Authentication auth)
    {
    return auth;
    }

    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Phone> getAllSmartPhones() {
        return phoneService.getAllSmartPhones();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Phone getPhoneById(@PathVariable("id") Long id) {
        return phoneService.getSmartPhone(id);
    }

    @RequestMapping(path = "/addphon", method = RequestMethod.POST)
    public Phone createPhone(@RequestBody Phone phone) {
        return phoneService.saveSmartPhone(phone);
    }

    @RequestMapping(path = "/updatephon", method = RequestMethod.PUT)
    public Phone updatePhone(@RequestBody Phone phone) {
        return phoneService.updateSmartPhone(phone);
    }

    @RequestMapping(value = "/delphon/{id}", method = RequestMethod.DELETE)
    public void deletePhone(@PathVariable("id") Long id) {
        phoneService.deleteSmartPhoneById(id);
    }

    @RequestMapping(value = "/phonstype/{type_id_type}", method = RequestMethod.GET)
    public List<Phone> getPhoneByIdType(@PathVariable("type_id_type") Long type_id_type) {
        return phoneService.findByTypeId(type_id_type);
    }

    @RequestMapping(value = "/phonsByMarque/{marque}", method = RequestMethod.GET)
    public List<Phone> findByMarqueContains(@PathVariable("marque") String marque) {
        return phoneService.findByPhoneContains(marque);
    }
}
