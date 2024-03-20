package top.sintang.test.scanner.service.consumer.impl;

import org.springframework.stereotype.Component;
import top.sintang.bhrpc.annotation.RpcReference;
import top.sintang.test.scanner.service.consumer.ConsumerBusinessService;
import top.sintang.test.scanner.service.provider.DemoService;

/**
 * @author sintang
 * @date 2024/3/20 16:26
 **/

@Component
public class ConsumerBusinessServiceImpl implements ConsumerBusinessService {

    @RpcReference(
            registryType = "zookeeper",
            registryAddress = "127.0.0.1:2181",
            version = "1.0.0",
            group = "binghe"
    )
    private DemoService demoService;
}
