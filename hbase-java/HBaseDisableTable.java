package com.hbase.learn.ddl.create;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class HBaseDisableTable {

	public static void main(String[] args) {
		// Create Hadoop Configuration object using HbaseConfiguration
		Configuration conf = HBaseConfiguration.create();

		// Create Connection object using Connection factory and configuration object
		Connection conn = null;
		String tableName = "emp";
		try {
			conn = ConnectionFactory.createConnection(conf);

			// Create Admin object for create, list, disable tables
			Admin admin = conn.getAdmin();
			boolean isDisabled = admin.isTableDisabled(TableName.valueOf(tableName));
			System.out.println(isDisabled);
			// Verifying weather the table is disabled

			if (!isDisabled) {
				admin.disableTable(TableName.valueOf(tableName));
				System.out.println("Table disabled");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
