package com.hbase.learn.ddl.create;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseDeleteColumnFamily {

	public static void main(String[] args) {
		// Create hadoop configuration object using HBaseConfiguration.create method
		Configuration conf = HBaseConfiguration.create();

		// create connection object from connection factory
		Connection conn = null;
		try {
			conn = ConnectionFactory.createConnection(conf);

			// Create Admin object using connection object
			Admin admin = conn.getAdmin();

			// Delete column Family
			admin.deleteColumn(TableName.valueOf("student"), Bytes.toBytes("college"));
			System.out.println("Column family deleted : "+ "college");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
