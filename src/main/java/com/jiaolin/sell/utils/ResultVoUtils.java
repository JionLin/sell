package com.jiaolin.sell.utils;

import com.jiaolin.sell.Vo.ResultVo;

/**
 * @Auther: Joinlin
 * @Descriptional: 返回的是utils类
 * @Date: Create in 10:00 2018/4/24
 * @Modify By:
 */
public class ResultVoUtils {

	public static ResultVo success(Object object){
		ResultVo resultVo=new ResultVo();
		resultVo.setCode(0);
		resultVo.setMessage("成功");
		resultVo.setData(object);
		return resultVo;
	}
	public static  ResultVo success(){
		return success(null);
	}

	public static ResultVo error(Integer code,String message){
		ResultVo resultVo=new ResultVo();
		resultVo.setMessage(message);
		resultVo.setCode(code);
		return resultVo;
	}
}

