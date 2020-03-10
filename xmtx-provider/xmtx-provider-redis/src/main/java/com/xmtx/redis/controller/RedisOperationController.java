package com.xmtx.redis.controller;

import java.util.concurrent.TimeUnit;

import com.xmtx.common.VO.ResultVO;
import com.xmtx.common.enums.ResultEnum;
import com.xmtx.common.utils.CommonUtils;
import com.xmtx.common.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisOperationController {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	/**
	 * 将字符串类型的键值对保存到Redis时调用的远程方法
	 * @param normalKey
	 * @param normalValue
	 * @param timeoutMinute	超时时间（单位：分钟）
	 * @return
	 */
	@RequestMapping("/save/normal/string/key/value")
	ResultVO saveNormalStringKeyValue(
			@RequestParam("normalKey") String normalKey, 
			@RequestParam("normalValue") String normalValue, 
			@RequestParam("timeoutMinute") Integer timeoutMinute) {
		
		// 对输入数据进行验证
		if(!CommonUtils.strEffectiveCheck(normalKey) || !CommonUtils.strEffectiveCheck(normalValue)) {
			return ResultVOUtil.error(ResultEnum.MESSAGE_REDIS_KEY_OR_VALUE_INVALID);
		}
		
		// 获取字符串操作器对象
		ValueOperations<String, String> operator = redisTemplate.opsForValue();
		
		// 判断timeoutMinute值：是否为无效值
		if(timeoutMinute == null || timeoutMinute == 0) {
			return ResultVOUtil.error(ResultEnum.MESSAGE_REDIS_KEY_TIME_OUT_INVALID);
		}
		
		// 判断timeoutMinute值：是否为不设置过期时间
		if(timeoutMinute == -1) {
			
			// 按照不设置过期时间的方式执行保存
			try {
				operator.set(normalKey, normalValue);
			} catch (Exception e) {
				e.printStackTrace();
				
				return ResultVOUtil.error(e.getMessage());
			}
			
			// 返回结果
			return ResultVOUtil.success();
		}
		
		// 按照设置过期时间的方式执行保存
		try {
			operator.set(normalKey, normalValue, timeoutMinute, TimeUnit.MINUTES);
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultVOUtil.error(e.getMessage());
		}
		
		return ResultVOUtil.success();
	}
	
	/**
	 * 根据key查询对应value时调用的远程方法
	 * @param normalKey
	 * @return
	 */
	@RequestMapping("/retrieve/string/value/by/string/key")
	ResultVO retrieveStringValueByStringKey(@RequestParam("normalKey") String normalKey) {
		
		// 对输入数据进行验证
		if(!CommonUtils.strEffectiveCheck(normalKey)) {
			return ResultVOUtil.error(ResultEnum.MESSAGE_REDIS_KEY_OR_VALUE_INVALID);
		}
		
		try {
			String value = redisTemplate.opsForValue().get(normalKey);
			
			return ResultVOUtil.success(value);
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultVOUtil.error(e.getMessage());
		}
		
	}
	
	/**
	 * 根据key删除对应value时调用的远程方法
	 * @param key
	 * @return
	 */
	@RequestMapping("/redis/remove/by/key")
	ResultVO removeByKey(@RequestParam("key") String key) {
		
		// 对输入数据进行验证
		if(!CommonUtils.strEffectiveCheck(key)) {
			return ResultVOUtil.error(ResultEnum.MESSAGE_REDIS_KEY_OR_VALUE_INVALID);
		}
		
		try {
			redisTemplate.delete(key);
			
			return ResultVOUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResultVOUtil.error(e.getMessage());
		}
		
	}

}
