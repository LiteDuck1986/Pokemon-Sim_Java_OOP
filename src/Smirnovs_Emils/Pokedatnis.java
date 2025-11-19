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
	
	// Speletāja un ienaidnieka pokemoni
	public static Pokemons SpeletajaPokemons = null;
	static Ienaidnieks IenaidniekaPokemons = null;

	
	static int nauda = 100; // sākuma nauda


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

        JPanel cinasPanel = new JPanel(null);
        cinasPanel.setBackground(Color.black);
        
        JPanel PokemoniPanel = new JPanel(null);
        PokemoniPanel.setBackground(Color.gray);
        
        JPanel NokertPanel = new JPanel(null);
        NokertPanel.setBackground(Color.darkGray);
        
        JPanel cinasAktivsPanel = new JPanel(null);
        cinasAktivsPanel.setBackground(Color.black);
        
     // =================== Dropdown Labeļi ====================
        JLabel IzveleText = new JLabel("Izvēlies Pokemonu:");
        IzveleText.setForeground(Color.WHITE);
        IzveleText.setBounds(50, 30, 200, 30);
        PokemoniPanel.add(IzveleText);
        
     // Cīņas dropdown labelis
        JLabel IzveleCinasText = new JLabel("Izvēlies Pokemonu:");
        IzveleCinasText.setForeground(Color.WHITE);
        IzveleCinasText.setBounds(50, 30, 200, 30);
        cinasPanel.add(IzveleText);

        // Dropdown izveide - Mani pokimoni panels
        JComboBox<String> pokemonDropdown = new JComboBox<>();
        pokemonDropdown.setBounds(50, 70, 200, 30);
        PokemoniPanel.add(pokemonDropdown);
        
     // Dropdown izveide - Cīņas panelī
        JComboBox<String> pokemonCinasDropdown = new JComboBox<>();
        pokemonCinasDropdown.setBounds(50, 70, 200, 30);
        cinasPanel.add(pokemonCinasDropdown);


        // ======== LABEĻI ========
        
        JLabel naudaLabel = new JLabel("Nauda: " + nauda);
        naudaLabel.setForeground(Color.YELLOW);
        naudaLabel.setBounds(50, 10, 200, 30);
        PokemoniPanel.add(naudaLabel);
        
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
        
        // Ciņas pokemona info
        JLabel infoVards2 = new JLabel("Vārds: ");
        infoVards2.setForeground(Color.WHITE);
        infoVards2.setBounds(300, 50, 300, 30);
        cinasPanel.add(infoVards2);

        JLabel infoHP2 = new JLabel("HP: ");
        infoHP2.setForeground(Color.WHITE);
        infoHP2.setBounds(300, 80, 300, 30);
        cinasPanel.add(infoHP2);

        JLabel infoDMG2 = new JLabel("Damage: ");
        infoDMG2.setForeground(Color.WHITE);
        infoDMG2.setBounds(300, 110, 300, 30);
        cinasPanel.add(infoDMG2);

        JLabel infoDEF2 = new JLabel("Defense: ");
        infoDEF2.setForeground(Color.WHITE);
        infoDEF2.setBounds(300, 140, 300, 30);
        cinasPanel.add(infoDEF2);

        JLabel infoLVL2 = new JLabel("Level: ");
        infoLVL2.setForeground(Color.WHITE);
        infoLVL2.setBounds(300, 170, 300, 30);
        cinasPanel.add(infoLVL2);
        
        // Noķert paneļa labeļi
        JLabel nokerts = new JLabel("Tu noķēri: ");
        nokerts.setForeground(Color.WHITE);
        nokerts.setBounds(345, 225, 300, 30);
        NokertPanel.add(nokerts);
        nokerts.setVisible(false);
        
        // Cīņas labeļi
        JLabel PokemonaVards = new JLabel();
        PokemonaVards.setForeground(Color.WHITE);
        PokemonaVards.setBounds(50, 30, 200, 30);
        cinasAktivsPanel.add(PokemonaVards);

        JLabel IenaidniekaVards = new JLabel();
        IenaidniekaVards.setForeground(Color.WHITE);
        IenaidniekaVards.setBounds(550, 30, 200, 30);
        cinasAktivsPanel.add(IenaidniekaVards);

        JLabel PokemonaHP = new JLabel();
        PokemonaHP.setForeground(Color.WHITE);
        PokemonaHP.setBounds(50, 70, 200, 30);
        cinasAktivsPanel.add(PokemonaHP);

        JLabel IenaidniekaHP = new JLabel();
        IenaidniekaHP.setForeground(Color.WHITE);
        IenaidniekaHP.setBounds(550, 70, 200, 30);
        cinasAktivsPanel.add(IenaidniekaHP);
        
        
        
        // ======== Pokemon bildes ========
        
        // Bildes izmēri
        int platums = 320, augstums = 322;
        
        JLabel pokemonBilde = new JLabel();
        pokemonBilde.setBounds(450, 40, platums, augstums);
        PokemoniPanel.add(pokemonBilde);
        
        JLabel pokemonCinasBilde = new JLabel();
        pokemonCinasBilde.setBounds(450, 40, platums, augstums);
        cinasPanel.add(pokemonCinasBilde);
        
        JLabel nokertBilde = new JLabel();
        nokertBilde.setBounds(325, -10, platums, augstums);
        NokertPanel.add(nokertBilde);
        nokertBilde.setVisible(false);
        
        // Cīņas bildes
        JLabel speletajaBilde = new JLabel();
        speletajaBilde.setBounds(30, 120, 300, 300);
        cinasAktivsPanel.add(speletajaBilde);

        JLabel ienaidniekaBilde = new JLabel();
        ienaidniekaBilde.setBounds(450, 120, 300, 300);
        cinasAktivsPanel.add(ienaidniekaBilde);


        // ============= PANEĻU SAVIENOJUMS ==============
        galvenaisPanel.add(sakumsPanel, "sakums");
        galvenaisPanel.add(cinasPanel, "cinas");
        galvenaisPanel.add(PokemoniPanel, "pokemoni");
        galvenaisPanel.add(NokertPanel, "nokert");
        galvenaisPanel.add(cinasAktivsPanel, "cinasAktivs");
        
        
        
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
        
       
        JButton CinasPoga = new JButton("Cīņas");
        CinasPoga.setBounds(300, 200, 200, 50);
        sakumsPanel.add(CinasPoga);
        
        
        JButton PokemoniPoga = new JButton("Mani pokemoni");
        PokemoniPoga.setBounds(300, 275, 200, 50);
        sakumsPanel.add(PokemoniPoga);

        
        JButton SakumaPoga = new JButton("Atpakaļ uz sākumu");
        SakumaPoga.setBounds(300, 400, 200, 50);
        cinasPanel.add(SakumaPoga);
        
        // Uzbrukt poga
        JButton UzbruktPoga = new JButton("Uzbrukt");
        UzbruktPoga.setBounds(300, 480, 200, 50);
        cinasAktivsPanel.add(UzbruktPoga);
        
        JButton SakumaPoga2 = new JButton("Atpakaļ uz sākumu");
        SakumaPoga2.setBounds(300, 400, 200, 50);
        PokemoniPanel.add(SakumaPoga2);
        
        
        JButton SakumaPoga3 = new JButton("Atpakaļ uz sākumu");
        SakumaPoga3.setBounds(300, 400, 200, 50);
        NokertPanel.add(SakumaPoga3);
        
        JButton CinitiesPoga = new JButton("Cīnīties");
        CinitiesPoga.setBounds(300, 300, 200, 50);
        cinasPanel.add(CinitiesPoga);
        
        JButton arstetPoga = new JButton("Ārstēt (" + 25 + "$)");
        arstetPoga.setBounds(50, 350, 200, 40);
        PokemoniPanel.add(arstetPoga);


        
        
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
        	pokemonCinasDropdown.addItem(p.getVards());
            
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
        
        CinasPoga.addActionListener(e -> {
        	cardLayout.show(galvenaisPanel, "cinas");
        });
        
        CinitiesPoga.addActionListener(e -> {
        	
        	if (SpeletajaPokemons == null) {
                JOptionPane.showMessageDialog(frame, "Tev nav izvēlēts pokemons!");
                return;
            }
        	
        	if (SpeletajaPokemons.getHP() <= 0) {
                JOptionPane.showMessageDialog(frame, "Jūsu pokemonam nav HP!");
                return;
            }

            // Pretinieka pokemons
            IenaidniekaPokemons = randomIenaidnieks(visiIespPokemoni);

            PokemonaVards.setText("Tu: " + SpeletajaPokemons.getVards());
            IenaidniekaVards.setText("Ienaidnieks: " + IenaidniekaPokemons.getVards());

            PokemonaHP.setText("HP: " + SpeletajaPokemons.getHP());
            IenaidniekaHP.setText("HP: " + IenaidniekaPokemons.HP);
            
            if (SpeletajaPokemons.getBilde() != null)
                speletajaBilde.setIcon(new ImageIcon(Pokedatnis.class.getResource(SpeletajaPokemons.getBilde())));
            if (IenaidniekaPokemons.getBilde() != null)
                ienaidniekaBilde.setIcon(new ImageIcon(Pokedatnis.class.getResource(IenaidniekaPokemons.getBilde())));

        	cardLayout.show(galvenaisPanel, "cinasAktivs");
        	
        });
        
        PokemoniPoga.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "pokemoni");
        });
        
        SakumaPoga.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "sakums");
        });
        
        SakumaPoga2.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "sakums");
        });
        
        SakumaPoga3.addActionListener(e -> {
        	NokertPoga.setVisible(true);
        	nokerts.setVisible(false);
        	OkPoga.setVisible(false);
        	nokertBilde.setVisible(false);
        	
            cardLayout.show(galvenaisPanel, "sakums");
        });
        
        UzbruktPoga.addActionListener(e -> {

            // Spēlētāja uzbrukums
            IenaidniekaPokemons.HP -= SpeletajaPokemons.getDamage();
            if (IenaidniekaPokemons.HP < 0) IenaidniekaPokemons.HP = 0;

            IenaidniekaHP.setText("HP: " + IenaidniekaPokemons.HP + "/" + IenaidniekaPokemons.getMaxHP());

            // Uzvara
            if (IenaidniekaPokemons.HP == 0) {
                int balva = 50;
                nauda += balva;
                updateNaudaLabel(naudaLabel);

                JOptionPane.showMessageDialog(frame, "Tu uzvarēji! Tu ieguvi " + balva + "$");
                cardLayout.show(galvenaisPanel, "sakums");
                return;
            }

            // Pretinieka uzbrukums
            SpeletajaPokemons.setHP(SpeletajaPokemons.getHP() - IenaidniekaPokemons.getDamage());

            if (SpeletajaPokemons.getHP() < 0)
                SpeletajaPokemons.setHP(0);

            PokemonaHP.setText("HP: " + SpeletajaPokemons.getHP() + "/" + SpeletajaPokemons.getMaxHP());

            if (SpeletajaPokemons.getHP() == 0) {
                JOptionPane.showMessageDialog(frame, "Tu zaudēji!");
                cardLayout.show(galvenaisPanel, "sakums");
            }
        });
        
        
        arstetPoga.addActionListener(e -> {

            String selected = (String)pokemonDropdown.getSelectedItem();
            if (selected == null) return;

            // Meklē izvēlēto pokemonu
            for (Pokemons p : Pokemoni) {
                if (p.getVards().equals(selected)) {

                    if (nauda < 25) {
                        JOptionPane.showMessageDialog(frame, "Nav pietiekami daudz naudas!");
                        return;
                    }

                    // atņem naudu par samaksu
                    nauda -= 25;

                    // ārstē
                    p.setHP(p.getMaxHP());

                    // atjauno labeli
                    infoHP.setText("HP: " + p.getHP() + "/" + p.getMaxHP());
                    updateNaudaLabel(naudaLabel);

                    JOptionPane.showMessageDialog(frame, p.getVards() + " tika pilnībā ārstēts!");
                }
            }
        });


          
        
        // Lai sākuma pokemons parādītos
        for (Pokemons p : Pokemoni) {
            pokemonDropdown.addItem(p.getVards());
            pokemonCinasDropdown.addItem(p.getVards());
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
        
        
        pokemonCinasDropdown.addActionListener(e -> {
            String izveletaisPokemons = (String)pokemonCinasDropdown.getSelectedItem();

            for (Pokemons p : Pokemoni) {
                if (p.getVards().equals(izveletaisPokemons)) {

                    // Uzrāda informāciju par pokemonu
                    infoVards2.setText("Vārds: " + p.getVards());
                    infoHP2.setText("HP: " + p.getHP() + "/" + p.getMaxHP());
                    infoDMG2.setText("Damage: " + p.getDamage());
                    infoDEF2.setText("Defense: " + p.getDefense());
                    infoLVL2.setText("Level: " + p.getLevel());

                    // Uzrāda attēlu, strādā arī ar JAR failu.
                    if (p.getBilde() != null) {
                        pokemonCinasBilde.setIcon(new ImageIcon(Pokedatnis.class.getResource(p.getBilde())));

                    } else {
                    	pokemonCinasBilde.setIcon(null);
                    }
                    SpeletajaPokemons = p;
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
	
	public static Ienaidnieks randomIenaidnieks(ArrayList<Pokemons> ienaidnieki) {
	    if (ienaidnieki.isEmpty()) return null;	// Ja nav neviena pokemona
	    
	    int i = rand.nextInt(ienaidnieki.size());
	    Pokemons p = ienaidnieki.get(i);
	    
	    return new Ienaidnieks(p);
	}

	public static void updateNaudaLabel(JLabel labelis) {
		labelis.setText("Nauda: " + nauda);
	}



}