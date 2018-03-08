package com.criller.base.demo;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ZK 客户端简单测试
 *
 * @author: CaoCheng
 * @description:
 * @date: Created in 11:01 2018/3/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleZkClientTest {
    @Value("base.zk.server.cc7")
    private String cc7;
    private static final String connectString = "10.211.55.7:2181,10.211.55.10:2181,10.211.55.17:2181";
    private static final int sessionTimeout = 2000;
    ZooKeeper zkClient = null;

    @Before
    public void init() throws Exception {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType() + "-----" + watchedEvent.getPath());
                try {
                    zkClient.getChildren("/", true);
                } catch (Exception e) {
                }
            }
        });
    }

    /**
     * 创建数据节点在ZK中
     *
     * @throws Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println(cc7);
        String nodeCreated = zkClient.create("/base", "one".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 获取znode数据
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }

        Thread.sleep(Long.MAX_VALUE);
    }
}
