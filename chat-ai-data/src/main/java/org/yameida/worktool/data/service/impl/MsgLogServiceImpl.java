package org.yameida.worktool.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.yameida.worktool.data.domain.MsgLog;
import org.yameida.worktool.data.service.MsgLogService;
import org.yameida.worktool.data.mapper.MsgLogMapper;
import org.springframework.stereotype.Service;

/**
* @author genxm
* @description 针对表【msg_log(消息发送记录)】的数据库操作Service实现
* @createDate 2023-02-10 17:23:45
*/
@Service
public class MsgLogServiceImpl extends ServiceImpl<MsgLogMapper, MsgLog>
    implements MsgLogService{

}




