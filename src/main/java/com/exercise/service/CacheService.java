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
 * Service that provides cache functionality
 */
@Service(value="cacheService")
public class CacheService implements ICacheService {
	
	/**
	 * Autowired cache object
	 */
	@Autowired
	private Cache<Object, Object> cache;

	/**
	 * Store a new object in cache
	 * @param <T>
	 * @param key the key with which the specified value is to be associated
	 * @param object value to be associated with the specified key
	 */
	@Override
	public <T> void store(String key, T object) {
		cache.put(key, object);
	}

	/**
	 * Given a key, check if an object with that name exist in cache memory.
	 * @param key
	 * @return
	 */
	@Override
	public boolean checkIfExists(String key) {
		return (cache.getIfPresent(key) == null) ? false : true;
	}

	/**
	 * Retrieve an object stored in cache if exist, otherwise will return an empty optional.
	 * @param key object key
	 * @param type object type
	 * @return
	 */
	@Override
	public <T> Optional<T> get(String key, Class<T> type) {
		
		return ofNullable(type.cast(cache.getIfPresent(key)));
	}

}
