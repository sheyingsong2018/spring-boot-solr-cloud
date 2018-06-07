package io.ymq.solr.test;

import com.alibaba.fastjson.JSONObject;
import io.ymq.solr.FdcParamSummaryRepository;
import io.ymq.solr.YmqRepository;
import io.ymq.solr.pagehelper.PageInfo;
import io.ymq.solr.pagehelper.RowBounds;
import io.ymq.solr.po.FdcParamSummary;
import io.ymq.solr.po.Ymq;
import io.ymq.solr.run.Startup;
import io.ymq.solr.utils.BaseSolr;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;


/**
 * 描述: 测试 solr cloud
 *
 * @author yanpenglei
 * @create 2017-10-17 19:00
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
public class BaseTestSimp {

//    @Autowired
//    private YmqRepository ymqRepository;

    @Autowired
    private FdcParamSummaryRepository fdcParamSummaryRepository;

    @Autowired
    private CloudSolrClient cloudSolrClient;

    @Autowired
    private BaseSolr baseSolr;



    /**
     * 使用 cloudSolrClient 方式新增
     *
     * @throws Exception
     */
   // @Test
    public void testAddCloudSolrClient() throws IOException, SolrServerException {

       /* Ymq ymq = new Ymq();
        ymq.setId("3");
        ymq.setYmqTitle("penglei");
        ymq.setYmqUrl("www_ymq_io");
        ymq.setYmqContent("ymqContent");*/
       /* FdcParamSummary fdcParamSummary= new  FdcParamSummary();
        fdcParamSummary.setEvent_time("2017-10-10 04:03:34");
        fdcParamSummary.setId("001");
        fdcParamSummary.setGlassId("TAP541043");
        fdcParamSummary.setOperCode("1200");
        fdcParamSummary.setProductId("TB543830");

        cloudSolrClient.setDefaultCollection("m_fdc_param_summary_wide_id");
        cloudSolrClient.connect();

        cloudSolrClient.addBean(fdcParamSummary);
        cloudSolrClient.commit();*/
    }

    /**
     * SolrQuery 语法查询
     *
     * @throws Exception
     */
    @Test
    public void testYmqSolrQuery() throws Exception {

        SolrQuery query = new SolrQuery();

        String glassId = "TA820878BD18";

        query.setQuery(" glass_id:*" + glassId + "* ");

        cloudSolrClient.setDefaultCollection("m_fdc_param_summary_wide_id");
        cloudSolrClient.connect();
        QueryResponse response = cloudSolrClient.query(query);

        List<FdcParamSummary> list = response.getBeans(FdcParamSummary.class);

        for (FdcParamSummary item : list) {
            System.out.println("SolrQuery 语法查询响应 :" + JSONObject.toJSONString(item));
        }
    }





}
