package org.yameida.worktool.askQuestion.observer


import lombok.extern.slf4j.Slf4j
import org.yameida.worktool.askQuestion.QuestionAskHandler
import org.yameida.worktool.common.utils.ThreadPoolManager
import java.util.*

/**
 * 主要用于观察线程是否出现意外崩溃,如果死亡则重启线程
 */
@Slf4j

class QuestionObserver : Observer {
    override fun update(o: Observable, arg: Any) {
        val handler = QuestionAskHandler()
        handler.addObserver(this)
        ThreadPoolManager.getInstance().execute(handler)
    }
}