package top.sintang.bhrpc.common.scanner.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.sintang.bhrpc.annotation.RpcReference;
import top.sintang.bhrpc.common.scanner.ClassScanner;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @RpcReference注解扫描器
 * @author sintang
 * @date 2024/3/20 14:20
 **/
public class RpcReferenceScanner extends ClassScanner {
    private static final Logger logger = LoggerFactory.getLogger(RpcReferenceScanner.class);

    /**
     * 扫描指定包下的类，并筛选使用@RpcService注解标注的类
     */
    public static Map<String, Object> doScannerWithRpcReferenceAnnotationFilter(String scanPackage) throws Exception{
        Map<String, Object> handlerMap = new HashMap<>();
        List<String> classNameList = getClassNameList(scanPackage);
        if (classNameList == null || classNameList.isEmpty()) {
            return handlerMap;
        }

        classNameList.stream().forEach((className) -> {
            try {
                Class<?> clazz = Class.forName(className);

                Field[] fields = clazz.getDeclaredFields();
                Arrays.stream(fields).forEach((field -> {
                    RpcReference rpcReference = field.getAnnotation(RpcReference.class);
                    if(null != rpcReference){

                        //TODO 处理后续逻辑，将@RpcReference注解标注的接口引用代理对象，放入全局缓存中
                        logger.info("当前标注了@RpcReference注解的字段名称===>>> " + field.getName());
                        logger.info("当前标注了@RpcReference注解的字段类型===>>> " + field.getType().getName());
                        logger.info("@RpcReference注解上标注的属性信息如下：");
                        logger.info("version===>>> " + rpcReference.version());
                        logger.info("group===>>> " + rpcReference.group());
                        logger.info("registryType===>>> " + rpcReference.registryType());
                        logger.info("registryAddress===>>> " + rpcReference.registryAddress());

                    }
                }));

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        return handlerMap;
    }
}
