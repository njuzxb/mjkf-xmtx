package com.xmtx.jobfair.utils;

import com.xmtx.jobfair.vo.ResultVO;
import com.xmtx.jobfair.enums.ResultEnum;

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
    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMsg());
        return resultVO;
    }

    public static ResultVO error(String erro) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg(erro);
        return resultVO;
    }
}
