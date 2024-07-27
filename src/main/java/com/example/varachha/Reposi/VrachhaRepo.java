package com.example.varachha.Reposi;

import com.example.varachha.Model.VarachhaBank;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrachhaRepo extends JpaRepository<VarachhaBank,Long> {

}
