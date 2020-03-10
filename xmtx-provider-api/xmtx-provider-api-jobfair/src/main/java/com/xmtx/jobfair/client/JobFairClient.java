package com.xmtx.jobfair.client;

import com.xmtx.jobfair.common.JobFairInfoOutput;
import com.xmtx.jobfair.common.ReleaseInput;
import com.xmtx.common.VO.ResultVO;
import com.xmtx.jobfair.common.UpdateInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 23:57 2020/2/18
 * @ Description：宣讲会暴露接口
 * @ Modified By：
 * @Version: $
 */
@FeignClient(name = "xmtx-provider-jobfair")
public interface JobFairClient {

    @GetMapping("/jobfair/list")
    public ResultVO list();

    @PostMapping("/jobfair/release")
    public ResultVO<Map<String,Integer>> release(@RequestParam("input") ReleaseInput releaseInput, @RequestParam("result") BindingResult bindingResult);

    @PostMapping("/jobfair/update")
    public ResultVO<JobFairInfoOutput> update(@RequestParam("input") UpdateInput updateInput, @RequestParam("result") BindingResult bindingResult);

    @PostMapping("/jobfair/delete")
    public ResultVO<String> delete(Integer id);


}
