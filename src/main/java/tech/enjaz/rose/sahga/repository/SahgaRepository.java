package tech.enjaz.rose.sahga.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import tech.enjaz.rose.sahga.entity.Sahga;

public interface SahgaRepository extends CrudRepository<Sahga, Long> {
    List<Sahga> findAll();
}
