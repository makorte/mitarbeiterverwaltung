package com.maxkorte.mitarbeiterverwaltung.repository;

import com.maxkorte.mitarbeiterverwaltung.entity.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;

public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter, Long> {
}