package com.example.provider.redis;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**状态枚举
 * @author dlz
 * @date 2020/11/3
 * @description
 */
public abstract class Status {

    /**
     * 过期时间相关枚举
     */
    public static enum ExpireEnum{
        UNREAD_MSG(30L, TimeUnit.DAYS);

        ExpireEnum(long time, TimeUnit timeUnit) {
            this.time=time;
            this.timeUnit=timeUnit;
        }

        /**
         * 过期时间
         */
        private Long time;
        
        /**
         * 时间单位
         */
        private TimeUnit timeUnit;
        
        public Long getTime(){
            return time;
        }
        
        public TimeUnit getTimeUnit(){
            return timeUnit;
        }
    }
}
