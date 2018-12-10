package com.lanou3g.demo;

import com.lanou3g.demo.entity.ItemEntity;
import com.lanou3g.demo.repository.ItemRepository;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private ItemRepository itemRepository;
    @Resource
    private SolrClient solrClient;
    @Test
    public void contextLoads() throws IOException, SolrServerException {
        List<ItemEntity> items = itemRepository.findAll();

        solrClient.addBeans(items);
        solrClient.commit();
    }

}
