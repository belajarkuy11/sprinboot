package com.arca.tutorial;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrangRepository extends JpaRepository<Orang, Long> {

	Optional<Orang> findByNama(String nama);

}
 