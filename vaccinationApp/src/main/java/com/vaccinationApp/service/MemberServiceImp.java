package com.vaccinationApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccinationApp.exceptions.NotFoundException;
import com.vaccinationApp.model.Member;
import com.vaccinationApp.repository.MemberRepository;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberRepository memRepo;
	

	@Override
	public Member addMember(Member member) {
		Member mem = memRepo.save(member);
		return mem;
	}

	@Override
	public Member updateMember(Member member) {
		Member mem = memRepo.findById( member.getMem_id()).orElseThrow();
		mem.setDose1Date(member.getDose1Date());
		mem.setDose2Date(member.getDose2Date());
		mem.setUser(member.getUser());
		memRepo.save(mem);
		return mem;
	}

	@Override
	public boolean deleteMember(Member member) {
		Member mem = memRepo.findById(member.getMem_id()).orElseThrow(()->new NotFoundException("No member found"));
		memRepo.delete(member);
		return true;
	}

	@Override
	public List<Member> getAllMember() {
		List<Member> members = memRepo.findAll();
		return members;
	}

	@Override
	public Member getMemberByAdharNo(long adharNo) {
		Member member = memRepo.findMemberByAdhar(adharNo);
		if(member == null) {
			throw new NotFoundException("No member found by this aadhar No: "+ adharNo);
			}
		return member;
	}

	@Override
	public Member getMemberByPanNo(String panNo) {
		Member member = memRepo.findMemberByPanNo(panNo);
		if(member == null) {
			throw new NotFoundException("No member found by this pan No: "+ panNo);
		}
		return member;
	}

	@Override
	public Member findMemberByIdCard(int id) {
		Member member = memRepo.findMemberByIdCard(id);
		if(member == null) {
			throw new NotFoundException("No member found by this id: "+ id);
		}
		return member;
	}
}
