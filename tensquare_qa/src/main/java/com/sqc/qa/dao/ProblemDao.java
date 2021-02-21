package com.sqc.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sqc.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    /**
     * 最新回复问题
     */
    @Query(value = "select * from tb_problem, tb_pl where id=problemid and labelid=? order by replytime",nativeQuery = true)
    Page<Problem> newList(String labelid, Pageable pageable);
//    /**
//     * 热门问题
//     */
//    List<Problem> hotList();
//    /**
//     * 等待回答
//     */
//    List<Problem> waitList();
//
}
