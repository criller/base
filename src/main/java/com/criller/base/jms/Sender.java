package com.criller.base.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: CaoCheng
 * @description:
 * @date: Created in 13:36 2018/1/23
 */
@Component
public class Sender implements CommandLineRunner{
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void run(String... strings) throws Exception {
        jmsTemplate.send("my-destination",new Msg());
    }
}
