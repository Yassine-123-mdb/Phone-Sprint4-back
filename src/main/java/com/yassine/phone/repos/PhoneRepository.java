package com.yassine.phone.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.yassine.phone.entities.Phone;
import com.yassine.phone.entities.Type;

@RepositoryRestResource(path = "rest")
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByMarque(String marque);

    List<Phone> findByMarqueContains(String marque); 

    @Query("select p from Phone p where p.marque like %?1 and p.prix > ?2")
    List<Phone> findByMarquePrix(String marque, Double prix);

    @Query("select p from Phone p where p.type = :type")
    List<Phone> findByType(@Param("type") Type type);

    List<Phone> findByType_IdType(Long id);

    List<Phone> findByOrderByMarqueAsc();

    @Query("select p from Phone p order by p.marque ASC, p.prix DESC")
    List<Phone> trierPhonesNomsPrix();
}
