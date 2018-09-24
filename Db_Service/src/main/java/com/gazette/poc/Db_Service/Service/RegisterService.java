package com.gazette.poc.Db_Service.Service;

import com.gazette.poc.Db_Service.Model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterService extends JpaRepository<Register , Integer> {
}
