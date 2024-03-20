package top.sintang.test.scanner;

import org.junit.jupiter.api.Test;
import top.sintang.bhrpc.common.scanner.ClassScanner;
import top.sintang.bhrpc.common.scanner.reference.RpcReferenceScanner;
import top.sintang.bhrpc.common.scanner.server.RpcServiceScanner;

import java.util.List;
import java.util.Map;

/**
 * @author sintang
 * @date 2024/3/20 16:28
 **/
public class ScannerTest {
    /**
     * 扫描top.sintang.test.scanner包下所有的类
     */
    @Test
    public void testScannerClassNameList() throws Exception {
        List<String> classNameList = ClassScanner.getClassNameList("top.sintang.test.scanner");
        classNameList.forEach(System.out::println);

    }

    /**
     * 扫描top.sintang.test.scanner包下所有的类，并过滤出带有@RpcService注解的类
     * @throws Exception
     */
    @Test
    public void testScannerRpcService()throws Exception {
        Map<String, Object> stringObjectMap = RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService("top.sintang.test.scanner");
        stringObjectMap.entrySet().stream().forEach((e) -> {
            String key = e.getKey();
            Object value = e.getValue();
            System.out.println("key:"+key +"   " + "value:"+value);

        });
    }

    /**
     * 扫描top.sintang.test.scanner包下所有的类，并过滤出带有@RpcReference注解的类
     * @throws Exception
     */
    @Test
    public void testScannerRpcReference()throws Exception {
        Map<String, Object> stringObjectMap = RpcReferenceScanner.doScannerWithRpcReferenceAnnotationFilter("top.sintang.test.scanner");
    }
}
