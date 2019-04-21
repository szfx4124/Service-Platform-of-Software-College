package cn.edu.nchu.util.action;

import cn.edu.nchu.util.ObjectToJSON;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public abstract class DefaultAction {
	@Resource
	private MessageSource messageSource;

	@Autowired
	protected HttpServletRequest request = null;

	/**
	 * 可以根据key取得资源的内容
	 * @param key 表示要读取key
	 * @param param 表示设置的参数
	 * @return
	 */

	public String getResource(String key,String ...param){
		return this.messageSource.getMessage(key,param, Locale.getDefault());
	}

	/**
	 * 设置提示信息与跳转路径，通过资源文件读取的
	 * @param mav
	 * @param msg
	 * @param path
	 */
	public void setMsgAndPath(ModelAndView mav,String msg,String path){
		if (mav != null){
			if (this.getText() != null){
				String [] result = this.getText().split("\\|");
				mav.addObject("msg",this.messageSource.getMessage(msg,result,Locale.getDefault()));
			}else{
				mav.addObject("msg",this.messageSource.getMessage(msg,null,Locale.getDefault()));
			}
			mav.addObject("path",this.messageSource.getMessage(path,null,Locale.getDefault()));
		}
	}
	public void printObjectToJson(HttpServletResponse response, Object vo){
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(ObjectToJSON.convertorObjectToJSON(vo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将List集合数据转换成JSON
	 * @param response
	 * @param name
	 * @param all
	 */
	public void printObjectToList(HttpServletResponse response, String name, List<?> all){
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(ObjectToJSON.convertorListToJSON(name,all));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将集合数据转换为JSON并实现分页处理
	 * @param response
	 * @param name
	 * @param all
	 * @param allRecorders
	 */
	public void printObjectToListSplit(HttpServletResponse response, String name, List<?> all,Integer allRecorders){
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(ObjectToJSON.convertorSplitToJSON(name,all,allRecorders));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public abstract String getText();
}
