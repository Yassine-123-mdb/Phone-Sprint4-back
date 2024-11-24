package com.yassine.phone.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.phone.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}
