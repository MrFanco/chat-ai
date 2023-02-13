package org.yameida.worktool.data.listener

import lombok.extern.slf4j.Slf4j
import org.springframework.context.ApplicationListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.yameida.worktool.common.event.DataUpdateEvent
import org.yameida.worktool.common.utils.SpringUtils


/**
 * @Author genxm
 * @Description 数据更新存储器
 * @Date 2022/12/16 10:55
 * @Version 1.0
 */
@Slf4j
@Component
open class DataUpdateEventListener : ApplicationListener<DataUpdateEvent> {

    @Async
    override fun onApplicationEvent(event: DataUpdateEvent) {
        val data = event.data
        val clazz = event.clazz
        val service = SpringUtils.getBean(clazz)
        service.updateById(data)
    }

}