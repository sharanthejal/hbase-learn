package com.hbase.learn.dml;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseScan {

	public static void main(String[] args) throws IOException {
		// Create Hadoop Configuration object using HbaseConfiguration
		Configuration conf = HBaseConfiguration.create();

		// Create Connection object using Connection factory and configuration object
		Connection conn = null;
		String tableName = "emp";
		try {
			conn = ConnectionFactory.createConnection(conf);

			// Instantiating HTable class
			Table table = conn.getTable(TableName.valueOf(tableName));

			Scan scan= new Scan();
			
			scan.addFamily(Bytes.toBytes("personal"));
			
			// Getting the scan result
			ResultScanner scanner= table.getScanner(scan);
			
			for(Result result=scanner.next(); result!=null; result= scanner.next())
			{
				System.out.println("Found row : " + result);
			}
			
		} finally {
			conn.close();
		}
	}

}
