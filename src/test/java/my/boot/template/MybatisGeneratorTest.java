package my.boot.template;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class MybatisGeneratorTest {

    @Test
    public void testSimple() {
        String property = System.getProperty("user.dir");
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/template", "root", "my-secret-pw")
            .globalConfig(
                builder -> {
                    builder
                        .author("Zhangcm") // 设置作者名
                        .outputDir(property + "/src/main/java")   //设置输出路径：项目的 java 目录下
                        .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
                        .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                        .enableSwagger()   //开启 swagger 模式
                        .disableOpenDir()   //禁止打开输出目录，默认打开
                        .build();
                }
            )
            .strategyConfig(builder -> {
                builder
                    .addInclude("user") // 需要生成的表名，多个表使用,分割
                    .entityBuilder() // entity配置
                    .enableLombok() // 开启lombok
                    .enableTableFieldAnnotation() // 开启字段注解
                    .controllerBuilder() // controller配置
                    .enableHyphenStyle() // 开启驼峰转连字符
                    .enableRestStyle() // 开启生成@RestController 控制器
                    .serviceBuilder() // service 配置
                    .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                    .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                    .build();
            }).packageConfig(builder -> {
                builder
                    .parent("my.boot.template") // 设置父包名
                    .entity("model.entity")   //pojo 实体类包名
                    .service("service") //Service 包名
                    .serviceImpl("service.impl") // ***ServiceImpl 包名
                    .mapper("mapper")   //Mapper 包名
                    .xml("mapper")   //Mapper XML 包名
                    .controller("controller") //Controller 包名
                    .pathInfo(Collections.singletonMap(OutputFile.xml,
                        property + "/src/main/resources/mapper")) //配置 mapper.xml 路径信息：项目的 resources 目录下
                    .build();
            })
            .templateEngine(new FreemarkerTemplateEngine())
            .execute();
    }
}
