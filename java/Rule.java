/*
 * Rule类：单条规则记录
 * 方法：
 * 		void addCondition(String condition) -- 添加前提条件
 * 		void setConclusion(String conclusion) -- 设定结论
 * 		ArrayList<String> getCondition() -- 获得条件集
 * 		String getConclusion() -- 获得结论
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Rule {
	private ArrayList<String> condition = new ArrayList<>();
	private String conclusion = new String();
	
	// 添加前提条件
	public void addCondition(String condition){
		this.condition.add(condition);
	}
	
	// 设定结论
	public void setConclusion(String conclusion){
		this.conclusion = conclusion;
	}
	
	// 获得条件集
	public ArrayList<String> getCondition(){
		return condition;
	}
	
	// 获得结论
	public String getConclusion(){
		return conclusion;
	}
}
