package com.nare.repository;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nare.entity.Contact;
@Repository
public interface ContactRepo extends JpaRepository<Contact,Serializable> {

	
}
