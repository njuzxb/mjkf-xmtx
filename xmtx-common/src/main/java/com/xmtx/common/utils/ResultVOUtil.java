package com.xmtx.common.utils;


import com.xmtx.common.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

//    public static ResultVO error(ResultEnum resultEnum) {
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(resultEnum.getCode());
//        resultVO.setMsg(resultEnum.getMessage());
//        return resultVO;
//    }
}