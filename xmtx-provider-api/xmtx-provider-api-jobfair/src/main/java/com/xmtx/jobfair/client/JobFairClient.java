package com.xmtx.jobfair.client;

import com.xmtx.jobfair.common.JobFairInfoOutput;
import com.xmtx.jobfair.common.ReleaseInput;
import com.xmtx.jobfair.common.ResultVO;
import com.xmtx.jobfair.common.UpdateInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 23:57 2020/2/18
 * @ Description：宣讲会暴露接口
 * @ Modified By：
 * @Version: $
 */
@FeignClient(name = "jobfair")
public interface JobFairClient {
    @GetMapping("/jobfair/list")
    List<JobFairInfoOutput> list();
    @PostMapping("/jobfair/release")
    ResultVO<Map<String,Integer>> release(@Valid ReleaseInput releaseInput, BindingResult bindingResult);
    @PostMapping("/jobfair/update")
    ResultVO<JobFairInfoOutput> update(@Valid UpdateInput updateInput, BindingResult bindingResult);
    @PostMapping("/jobfair/delete")
    ResultVO<String> delete(Integer id);


}
