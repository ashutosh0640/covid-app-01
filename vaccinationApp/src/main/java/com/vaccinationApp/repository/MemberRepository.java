package com.vaccinationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vaccinationApp.model.Member;
import com.vaccinationApp.model.PanCard;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	@Query(value="Select * from member m left join user u where u.id = :id", nativeQuery = true)
	public Member findMemberByIdCard(@Param("id") int id);
	
	@Query(value="Select * from member m left join user u Where u.aadhar = :aadhar", nativeQuery = true)
	public Member findMemberByAdhar(@Param("aadhar") long aadhar);
	
	@Query(value="Select * from member m left join user u Where u.panNo = :panNo", nativeQuery = true)
	public Member findMemberByPanNo(@Param("panNo") String panNo);
}
