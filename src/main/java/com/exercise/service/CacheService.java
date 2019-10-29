/**
 * 
 */
package com.exercise.service;

import static java.util.Optional.ofNullable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.benmanes.caffeine.cache.Cache;

/**
 * @author Alberto
 *
 */
@Service(value="cacheService")
public class CacheService implements ICacheService {
	
	@Autowired
	private Cache<Object, Object> cache;

	@Override
	public <T> void store(String key, T object) {
		cache.put(key, object);
	}

	@Override
	public boolean checkIfExists(String key) {
		return (cache.getIfPresent(key) == null) ? false : true;
	}

	@Override
	public <T> Optional<T> get(String key, Class<T> type) {
		
		return ofNullable(type.cast(cache.getIfPresent(key)));
	}

}
