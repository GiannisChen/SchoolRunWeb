package com.wywnb.schoolrun;

import com.wywnb.schoolrun.Dao.RunTraceDao;
import com.wywnb.schoolrun.Dao.UserInfoDao;
import com.wywnb.schoolrun.Entity.RunTraceEntity;
import com.wywnb.schoolrun.Entity.UserInfoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SchoolrunApplicationTests {
    @Resource
    private RunTraceDao runTraceDao;

    @Test
    void contextLoads() {
        List<RunTraceEntity> list = runTraceDao.findAll();
        for(RunTraceEntity trace : list) {
            trace.sort();
        }
        System.out.println(list.size());
    }
}
