package com.hbase.learn.dml;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseGetData {

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

			// Create get object by giving specified row
			Get get = new Get(Bytes.toBytes("1"));

			Result rs = table.get(get);

			// Reading values from Result class object
			byte[] value = rs.getValue(Bytes.toBytes("personal"), Bytes.toBytes("name"));

			byte[] value1 = rs.getValue(Bytes.toBytes("personal"), Bytes.toBytes("city"));
			
			// Printing the values
			String name = Bytes.toString(value);
			String city = Bytes.toString(value1);

			System.out.println("name: " + name + " city: " + city);

		} finally {
			conn.close();
		}
	}

}
