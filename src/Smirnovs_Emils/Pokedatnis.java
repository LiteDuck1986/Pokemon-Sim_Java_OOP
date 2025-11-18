package Smirnovs_Emils;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pokedatnis {

	public static void main(String[] args) {
		
		// <========================= GUI ==================================>

		JFrame frame = new JFrame("Pokemon simulators");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // ============= CardLayout ==============
        CardLayout cardLayout = new CardLayout();
        JPanel galvenaisPanel = new JPanel(cardLayout);

        // ============= Paneļi ==============
        JPanel sakumsPanel = new JPanel(null);
        sakumsPanel.setBackground(Color.darkGray);

        JPanel trenetPanel = new JPanel(null);
        trenetPanel.setBackground(Color.black);
        
        JPanel PokemoniPanel = new JPanel(null);
        PokemoniPanel.setBackground(Color.gray);
        
     // =================== Dropdown ====================
        JLabel IzveleText = new JLabel("Izvēlies Pokemonu:");
        IzveleText.setForeground(Color.WHITE);
        IzveleText.setBounds(50, 30, 200, 30);
        PokemoniPanel.add(IzveleText);

        // Dropdown izveide
        JComboBox<String> pokemonDropdown = new JComboBox<>();
        pokemonDropdown.setBounds(50, 70, 200, 30);
        PokemoniPanel.add(pokemonDropdown);


        // ======== Informācijas labeļi ========
        JLabel infoVards = new JLabel("Vārds: ");
        infoVards.setForeground(Color.WHITE);
        infoVards.setBounds(300, 50, 300, 30);
        PokemoniPanel.add(infoVards);

        JLabel infoHP = new JLabel("HP: ");
        infoHP.setForeground(Color.WHITE);
        infoHP.setBounds(300, 80, 300, 30);
        PokemoniPanel.add(infoHP);

        JLabel infoDMG = new JLabel("Damage: ");
        infoDMG.setForeground(Color.WHITE);
        infoDMG.setBounds(300, 110, 300, 30);
        PokemoniPanel.add(infoDMG);

        JLabel infoDEF = new JLabel("Defense: ");
        infoDEF.setForeground(Color.WHITE);
        infoDEF.setBounds(300, 140, 300, 30);
        PokemoniPanel.add(infoDEF);

        JLabel infoLVL = new JLabel("Level: ");
        infoLVL.setForeground(Color.WHITE);
        infoLVL.setBounds(300, 170, 300, 30);
        PokemoniPanel.add(infoLVL);

        
        // ======== Pokemon bilde ========
        
        // Bildes izmēri
        int platums = 320, augstums = 322;
        
        JLabel pokemonBilde = new JLabel();
        pokemonBilde.setBounds(450, 40, platums, augstums);
        PokemoniPanel.add(pokemonBilde);


        // ============= PANEĻU SAVIENOJUMS ==============
        galvenaisPanel.add(sakumsPanel, "menu");
        galvenaisPanel.add(trenetPanel, "training");
        galvenaisPanel.add(PokemoniPanel, "pokemoni");

        // ============= POGA no Sākuma Paneļa -> Trenēšanās Paneļi ==============
        JButton TrenetPoga = new JButton("Trenēt pokemonu");
        TrenetPoga.setBounds(300, 125, 200, 50);
        sakumsPanel.add(TrenetPoga);
        
        TrenetPoga.addActionListener(e -> {
        	cardLayout.show(galvenaisPanel, "training");
        });
        
     // ============= POGA no Sākuma Paneļa -> Pokemoni Paneļi ==============
        JButton PokemoniPoga = new JButton("Mani pokemoni");
        PokemoniPoga.setBounds(300, 50, 200, 50);
        sakumsPanel.add(PokemoniPoga);

        PokemoniPoga.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "pokemoni");
        });

        // ============= POGA no Trenēt paneļa -> Sākuma paneli ==============
        JButton SakumaPoga = new JButton("Atpakaļ uz sākumu");
        SakumaPoga.setBounds(300, 400, 200, 50);
        trenetPanel.add(SakumaPoga);
        

        SakumaPoga.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "menu");
        });
        
        // ============= POGA no Pokemoni paneļa -> Sākuma paneli ==============
        JButton SakumaPoga2 = new JButton("Atpakaļ uz sākumu");
        SakumaPoga2.setBounds(300, 400, 200, 50);
        PokemoniPanel.add(SakumaPoga2);
        

        SakumaPoga2.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "menu");
        });
        
        frame.add(galvenaisPanel);
        frame.setVisible(true);
        
        
        
        // <===================================== LOĢIKA ====================================>
        
        ArrayList<Pokemons> Pokemoni = new ArrayList<>();

        Pokemons p1 = new ElektriskaisP(7, 20, 0, 5, 20, "Pikachu", "bildes/pikachu.png", "Elektrisks");
        Pokemons p2 = new UdensP(4, 32, 0, 8, 32, "Squirtle", "bildes/pikachu.png", "Ūdens");

        Pokemoni.add(p1);
        Pokemoni.add(p2);
        
        for (Pokemons p : Pokemoni) {
            pokemonDropdown.addItem(p.getVards());
        }
        
     // ============== DROPDOWN Pokemoni ====================
        pokemonDropdown.addActionListener(e -> {
            String izveletaisPokemons = (String)pokemonDropdown.getSelectedItem();

            for (Pokemons p : Pokemoni) {
                if (p.getVards().equals(izveletaisPokemons)) {

                    // Uzrāda informāciju par pokemonu
                    infoVards.setText("Vārds: " + p.getVards());
                    infoHP.setText("HP: " + p.getHP() + "/" + p.getMaxHP());
                    infoDMG.setText("Damage: " + p.getDamage());
                    infoDEF.setText("Defense: " + p.getDefense());
                    infoLVL.setText("Level: " + p.getLevel());

                    // Uzrāda attēlu, strādā arī ar JAR failu.
                    if (p.getBilde() != null) {
                        pokemonBilde.setIcon(new ImageIcon(Pokedatnis.class.getResource("/bildes/pikachu.png")));

                    } else {
                    	pokemonBilde.setIcon(null);
                    }
                }
            }
        });
        
        
        
    }
}