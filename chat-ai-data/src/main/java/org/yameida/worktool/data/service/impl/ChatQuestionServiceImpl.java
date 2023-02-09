package org.yameida.worktool.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.yameida.worktool.data.domain.ChatQuestion;
import org.yameida.worktool.data.service.ChatQuestionService;
import org.yameida.worktool.data.mapper.ChatQuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author genxm
* @description 针对表【chat_question(被询问消息记录)】的数据库操作Service实现
* @createDate 2023-02-09 18:16:14
*/
@Service
public class ChatQuestionServiceImpl extends ServiceImpl<ChatQuestionMapper, ChatQuestion>
    implements ChatQuestionService{

}




