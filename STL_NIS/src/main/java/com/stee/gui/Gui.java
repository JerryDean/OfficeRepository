package com.stee.gui;

import com.stee.asm.configuration.LampBurningHour;
import com.stee.asm.configuration.Status;
import com.stee.controller.NisController;
import com.stee.db.Dao;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Gui extends JPanel {

	public static Integer a;
	static Table table = null;
	static JTable jTable = null;
	public static Map<String, Integer> map = new HashMap<String, Integer>();

	static int m = 0;// 定义多少行

	static JTextArea area;// 文本域

	static JTextField jt;
	static JTextField jt2;
	static JTextField jt3;
	static JTextField jt4;
	static JTextField jt1;

	public Gui() {

		// 创建JTabbedPane
		JTabbedPane tp = new JTabbedPane();

		// 第一个标签页
		JPanel jP = new JPanel();
		jP.setLayout(null);

		JPanel jPanel = new JPanel();
		Border titleBorder1 = BorderFactory
				.createTitledBorder("Realtime Feedback");
		jPanel.setBorder(titleBorder1);
		jPanel.setLayout(null);
		jPanel.setBounds(5, 10, 710, 160);

		JRadioButton b1 = new JRadioButton("OK");
		b1.setBounds(20, 74, 80, 25);
		jPanel.add(b1);

		JRadioButton b2 = new JRadioButton("Error");
		b2.setBounds(300, 74, 80, 25);
		jPanel.add(b2);

		JRadioButton b3 = new JRadioButton("Timeout");
		b3.setBounds(550, 74, 100, 25);
		jPanel.add(b3);

		b1.setFont(new Font("", Font.BOLD, 15));
		b2.setFont(new Font("", Font.BOLD, 15));
		b3.setFont(new Font("", Font.BOLD, 15));

		JPanel jPanel2 = new JPanel();
		Border titleBorder2 = BorderFactory
				.createTitledBorder("Calendar Profile Feedback");
		jPanel2.setBorder(titleBorder2);
		jPanel2.setLayout(null);
		jPanel2.setBounds(5, 190, 710, 160);

		JRadioButton b4 = new JRadioButton("OK");
		b4.setBounds(20, 74, 80, 25);
		jPanel2.add(b4);

		JRadioButton b5 = new JRadioButton("Error");
		b5.setBounds(300, 74, 80, 25);
		jPanel2.add(b5);

		JRadioButton b6 = new JRadioButton("Timeout");
		b6.setBounds(550, 74, 100, 25);
		jPanel2.add(b6);

		b4.setFont(new Font("", Font.BOLD, 15));
		b5.setFont(new Font("", Font.BOLD, 15));
		b6.setFont(new Font("", Font.BOLD, 15));

		JButton b7 = new JButton("Confirm");
		b7.setBounds(600, 370, 110, 30);

		ButtonGroup group = new ButtonGroup();
		group.add(b1);
		group.add(b2);
		group.add(b3);
		group.add(b4);
		group.add(b5);
		group.add(b6);

		JLabel label = new JLabel();
		label.setBounds(40, 400, 100, 30);

		jP.add(label);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 1;
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 2;
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 3;
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 4;
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 5;
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = 6;
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a == 1) {
					NisController.a = 200;
					Gui.addText("Realtime Feedback----------OK");
				}
				if (a == 2) {
					NisController.a = 500;
					Gui.addText("Realtime Feedback----------ERROE");
				}
				if (a == 3) {
					NisController.a = 400;
					Gui.addText("Realtime Feedback----------TimeOut");
				}
				if (a == 4) {
					NisController.b = 200;
					Gui.addText("Calendar Profile Feedback----------Ok");
				}
				if (a == 5) {
					NisController.b = 500;
					Gui.addText("Calendar Profile Feedback----------Error");
				}
				if (a == 6) {
					NisController.b = 400;
					Gui.addText("Calendar Profile Feedback----------TimeOut");
				}
			}
		});

		jP.add(jPanel);
		jP.add(jPanel2);
		jP.add(b7);
		tp.addTab("    Connection Simulator   ", jP);
		tp.setMnemonicAt(0, KeyEvent.VK_1);

		// 第二个标签页
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);

		JPanel jPanel3 = new JPanel();
		Border titleBorder3 = BorderFactory
				.createTitledBorder("Database-Configuration");
		jPanel3.setBorder(titleBorder3);
		jPanel3.setLayout(null);
		jPanel3.setBounds(1, 1, 720, 140);

		JLabel label2 = new JLabel("        IP :");
		label2.setBounds(20, 20, 100, 35);
		jPanel3.add(label2);
		jt = new JTextField();
		jt.setBounds(95, 25, 100, 35);

		jPanel3.add(jt);

		JLabel label3 = new JLabel("Port :");
		label3.setBounds(300, 25, 40, 35);
		jPanel3.add(label3);
		jt1 = new JTextField();
		jt1.setBounds(350, 25, 100, 35);
		jPanel3.add(jt1);

		JLabel label4 = new JLabel("Instance :");
		label4.setBounds(530, 25, 60, 35);
		jPanel3.add(label4);
		jt2 = new JTextField();
		jt2.setBounds(600, 25, 100, 35);
		jPanel3.add(jt2);

		JLabel label5 = new JLabel("UserName :");
		label5.setBounds(20, 80, 70, 35);
		jPanel3.add(label5);
		jt3 = new JTextField();
		jt3.setBounds(95, 80, 100, 35);
		jPanel3.add(jt3);

		JLabel label6 = new JLabel("Password :");
		label6.setBounds(280, 80, 100, 40);
		jPanel3.add(label6);
		jt4 = new JTextField();
		jt4.setBounds(350, 80, 100, 35);
		panel2.add(jt4);

		JButton jButton = new JButton("Load");
		jButton.setBounds(570, 80, 120, 35);
		panel2.add(jButton);

		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
				jTable.updateUI();
			}
		});

		table = new Table();
		jTable = new JTable(table);
		jTable.setRowHeight(40);// 设置表格高度

		JLabel jLabel = new JLabel(
				"*  BHT:BurningHour(Total)--IBH:InitialBourHour(H) --H(hour)");
		jLabel.setFont(new Font("", Font.ITALIC, 11));
		jLabel.setBounds(8, 150, 400, 15);

		JScrollPane js = new JScrollPane(jTable);
		js.setBounds(8, 170, 710, 250);
		js.setBackground(Color.black);

		panel2.add(jLabel);
		panel2.add(js);
		panel2.add(jPanel3);

		tp.addTab("       Burning Hour Simulator     ", panel2);
		tp.setFont(new Font("", Font.BOLD, 15));
		tp.setMnemonicAt(1, KeyEvent.VK_2);

		// 设置标签停放的位置，这里设置为上侧停放
		tp.setTabPlacement(JTabbedPane.TOP);

		JPanel jPanel4 = new JPanel();
		Border titleBorder4 = BorderFactory
				.createTitledBorder("Received data of request");
		jPanel4.setBorder(titleBorder4);
		jPanel4.setLayout(null);
		jPanel4.setBounds(5, 450, 720, 150);

		area = new JTextArea();
		area.setBounds(5, 20, 710, 125);
		JScrollPane jScrollPane = new JScrollPane(area);
		jScrollPane.setBounds(5, 20, 710, 125);
		jPanel4.add(jScrollPane);

		JFrame frame = new JFrame("NMS Interface Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(jPanel4);
		frame.add(tp);

		frame.pack();
		frame.setSize(750, 650);

		int windowWidth = frame.getWidth(); // 获得窗口宽
		int windowHeight = frame.getHeight(); // 获得窗口高
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width; // 获取屏幕的宽
		int screenHeight = screenSize.height; // 获取屏幕的高
		frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2
				- windowHeight / 2);// 设置窗口居中显示
		// 是否显示页面
		frame.setVisible(true);
	}

	// 给表格加数据
	public static void add() {
		String id = jt.getText();// id
		String port = jt1.getText();// port
		String instance = jt2.getText();// instance
		String userName = jt3.getText();
		String password = jt4.getText();
		String url = "jdbc:mysql://" + id + ":" + port + "/" + instance;

		Dao dao = new Dao(url, userName, password);
		List<LampBurningHour> li = new ArrayList<>();

		List<String> list = dao.id();
		for (String string : list) {
			LampBurningHour lamp = new LampBurningHour();
			int a = dao.id1(string);
			Status status = dao.mo(a);
			lamp.setId(string);
			lamp.setBurningHour(status.getBurningHour());
			lamp.setLampOn(status.isLampOn());
			lamp.setLifetime(100);
			li.add(lamp);
		}
		for (LampBurningHour lamp : li) {
			map.put(lamp.getId(), m);
			table.addRow(lamp);
			m++;
		} 
	}

	// 改变表单内容
	public static void change(LampBurningHour light, String time, Integer hour) {
		int cow = map.get(light.getId());
		System.out.println(cow);

		if (light.isLampOn() == true) {
			jTable.setValueAt("on", cow, 1);
			jTable.setValueAt(time, cow, 5);
			jTable.setValueAt(hour, cow, 3);
		} else {
			jTable.setValueAt("off", cow, 1);
			jTable.setValueAt(time, cow, 6);
			jTable.setValueAt(hour, cow, 4);
		}
	}

	// 获取开关和时间
	public static Status get(String Id) {
		int row = map.get(Id);
		int burnHour = (int) jTable.getValueAt(row, 4);
		boolean bool = false;
		if (jTable.getValueAt(row, 1).equals("on")) {
			bool = true;
		} else {
			bool = false;
		}
		Status status = new Status();
		status.setBurningHour(burnHour);
		status.setLampOn(bool);
		return status;
	}

	// 给文本域中加内容
	public static void addText(String string) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		area.append(format.format(date) + "\r" + "\n" + string + "\r" + "\n");
	}
}

