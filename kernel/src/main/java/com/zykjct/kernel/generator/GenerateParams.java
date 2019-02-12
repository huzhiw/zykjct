package com.zykjct.kernel.generator;

import lombok.Data;

/**
 * @description:  代码生成参数类
 * @author: huzhiwen
 * @create: 2019-01-26 14:47
 **/

@Data
public class GenerateParams {
    //生成代码里，注释的作者
    private String author = "";

    //代码生成输出的目录，可为项目路径的相对路径
    private String outputDirectory = "";

    //jdbc驱动
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    //数据库连接地址
    private String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/zykjct?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC";

    //数据库账号
    private String jdbcUserName = "root";

    //数据库密码
    private String jdbcPassword = "root";

    //去掉表的前缀
    private String[] removeTablePrefix = {"t_"};

    //代码生成包含的表，可为空，为空默认生成所有
    private String[] includeTables;

    //代码生成的类的父包名称
    private String parentPackage = "";

    //service是否生成接口，这个根据自己项目情况决定
    private Boolean generatorInterface = false;
}
