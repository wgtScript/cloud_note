package readNote.service;


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.baomidou.mybatisplus.plugins.Page;

@Service
public class BaseService<T extends Object> {

	/**
	 * 分页辅助类
	 * @author cm
	 * @param params
	 * @return
	 */
	public Page<T> getPageHelper(Map<String, Object>params) {
		Integer current = 1;
		Integer size = 10;
		if (!ObjectUtils.isEmpty(params.get("page"))) {
			current = Integer.valueOf(params.get("page").toString());
		}
		if (!ObjectUtils.isEmpty(params.get("rows"))) {
			size = Integer.valueOf(params.get("rows").toString());
		}
		if (!ObjectUtils.isEmpty(params.get("sort"))) {
			String sort = (String) params.get("sort");
			String order = (String) params.get("order");
//			params.remove("sort");
			return new Page<T>(current,size,getSort(sort, order));
		}
		String dafaultOrder="create_time";
		//page.setOrderByField("id_ ");
		//page.setAsc(false);
		return new Page<T>(current,size,dafaultOrder);
	}
	
	
	public String getSort(String sort, String order) {
		
		String result = "";
		
		String[] sortArr = sort.split(",");
		String[] orderArr = order.split(",");
		
		for(int i = 0; i < sortArr.length; i++) {
			result += camel2Underline(sortArr[i]) + " " + orderArr[i] + ",";
		}
		
		return result + "create_time";
	}
	
	public static String camel2Underline(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toLowerCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String str = "applyCode";
		System.out.println(camel2Underline(str));
	}
}
