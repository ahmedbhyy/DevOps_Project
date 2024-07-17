package tn.esprit.devops_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devops_project.entities.Supplier;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
