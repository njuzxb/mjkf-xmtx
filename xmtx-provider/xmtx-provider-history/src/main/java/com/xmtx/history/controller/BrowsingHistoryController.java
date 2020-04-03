package com.xmtx.history.controller;

import com.alibaba.fastjson.JSON;
import com.xmtx.common.VO.ResultVO;
import com.xmtx.common.utils.ResultVOUtil;
import com.xmtx.history.service.BrowsingHistoryService;
import com.xmtx.common.DTO.TopNDTO;
import com.xmtx.redis.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/browsingHistory")
public class BrowsingHistoryController {

    @Autowired
    BrowsingHistoryService browsingHistoryService;

    @Autowired
    RedisClient redisClient;

    // 查询TOPN并存入redis
    // 改为定时任务:每10分钟自动去统计24小时内浏览量最高的TOP10招聘信息,并存入redis
    @Scheduled(fixedDelay = 60000 * 1)  // 单位是毫秒，测试时设置1分钟
    public  void findTopNBrowsingHistory(){
        List<TopNDTO> listTopN = browsingHistoryService.getTopNBrowsingCount();
        System.err.println(JSON.toJSONString(listTopN));

        redisClient.saveListInZset(JSON.toJSONString(listTopN));

    }

    // 新增浏览记录
    @RequestMapping("/addBrowsingHistory")
    public ResultVO saveBrowsingHistory(@RequestParam("jobid") Integer jobid, @RequestParam("userid") Integer userid){

        // 验证信息
        // 新增浏览记录
        browsingHistoryService.save(jobid,userid);

        return ResultVOUtil.success();

    }




}
