package top.sintang.bhrpc.common.scanner.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.sintang.bhrpc.annotation.RpcService;
import top.sintang.bhrpc.common.scanner.ClassScanner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sintang
 * @RpcService注解扫描器
 */
public class RpcServiceScanner extends ClassScanner {
    private static final Logger logger = LoggerFactory.getLogger(RpcServiceScanner.class);

    /**
     * 扫描指定包下的类，并筛选使用@RpcService注解标注的类
     */
    public static Map<String, Object> doScannerWithRpcServiceAnnotationFilterAndRegistryService(String scanPackage) throws Exception{
        Map<String, Object> handlerMap = new HashMap<>();
        List<String> classNameList = getClassNameList(scanPackage);
        if (classNameList.isEmpty()){
            return handlerMap;
        }

        classNameList.stream().forEach((className) -> {
            try {
                Class<?> clazz = Class.forName(className);
                RpcService rpcService = clazz.getAnnotation(RpcService.class);
                if(null != rpcService){
                    // 优先使用interfaceClass, interfaceClass的name为空，再使用interfaceClassName
                    if(null != rpcService.interfaceClass()){
                        handlerMap.put(rpcService.interfaceClass().getName(), rpcService);
                    }else{
                        handlerMap.put(rpcService.interfaceClassName(), rpcService);
                    }

                    // TODO 后续逻辑向注册中心注册服务元数据，同时向handlerMap中记录标注了RpcService注解的类实例

                    logger.info("当前标注了@RpcService注解的类实例名称===>>> " + clazz.getName());
                    logger.info("@RpcService注解上标注的属性信息如下：");
                    logger.info("interfaceClass===>>> " + rpcService.interfaceClass().getName());
                    logger.info("interfaceClassName===>>> " + rpcService.interfaceClassName());
                    logger.info("version===>>> " + rpcService.version());
                    logger.info("group===>>> " + rpcService.group());


                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        return handlerMap;
    }
}
