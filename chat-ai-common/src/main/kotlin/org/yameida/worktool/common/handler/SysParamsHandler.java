package org.yameida.worktool.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


/**
 * 系统记录字段使用
 */
@Component
@Slf4j
class SysParamsHandler implements MetaObjectHandler {
    private static final String CREATE_TIME = "createTime";
    private static final String UPDATE_TIME = "updateTime";

    private static final String CREATE_BY = "createBy";

    private static final String UPDATE_BY = "updateBy";

    private static final String ROBOT_ID = "robotId";

    private static final String USER_ID = "userId";

    private static final String KEY = "key";


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert .. ");
        try {
            this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        } catch (Exception exception) {
            log.info("表缺少 CREATE_TIME 字段");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update .. ");
        try {
            this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        } catch (Exception exception) {
            log.info("表缺少 UPDATE_TIME 字段");
        }
    }

}

