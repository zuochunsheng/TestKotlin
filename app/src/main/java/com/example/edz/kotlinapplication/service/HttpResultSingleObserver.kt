package com.example.edz.kotlinapplication.service

import io.reactivex.observers.DisposableSingleObserver

/**
 * @author： zcs
 * @time：2019/9/23 on 17:20
 * @description：DisposableSingleObserver 的子类，用来接收网络数据回调
 */
abstract class HttpResultSingleObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {
        //dispose 一次任务
        dispose()
        onResult(t)
    }

    override fun onError(e: Throwable) {
        //dispose 一次任务
        dispose()
        //HttpResultException e = new HttpResultException(t.getCode(), t.getMessage());
        onFailure("-1", e?.message!!)
    }


    /**
     * @param t 获取结果
     */
    protected abstract fun onResult(t: T)

    /**
     * @param message 获取结果失败
     * code 等于-1 时，本地抛出的异常
     */
    protected abstract fun onFailure(code: String, message: String)

}
