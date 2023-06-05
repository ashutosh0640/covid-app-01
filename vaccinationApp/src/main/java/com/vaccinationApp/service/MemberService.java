package com.vaccinationApp.service;


import java.util.List;

import com.vaccinationApp.model.Member;

public interface MemberService {
	
	
	public Member getMemberByAdharNo(long adharNo);
	
	public Member getMemberByPanNo(String panNo);
	
	public Member addMember(Member member);
	
	public Member updateMember(Member member);
	
	public boolean deleteMember(Member member);
	
	public Member findMemberByIdCard(int id);
	
	public List<Member> getAllMember();
}
