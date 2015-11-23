package com.orangefunction.tomcat.redissessions;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author Artur Dyadchenko
 */
public class JedisProxy {
    private Log log = LogFactory.getLog(JedisProxy.class);
    private Jedis jedis;

    public JedisProxy(Jedis jedis) {
        this.jedis = jedis;
    }

    public void trace(String message) {
        log.trace(message);
    }

    public String select(int index) {
        trace("cmd=select, db=" + index);
        return jedis.select(index);
    }

    public Long setnx(byte[] key, byte[] value) {
        trace("cmd=setnx, bytes=" + value.length);
        return jedis.setnx(key, value);
    }

    public String flushDB() {
        trace("cmd=flushDB");
        return jedis.flushDB();
    }

    public Long dbSize() {
        trace("cmd=dbSize");
        return jedis.dbSize();
    }

    public Set<String> keys(String pattern) {
        trace("cmd=keys, pattern=" + pattern);
        return jedis.keys(pattern);
    }

    public String get(String key) {
        trace("cmd=get");
        return jedis.get(key);
    }

    public byte[] get(byte[] key) {
        byte[] value = jedis.get(key);
        trace("cmd=get, bytes=" + value.length);
        return value;
    }

    public String set(String key, String value) {
        trace("cmd=set, length=" + value.length());
        return jedis.set(key, value);
    }

    public String set(byte[] key, byte[] value) {
        trace("cmd=set, bytes=" + value.length);
        return jedis.set(key, value);
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        trace("cmd=set, nxxx=" + nxxx + ", expx=" + expx + ", time=" + time);
        return jedis.set(key, value, nxxx, expx, time);
    }

    public Long expire(String key, int seconds) {
        trace("cmd=expire");
        return jedis.expire(key, seconds);
    }

    public Long expire(byte[] key, int seconds) {
        trace("cmd=expire");
        return jedis.expire(key, seconds);
    }

    public Long del(String key) {
        trace("cmd=del");
        return jedis.del(key);
    }

    public Jedis getJedis() {
        return this.jedis;
    }
}
