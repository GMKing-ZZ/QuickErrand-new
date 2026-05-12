package com.quickerrand.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickerrand.entity.RunnerBlacklist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RunnerBlacklistMapper extends BaseMapper<RunnerBlacklist> {

    @Select("SELECT * FROM t_runner_blacklist WHERE user_id = #{userId} AND runner_id = #{runnerId} AND deleted = 1 LIMIT 1")
    RunnerBlacklist selectDeletedRecord(Long userId, Long runnerId);

    @Update("UPDATE t_runner_blacklist SET deleted = 0, reason = #{reason}, update_time = NOW() WHERE id = #{id}")
    int restoreRecord(Long id, String reason);
}
