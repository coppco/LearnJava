import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * 集群版SolrCloud
 */
public class TestSolrJCloud {

    @Test
    public void testSolrCloudAddDocument() throws Exception {
        //solr4.x.x版本使用CloudSolrServer ,solr5.x.x版本使用CloudSolrClient, 需要知道Zookeeper地址列表
        CloudSolrClient cloudSolrClient = new CloudSolrClient("192.168.1.184:2182,192.168.1.184:2183,192.168.1.184:2184");
        //设置默认collection
        cloudSolrClient.setDefaultCollection("iOS");
        //创建文档
        SolrInputDocument document = new SolrInputDocument();
        //向文档中添加域
        document.addField("id", "test001");
        //文档写入索引库
        cloudSolrClient.add(document);
        //提交
        cloudSolrClient.commit();
    }
}
