package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Administrator;

/**
 * administratorsテーブルを操作するリポジトリ.
 * 
 * @author igamasayuki
 * 
 */
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	public Administrator findByMailAddressAndPassword(String mailAddress, String password);

	public Administrator findByMailAddress(String value);

}
