package com.lms.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;

	private String lastName;

	private String emailId;

	@JsonIgnore
	private String password;

	private String phoneNo;

	private String role;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToOne
	@JoinColumn(name = "mentor_detail_id")
	private MentorDetail mentorDetail;

	private BigDecimal amount;
	
	private String status;

	private String emailVerified;

	private String emailToken;

	private Integer failedAttempts = 0;

	private LocalDateTime accountLockedUntil;

}
