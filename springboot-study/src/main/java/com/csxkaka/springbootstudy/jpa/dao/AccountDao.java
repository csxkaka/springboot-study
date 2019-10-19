package com.csxkaka.springbootstudy.jpa.dao;

import com.csxkaka.springbootstudy.jpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {
}
