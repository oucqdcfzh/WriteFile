package edu.cn.service;

import edu.cn.WriteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program WriteFileEx
 * @description:
 * @author:
 * @create:2019-09-23 09:19:46
 **/

@Component
public class WriteServiceImpl implements WriteService {
    @Value("${filepath}")
    private String path;
    private FileOutputStream fout=null;

    @PostConstruct
    public void init() {
        try {
            System.out.println(path);
            fout=new FileOutputStream(path);
            System.out.println("init");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(String content) {
        byte bytes[]=new byte[512];
        bytes=content.getBytes();
        int b=content.length();
        try {
            fout.write(bytes,0,b);
            System.out.println("write " + content );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PreDestroy
    public void destroy() {
        if(fout!=null){
            try {
                System.out.println("close");
                fout.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
