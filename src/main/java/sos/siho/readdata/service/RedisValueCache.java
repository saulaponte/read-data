package sos.siho.readdata.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisValueCache {

    private final ValueOperations<String, Object> valueOps;

    public RedisValueCache(final RedisTemplate<String, Object> valueOps) {
        this.valueOps = valueOps.opsForValue();
    }

    public void cache(final String key, final Object data) {
        valueOps.set(key, data);
    }

    public Object getCachedValues(final String key){
        return valueOps.get(key);
    }

    public void deleteCachedValue(String key) {
        valueOps.getOperations().delete(key);
    }
}
