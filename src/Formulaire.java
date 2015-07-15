
	//Les autres imports 
	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

	public class Formulaire extends JFrame{
		  private ButtonGroup bg = new ButtonGroup();
		  private JPanel container = new JPanel();
		  private JRadioButton jr1 = new JRadioButton("Patient");
		  private JRadioButton jr2 = new JRadioButton("Medecin");
		  private JRadioButton jr3 = new JRadioButton("Pharmacien");
		  private JTextField nom = new JTextField("");
		  private JLabel label = new JLabel("NOM : ");
		  private JTextField prenom = new JTextField("");
		  private JLabel label1 = new JLabel("PRENOM : ");
		  private JTextField date = new JTextField("");
		  private JLabel label2 = new JLabel("DATE DE NAISSANCE : ");
		  private JTextField add = new JTextField("");
		  private JLabel label3 = new JLabel("ADRESSE : ");
		  private JTextField code = new JTextField("");
		  private JLabel label4 = new JLabel("CODE POSTAL : ");
		  private JTextField ville = new JTextField("");
		  private JLabel label5 = new JLabel("VILLE : ");
		  
		  private JButton b = new JButton ("SOUMETTRE");
		  
		  private JCheckBox check = new JCheckBox("Valider les conditions générales");
		  
		  public Formulaire(){
		    this.setTitle("Formulaire de renseignement");
		    this.setSize(500, 500);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    //container.setBackground(Color.white);
		    //container.setLayout(new BorderLayout());
		    JPanel top = new JPanel();
		    jr1.addActionListener((ActionListener) new StateListener());
		    jr2.addActionListener(new StateListener());
		    jr3.addActionListener(new StateListener());
		    top.add(jr1);
		    top.add(jr2);
		    top.add(jr3);
		    Font police = new Font("Arial", Font.BOLD, 14);
		    
		    // nom
		    nom.setFont(police);
		    nom.setPreferredSize(new Dimension(150, 30));
		    nom.setForeground(Color.BLUE);
		    top.add(label);
		    top.add(nom);
		    
		    //prenom
		    prenom.setFont(police);
		    prenom.setPreferredSize(new Dimension(150, 30));
		    prenom.setForeground(Color.BLUE);
		    top.add(label1);
		    top.add(prenom);
		    
		    //date de naissance
		    date.setFont(police);
		    date.setPreferredSize(new Dimension(150, 30));
		    date.setForeground(Color.BLUE);
		    top.add(label2);
		    top.add(date);
		    
		    //adresse
		    add.setFont(police);
		    add.setPreferredSize(new Dimension(150, 30));
		    add.setForeground(Color.BLUE);
		    top.add(label3);
		    top.add(add);
		    
		    //code postal
		    code.setFont(police);
		    code.setPreferredSize(new Dimension(150, 30));
		    code.setForeground(Color.BLUE);
		    top.add(label4);
		    top.add(code);
		    
		    //ville
		    ville.setFont(police);
		    ville.setPreferredSize(new Dimension(150, 30));
		    ville.setForeground(Color.BLUE);
		    top.add(label5);
		    top.add(ville);
		    top.add(check);
		    top.add(b);
		    
		    this.setContentPane(top);
		    this.setVisible(true);            
		  }       
		        
		  class StateListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		      System.out.println("source : " + ((JRadioButton)e.getSource()).getText() + " - état : " + ((JRadioButton)e.getSource()).isSelected());
		      
		      System.out.println("source : " + ((JCheckBox)e.getSource()).getText() + " - état : " + ((JCheckBox)e.getSource()).isSelected());
		      
		      
		      
		    }
		    }
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Formulaire f = new Formulaire();
			

		}

	}

