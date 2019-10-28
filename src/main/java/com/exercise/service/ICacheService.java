/**
 * 
 */
package com.exercise.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * @author Alberto
 *
 */
@Service
public interface ICacheService {
	
	/**
	 * Store a new object in cache
	 * @param <T>
	 * @param key the key with which the specified value is to be associated
	 * @param object value to be associated with the specified key
	 */
	<T> void store(String key, T object);
	
	boolean checkIfExists(String key);
	
	<T> Optional<T> get(String key, Class<T> type);

}
