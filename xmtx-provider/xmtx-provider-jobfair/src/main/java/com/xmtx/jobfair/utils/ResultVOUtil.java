package com.xmtx.jobfair.utils;

import com.xmtx.jobfair.vo.ResultVO;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 21:39 2020/1/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
