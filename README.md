# 学生社团网站开发

#### 介绍
2020/9/28

生产实习开发项目用。 

#### 软件架构
软件架构说明


<<<<< HEAD
#### 安装教程

1.  修改自己的maven 仓库为你自己电脑的 路径。不知道，就新建一个项目，看下路径
2.  选app下的作为运行。
3.  打包选择maven 打包 ，而不是idea 的打包

#### 使用说明

1. ![img](https://user-gold-cdn.xitu.io/2020/3/16/170e3cc1ccbe35ec?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

2. [SpringBoot图文教程16—SpringBoot 多模块开发「web」「打包](https://juejin.im/post/6844904094558060552)

3. 

   ​     *当我们的项目模块很多的时候，我们使用**Maven**管理项目非常方便，帮助我们管理构建、文档、报告、依赖、**scms**、发布、分发的方法。可以方便的编译代码、进行依赖管理、管理二进制库等等。*

   ​     *由于我们的模块很多，所以我们又抽象了一层，抽出一个**itoo-base-parent**来管理子项目的公共的依赖。为了项目的正确运行，必须让所有的子项目使用依赖项的统一版本，必须确保应用的各个项目的依赖项和版本一致，才能保证测试的和发布的是相同的结果。*

   ​    *在我们项目顶层的**POM**文件中，我们会看到**dependencyManagement**元素。通过它元素来管理**jar**包的版本，让子项目中引用一个依赖而不用显示的列出版本号。**Maven**会沿着父子层次向上走，直到找到一个拥有**dependencyManagement**元素的项目，然后它就会使用在这个**dependencyManagement**元素中指定的版本号。*

#### 参与贡献

1.  https://spring.io/[](https://spring.io/)
2.  [https://mybatis.org/mybatis-3/zh/index.html](https://mybatis.org/mybatis-3/zh/index.html)
3.  git 教程[https://www.yiibai.com/git/git_merge.html](https://www.yiibai.com/git/git_merge.html)
4.  idea 的iml 模块管理 
5.  maven 的模块管理
6.  Gradle的模块管理


#### 特技

1. 4、在模块中web依赖于service，在web中执行完clean和install之后，本地仓库也存在依赖，但是在service中进行install就会出现

   > Failed to execute goal on project ...: Could not resolve dependencies for project ...

   这样测 错误，最后发现原来是自己没有首先对父项目也就是interface-test项目进行clean和install ，

   5、**总结、在父项目下有的子项目在首次运行clean 和install前应该先运行父项目的clean和install**



   3. 使用maven打包而不是idea

2. git clone  -b docs https://gitee.com/mai-tao/Shetuankaif.git

3. 每个模块必须有一个包
=======
4.  新建 Pull Request

#### 时间

![image-20200929170114270](https://img.vim-cn.com/76/b3ec63d1e9a913818c7813b22981b87b2bcaf5.png)

### jenkinsfile 

docker 挂载 -v .m2文件目录。配置里面镜像maven 镜像

![image-20201006230404149](https://img.vim-cn.com/72/c772bbdf81745f9f1ab5c56587768aafca2a7b.png)
 
wercker

No MyBatis mapper was found in '[kunpeng]' package. Please check your configuration.

org.springframework.dao.DataIntegrityViolationException: 

k` FOREIGN KEY (`Nt_Author`) REFERENCES `admin` (`Ad_no`) ON DELETE RESTRICT ON UPDATE RESTRICT)



/*  user 有改动 ，你改回去就行。
java 转 kotlin 时会自动小写。
增加了jackjson 用于调试而已
如果有办法开户 spring内置的json debug信息 抛出 则不用第三方的也行
