package com.sqc.base.dao;

import com.sqc.base.BaseApplicationTest;
import com.sqc.base.pojo.Label;
import com.sqc.util.IdWorker;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class LabelDaoTest extends BaseApplicationTest {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;
    @Test
    public void test(){
        Label label = new Label();
        label.setId(idWorker.nextId() + "");
        label.setFans(10l);
        label.setLabelname("test001");
        labelDao.save(label);
    }

}