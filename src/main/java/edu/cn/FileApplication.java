package edu.cn;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program WriteFileEx
 * @description:
 * @author:
 * @create:2019-09-23 09:25:33
 **/

@Component
public class FileApplication {

    @Resource
    private WriteService writeService;

    public void service(String content){
        writeService.write(content);

    }
}
