//Les autres imports 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InitCarnetDeSante extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JTextField age = new JTextField("");
	private JLabel label = new JLabel("age : ");

	private JTextField taille = new JTextField("");
	private JLabel label1 = new JLabel("taille : ");

	private JTextField poids = new JTextField("");
	private JLabel label2 = new JLabel("poids : ");

	private JTextField groupe_sanguin = new JTextField("");
	private JLabel label3 = new JLabel("Groupe sanguin : ");

	private JTextField code = new JTextField("");
	private JLabel label4 = new JLabel("CODE POSTAL : ");

	private JTextField ville = new JTextField("");
	private JLabel label5 = new JLabel("VILLE : ");

	private JTextField phone = new JTextField("");
	private JLabel label6 = new JLabel("TELEPHONE : ");

	private JButton b = new JButton("SOUMETTRE");

	public InitCarnetDeSante(String login) {

		apublic String getLogin()
		{return login;}
		
		this.setTitle("création du Carnet De Santé");
		this.setSize(200, 650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);


		JPanel top = new JPanel();

		Font police = new Font("Arial", Font.BOLD, 14);

		// age
		age.setFont(police);
		age.setPreferredSize(new Dimension(150, 30));
		age.setForeground(Color.BLUE);
		top.add(label);
		top.add(age);

		// taille
		taille.setFont(police);
		taille.setPreferredSize(new Dimension(150, 30));
		taille.setForeground(Color.BLUE);
		top.add(label1);
		top.add(taille);

		// poids
		poids.setFont(police);
		poids.setPreferredSize(new Dimension(150, 30));
		poids.setForeground(Color.BLUE);
		top.add(label2);
		top.add(poids);

		// Telephone
		phone.setFont(police);
		phone.setPreferredSize(new Dimension(150, 30));
		phone.setForeground(Color.BLUE);
		top.add(label6);
		top.add(phone);

		// groupe_sanguin
		groupe_sanguin.setFont(police);
		groupe_sanguin.setPreferredSize(new Dimension(150, 30));
		groupe_sanguin.setForeground(Color.BLUE);
		top.add(label3);
		top.add(groupe_sanguin);

		// Code postal
		code.setFont(police);
		code.setPreferredSize(new Dimension(150, 30));
		code.setForeground(Color.BLUE);
		top.add(label4);
		top.add(code);

		// Ville
		ville.setFont(police);
		ville.setPreferredSize(new Dimension(150, 30));
		ville.setForeground(Color.BLUE);
		top.add(label5);
		top.add(ville);
		top.add(b);
		b.addActionListener(new FieldGetter());

		this.setContentPane(top);
		this.setVisible(true);
	}

	class FieldGetter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String age1 = null;
			String taille1 = null;
			String poids1 = null;
			String groupe_sanguin1 = null;
			String code_postal = null;
			String ville1 = null;
			char[] password1 = null;
			String url_base="jdbc:mysql://localhost:3306/mydb";
			String user_base="root";
			String base_pwd="";

			System.out.println("je passe par la ");
			// recréation des fonctions isset pour verifier les saisies
			if (age.getText().length() == 0)
				JOptionPane.showMessageDialog(null, "Le Champ age est vide.",
						" Saisie Incomplète", JOptionPane.WARNING_MESSAGE);
			else
				age1 = age.getText();
			if (taille.getText().length() == 0)
				JOptionPane.showMessageDialog(null,
						"Le Champ taille est vide.", " Saisie Incomplète",
						JOptionPane.WARNING_MESSAGE);
			else
				taille1 = taille.getText();
			if (groupe_sanguin.getText().length() == 0)
				JOptionPane.showMessageDialog(null,
						"Le Champ groupe_sanguin est vide.", " Saisie Incomplète",
						JOptionPane.WARNING_MESSAGE);
			else
				groupe_sanguin1 = groupe_sanguin.getText();
			if (code.getText().length() == 0)
				JOptionPane.showMessageDialog(null,
						"Le Champ CODE POSTAL est vide.", " Saisie Incomplète",
						JOptionPane.WARNING_MESSAGE);
			else
				code_postal = code.getText();
			if (ville.getText().length() == 0)
				JOptionPane.showMessageDialog(null, "Le Champ VILLE est vide.",
						" Saisie Incomplète", JOptionPane.WARNING_MESSAGE);
			else
				ville1 = ville.getText();

			// si tout les champs sont saisis ET que un statut est choisi
			if ((age1.length() != 0 && taille1.length() != 0
					&& groupe_sanguin1.length() != 0 && code_postal.length() != 0
					&& ville1.length() != 0)) {
				// on prépare l'insertion en BDD
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection( url_base , user_base , base_pwd );
					Statement qui_est_ce = con.prepareStatement("select id from utilisateur where mail="+ login);
					//requete pour la recherche de statut utilisateur
					String requete = "INSERT INTO `carnet_sante` (`age`, `taille`, `poids`, `mot_de_passe`, `groupe_sanguin`, `telephone`, `statut_user`, `centre_medical_idcentre_medical`) VALUES('"
							+ age1
							+ "', '"
							+ taille1
							+ "', '"
							+ poids1
							+ "', '"
							+ groupe_sanguin1
							+ " - "
							+ code_postal
							+ " "
							+ ville1
							+ "', '0139929456', 1, 1)";
					Statement stmt = con.createStatement();
					stmt.executeUpdate(requete);
					System.out.println("insertion effectué avec succès");
				    SwingLogin s= new SwingLogin();
				    

				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("connexion erronnée");
				}

			} else
				JOptionPane.showMessageDialog(null,
						"Le Formulaire est incomplet.Vérifiez vos saisies",
						" Saisie Incomplète", JOptionPane.WARNING_MESSAGE);
		}
	}


}
