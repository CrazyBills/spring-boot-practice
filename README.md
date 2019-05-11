# 项目简介
本项目是ecommerce系统的订单子系统，用于向用户展示产品并接受用户订单。

# 技术选型
Spring Boot、Gradle、MySQL、Junit 5、Rest Assured、Docker

# 本地构建
|功能|命令|备注|
| --- | --- | --- |
|生成IntelliJ工程|`./idea.sh`|自动打开IntelliJ|
|本地运行|`./run.sh`|监听5005调试端口|

# 领域对象
|领域对象|中文名|业务功能|
| --- | --- | --- |
|Product|产品|包含名称和价格|

# 测试策略
|测试类型|代码目录|测试内容|
| --- | --- | --- |
|单元测试|`src/test/java`|包含核心领域模型（包含领域对象和Factory类）的测试|
|组件测试|`src/componentTest/java`|用于测试一些核心的组件级对象，比如Repository|


# 编码实践
列出常用的公共的编码实践方式。

# FAQ