package com.app.glorepay.repository;

import com.app.glorepay.entity.PublicTransport;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into a public transport repository
public interface PublicTransportRepository extends JpaRepository<PublicTransport,Long>{
}
