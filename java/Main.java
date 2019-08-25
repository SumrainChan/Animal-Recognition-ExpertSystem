/*
 * 主方法入口
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalJudgeSystem animalJudgeSystem = new AnimalJudgeSystem();
		animalJudgeSystem.loadRuleBase("./rules.txt");
		System.out.println("-----欢迎使用动物识别专家系统-----");
		while(true){
			System.out.println("请输入您要执行的功能编号：");
			System.out.println("	[1] 动物识别");
			System.out.println("	[2] 显示规则");
			System.out.println("	[3] 插入规则");
			System.out.println("	[4] 删除规则");
			System.out.println("	[5] 退出系统");
			Scanner scanner = new Scanner(System.in);
			int choose = scanner.nextInt();
			if(choose == 1)animalJudgeSystem.recognizeAnimal("", "console");
			else if(choose == 2)animalJudgeSystem.displayRules();
			else if(choose == 3)animalJudgeSystem.insertRule();
			else if(choose == 4)animalJudgeSystem.deleleRule();
			else break;
			System.out.println("-------------------------");
		}
	}


}

