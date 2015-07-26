import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class CreateUsers extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JPasswordField jPasswordField0;
	private JPasswordField jPasswordField1;
	private JTextField jTextField0;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JCheckBox jCheckBox0;
	private JTextField jTextField3;
	private JTextField jTextField5;
	private JTextField jTextField7;
	private JTextField jTextField6;
	private JLabel Numero;
	private JTextField jTextField4;
	private JComboBox type_voie;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	public CreateUsers() {
		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(0, 128, 128));
		setLayout(new GroupLayout());
		add(getJLabel3(), new Constraints(new Leading(19, 90, 10, 10), new Leading(198, 12, 10, 10)));
		add(getJLabel4(), new Constraints(new Leading(21, 12, 12), new Leading(235, 10, 10)));
		add(getJLabel2(), new Constraints(new Leading(21, 12, 12), new Leading(152, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(21, 12, 12), new Leading(112, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(21, 12, 12), new Leading(74, 10, 10)));
		add(getJPasswordField0(), new Constraints(new Leading(139, 132, 10, 10), new Leading(194, 12, 12)));
		add(getJPasswordField1(), new Constraints(new Leading(139, 132, 12, 12), new Leading(235, 12, 12)));
		add(getJTextField0(), new Constraints(new Leading(139, 132, 12, 12), new Leading(70, 12, 12)));
		add(getJTextField1(), new Constraints(new Leading(139, 132, 12, 12), new Leading(110, 12, 12)));
		add(getJTextField2(), new Constraints(new Leading(139, 132, 12, 12), new Leading(156, 12, 12)));
		add(getJLabel5(), new Constraints(new Leading(135, 10, 10), new Leading(24, 10, 10)));
		add(getJLabel6(), new Constraints(new Leading(591, 71, 10, 10), new Leading(24, 26, 10, 10)));
		add(getJCheckBox0(), new Constraints(new Leading(551, 10, 10), new Leading(301, 10, 10)));
		add(getJTextField3(), new Constraints(new Leading(552, 12, 12), new Leading(70, 12, 12)));
		add(getJTextField5(), new Constraints(new Leading(552, 12, 12), new Leading(160, 12, 12)));
		add(getJTextField7(), new Constraints(new Leading(549, 10, 10), new Leading(235, 12, 12)));
		add(getJTextField6(), new Constraints(new Leading(552, 12, 12), new Leading(192, 12, 12)));
		add(getJLabel8(), new Constraints(new Leading(469, 55, 10, 10), new Leading(66, 22, 10, 10)));
		add(getJTextField4(), new Constraints(new Leading(155, 165, 10, 10), new Leading(301, 18, 12, 12)));
		add(getType_voie(), new Constraints(new Leading(550, 207, 10, 10), new Leading(114, 34, 12, 12)));
		setSize(794, 497);
	}

	private JComboBox getType_voie() {
		if (type_voie == null) {
			type_voie = new JComboBox();
			type_voie.setModel(new DefaultComboBoxModel(new Object[] { "Allée", "Avenue", "Boulevard", "Chemin", "Esplanade", "Impasse", "Place", "Résidence",
					"Square", "Route", "Rue" }));
		}
		return type_voie;
	}

	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
		}
		return jTextField4;
	}

	private JLabel getJLabel8() {
		if (Numero == null) {
			Numero = new JLabel();
			Numero.setText("Numéro");
		}
		return Numero;
	}

	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setText("jTextField6");
		}
		return jTextField6;
	}

	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setText("jTextField7");
		}
		return jTextField7;
	}

	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setText("jTextField5");
		}
		return jTextField5;
	}

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setText("jTextField3");
		}
		return jTextField3;
	}

	private JCheckBox getJCheckBox0() {
		if (jCheckBox0 == null) {
			jCheckBox0 = new JCheckBox();
			jCheckBox0.setText("Patient");
		}
		return jCheckBox0;
	}

	private JLabel getJLabel7() {
		if (jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Numéro");
		}
		return jLabel7;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("Adresse");
		}
		return jLabel6;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setText("jTextField2");
		}
		return jTextField2;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("jTextField1");
		}
		return jTextField1;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			jTextField0.setText("jTextField0");
			jTextField0.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jTextField0ActionActionPerformed(event);
				}
			});
		}
		return jTextField0;
	}

	private JPasswordField getJPasswordField1() {
		if (jPasswordField1 == null) {
			jPasswordField1 = new JPasswordField();
			jPasswordField1.setText("jPasswordField1");
			jPasswordField1.setEchoChar('•');
		}
		return jPasswordField1;
	}

	private JPasswordField getJPasswordField0() {
		if (jPasswordField0 == null) {
			jPasswordField0 = new JPasswordField();
			jPasswordField0.setText("jPasswordField0");
			jPasswordField0.setEchoChar('•');
		}
		return jPasswordField0;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Nom");
		}
		return jLabel0;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Identité");
		}
		return jLabel5;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Confirmez ici");
		}
		return jLabel4;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Mot de Passe");
		}
		return jLabel3;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Email");
		}
		return jLabel2;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Prénom");
		}
		return jLabel1;
	}

	private void jTextField0ActionActionPerformed(ActionEvent event) {
	}



}
