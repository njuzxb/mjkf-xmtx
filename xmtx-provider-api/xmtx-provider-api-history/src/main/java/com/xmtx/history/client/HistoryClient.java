package com.xmtx.history.client;

import com.xmtx.common.DTO.TopNDTO;
import com.xmtx.common.VO.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// name对于要调用的服务在eureka配置的名字，而@RequestMapping配置的地址必须跟要调用的服务方法地址一致
// feign首先会根据name找到要调用的服务，在通过@RequestMapping配置的地址调用指定的方法。
@FeignClient(name = "xmtx-provider-history")
public interface HistoryClient {

    // 查询topN浏览量的jobid；
    @RequestMapping("/browsingHistory/findTopNBrowsingHistory")
    public List<TopNDTO> findTopNBrowsingHistory();


    // 新增浏览记录
    @RequestMapping("/browsingHistory/addBrowsingHistory")
    public ResultVO saveBrowsingHistory(@RequestParam("jobid") Integer jobid, @RequestParam("userid") Integer userid);
}
