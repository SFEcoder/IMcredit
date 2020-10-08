package com.example.common.cache;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

/**
 * @Author:
 * @Date: 2020/9/19 20:17
 */
@Component
public class RedisCacheClient {

    @Resource
    protected  RedisTemplate<Serializable,Serializable> redisTemplate;

    public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        return redisTemplate;
    }

    public  void set(String key,Serializable value,long expireSeconds){
        redisTemplate.execute((RedisCallback<Object>) connection->{
            byte[] k = redisTemplate.getStringSerializer().serialize(key);
            byte[] v = SerializationUtils.serialize(value);
            connection.set(k,v);
            connection.expire(k,expireSeconds);
            return null;
        });
    }

    public  <T> T get(String key){
        return redisTemplate.execute((RedisCallback<T>) connection ->{
            byte [] k = redisTemplate.getStringSerializer().serialize(key);
            byte [] value = connection.get(k);
            if (value!=null){
                return (T)SerializationUtils.deserialize(value);
            }
            return null;
        });
    }

    public  void  delete(String key){
        redisTemplate.delete(key);
    }
    public  <T> T getAndDel(String key){
        T object = (T) get(key);
        delete(key);
        return object;

    }

    public  void deleteKeys(Collection keys){
        redisTemplate.delete(keys);
    }
    public  boolean exists(String key){
        return redisTemplate.execute((RedisCallback<Boolean>) connection->{
            byte [] k = redisTemplate.getStringSerializer().serialize(key);
            return connection.exists(k);
        });
    }
}

