# mybatisPlusGenerator
mybatisPlus 代码生成器 生成增删改查

减少重复的增删改查工作

项目集成了swagger2 和 mybatisPlus  

接口采用 restful 

可以复制 /templates/ 文件夹下的文件到/src/main/resources/templates/下

对应不同的 Freemarker 模版文件进行灵活配置

项目中的文件是生成 增删改查 功能的模版

生成后增加请求路径就可以对单表进行  插入 修改 删除 分页查询等操作

# 使用方式
更改数据库连接  
运行Generator 类

输入包名
输入表名

自动生成相关文件

调用 增删改查方法
