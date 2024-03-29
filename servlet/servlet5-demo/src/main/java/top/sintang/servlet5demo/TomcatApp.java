package top.sintang.servlet5demo;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class TomcatApp {
    public static void main(String[] args) throws LifecycleException {
        // 启动Tomcat:
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        // 创建webapp 默认是/ ，也可以自定义contentPath
        Context ctx = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(
                new DirResourceSet(resources,
                        "/WEB-INF/classes",
                        new File("target/classes").getAbsolutePath(),
                        "/"));
        ctx.setResources(resources);
        tomcat.start();
        tomcat.getServer().await();
    }
}
