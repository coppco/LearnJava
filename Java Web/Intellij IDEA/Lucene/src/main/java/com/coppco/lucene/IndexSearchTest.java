package com.coppco.lucene;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;

public class IndexSearchTest {

    /**
     * 搜索
     */
    @Test
    public void testIndexSearch() throws Exception {

        //创建分词器, 必须和创建时的分词器一样
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();

        //指定文件夹
        Directory directory = FSDirectory.open(new File("/Users/apple/Desktop/lucene"));

        //创建: 索引和文档的读取对象
        IndexReader indexReader = IndexReader.open(directory);

        //创建: 索引搜索对象
        IndexSearcher searcher = new IndexSearcher(indexReader);

        //创建查询对象, 第一个参数: 搜索域  第二个参数: 分词器
        QueryParser parser = new QueryParser("fileContext", analyzer);

        //查询语法: 域:关键字,  如果指定了搜索域则从该域中搜索, 没有指定从默认域搜索
        Query query = parser.parse("偶");

        //搜索:  第一个是参数, 第二个是显示多少条
        TopDocs topDocs = searcher.search(query, 10);

        System.out.println("=======count: " + topDocs.totalHits + "==========");


        for (ScoreDoc doc: topDocs.scoreDocs) {
            //获取ID
            int docId = doc.doc;
            //根据id获取文档
            Document document = indexReader.document(docId);

            //取出值
            System.out.println(document.get("fileName"));
            System.out.println(document.get("fileSize"));
            System.out.println(document.get("fileContext"));

            System.out.println("====================================");

        }
    }
}
