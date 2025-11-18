package Smirnovs_Emils;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
	
	static Random rand = new Random();

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
        
        JPanel NokertPanel = new JPanel(null);
        NokertPanel.setBackground(Color.darkGray);
        
     // =================== Dropdown ====================
        JLabel IzveleText = new JLabel("Izvēlies Pokemonu:");
        IzveleText.setForeground(Color.WHITE);
        IzveleText.setBounds(50, 30, 200, 30);
        PokemoniPanel.add(IzveleText);

        // Dropdown izveide
        JComboBox<String> pokemonDropdown = new JComboBox<>();
        pokemonDropdown.setBounds(50, 70, 200, 30);
        PokemoniPanel.add(pokemonDropdown);


        // ======== LABEĻI ========
        
        // Pokemonu informacija
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
        
        // Noķert paneļa labeļi
        JLabel nokerts = new JLabel("Tu noķēri: ");
        nokerts.setForeground(Color.WHITE);
        nokerts.setBounds(345, 225, 300, 30);
        NokertPanel.add(nokerts);
        nokerts.setVisible(false);
        
        // ======== Pokemon bildes ========
        
        // Bildes izmēri
        int platums = 320, augstums = 322;
        
        JLabel pokemonBilde = new JLabel();
        pokemonBilde.setBounds(450, 40, platums, augstums);
        PokemoniPanel.add(pokemonBilde);
        
        JLabel nokertBilde = new JLabel();
        nokertBilde.setBounds(325, -10, platums, augstums);
        NokertPanel.add(nokertBilde);
        nokertBilde.setVisible(false);


        // ============= PANEĻU SAVIENOJUMS ==============
        galvenaisPanel.add(sakumsPanel, "sakums");
        galvenaisPanel.add(trenetPanel, "trenesanas");
        galvenaisPanel.add(PokemoniPanel, "pokemoni");
        galvenaisPanel.add(NokertPanel, "nokert");
        
        
        
     // ============= POGA Izveide ==============
        JButton NokertPoga = new JButton("Noķert");
        NokertPoga.setBounds(300, 200, 200, 50);
        NokertPanel.add(NokertPoga);
        
        
        JButton OkPoga = new JButton("OK");
        OkPoga.setBounds(365, 250, 65, 25);
        NokertPanel.add(OkPoga);
        OkPoga.setVisible(false);
        
        
        JButton NokertPanelPoga = new JButton("Noķert pokemonus");
        NokertPanelPoga.setBounds(300, 125, 200, 50);
        sakumsPanel.add(NokertPanelPoga);
        
       
        JButton TrenetPoga = new JButton("Trenēt pokemonu");
        TrenetPoga.setBounds(300, 200, 200, 50);
        sakumsPanel.add(TrenetPoga);
        
        
        JButton PokemoniPoga = new JButton("Mani pokemoni");
        PokemoniPoga.setBounds(300, 275, 200, 50);
        sakumsPanel.add(PokemoniPoga);

        
        JButton SakumaPoga = new JButton("Atpakaļ uz sākumu");
        SakumaPoga.setBounds(300, 400, 200, 50);
        trenetPanel.add(SakumaPoga);
        

        
        JButton SakumaPoga2 = new JButton("Atpakaļ uz sākumu");
        SakumaPoga2.setBounds(300, 400, 200, 50);
        PokemoniPanel.add(SakumaPoga2);
        
        
        JButton SakumaPoga3 = new JButton("Atpakaļ uz sākumu");
        SakumaPoga3.setBounds(300, 400, 200, 50);
        NokertPanel.add(SakumaPoga3);

        
        
        frame.add(galvenaisPanel);
        frame.setVisible(true);
        
        
        
        // <===================================== LOĢIKA ====================================>
        
        ArrayList<Pokemons> Pokemoni = new ArrayList<>();
        // Visi iespējamie pokemoni ko var noķert
        ArrayList<Pokemons> visiIespPokemoni = new ArrayList<>();
        visiIespPokemoni.add(new UdensP(4, 32, 0, 8, 32, "Squirtle", "/bildes/squirtle.png", "Ūdens"));
        visiIespPokemoni.add(new ElektriskaisP(10, 25, 0, 6, 25, "Electabuzz", "/bildes/electabuzz.png", "Elektrisks"));


        Pokemons sakumaPokemons = new ElektriskaisP(7, 20, 0, 5, 20, "Pikachu", "/bildes/pikachu.png", "Elektrisks");

        Pokemoni.add(sakumaPokemons);     
        
        
        // ======== POGAS LOĢIKA =========
        
        NokertPoga.addActionListener(e -> {
        	
        	Pokemons p = Catch(visiIespPokemoni);
        	
        	if (p == null) {  	
        	// Ja vairs nav pokemonu
            if (visiIespPokemoni.isEmpty()) {
                nokerts.setText("Visi pokemoni ir noķerti!");
            } else {
                nokerts.setText("Pokemons izspruka!"); // 50% ja pokemons izspruka
            }
            nokerts.setVisible(true);
            OkPoga.setVisible(true);
            NokertPoga.setVisible(false);
            return;
        }
        	
        	// Ja pokemons noķerts
        	Pokemoni.add(p);
        	pokemonDropdown.addItem(p.getVards());
            
            nokerts.setText("Tu noķēri: " + p.getVards());
            nokerts.setVisible(true);
            
            if (p.getBilde() != null) {
                ImageIcon bilde = new ImageIcon(Pokedatnis.class.getResource(p.getBilde()));
                Image scaled = bilde.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                nokertBilde.setIcon(new ImageIcon(scaled));
                nokertBilde.setVisible(true);
            } else {
            	pokemonBilde.setIcon(null);
            }
            
            OkPoga.setVisible(true);
            NokertPoga.setVisible(false);
            });

        
        OkPoga.addActionListener(e -> {
        	nokertBilde.setVisible(false);
        	NokertPoga.setVisible(true);
        	nokerts.setVisible(false);
        	OkPoga.setVisible(false);
        	
        });
        
        NokertPanelPoga.addActionListener(e -> {
        	cardLayout.show(galvenaisPanel, "nokert");
        });
        
        TrenetPoga.addActionListener(e -> {
        	cardLayout.show(galvenaisPanel, "training");
        });
        
        PokemoniPoga.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "pokemoni");
        });
        
        SakumaPoga.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "menu");
        });
        
        SakumaPoga2.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "menu");
        });
        
        SakumaPoga3.addActionListener(e -> {
        	NokertPoga.setVisible(true);
        	nokerts.setVisible(false);
        	OkPoga.setVisible(false);
        	nokertBilde.setVisible(false);
        	
            cardLayout.show(galvenaisPanel, "menu");
        });
          
        
        
        for (Pokemons p : Pokemoni) {
            pokemonDropdown.addItem(p.getVards());
        }
        
     // ================ DROPDOWN Pokemoni ====================
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
                        pokemonBilde.setIcon(new ImageIcon(Pokedatnis.class.getResource(p.getBilde())));

                    } else {
                    	pokemonBilde.setIcon(null);
                    }
                }
            }
        });
        
        
        
    }
	
	// ============================= Metodes ===================================
	
	public static Pokemons Catch(ArrayList<Pokemons> visiIesp) {

	    // 50% iespēja ka pokemons netiks noķerts
	    if (rand.nextInt(2) == 0) {
	        return null;
	    }

	    // Ja vairs nav pokemonu tad null
	    if (visiIesp.isEmpty()) {
	        return null; 
	    }

	    // Random pokemons no visiem Iespējamiem
	    int randomPokemons = rand.nextInt(visiIesp.size());

	    Pokemons p = visiIesp.get(randomPokemons);

	    // tiek izņemts pokemons no Arraylist
	    visiIesp.remove(randomPokemons);

	    return p;
	}



}