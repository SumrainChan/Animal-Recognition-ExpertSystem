# 动物识别专家系统

### 程序简介
本程序选用Java作为开发语言，基于专家系统原理，实现通过输入未知动物的特征，推测出此动物的具体类别。除此之外，本系统的规则还可以动态地插入和删除，以便于系统规则库的维护和升级。


### 操作说明
1. 在命令行窗口上进入程序所在路径，输入“java Main”进入系统主页面
2. 输入“1”选择动物识别功能，然后输入未知动物的特征
3. 输入“2”，显示规则库的所有规则
4. 输入“3”选择插入规则功能，输入格式为“if (特征) then (结论)”
5. 输入“4”选择删除规则功能
6. 输入“5”退出本系统

### 问题解决思路
本系统由三部分组成：规则库、推理机和综合数据库组成：
1. 规则库。规则库中的规则采用产生式表示，规则库是一个RuleBase类，其包含保存规则的列表。每条规则是一个Rule类的对象，用对象的字符串变量分别保存产生式的条件和结论，便于推理机的搜索、推理。
2. 推理机。推理机不断搜索规则库的规则，若事实库中包含了规则的条件，则采用该条规则，将该条规则的结论加入到事实库中，并为该条规则设定“已用”标志，下次搜索将跳过该条规则；若事实库中加入的事实在最终结论即动物类别的集合内，则停止搜索，该事实就是想要找的动物类别；若搜索完所有规则都找不到符合要求的规则以推出动物类别，则停止搜索，向用户反馈“无法识别此动物”的信息。
3. 事实库。事实库的数据结构十分简单，用一个字符串列表便可满足需求。


### 程序设计说明

* Main.java	主方法入口	Main方法	提供主方法入口，实现字符界面

* AnimalJudgeSystem.java	动物识别专家系统	AnimalJudgeSystem类	方法：

>> void loadRuleBase(String pathname) -- 加载规则库

>> void recognizeAnimal(String pathname, String method) -- 识别动物

String reasonMachine() -- 启动推理机

>> void displayRules() -- 显示规则库所有规则

>> void deleleRule() -- 删除单条规则

>> void insertRule() -- 插入单条规则

* RuleBase.java	规则库	RuleBase类	方法：

>> void insertRule() -- 插入单条规则

>> void insert() -- 插入单条规则

>> load(String pathname) -- 加载规则库

>> void delete() -- 删除单条规则

>> void display() -- 显示所有规则

* Rule.java	单条规则记录	Rule类	方法：

>> void addCondition(String condition) -- 添加前提条件

>> void setConclusion(String conclusion) -- 设定结论

>> ArrayList<String> getCondition() -- 获得条件集

>> String getConclusion() -- 获得结论

Rules.txt	保存规则的文本

