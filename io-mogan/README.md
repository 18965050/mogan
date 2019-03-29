* spring-boot-starter 服务化应用(非web应用), acturator不起作用, 不需要配置

* 集成Mybatis,Orika,Dubbo,Druid,Apollo等SpringBoot模块

* 使用ctrip-apollo实现配置管理. 如不依赖apollo,修改点如下:
  
  1. 使用`../support/no-apollo/application.properties`替换`src/main/resources/application.properties`
  2. 使用`../support/no-apollo/logback-spring.xml`替换`src/main/resources/logback-spring.xml`
  3. 删除`src/main/resources/META-INF/app.properties`文件
