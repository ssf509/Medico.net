//Les autres imports 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
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

public class CreateUser extends JFrame {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton jr1 = new JRadioButton("Patient");
	private JRadioButton jr2 = new JRadioButton("Medecin");
	private JRadioButton jr3 = new JRadioButton("Pharmacien");

	private JTextField nom = new JTextField("");
	private JLabel label = new JLabel("NOM : ");

	private JTextField prenom = new JTextField("");
	private JLabel label1 = new JLabel("PRENOM : ");

	private JTextField email = new JTextField("");
	private JLabel label2 = new JLabel("EMAIL : ");

	private JPasswordField pass = new JPasswordField("");
	private JLabel labelx = new JLabel("MOT DE PASSE : ");

	private JTextField add = new JTextField("");
	private JLabel label3 = new JLabel("ADRESSE : ");

	private JTextField code = new JTextField("");
	private JLabel label4 = new JLabel("CODE POSTAL : ");

	private JTextField ville = new JTextField("");
	private JLabel label5 = new JLabel("VILLE : ");

	private JTextField phone = new JTextField("");
	private JLabel label6 = new JLabel("TELEPHONE : ");

	private JButton b = new JButton("SOUMETTRE");

	public CreateUser() {
		this.setTitle("CreateUser de renseignement");
		this.setSize(200, 650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		group.add(jr1);
		group.add(jr2);
		group.add(jr3);
		JPanel top = new JPanel();
		jr1.addActionListener((ActionListener) new StateListener());
		jr2.addActionListener(new StateListener());
		jr3.addActionListener(new StateListener());
		top.add(jr1);
		top.add(jr2);
		top.add(jr3);
		Font police = new Font("Arial", Font.BOLD, 14);

		// Nom
		nom.setFont(police);
		nom.setPreferredSize(new Dimension(150, 30));
		nom.setForeground(Color.BLUE);
		top.add(label);
		top.add(nom);

		// Prenom
		prenom.setFont(police);
		prenom.setPreferredSize(new Dimension(150, 30));
		prenom.setForeground(Color.BLUE);
		top.add(label1);
		top.add(prenom);

		// Email
		email.setFont(police);
		email.setPreferredSize(new Dimension(150, 30));
		email.setForeground(Color.BLUE);
		top.add(label2);
		top.add(email);

		// PassWord
		pass.setFont(police);
		pass.setPreferredSize(new Dimension(150, 30));
		pass.setForeground(Color.BLUE);
		top.add(labelx);
		top.add(pass);

		// Telephone
		phone.setFont(police);
		phone.setPreferredSize(new Dimension(150, 30));
		phone.setForeground(Color.BLUE);
		top.add(label6);
		top.add(phone);

		// Adresse
		add.setFont(police);
		add.setPreferredSize(new Dimension(150, 30));
		add.setForeground(Color.BLUE);
		top.add(label3);
		top.add(add);

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
			String nom1 = null;
			String prenom1 = null;
			String email1 = null;
			String adresse = null;
			String code_postal = null;
			String ville1 = null;
			char[] password1 = null;

			System.out.println("je passe par la ");
			// recréation des fonctions isset pour verifier les saisies
			if (nom.getText().length() == 0)
				JOptionPane.showMessageDialog(null, "Le Champ NOM est vide.",
						" Saisie Incomplète", JOptionPane.WARNING_MESSAGE);
			else
				nom1 = nom.getText();
			if (prenom.getText().length() == 0)
				JOptionPane.showMessageDialog(null,
						"Le Champ PRENOM est vide.", " Saisie Incomplète",
						JOptionPane.WARNING_MESSAGE);
			else
				prenom1 = prenom.getText();
			if (add.getText().length() == 0)
				JOptionPane.showMessageDialog(null,
						"Le Champ ADRESSE est vide.", " Saisie Incomplète",
						JOptionPane.WARNING_MESSAGE);
			else
				adresse = add.getText();
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
			if (pass.getPassword().length == 0)
				JOptionPane.showMessageDialog(null,
						"Le Champ MOT DE PASSE est vide.",
						" Saisie Incomplète", JOptionPane.WARNING_MESSAGE);
			else
				password1 = pass.getPassword();
			// si tout les champs sont saisis ET que un statut est choisi
			if ((nom1.length() != 0 && prenom1.length() != 0
					&& adresse.length() != 0 && code_postal.length() != 0
					&& ville1.length() != 0 && password1.length != 0)
					&& group.getSelection() != null) {
				// on prépare l'insertion en BDD
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/mydb", "root", "");
					String requete = "INSERT INTO `utilisateur` (`nom`, `prenom`, `mail`, `mot_de_passe`, `adresse`, `telephone`, `statut_user`, `centre_medical_idcentre_medical`) VALUES('"
							+ nom1
							+ "', '"
							+ prenom1
							+ "', '"
							+ email1
							+ "', '"
							+ password1.toString()
							+ "', '"
							+ adresse
							+ " - "
							+ code_postal
							+ " "
							+ ville1
							+ "', '0139929456', 1, 1)";
					Statement stmt = con.createStatement();
					stmt.executeUpdate(requete);
					System.out.println("insertion effectué avec succès");

				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println("connexion erronnée");
				}

			} else
				JOptionPane.showMessageDialog(null,
						"Le Formulaire est incomplet.Vérifiez vos saisies",
						" Saisie Incomplète", JOptionPane.WARNING_MESSAGE);
		}
	}

	class StateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Attribution des droits
			int droit = 0;
			System.out.println("source : "
					+ ((JRadioButton) e.getSource()).getText() + " - état : "
					+ ((JRadioButton) e.getSource()).isSelected());
			if (((JRadioButton) e.getSource()).isSelected())
				if (((JRadioButton) e.getSource()).getText() == "Medecin")
					droit = 2;
				else if (((JRadioButton) e.getSource()).getText() == "Pharmacien")
					droit = 3;
				else if (((JRadioButton) e.getSource()).getText() == "Patient")
					droit = 1;
			System.out.println(droit);

		}

	}

}
