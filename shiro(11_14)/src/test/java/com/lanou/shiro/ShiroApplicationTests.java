package com.lanou.shiro;

import com.lanou.shiro.entity.TbItem;
import com.lanou.shiro.repository.ItemRepository;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {

    @Resource
    private ItemRepository itemRepository;

    @Resource
    private SolrClient solrClient;

    @Test
    public void contextLoads() throws IOException, SolrServerException {
//        delete();
//        insert();
//        update();
        List<TbItem> items = itemRepository.findAll();
        TbItem tbItem = itemRepository.findBySellPoint("卖点");
        System.out.println(tbItem);
        // 将数据放入到solr中
        solrClient.addBeans(items);
        solrClient.commit();
    }

    // 新增
    @Test
    public void insert() throws IOException, SolrServerException {
        TbItem tbItem = new TbItem();
        tbItem.setId(100088788888L);
        tbItem.setSellPoint("买点");
        tbItem.setTitle("标题");
        tbItem.setPrice(199L);
        tbItem.setNum(4L);
        tbItem.setBarcode("xxx");
        tbItem.setImage("uuuuuu");
        tbItem.setCid(8888L);
        tbItem.setStatus(6L);
        Date date = new Date();
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        itemRepository.save(tbItem);
        Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", tbItem.getId());
        doc.addField("title", tbItem.getTitle());
        doc.addField("sellPoint", tbItem.getSellPoint());
        docs.add(doc);
        solrClient.add(docs);
        solrClient.commit();
    }


    // 修改
    @Test
    public void update() throws IOException, SolrServerException {
        TbItem tbItem = new TbItem();
        tbItem.setId(149892054974616L);
        tbItem.setSellPoint("卖点");
        tbItem.setTitle("标题");
        itemRepository.update(tbItem.getId());
        Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", tbItem.getId());
        doc.addField("title", tbItem.getTitle());
        doc.addField("sellPoint", tbItem.getSellPoint());
        docs.add(doc);
        solrClient.add(docs);
        solrClient.commit();
    }


    // 删除
    @Test
    public void delete() throws IOException, SolrServerException {
        itemRepository.deleteById(149892054974616L);
        solrClient.deleteById("149892054974616");
        solrClient.commit();
    }


}
