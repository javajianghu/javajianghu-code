package top.sintang.test.scanner.service.provider.impl;

import top.sintang.bhrpc.annotation.RpcService;
import top.sintang.test.scanner.service.provider.DemoService;

/**
 * @author sintang
 * @date 2024/3/20 15:34
 **/
@RpcService(
        interfaceClass = DemoService.class,
        interfaceClassName = "top.sintang.test.scanner.service.provider.DemoService",
        version = "1.0.0",
        group = "binghe"
)
public class ProviderDemoServiceImpl implements DemoService {
}
