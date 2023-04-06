package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;

public class PasswordUtil {

	@Autowired
	private AdministratorRepository repository;

	
	/**
	 * ログイン処理を行う.
	 * @param administrator 管理者
	 * @param パスワード
	 * @return
	 */
	public boolean login(Administrator administrator ,String password)  {
		// IDをキーにユーザー情報を取得
		Administrator hashPass = repository.getById(administrator.getId());
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		// 入力されたパスワードとDBのパスワード(ハッシュ化済み)を比較
		if (bcpe.matches(hashPass.getPassword(), password)) {
			return true;
		}
		return false;
	}

}
