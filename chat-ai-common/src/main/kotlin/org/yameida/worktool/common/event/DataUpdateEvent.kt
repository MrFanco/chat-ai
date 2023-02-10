package org.yameida.worktool.common.event

import com.baomidou.mybatisplus.extension.service.IService
import org.springframework.context.ApplicationEvent

/**
 * @Author genxm
 * @Description 数据存储事件
 * @Date 2023/2/9 18:24
 * @Version 1.0
 */
class DataUpdateEvent(
    private val data: Any,
    private val clazz: Class<IService<Any>>
) : ApplicationEvent(data) {

    fun getData(): Any {
        return data
    }

    fun getClazz(): Class<IService<Any>> {
        return clazz;
    }
}
