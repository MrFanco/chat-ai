package org.yameida.worktool.service

import org.yameida.worktool.data.domain.ChatAi

/**
 * @Author genxm
 * @Description ai服务类
 * @Date 2023/2/13 17:14
 * @Version 1.0
 */
interface AIService {

    /**
     * 获取AI列表
     */
    fun getAIs():MutableList<ChatAi>


}