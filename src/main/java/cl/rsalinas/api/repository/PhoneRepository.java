package cl.rsalinas.api.repository;

import cl.rsalinas.api.persistence.entities.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {
}
