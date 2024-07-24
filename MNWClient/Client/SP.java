

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.net.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SP extends javax.swing.JPanel{
	private JLabel lbl1,lbl2,lbl3;
	public SP(Socket socket){
		//setBackground(Color.white);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),""));

		//Date Code
		Date currDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd MMMM yyyy",Locale.getDefault());
		String date=sdf.format(currDate);
		Calendar today=Calendar.getInstance();
		String AM="AM";

		lbl1=new JLabel("Client Login Date :"+date+" Time :"+today.get(Calendar.HOUR)+":"+today.get(Calendar.MINUTE)+":"+today.get(Calendar.SECOND)+AM);
		lbl1.setFont(new Font("Arial",Font.BOLD,12));
		lbl1.setForeground(Color.red);
		add(lbl1,"West");
		try{
			lbl2=new JLabel("Server : "+socket.getInetAddress()+":" +" Port :"+ socket.getPort());
			lbl2.setFont(new Font("Arial",Font.BOLD,12));
			//lbl2.setForeground(Color.yellow);
			add(lbl2,"Center");
		}
		catch(Exception e){
			//SystemLogger.passException(e);
		}		
		lbl3=new JLabel();
		lbl3.setFont(new Font("Arial",Font.BOLD,12));
		lbl3.setForeground(Color.green);
		add(lbl3,"East");
		add();
	}
	private void add(){
		Timer t=new Timer(1000,new ActionListener(){
			private Date currDate1=new Date();
			private SimpleDateFormat sdf1=new SimpleDateFormat("dd MMMM yyyy",Locale.getDefault());
			private String date1=sdf1.format(currDate1);
			public void actionPerformed(ActionEvent objE){
				Calendar today=Calendar.getInstance();
				String AM="AM";
				if(today.get(Calendar.AM_PM)==1)
					AM="PM";
				lbl3.setText("Current Date :"+date1+" Time :"+today.get(Calendar.HOUR)+":"+today.get(Calendar.MINUTE)+":"+today.get(Calendar.SECOND)+AM);
			}
		});
		t.start();
	}
}
