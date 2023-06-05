package com.vaccinationApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaccinationApp.DTO.ApiResponse;
import com.vaccinationApp.model.Member;
import com.vaccinationApp.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memSer;
	
	@GetMapping("/member/{adhar}")
	public ResponseEntity<Member> getMemberByAdharNoHandler(@PathVariable("adhar") long adharNo) {
		Member member = memSer.getMemberByAdharNo(adharNo);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}
	
	@GetMapping("/member/{pan}")
	public ResponseEntity<Member> getMemberByPanNoHandler(@PathVariable("pan") String panNo) {
		Member member = memSer.getMemberByPanNo(panNo);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}
	
	@PostMapping("/member/")
	public ResponseEntity<Member> addMemberHandler(@RequestBody Member member) {
		Member mem = memSer.addMember(member);
		return new ResponseEntity<>(mem, HttpStatus.OK);
	}
	
	@PutMapping("/member/")
	public ResponseEntity<Member> updateMemberHandler(Member member) {
		Member mem = memSer.updateMember(member);
		return new ResponseEntity<>(mem, HttpStatus.OK);
	}
	
	@DeleteMapping("/member/")
	public ResponseEntity<ApiResponse> deleteMemberHandler(@RequestBody Member member) {
		memSer.deleteMember(member);
		return new ResponseEntity<>(new ApiResponse("member deleted successfully...", true), HttpStatus.OK);
	}
	
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> findMemberByIdCardHandler(@PathVariable("id") int id) {
		Member mem = memSer.findMemberByIdCard(id);
		return new ResponseEntity<>(mem, HttpStatus.OK);
	}
	
	@GetMapping("/members/")
	public ResponseEntity<List<Member>> getAllMemberHandler(){
		List<Member> members = memSer.getAllMember();
		return new ResponseEntity<>(members, HttpStatus.OK);
	}

}
