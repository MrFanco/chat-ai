package org.yameida.worktool

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@EnableAsync
@EnableFeignClients
@EnableScheduling
@MapperScan("org.yameida.worktool.data.mapper")
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
open class ChatAIApplication
fun main(args: Array<String>) {
    runApplication<ChatAIApplication>(*args)
}

