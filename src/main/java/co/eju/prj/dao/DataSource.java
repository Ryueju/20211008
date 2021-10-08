package co.eju.prj.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//singletonŬ������ ����� ��
public class DataSource {
	
	private static DataSource dataSource = new DataSource();
	
	//�����ͺ��̽����� �ʿ��� �͵�
	private Connection conn;
	private String driver; //������ ����̹�
	private String url; 
	private String user;
	private String password;
	
	private DataSource() {
		dbconfig();
	} // �ܺο��� ������ �� ������ �����ڸ� private�����ڷ� �����
		
	public static DataSource GetInstance() {
		return dataSource;
	}
	
	private void dbconfig() { //������ ä���ֱ� ���� �޼ҵ� //�ܺ� properties������ �о ���� ������
		Properties properties = new Properties(); 
		String resource = getClass().getResource("/db.properties").getFile();
										//resources���Ͽ� �ִ� �� ���ڿ��θ������
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() { //dbconfig()�� ������Ѿ���
	
		try {
			Class.forName(driver); //ojdbc load
			conn = DriverManager.getConnection(url, user, password);
	//		System.out.println("DB 연결 성공!!");
		}	catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
				
		
	}
}
