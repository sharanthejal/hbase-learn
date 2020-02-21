package com.hbase.learn.ddl.create;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class HbaseListTables {

	public static void main(String[] args) throws IOException {

		Configuration conf = HBaseConfiguration.create();

		// HBaseAdmin admin = new HBaseAdmin(conf);

		/*
		 * use the below code instead iof HbaseAdmin as it is deprecated
		 */
		Connection conn = null;
		try {
			conn = ConnectionFactory.createConnection(conf);

			Admin admin = conn.getAdmin();

			// Admin admin1= new Admin(conf);

			// getting the list of tables using HBaseAdmin object
			HTableDescriptor[] tableDescriptor = admin.listTables();

			for (int i = 0; i < tableDescriptor.length; i++) {
				System.out.println(tableDescriptor[i].getNameAsString());
			}
		} finally {
			conn.close();
		}
	}

}
