package com.criller.base.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: CaoCheng
 * @description:
 * @date: Created in 15:56 2018/1/23
 */
@Component
public class Receiver {
    @JmsListener(destination = "my-destination")
    public void receiverMessage(String message){
        System.out.println("接受到的消息："+message);
    }
}
