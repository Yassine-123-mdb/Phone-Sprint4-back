package com.yassine.phone.entities;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "marque", types = { Phone.class })
public interface PhoneProjection {
public String getMarque();
}
