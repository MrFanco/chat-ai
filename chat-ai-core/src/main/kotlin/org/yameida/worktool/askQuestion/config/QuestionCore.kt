package org.yameida.worktool.askQuestion.config

import org.yameida.worktool.askQuestion.QuestionAskHandler
import org.yameida.worktool.askQuestion.observer.QuestionObserver
import org.yameida.worktool.common.utils.ThreadPoolManager

/**
 * @Author genxm
 * @Description 问题核心类
 * @Date 2023/2/13 12:25
 * @Version 1.0
 */
open class QuestionCore {
    /**
     * 线程安全的单利模式
     */
    companion object {
        private var instance: QuestionCore? = null
            get() {
                if (field == null) {
                    field = QuestionCore()
                }
                return field
            }

        @Synchronized
        fun get(): QuestionCore {
            return instance!!
        }
    }

    open fun startQuestion(): QuestionCore {
        val handler = QuestionAskHandler()
        handler.addObserver(QuestionObserver())
        ThreadPoolManager.getInstance().execute(handler)
        return this
    }


}