package com.zykjct.order.util;

import com.zykjct.kernel.generator.GenerateParams;
import com.zykjct.kernel.generator.SimpleGenerator;

import java.io.File;

/**
 * @description:  DAO生成
 * @author: huzhiwen
 * @create: 2019-01-26 15:41
 **/

public class GeneratorUtils {

    public static void main(String[] args) {
        GenerateParams generateParams = new GenerateParams();
        generateParams.setAuthor("huzhiwen");
        generateParams.setOutputDirectory(System.getProperty("user.dir") + File.separator + "order" +  File.separator + "src" + File.separator + "main" + File.separator + "java");
        generateParams.setParentPackage("com.zykjct.order");
        generateParams.setIncludeTables(new String[] {"t_order"});
        SimpleGenerator.doGeneration(generateParams);

    }
}
