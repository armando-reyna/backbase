package com.backbase.atm.repository;

import com.backbase.atm.dto.Atm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmRepository extends JpaRepository<Atm, Long> {

    Page<Atm> findByOrderByAddress_CityAscAddress_StreetAsc(Pageable pageable);

    Page<Atm> findByAddress_CityOrderByAddress_CityAscAddress_StreetAsc(Pageable pageable, String city);

}
