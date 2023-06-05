package com.vaccinationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaccinationApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//@Query("SELECT a FROM Author a WHERE firstName = ?1 AND lastName = ?2")
    //List<Author> findByFirstNameAndLastName(String firstName, String lastName);
	
	//@Query("FROM Author WHERE firstName = ?1")
	//List<Author> findByFirstName(String firstName);
	
	
	@Query("FROM User WHERE aadhar=?1")
	public User getUserByAdharNo(long adharNo);
	
	@Query("FROM User WHERE panNo=?1")
	public User getUserByPanNo(String panNo);
	
}
