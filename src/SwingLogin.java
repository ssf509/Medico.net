import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SwingLogin extends JFrame implements ActionListener {

	JLabel l1, l2, l3;
	JTextField tf1;
	JButton btn1,btn2;
	JPasswordField p1;
	SwingLogin()
	{
		setTitle("Connectez vous sur le service Medico");
		
		setSize(700, 300);
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
		btn2 = new JButton("S'inscrire");
		
		l1.setBounds(100, 30, 400, 30);
		l2.setBounds(80, 70, 200, 30);
		l3.setBounds(80, 110, 200, 30);
		tf1.setBounds(300, 70, 200, 30);
		p1.setBounds(300, 110, 200, 30);
		btn1.setBounds(150, 160, 100, 30);
		btn2.setBounds(300, 160, 100, 30);
		
		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(p1);
		add(btn1);
		add(btn2);
		setVisible(true);
		btn1.addActionListener(this);
		btn2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==btn1)
		showData();
		if (e.getSource()==btn2){
			this.dispose();
			CreateUser c= new CreateUser();

	}
	}
	public void showData()
	{
		JFrame f1 = new JFrame();
		JLabel l, l0;
		String user = "root";
		String str1 = tf1.getText();
		char[] p = p1.getPassword();
		String str2 = new String(p);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", user, "");
			// requete pour obtenir le prenom de l utilisateur
			PreparedStatement ps = con.prepareStatement("select prenom from utilisateur where mail=? and mot_de_passe=?");
			//requete pour la recherche de statut utilisateur
			PreparedStatement statut = con.prepareStatement("select statut_user from utilisateur where mail=? and mot_de_passe=?");
			System.out.println(ps);
			//on complete les requete avant de les executer
			ps.setString(1, str1);
			ps.setString(2, str2);
			statut.setString(1, str1);
			statut.setString(2, str2);
			
			System.out.println(statut);
			// on execute les requetes 
			ResultSet rs = ps.executeQuery();
			ResultSet pouvoir =statut.executeQuery();
			
			
			
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
				//gestion des droits;
				if(pouvoir.next()){
					int droit= pouvoir.getInt(1); //1= patient 2= medecin 3 = pharmacien
					if (droit==1)
					l.setText("Bienvenue monsieur ou madame" +  rs.getString(1));
					else if (droit == 2)
						l.setText("Bienvenue Docteur" +  rs.getString(1));
					else if (droit == 3 )
						l.setText("Bienvenue monsieur ou madame" +  rs.getString(1));

				//fi attribution des droits 
				} 
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