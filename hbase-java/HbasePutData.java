package com.hbase.learn.dml;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class HbasePutData {

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

			// Instantiating Put class accepts a row name.
			Put put = new Put(Bytes.toBytes("row1"));

			// adding values using addColumn() method
			// accepts column family name, qualifier/row name ,value
			put.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"), Bytes.toBytes("Rocky"));

			put.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("city"), Bytes.toBytes("hyderabad"));
			
			put.addColumn(Bytes.toBytes("professional"), Bytes.toBytes("designation"), Bytes.toBytes("RockStar"));

			put.addColumn(Bytes.toBytes("professional"), Bytes.toBytes("salary"), Bytes.toBytes("8500008"));
			
			// Saving the put Instance to the HTable.
			table.put(put);
			
			System.out.println("data inserted");
		} finally {
			conn.close();
		}
	}

}
