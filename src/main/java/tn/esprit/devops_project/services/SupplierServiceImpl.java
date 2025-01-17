package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.List;

@Service

@AllArgsConstructor
public class SupplierServiceImpl implements ISupplierService {

	SupplierRepository supplierRepository;

	@Override
	public List<Supplier> retrieveAllSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public void deleteSupplier(Long supplierId) {
		supplierRepository.deleteById(supplierId);

	}

	@Override
	public Supplier retrieveSupplier(Long supplierId) {

		return supplierRepository.findById(supplierId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + supplierId));
	}

}