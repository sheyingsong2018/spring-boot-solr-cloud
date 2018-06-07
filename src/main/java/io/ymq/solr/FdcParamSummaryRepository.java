package io.ymq.solr;

import io.ymq.solr.po.FdcParamSummary;
import io.ymq.solr.po.Ymq;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * 描述: 继承 SolrCrudRepository
 *
 * @author yanpenglei
 * @create 2017-10-18 10:34
 **/
public interface FdcParamSummaryRepository extends SolrCrudRepository<FdcParamSummary, String> {

    /**
     * 通过Glass ID 查询
     *
     * @param glassId
     * @return
     */
    @Query(" glass_id:*?0* ")
    public List<FdcParamSummary> findByQueryAnnotation(String glassId);
}
