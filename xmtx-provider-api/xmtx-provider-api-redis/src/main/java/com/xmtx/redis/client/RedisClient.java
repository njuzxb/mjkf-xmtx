package com.xmtx.redis.client;

import com.xmtx.common.DTO.TopNDTO;
import com.xmtx.common.VO.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "xmtx-provider-redis")
public interface RedisClient {


    /*
     * 查询key是否存在
     * */
    @RequestMapping("/get/normal/string/key/value")
    public boolean exists(@RequestParam("normalKey") String normalKey);

    /*
     * 把list存入zset中
     * */
    @RequestMapping("/save/zset")
    ResultVO saveListInZset(@RequestParam("topList") String topList);

    /**
     * 将字符串类型的键值对保存到Redis时调用的远程方法
     * @param normalKey
     * @param normalValue
     * @param timeoutMinute	超时时间（单位：分钟）
     * 		-1表示无过期时间
     * 		正数表示过期时间分钟数
     * 		0和null值不接受
     * @return
     */
    @RequestMapping("/save/normal/string/key/value")
    ResultVO saveNormalStringKeyValue(@RequestParam("normalKey") String normalKey, @RequestParam("normalValue") String normalValue, @RequestParam("timeoutMinute") Integer timeoutMinute);

    /**
     * 根据key查询对应value时调用的远程方法
     * @param normalKey
     * @return
     */
    @RequestMapping("/retrieve/string/value/by/string/key")
    ResultVO retrieveStringValueByStringKey(@RequestParam("normalKey") String normalKey);

    /**
     * 根据key删除对应value时调用的远程方法
     * @param key
     * @return
     */
    @RequestMapping("/redis/remove/by/key")
    ResultVO removeByKey(@RequestParam("key") String key);

}
