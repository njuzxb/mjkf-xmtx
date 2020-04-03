package com.xmtx.history.service.impl;

import com.xmtx.common.utils.EntityUtils;
import com.xmtx.history.dataObject.BrowsingHistory;
import com.xmtx.history.repository.BrowsingHistoryRepository;
import com.xmtx.history.service.BrowsingHistoryService;
import com.xmtx.common.DTO.TopNDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrowsingHistoryServiceImpl implements BrowsingHistoryService {

    @Autowired
    BrowsingHistoryRepository browsingHistoryRepository;

    // 获取过去24小时内浏览量Top10的jobid
    public List<TopNDTO> getTopNBrowsingCount(){

        List<Object[]> list = browsingHistoryRepository.getOneDayTopN();

        return EntityUtils.castEntity(list, TopNDTO.class);
    }


    // 插入新浏览记录
    public void save(Integer jobid, Integer userid) {
        BrowsingHistory browsingHistory = new BrowsingHistory();
        browsingHistory.setJobid(jobid);
        browsingHistory.setUserid(userid);
        browsingHistory.setGmt_browsing(new Date());
        browsingHistoryRepository.save(browsingHistory);
    }
}
