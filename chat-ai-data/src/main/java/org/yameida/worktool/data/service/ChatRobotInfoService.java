package org.yameida.worktool.data.service;


import org.yameida.worktool.data.domain.ChatRobotInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author genxm
 * @description 针对表【chat_robot_info】的数据库操作Service
 * @createDate 2023-02-09 18:16:14
 */
public interface ChatRobotInfoService extends IService<ChatRobotInfo> {

    /**
     * 根据机器人id查询机器人信息
     * @param robotId 机器人id
     * @return 机器人信息
     */
    ChatRobotInfo findByRobotId(String robotId);
}
