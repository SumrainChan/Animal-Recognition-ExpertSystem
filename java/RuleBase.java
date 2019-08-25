/*
 * RuleBase类：规则库
 * 方法：
 * 		void insert() -- 插入单条规则
 * 		load(String pathname) -- 加载规则库
 * 		void delete() -- 删除单条规则
 * 		void display() -- 显示所有规则
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RuleBase {
	public ArrayList<Rule> rules = new ArrayList<Rule>();
	
	// 插入单条规则
	public void insert(){
		Rule rule = new Rule();
		Scanner scanner = new Scanner(System.in);
		String content = scanner.nextLine();
		String[] split_content = content.replace(" ", "").split("if|and|then");
		for(int i = 1; i < split_content.length; i++){
			if(i < split_content.length - 1){
				rule.addCondition(split_content[i]);
			}
			else {
				rule.setConclusion(split_content[i]);
			}
		}
		rules.add(rule);
	}
	
	// 加载规则库
	public void load(String pathname){
		File file = new File(pathname);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String content = null;
            while((content = br.readLine()) != null){
            	Rule rule = new Rule();
            	String[] split_content = content.replace(" ", "").split("if|and|then");
        		for(int i = 1; i < split_content.length; i++){
        			if(i < split_content.length - 1){
        				rule.addCondition(split_content[i]);
        			}
        			else {
        				rule.setConclusion(split_content[i]);
        			}
        		}        	
            	rules.add(rule);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	// 删除单条规则
	public void delete(){
		display();
		System.out.println("请输入您要删除的规则编号：");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		rules.remove(i);
	}
	
	// 显示所有规则
	public void display(){
		for(int i = 0; i < rules.size(); i++){
			Rule c_rule = rules.get(i);
			ArrayList<String>c_condition = c_rule.getCondition();
			String c_conclusion = c_rule.getConclusion();
			System.out.print("[" + i + "] if ");
			System.out.print(c_condition.get(0) + " ");
			for (int j = 1; j < c_condition.size(); j++){
				String c_String = c_condition.get(j);
				System.out.print("and " + c_String + " ");
			}
			System.out.println(" then " + c_conclusion);
		}
	}
}
