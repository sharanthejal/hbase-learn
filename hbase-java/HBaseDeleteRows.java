package com.hbase.learn.dml;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseDeleteRows {

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

			Delete delete = new Delete(Bytes.toBytes("1"));

			// Adding only addColumn not deleting all versions of the specified columns
			// because of get call
			// professional :designation
			delete.addColumns(Bytes.toBytes("professional"), Bytes.toBytes("designation"));

			// professional:salary
			delete.addColumns(Bytes.toBytes("professional"), Bytes.toBytes("salary"));

			table.delete(delete);

			//Delete Column Family
			delete.addFamily(Bytes.toBytes("jaffa"));

			table.delete(delete);

		} finally {
			conn.close();
		}
	}

}
