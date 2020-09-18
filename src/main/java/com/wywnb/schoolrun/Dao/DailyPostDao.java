package com.wywnb.schoolrun.Dao;

import com.wywnb.schoolrun.Entity.DailyPostEntity;

import java.util.List;

public interface DailyPostDao {
    Long countAll();
    Long countDaily(Long startTime, Long endTime);
    List<DailyPostEntity> findAll();
}
