package com.sqc.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sqc.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
    /**
     * 查询推荐职位
     * @param status
     * @return
     */
    List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String status);

    /**
     * 查询最新职位
     * @param status
     * @return
     */
    List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String status);
	
}
