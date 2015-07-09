import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SwingLogin extends JFrame implements ActionListener {

	JLabel l1, l2, l3;
	JTextField tf1;
	JButton btn1;
	JPasswordField p1;
	SwingLogin()
	{
		setTitle("Connectez vous sur le service Medico");
		
		setSize(600, 300);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1 = new JLabel("Connectez vous sur le service Medico:");
		l1.setForeground(Color.orange);
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
		l2 = new JLabel("Enter Email:");
		l3 = new JLabel("Enter Password:");
		tf1 = new JTextField();
		p1 = new JPasswordField();
		btn1 = new JButton("Valider");
		
		l1.setBounds(100, 30, 400, 30);
		l2.setBounds(80, 70, 200, 30);
		l3.setBounds(80, 110, 200, 30);
		tf1.setBounds(300, 70, 200, 30);
		p1.setBounds(300, 110, 200, 30);
		btn1.setBounds(150, 160, 100, 30);

		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(p1);
		add(btn1);
		setVisible(true);
		btn1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		showData();
	}

	public void showData()
	{
		JFrame f1 = new JFrame();
		JLabel l, l0;
		String user = "root";
		String str1 = tf1.getText();
		char[] p = p1.getPassword();
		String str2 = new String(p);
		boolean is_patient = false;
		boolean is_medecin = false;
		boolean is_pharmacie = false;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", user, "");
			PreparedStatement ps = con.prepareStatement("select prenom from utilisateur where mail=? and mot_de_passe=?");
            // ici j'aurai aimé preparer la requete pour lire mes bool dans ma BDD
			
			ps.setString(1, str1);
			ps.setString(2, str2);
/*
			statut.setBoolean(1, is_patient);
			statut.setBoolean(2, is_medecin);
			statut.setBoolean(3, is_pharmacie);
			*/
			ResultSet rs = ps.executeQuery();
			PreparedStatement statut = con.prepareStatement("select is_patient, is_medecin, is_pharmacie from utilisateur where mail=? and mot_de_passe=?");
			
			
			 
			
			if (rs.next())
			{
				f1.setVisible(true);
				f1.setSize(600, 300);
				f1.setLayout(null);
				l = new JLabel();
				l0 = new JLabel("Vous êtes bien connecté...");
				l0.setForeground(Color.blue);
				l0.setFont(new Font("Calibri", Font.BOLD, 30));
				l.setBounds(60, 50, 400, 30);
				l0.setBounds(60, 100, 400, 40);
				f1.add(l);
				f1.add(l0);
				//l.setText("Bienvenue " + rs.getString(1));
				//gestion des droits
				ResultSet askstatut = statut.executeQuery();
				System.out.println(askstatut.getBoolean("is_medecin")); 
				is_patient = askstatut.getBoolean(1);
				is_medecin = askstatut.getBoolean(2);
				is_pharmacie = askstatut.getBoolean(3);
				System.out.printf("%d %d %d",is_patient, is_medecin, is_pharmacie);
				//fi attribution des droits 
				//test 
				if(is_medecin)
					l.setText("Bienvenue Docteur" + rs.getString(1));
				else if(is_patient)
					l.setText("Bienvenue Cher Patient" + rs.getString(1));
				else if (is_pharmacie)
					l.setText("Bienvenue Mr le Pharmacien" + rs.getString(1));
				else 
					l.setText("Il y a un problème avec vos droits.Contactez un Admin" + rs.getString(1));
				f1.add(l);
				l.setForeground(Color.red);
				
				l.setFont(new Font("Calibri", Font.BOLD, 30));
	
			} else
			{
				JOptionPane.showMessageDialog(null,"email ou mot de passe erroné ... Corrigez vos saisies");
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
 	public static void main(String args[])
	{
		new SwingLogin();
	}
}