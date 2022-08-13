package com.cine.socios.repository;

import com.cine.socios.model.Socio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocioRepository extends MongoRepository<Socio, String> {
}
