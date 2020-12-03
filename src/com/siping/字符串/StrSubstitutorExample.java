package com.siping.字符串;

import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yang Xu
 * @date 2020/12/2 9:01
 * @description:
 */
public class StrSubstitutorExample {

    public static void main(String[] args) {
        String content ="";
        // 替换系统变量
        String systemProperties = StrSubstitutor.replaceSystemProperties(
                "You are running with java.version = ${java.version} and os.name = ${os.name}.");
        System.out.println(systemProperties);
        // 使用Map替换占位符
        Map valuesMap = new HashMap();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");
        String templateString = "The ${animal} jumped over the ${target}.";
        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        System.out.println(resolvedString);
        // 递归替换变量
        Map<String, Object> params = new HashMap();
        params.put("name", "${x}");
        params.put("x", "y");
        StrSubstitutor strSubstitutor = new StrSubstitutor(params);
        String hello2 = "${name}";
        System.out.println(strSubstitutor.replace(hello2));
        // 替换嵌套变量
        Map<String, Object> params2 = new HashMap();
        params2.put("jre-1.8", "java-version-1.8");
        params2.put("java.specification.version", "1.8");
        StrSubstitutor strSubstitutor2 = new StrSubstitutor(params2);

        strSubstitutor2.setEnableSubstitutionInVariables(true);
        System.out.println(strSubstitutor2.replace("${jre-${java.specification.version}}"));

        // 获取变量名
        String content2 = "恭喜${姓名}报名成功，请凭报名编号${DB:code.id}到现场参加活动${jre-${java.${specification.version}}}";
        String reg = "\\$\\{DB:(.+?)\\}";
        List<String> params3 = getParams(reg, content2);
        System.out.println(params3);
    }


    /**
     * 根据正则表达式获取文本中的变量名列表
     * @param pattern
     * @param content
     * @return
     */
    public static List<String> getParams(String pattern, String content) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);

        List<String> result = new ArrayList<>();
        while (m.find()) {
            result.add(m.group(1));
        }
        return result;
    }
}
