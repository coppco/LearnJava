package com.coppco.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IndexManagerTest {

    /**
     * 采集文件系统中的文档数据存入lucene中
     */
    @Test
    public void testIndexCreate() throws Exception {

        //Lucene的文档列表
        List<Document> documentList = new ArrayList<Document>();

        //数据文件路径
        File file = new File("/Users/apple/Desktop/百度云同步盘/学习视频/JAVA/JAVA28期/SSM框架/lucene_day01/参考资料/searchsource");

        //遍历
        if (file.exists() && file.listFiles().length > 0) {
            for (File subFile : file.listFiles()) {
                //文件名称
                String fileName = subFile.getName();
                //文件内容
                String fileContext = FileUtils.readFileToString(subFile, "utf-8");
                //文件大小
                Long fielSize = FileUtils.sizeOf(subFile);

                //文档对象
                Document document = new Document();
                /**
                 * 第一个参数: 域名
                 * 第二个参数: 域值
                 * 第三个参数: 是否存储
                 */
                /*
                TextField nameField = new TextField("fileName", fileName, Field.Store.YES);
                TextField contextField = new TextField("fileContext", fileContext, Field.Store.YES);
                TextField sizeField = new TextField("fileSize", fielSize.toString(), Field.Store.YES);
                */

                /** 名称
                 * 是否分词: 要, 因为要根据内容索引
                 * 是否索引: 要, 因为要根据名称搜索
                 * 是否存储: 要, 因为要显示
                 */
                TextField nameField = new TextField("fileName", fileName, Field.Store.YES);

                /** 内容
                 * 是否分词: 要, 因为要根据内容索引
                 * 是否索引: 要, 因为要根据名称搜索
                 * 是否存储: 都可以, 不存储document中没有
                 */
                TextField contextField = new TextField("fileContext", fileContext, Field.Store.NO);

                /** 大小
                 * 是否分词: 要, 数字要对比
                 * 是否索引: 要, 因为要根据大小搜索
                 * 是否存储: 要, 显示大小
                 */
                LongField sizeField = new LongField("fileSize", fielSize, Field.Store.YES);

                //将域存入document中
                document.add(nameField);
                document.add(contextField);
                document.add(sizeField);

                documentList.add(document);
            }

            //创建分词器, StandardAnalyzer标准分词器, 对英文支持很好, 中文是单字分词
            Analyzer analyzer = new SmartChineseAnalyzer();


            //存储目录
            Directory directory = FSDirectory.open(new File("/Users/apple/Desktop/lucene"));

            //创建写对象的初始化对象
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);

            //创建索引和文档写对象
            IndexWriter indexWriter = new IndexWriter(directory, config);

            for (Document doc : documentList) {
                //将文档加入到 索引和文档写对象中
                indexWriter.addDocument(doc);
            }

            //提交
            indexWriter.commit();

            //关流
            indexWriter.close();
        }
    }
}
