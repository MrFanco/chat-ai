package org.yameida.worktool.common.base;


import lombok.extern.slf4j.Slf4j;
import org.yameida.worktool.common.utils.ThreadPoolManager;

import java.util.Observable;


/**
 * @author genxm
 */
@Slf4j
public abstract class BaseHandler extends Observable implements Runnable {
    private String handlerName;

    @Override
    public void run() {
        log.info("{}线程启动.....", handlerName);
        while (true) {
            try {
                this.handler();
            } catch (Exception e) {
                e.printStackTrace();
                setChanged();
                this.notifyObservers();
                log.info("{}线程意外停止.....", handlerName);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
        ThreadPoolManager.getInstance().remove(this);
    }

    public abstract void handler();


    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BaseHandler(String handlerName) {
        this.handlerName = handlerName;
    }
}
