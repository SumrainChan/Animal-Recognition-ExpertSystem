/*
 * AnimalJudgeSystem类：动物识别专家系统
 * 方法：
 * 		void loadRuleBase(String pathname) -- 加载规则库
 * 		void recognizeAnimal(String pathname, String method) -- 识别动物
 * 		String reasonMachine() -- 启动推理机
 * 		void displayRules() -- 显示规则库所有规则
 * 		void deleleRule() -- 删除单条规则
 * 		void insertRule() -- 插入单条规则
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AnimalJudgeSystem {
	private RuleBase ruleBase; // 规则库
	private ArrayList<String> factset = new ArrayList<String>(); // 事实集
	private String[] animal_category = {"虎", "豹", "斑马", "长颈鹿", "企鹅", "鸵鸟", "信天翁"}; // 最终结论集
	public AnimalJudgeSystem(){
		this.ruleBase = new RuleBase();
	}
	
	// 加载规则库
	public void loadRuleBase(String pathname){
		ruleBase.load(pathname);
	}
	
	// 识别 动物
	/*
	 * 参数：
	 * 		pathname -- 规则库文件路径
	 * 		method -- 'console'/'file'， 'console'表示控制台输入动物特征， 'file'表示文件导入动物特征
	 */
	public void recognizeAnimal(String pathname, String method){
		if(method == "console"){
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入该动物的特征 （以“end”结束输入）：");
			while(true){
				String feature = scanner.next();
				if(feature.equals("end"))break;
				factset.add(feature);
			}
		}
		else if (method == "file"){
			File file = new File(pathname);
	        try{
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String content = null;
	            while((content = br.readLine()) != null){
	            		factset.add(content);     	
	            }
	            br.close();    
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		}
		else return;
		
		String result = reasonMachine();
		
		if(result == null){
			System.out.println("无法识别此动物！");
		}
		else {
			System.out.println("这个动物是" + result);
		}
	}
	
	// 启动推理机
	private String reasonMachine(){
		int[] rule_flag = new int[ruleBase.rules.size()];
		for(int i = 0; i < rule_flag.length; i++)rule_flag[i] = 0; 
		int i = 0;
		while(true){
			if(i == rule_flag.length)break;
			if(rule_flag[i] == 1){i++;continue;}
			Rule c_rule = ruleBase.rules.get(i);
			if(!contains(factset, c_rule.getCondition())){
					i++;
					continue;		
			}
			String c_conclusion  = c_rule.getConclusion();
			for(String string: animal_category){
				if(c_conclusion.equals(string))return c_conclusion;
			}
			factset.add(c_conclusion);
			rule_flag[i] = 1;
			i = 0;
		}
		return null;
	}
	
	// 显示规则库所有规则
	public void displayRules(){
		ruleBase.display();
	}
	
	// 删除单条规则
	public void deleleRule(){
		ruleBase.delete();
	}
	
	// 插入单条规则
	public void insertRule(){
		ruleBase.insert();
	}
	
	// 判断A集是否包含B集
	public static boolean contains(ArrayList<String> a, ArrayList<String> b){
		Iterator<String> bIterator = b.iterator();		
		while(bIterator.hasNext()){
			String bString = bIterator.next();
			Iterator<String> aIterator = a.iterator();
			boolean find = false;
			while(aIterator.hasNext()){
				String aString = aIterator.next();
				if(bString.equals(aString)){find = true; break;}
			}
			if(find == false)return false;
		}
		return true;
	}
		
	
	
}
