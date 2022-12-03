package org.sojuton.skeleton.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SkeletonDao {

    public String test();
}
