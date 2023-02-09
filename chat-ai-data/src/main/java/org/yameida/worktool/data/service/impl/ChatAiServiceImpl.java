package org.yameida.worktool.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.yameida.worktool.data.domain.ChatAi;
import org.yameida.worktool.data.service.ChatAiService;
import org.yameida.worktool.data.mapper.ChatAiMapper;
import org.springframework.stereotype.Service;

/**
* @author genxm
* @description 针对表【chat_ai(chatGPT机器人)】的数据库操作Service实现
* @createDate 2023-02-09 18:16:14
*/
@Service
public class ChatAiServiceImpl extends ServiceImpl<ChatAiMapper, ChatAi>
    implements ChatAiService{

}




