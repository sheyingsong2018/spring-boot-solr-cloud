package io.ymq.solr.po;


import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * 描述: 映射的实体类必须有@ID主键
 *
 * @author yanpenglei
 * @create 2017-10-17 18:28
 **/
@SolrDocument(solrCoreName = "m_fdc_param_summary_wide_id")
public class FdcParamSummary implements Serializable {
    @Id
    @Field
    private String id;

    @Field
    private String product_id;

    @Field
    private String oper_code;

    @Field
    private String event_time;

    @Field
    private String glass_id;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getOper_code() {
        return oper_code;
    }

    public void setOper_code(String oper_code) {
        this.oper_code = oper_code;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getGlass_id() {
        return glass_id;
    }

    public void setGlass_id(String glass_id) {
        this.glass_id = glass_id;
    }







}
