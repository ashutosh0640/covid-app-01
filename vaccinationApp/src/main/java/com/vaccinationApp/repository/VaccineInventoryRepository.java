package com.vaccinationApp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaccinationApp.model.VaccineInventory;

@Repository
public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory, Integer> {
	
	public VaccineInventory findByDate(LocalDate date);
	
	
	@Query(value="Select i from VaccineInventory i left join VaccineCount c on i.vCount_id = c.inventory_id left join Vaccine v on c.vaccine_id = v.vCount_id", nativeQuery=true)
	public List<VaccineInventory> findByVaccine();
	
}
