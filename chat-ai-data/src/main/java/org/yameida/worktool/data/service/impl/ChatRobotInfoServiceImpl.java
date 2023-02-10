package org.yameida.worktool.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yameida.worktool.data.domain.ChatRobotInfo;
import org.yameida.worktool.data.mapper.ChatRobotInfoMapper;
import org.yameida.worktool.data.service.ChatRobotInfoService;

/**
 * @author genxm
 * @description 针对表【chat_robot_info】的数据库操作Service实现
 * @createDate 2023-02-09 18:16:14
 */
@Service
public class ChatRobotInfoServiceImpl extends ServiceImpl<ChatRobotInfoMapper, ChatRobotInfo>
        implements ChatRobotInfoService {

    @Override
    public ChatRobotInfo findByRobotId(String robotId) {
        LambdaQueryWrapper<ChatRobotInfo> query = Wrappers.<ChatRobotInfo>lambdaQuery().eq(ChatRobotInfo::getRobotId, robotId);
        return this.getOne(query);


    }
}




