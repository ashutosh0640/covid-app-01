package com.vaccinationApp.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Validated
public class VaccineRegistration {
		@Id
//		@NotEmpty( message="mobileNo cann't be empty")
		private long mobileNo;
		
//		@NotEmpty(message="date of registration cann't be empty")
		private LocalDate dateOfReg=LocalDate.now();
		
//		@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
//        message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
		private String password;
		
		@OneToMany(mappedBy="mob_no", cascade = CascadeType.ALL)
		private List<Member> members;
		
}
