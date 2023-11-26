package com.registration.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.form.model.FormEntity;
@Repository
public interface FormRepository extends JpaRepository<FormEntity,Integer> {

}
