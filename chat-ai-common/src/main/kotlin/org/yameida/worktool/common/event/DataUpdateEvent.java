package org.yameida.worktool.common.event;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.context.ApplicationEvent;

/**
 * @Author genxm
 * @Description TODO
 * @Date 2023/2/10 17:37
 * @Version 1.0
 */
public class DataUpdateEvent extends ApplicationEvent {

    private Object data;
    private Class<?extends IService> clazz;

    public DataUpdateEvent(Object data, Class<?extends IService> clazz) {
        super(data);
        this.data = data;
        this.clazz = clazz;
    }

    public Class<?extends IService> getClazz() {
        return clazz;
    }

    public Object getData() {
        return data;
    }
}
