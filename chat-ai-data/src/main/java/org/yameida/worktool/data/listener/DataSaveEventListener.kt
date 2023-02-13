package org.yameida.worktool.data.listener

import com.baomidou.mybatisplus.extension.service.IService
import lombok.extern.slf4j.Slf4j
import org.springframework.context.ApplicationListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.yameida.worktool.common.event.DataSaveEvent
import org.yameida.worktool.common.utils.SpringUtils


/**
 * @Author genxm
 * @Description 数据存储监听器
 * @Date 2022/12/16 10:55
 * @Version 1.0
 */
@Slf4j
@Component
open class DataSaveEventListener : ApplicationListener<DataSaveEvent> {

    @Async
    override fun onApplicationEvent(event: DataSaveEvent) {
        val data = event.data
        val clazz = event.clazz
        val service = SpringUtils.getBean(clazz)
        service.save(data)
    }

}