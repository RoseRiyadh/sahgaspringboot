package tech.enjaz.rose.sahga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.enjaz.rose.sahga.entity.Sahga;

@Repository
public interface SahgaRepository extends JpaRepository<Sahga, Long> {

}
