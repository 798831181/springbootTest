package com.sqc.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户持久层操作接口
 * @author 孙启超
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
