package org.yameida.worktool.common.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {

    private volatile static ThreadPoolManager threadPoolManager;

    private ThreadPoolExecutor mThreadPool;

    // 线程池维护线程的最少数量
    private static final int SIZE_CORE_POOL =  Runtime.getRuntime().availableProcessors() * 2 + 1;

    private static final int maxPoolSize = 1000;

    private static final long keepAliveTime = 10;

    private static final int blockingQueueCapacity = 500;

    private ThreadPoolManager() {
        mThreadPool = new ThreadPoolExecutor(SIZE_CORE_POOL, maxPoolSize, keepAliveTime,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(blockingQueueCapacity));
    }

    public static ThreadPoolManager getInstance() {
        if (null == threadPoolManager) {
            synchronized (ThreadPoolManager.class) {
                if (null == threadPoolManager) {
                    threadPoolManager = new ThreadPoolManager();
                }
            }
        }
        return threadPoolManager;
    }


    /*
     * 向线程池中添加任务方法
     */
    public void execute(Runnable task) {
        if (task != null) {
            mThreadPool.execute(task);
        }
    }

    /*
     * 判断是否是最后一个任务
     */
    protected boolean isTaskEnd() {
        if (mThreadPool.getActiveCount() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 获取缓存大小
     */
    public int getQueue(){
        return mThreadPool.getQueue().size();
    }

    /*
     * 获取线程池中的线程数目
     */
    public int getPoolSize(){
        return mThreadPool.getPoolSize();
    }

    /*
     * 获取已完成的任务数
     */
    public long getCompletedTaskCount(){
        return mThreadPool.getCompletedTaskCount();
    }

    /**
     * 获取线程池中活动线程的数量
     *
     * @return
     */
    public int getActiveThreadCount() {

        return mThreadPool.getActiveCount();
    }

    /*
     * 关闭线程池，不在接受新的任务，会把已接受的任务执行玩
     */
    public void shutdown() {
        mThreadPool.shutdown();
    }

    /**
     * 从线程池中移除任务
     */
    public void remove(Runnable runnable) {
        if (runnable == null) return;
        mThreadPool.remove(runnable);
    }

}
