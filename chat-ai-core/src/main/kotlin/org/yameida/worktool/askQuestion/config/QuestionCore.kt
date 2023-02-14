package org.yameida.worktool.askQuestion.config

import org.yameida.worktool.askQuestion.QuestionAskHandler
import org.yameida.worktool.askQuestion.observer.QuestionObserver
import org.yameida.worktool.common.utils.ThreadPoolManager
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

/**
 * @Author genxm
 * @Description 问题核心类
 * @Date 2023/2/13 12:25
 * @Version 1.0
 */
open class QuestionCore {

    val AIUseMap = ConcurrentHashMap<Int,Long>()


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

    open fun getAIUseAITime(id :Int):Long{
        var time = AIUseMap[id]
        if (time == null) {
            time = System.currentTimeMillis()
            AIUseMap[id] = time
        }
        return time
    }
    open fun updateAIUseTime(id: Int, time:Long){
        AIUseMap[id] = time
    }
}