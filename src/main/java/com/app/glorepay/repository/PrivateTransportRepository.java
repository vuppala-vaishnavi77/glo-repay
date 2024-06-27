package com.app.glorepay.repository;

import com.app.glorepay.entity.PrivateTransport;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into a private transport repository
public interface PrivateTransportRepository extends JpaRepository<PrivateTransport,Long> {
}