// 表格类
class Table extends AbstractTableModel {

	private JPanel pane = null;
	private Vector TableData;// 用来存放表格数据的线性表
	private String[] Name = { "DeviceId", "Switch", "Lifetime(H)", "IBH(H)",
			"BHT(H)", "StartTime", "EndTime" };// 表单标题
	public Table() {
		TableData = new Vector();
	}
	public void addRow(LampBurningHour light) {
		Vector v = new Vector(4);
		v.add(0, light.getId());
		if (light.isLampOn() == true) {
			v.add(1, "on");
		} else {
			v.add(1, "off");
		}
		v.add(2, light.getLifetime());
		v.add(3, light.getBurningHour());
		v.add(4, light.getBurningHour()); // 燃烧后时间 (BTH)
		v.add(5, 0); // 开始时间
		v.add(6, 0); // 结束时间

		TableData.add(v);
	}

	public String getColumnName(int col) { // 返回列名，即表头
		return Name[col];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/**
	 * 使修改的内容生效
	 */
	public void setValueAt(Object value, int row, int col) {
		((Vector) TableData.get(row)).remove(col);
		((Vector) TableData.get(row)).add(col, value);
		this.fireTableCellUpdated(row, col);
	}

	public int getRowCount() {// 这里是告知表格应该有多少行
		return TableData.size();
	}

	public int getColumnCount() {// 告知列数
		return Name.length;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((Vector) TableData.get(rowIndex)).get(columnIndex);
	}
}
