import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * 单机版solr
 */
public class TestSolrJ {
    /**
     * 添加文档
     * @throws Exception
     */
    @Test
    public void TestAddDocument() throws Exception {
        SolrClient client = new HttpSolrClient("http://192.168.1.184:8181/solr/iOS");
        //2 创建一个文档对象SolrInputDocument对象。
        SolrInputDocument document = new SolrInputDocument();
        //3 向文档中添加域。必须有id域，域的名称必须在schema.xml中定义。
        document.addField("id", "test001");
        document.addField("item_title", "测试商品");
        document.addField("item_price", "199");
        //4 把文档添加到索引库中。
        client.add(document);
        //5 提交。
        client.commit();
    }

    @Test
    public void TestDeleteDocumentByID() throws Exception {
        SolrClient client = new HttpSolrClient("http://192.168.1.184:8181/solr/iOS");
        client.deleteById("test001");
        client.commit();
    }

    @Test
    public void TestDeleteDocumentByQuery() throws Exception {
        SolrClient client = new HttpSolrClient("http://192.168.1.184:8181/solr/iOS");
        client.deleteByQuery("id:test001");
        client.commit();
    }

    @Test
    public void TestQueryDocument() throws Exception{
        SolrClient client = new HttpSolrClient("http://192.168.1.184:8181/solr/iOS");

        //插件查询对象
        SolrQuery query = new SolrQuery();
        //设置查询条件、过滤条件, 分页条件等
        //query.setQuery("*:*");  //和下面等价
        query.setQuery("手机");
        //分页
        query.setStart(0);
        query.setRows(5);
        //默认搜索域
        query.set("df", "item_keywords");
        //分页
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em>");
        query.setHighlightSimplePost("</em>");

        //执行查询
        QueryResponse response = client.query(query);
        SolrDocumentList results = response.getResults();
        System.out.println(results.getNumFound());
        for (SolrDocument solr:results) {
            System.out.println(solr.get("item_title"));
        }
        System.out.println("高亮");
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

        for (Map.Entry<String, Map<String, List<String>>> value:highlighting.entrySet()) {
            System.out.println(value.getKey());

            for (Map.Entry<String, List<String>> value1:value.getValue().entrySet()) {
                System.out.println(value1.getKey());
                for (String str:value1.getValue()) {
                    System.out.println(str);
                }
            }
        }
    }

}
