## 阿里巴巴java代码风格

#### 缩进：

    采用四个空格。
    
#### 变量命名：

* 成员变量、局部变量都统一使用lowerCamelCase风格，遵从驼峰形式。
    
* 常量命名全部大写，单词间用下划线隔开。
    
#### 每行最多字符数

* 单行字符数限制不超过  120个，超出需要换行，换行时遵循如下原则：

     * 第二行相对第一行缩进4个空格，从第三行开始，不再继续缩进，参考示例。
     
     * 运算符与下文一起换行。
     
     * 方法调用的点符号与下文一起换行。
     
     * 在多个参数超长，逗号后进行换行。
     
     * 在括号前不要换行。
    
#### 函数最大行数

* 函数最大行数尽量不超过一屏。

#### 函数、类命名

* 函数名统一使用lowerCamelCase风格，必须遵从驼峰形式。
    
* 类名使用UpperCamelCase风格，必须遵从驼峰形式，但以下情形例外：（领域模型的相关命名）DO / BO / DTO / VO等。
    
#### 常量

* 不允许出现任何魔法值（即未经定义的常量）直接出现在代码中。
    
* long或者Long初始赋值时，必须使用大写的L，不能是小写的l，小写容易跟数字1混淆，造成误解。
    
* 不要使用一个常量类维护所有常量，应该按常量功能进行归类，分开维护。如：缓存相关的常量放在类：CacheConsts下；系统配置相关的常量放在类：ConfigConsts下。
    
* 常量的复用层次有五层：跨应用共享常量、应用内共享常量、子工程内共享常量、包内共享常量、类内共享常量。
    
    * 跨应用共享常量：放置在二方库中，通常是client.jar中的constant目录下。
        
    * 应用内共享常量：放置在一方库的modules中的constant目录下。
        
    * 子工程内部共享常量：即在当前子工程的constant目录下。
        
    * 包内共享常量：即在当前包下单独的constant目录下。
        
    * 类内共享常量：直接在类内部private  static  final定义。
    
    * 如果变量值仅在一个范围内变化用Enum类。如果还带有名称之外的延伸属性，必须使用Enum类，
    
#### 空行规则

* 方法体内的执行语句组、变量的定义语句组、不同的业务逻辑之间或者不同的语义之间插入一个空行。相同业务逻辑和语义之间不需要插入空行。

#### 注释规则
* 类、类属性、类方法的注释必须使用Javadoc规范，使用/**内容*/格式，不得使用//xxx方式。
    
        说明：在IDE编辑窗口中，Javadoc方式会提示相关注释，生成Javadoc可以正确输出相应注释；在IDE中，工程调用方法时，不进入方法即可悬浮提示方法、参数、返回值的意义，提高阅读效率。
        
* 所有的抽象方法（包括接口中的方法）必须要用Javadoc注释、除了返回值、参数、异常说明外，还必须指出该方法做什么事情，实现什么功能。
    
        说明：对子类的实现要求，或者调用注意事项，请一并说明。
        
* 所有的类都必须添加创建者信息。
    
* 方法内部单行注释，在被注释语句上方另起一行，使用//注释。方法内部多行注释使用/* */注释，注意与代码对齐。
    
* 所有的枚举类型字段必须要有注释，说明每个数据项的用途。
    
* 与其“半吊子”英文来注释，不如用中文注释把问题说清楚。专有名词与关键字保持英文原文即可。
    
* 代码修改的同时，注释也要进行相应的修改，尤其是参数、返回值、异常、核心逻辑等的修改。
    
        说明：代码与注释更新不同步，就像路网与导航软件更新不同步一样，如果导航软件严重滞后，就失去了导航的意义。
        
* 注释掉的代码尽量要配合说明，而不是简单的注释掉。
    
        说明：代码被注释掉有两种可能性：
        
    * 后续会恢复此段代码逻辑。
        
    * 永久不用。
        
    * 前者如果没有备注信息，难以知晓注释动机。后者建议直接删掉（代码仓库保存了历史代码）。
        
* 对于注释的要求：
    
    * 能够准确反应设计思想和代码逻辑；
        
    * 能够描述业务含义，使别的程序员能够迅速了解到代码背后的信息。完全没有注释的大段代码对于阅读者形同天书，注释是给自己看的，即使隔很长时间，也能清晰理解当时的思路；注释也是给继任者看的，使其能够快速接替自己的工作。
        
    * 好的命名、代码结构是自解释的，注释力求精简准确、表达到位。避免出现注释的一个极端：过多过滥的注释，代码的逻辑一旦修改，修改注释是相当大的负担。
    
    * 特殊注释标记，请注明标记人与标记时间。注意及时处理这些标记，通过标记扫描，经常清理此类标记。线上故障有时候就是来源于这些标记处的代码。
    
        * 待办事宜（TODO）:（标记人，标记时间，[预计处理时间]）表示需要实现，但目前还未实现的功能。这实际上是一个Javadoc的标签，目前的Javadoc还没有实现，但已经被广泛使用。只能应用于类，接口和方法（因为它是一个Javadoc标签）。
        
        * 错误，不能工作（FIXME）:（标记人，标记时间，[预计处理时间]）在注释中用FIXME标记某代码是错误的，而且不能工作，需要及时纠正的情况。
        
#### 操作符前后空格

* 任何运算符左右必须加一个空格

#### 其他规则

* 枚举类名建议带上Enum后缀，枚举成员名称需要全大写，单词间用下划线隔开。

* 代码中的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束。
    
* 代码中的命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式

## W3C HTML5代码规范
#### HTML代码约定
* 文档类型声明位于HTML文档的第一行
* 使用小写元素名
* 所有HTML元素必须关闭
* 使用小写属性名
* 属性值推荐使用引号
* 图片属性通常需要包含alt属性
* 等号前后可以使用空格（少用空格）
* 避免一行代码过长
#### 空行和缩进
  * 不要无缘无故添加空行。
  * 为每个逻辑功能块添加空行，这样更易于阅读。
  * 缩进使用两个空格，不建议使用 TAB。
  * 比较短的代码间不要使用不必要的空行和缩进。
#### 其他
* 不推荐省略 html 和 body 标签。
* 使用简洁的语法来载入外部的脚本文件 ( type 属性不是必须的 )
* 使用小写文件名

## W3C JavaScript代码规范

#### 变量名

* 变量名推荐使用驼峰法来命名(camelCase)
* 变量名应该区分大小写，允许包含字母、数字、美元符号($)和下划线，但第一个字符不允许是数字，不允许包含空格和其他标点符号；
* 变量命名长度应该尽可能的短，并抓住要点，尽量在变量名中体现出值的类型；
* 变量名的命名应该是有意义的；
* 变量名不能为JavaScript中的关键词、保留字全名；
* 变量名命名方法常见的有匈牙利命名法、驼峰命名法和帕斯卡命名法。
#### 空格与运算符
  * 通常运算符 ( = + - * / ) 前后需要添加空格；
#### 代码缩进
* 通常使用 4 个空格符号来缩进代码块：
#### 复杂语句的通用规则
* 将左花括号放在第一行的结尾。
* 左花括号前添加一空格。
* 将右花括号独立放在一行。
* 不要以分号结束一个复杂的声明。
#### 其他
 * 每行代码字符小于 80
 * 一条语句通常以分号作为结束符。

