# 我的第一个SpringBoot学习项目

## 项目描述

这是一个基于 Spring Boot 的 Web 应用，主要用于管理部门和员工信息。它是我在学习 Spring Boot 阶段制作的练手小项目。

## 技术栈
**主要技术栈包括：**

- Spring Boot
- MyBatis
- Thymeleaf
- Druid
- 国际化（i18n）
- Bootstrap

## 项目结构

项目的主要目录结构如下：

- `springboot-033-build`: 项目的根目录。
- `src`：项目的源代码目录。
  - `main`：主要代码的存放目录。
    - `java`：Java代码文件的存放目录。
      - `com`：项目的基本包名。
        - `sq`：项目的子包。
          - `config`：存放配置类的包。
            - `DruidConfig.java`：Druid数据库连接池的配置类。
            - `LoginHandlerInterceptor.java`：登录拦截器配置类。
            - `MyLocalResolver.java`：本地区域解析器配置类。
            - `MyMvcConfig.java`：Spring MVC配置类。
          - `controller`：存放控制器类文件的包。
            - `DepartmentController.java`：部门控制器类。
            - `EmployeeController.java`：员工控制器类。
            - `LoginController.java`：登录控制器类。
          - `mapper`：存放MyBatis映射器接口的包。
            - `DepartmentMapper.java`：部门映射器接口。
            - `EmployeeMapper.java`：员工映射器接口。
          - `pojo`：存放各种POJO（Plain Old Java Object）类的包。
            - `Department.java`：部门POJO类。
            - `Employee.java`：员工POJO类。
    - `resources`：项目资源文件的存放目录。
      - `i18n`：国际化（Internationalization）资源文件的目录。
        - `Resource Bundle login`：用于支持登录功能的国际化资源包文件。
          - `login.properties`：英语版本的登录资源包。
          - `login en US.properties`：美国英语版本的登录资源包。
          - `login zh CN.properties`：简体中文版本的登录资源包。
      - `mapper`：MyBatis映射文件的存放目录。
        - `DepartmentMapper.xml`：部门映射器的XML配置文件。
        - `EmployeeMapper.xml`：员工映射器的XML配置文件。
      - `static`：静态资源文件的存放目录。
        - `Css`：CSS样式表文件的存放目录。
          - `css bootstrap.min.css`：Bootstrap样式表文件。
          - `css dashboard.css`：仪表板样式表文件。
          - `css signin.css`：登录页面的样式表文件。
        - `img`：包含图像文件的目录。
          - `bootstrap-solid.svg`：Bootstrap图标。
        - `js`：包含JavaScript文件的目录。
          - `bootstrap.min.js`：Bootstrap的JavaScript文件。
          - `Chart.min.js`：图表库的JavaScript文件。
          - `feather.min.js`：Feather图标库的JavaScript文件。
          - `jquery-3.2.1.slim.min.js`：jQuery库的JavaScript文件。
          - `popper.min.js`：Popper.js的JavaScript文件。
      - `favicon.ico`：网站的图标文件。
- `templates`：存放项目的模板文件，用于生成动态页面。

## 功能特点

**项目主要功能特点包括：**

- 用户登录和认证： 项目提供用户登录功能，包括登录页面和认证过程。用户可以输入凭证进行身份验证，并访问受保护的资源。
- 多语言支持： 项目支持国际化（i18n），具有多语言功能。用户可以在不同语言环境下访问应用程序。当前支持的语言包括英语和简体中文。
- 员工管理：项目允许用户执行员工信息的管理任务，包括创建新员工记录、更新员工信息、删除员工记录以及查询员工列表。
- 数据库访问：项目使用MyBatis作为持久层框架，通过映射器接口和XML配置文件与数据库进行交互。
- Web前端界面：使用Thymeleaf模板引擎生成动态Web页面

## 快速开始

### 步骤 1: 克隆项目

使用Git工具克隆项目到你的本地计算机。

   ```bash
   git clone https://github.com/yourusername/your-project.git
   ```

### 步骤 2: 配置数据库

打开`src/main/resources`目录下的配置文件`application.yml`，并配置数据库连接信息。根据项目中的`DruidConfig`配置类，你可能需要设置以下信息：

   - 数据库URL
   - 数据库用户名
   - 数据库密码

### 步骤 3: 启动项目

 进入项目目录,使用IDE（如idea打开项目）,启动Springboot033BuildApplication启动类来开启应用

### 步骤4: 访问项目

打开Web浏览器，访问 http://localhost:8080 查看项目。

## 贡献

非常欢迎你为这个项目做出贡献，并使其变得更好！如果你希望参与贡献，请按照以下步骤进行：

1. **Fork 项目：** 在项目页面右上角点击 "Fork" 按钮，创建你自己的分支。

2. **克隆项目：** 使用 `git` 命令从你的 GitHub 仓库中克隆项目到本地计算机。

   ```bash
   git clone https://github.com/yourusername/your-project.git
   ```

3. **创建分支：** 创建一个新的分支，以便你可以在上面工作。

   ```bash
   git checkout -b feature/your-feature
   ```

4. **进行修改：** 在你的分支上进行所需的修改和改进。确保遵循项目的编码规范和最佳实践。

5. **提交更改：** 将你的修改提交到你的分支上。

   ```bash
   git commit -m "描述你的修改"
   ```

6. **推送到远程：** 将你的分支上的修改推送到你的 GitHub 仓库。

   ```bash
   git push origin feature/your-feature
   ```

7. **提出 Pull Request：** 在项目的 GitHub 页面中，点击 "New Pull Request" 按钮，选择你的分支作为比较分支，然后提出 Pull Request。

8. **等待审核：** 项目维护者将审查你的 Pull Request，并在必要时提供反馈。请耐心等待。

9. **合并 Pull Request：** 一旦你的 Pull Request 被审查并获得批准，项目维护者将合并它。

10. **感谢贡献：** 你的贡献将成为项目的一部分，非常感谢你的参与！

请确保在贡献之前阅读项目的贡献准则和许可证信息，以确保你的贡献符合项目的规定。

## 许可证

本项目采用 Apache2.0 许可证进行开源。详细信息请参阅(LICENSE.md) 文件。
