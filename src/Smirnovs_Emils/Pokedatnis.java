package Smirnovs_Emils;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	
	// Damage mainīgais
	static int dmg = 0;
	
	// Ienaidnieka AI mainīgie
	static int iespejaUzbrukt = 50;

	// Static JLabel, JFRAME, CardLayout, JPanel, JButton
	static JLabel dialogaLabels;
	static JLabel PokemonaHP;
	static JLabel IenaidniekaHP;
	static JLabel naudaLabel;
	static JLabel naudaLabel2;
	static JLabel cinasInfo;
	
	static JFrame frame;
	
	static CardLayout cardLayout;
	
	static JPanel galvenaisPanel;
	
	static JButton NokertPoga;
	
	// Priekš muzikas
	private static Clip muzika;

	public static void main(String[] args) {
		
		//--------------------------------------------------------------------------------------------------------------------------------
		// <=========================================== GUI =============================================>
		//--------------------------------------------------------------------------------------------------------------------------------

		frame = new JFrame("Pokemona simulators");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // ============= CardLayout ==============
        cardLayout = new CardLayout();
        galvenaisPanel = new JPanel(cardLayout);
        

        // ============= Paneļi ==============
        JPanel sakumsPanel = new JPanel(null);
        sakumsPanel.setBackground(Color.white);

        JPanel cinasPanel = new JPanel(null);
        cinasPanel.setBackground(Color.black);
        
        JPanel PokemoniPanel = new JPanel(null);
        PokemoniPanel.setBackground(Color.white);
        
        JPanel NokertPanel = new JPanel(null);
        NokertPanel.setBackground(Color.white);
        
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
        
        naudaLabel = new JLabel("Nauda: " + nauda+"$");
        naudaLabel.setForeground(Color.GREEN);
        naudaLabel.setBounds(50, 10, 200, 30);
        PokemoniPanel.add(naudaLabel);
        
        naudaLabel2 = new JLabel("Nauda: " + nauda+"$");
        naudaLabel2.setForeground(Color.GREEN);
        naudaLabel2.setBounds(50, 10, 200, 30);
        NokertPanel.add(naudaLabel2);
        
        JLabel Nosaukums = new JLabel("Pokemona simulators");
        Nosaukums.setForeground(Color.BLACK);
        Nosaukums.setBounds(245, 75, 500, 30);
        Nosaukums.setFont(new Font("Arial", Font.BOLD, 32));
        sakumsPanel.add(Nosaukums);
        
        JLabel infoParNokert = new JLabel("50%, ka noķers random pokemonu un 50%, ka neko nenoķersi.");
        infoParNokert.setForeground(Color.RED);
        infoParNokert.setBounds(225, 270, 400, 50);
        NokertPanel.add(infoParNokert);
        
        // Pokemonu informacija
        JLabel infoVards = new JLabel("Vārds: ");
        infoVards.setForeground(Color.BLACK);
        infoVards.setBounds(300, 50, 300, 30);
        PokemoniPanel.add(infoVards);

        JLabel infoHP = new JLabel("HP: ");
        infoHP.setForeground(Color.BLACK);
        infoHP.setBounds(300, 80, 300, 30);
        PokemoniPanel.add(infoHP);

        JLabel infoDMG = new JLabel("Damage: ");
        infoDMG.setForeground(Color.BLACK);
        infoDMG.setBounds(300, 110, 300, 30);
        PokemoniPanel.add(infoDMG);

        JLabel infoDEF = new JLabel("Defense: ");
        infoDEF.setForeground(Color.BLACK);
        infoDEF.setBounds(300, 140, 300, 30);
        PokemoniPanel.add(infoDEF);

        JLabel infoLVL = new JLabel("Level: ");
        infoLVL.setForeground(Color.BLACK);
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
        nokerts.setForeground(Color.BLACK);
        nokerts.setBounds(344, 225, 300, 30);
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

        PokemonaHP = new JLabel();
        PokemonaHP.setForeground(Color.WHITE);
        PokemonaHP.setBounds(50, 55, 200, 30);
        cinasAktivsPanel.add(PokemonaHP);

        IenaidniekaHP = new JLabel();
        IenaidniekaHP.setForeground(Color.WHITE);
        IenaidniekaHP.setBounds(550, 55, 200, 30);
        cinasAktivsPanel.add(IenaidniekaHP);
        
        dialogaLabels = new JLabel();
        dialogaLabels.setForeground(Color.WHITE);
        dialogaLabels.setBounds(340, 200, 200, 30);
        cinasAktivsPanel.add(dialogaLabels);
        
        cinasInfo = new JLabel();
        cinasInfo.setForeground(Color.WHITE);
        cinasInfo.setBounds(275, 435, 400, 30);
        cinasAktivsPanel.add(cinasInfo);
        
        JLabel PokemonaDEF = new JLabel("DEF: ");
        PokemonaDEF.setForeground(Color.WHITE);
        PokemonaDEF.setBounds(120, 55, 200, 30);
        cinasAktivsPanel.add(PokemonaDEF);
        
        JLabel PretiniekaDEF = new JLabel("DEF: ");
        PretiniekaDEF.setForeground(Color.WHITE);
        PretiniekaDEF.setBounds(620, 55, 200, 30);
        cinasAktivsPanel.add(PretiniekaDEF);
        
        JLabel PokemonaLVL = new JLabel("LVL: ");
        PokemonaLVL.setForeground(Color.WHITE);
        PokemonaLVL.setBounds(170, 55, 200, 30);
        cinasAktivsPanel.add(PokemonaLVL);
        
        JLabel PretiniekaLVL = new JLabel("LVL: ");
        PretiniekaLVL.setForeground(Color.WHITE);
        PretiniekaLVL.setBounds(670, 55, 200, 30);
        cinasAktivsPanel.add(PretiniekaLVL);
        
        
        
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
        NokertPoga = new JButton("Noķert (100$)");
        NokertPoga.setBounds(320, 200, 160, 40);
        if(nauda >= 100) {
        NokertPoga.setForeground(Color.GREEN);
        }
        
        NokertPoga.setForeground(Color.GREEN);
        NokertPoga.setBackground(Color.BLACK);
        NokertPoga.setBorderPainted(true);
        NokertPoga.setFocusPainted(false);
        NokertPanel.add(NokertPoga);
        
        
        JButton OkPoga = new JButton("OK");
        OkPoga.setBounds(365, 250, 65, 25);
        OkPoga.setBackground(Color.BLACK);
        OkPoga.setForeground(Color.WHITE);
        OkPoga.setBorderPainted(true);
        OkPoga.setFocusPainted(false);
        NokertPanel.add(OkPoga);
        OkPoga.setVisible(false);
        
        
        JButton NokertPanelPoga = new JButton("Noķert pokemonus");
        NokertPanelPoga.setBounds(320, 300, 160, 50);
        NokertPanelPoga.setBackground(Color.BLACK);
        NokertPanelPoga.setForeground(Color.WHITE);
        NokertPanelPoga.setBorderPainted(true);
        NokertPanelPoga.setFocusPainted(false);
        sakumsPanel.add(NokertPanelPoga);
        
       
        JButton CinasPoga = new JButton("CĪŅAS");
        CinasPoga.setBounds(320, 150, 160, 50);
        CinasPoga.setBackground(Color.BLACK);
        CinasPoga.setForeground(Color.WHITE);
        CinasPoga.setBorderPainted(true);
        CinasPoga.setFocusPainted(false);
        sakumsPanel.add(CinasPoga);
        
        
        
        JButton PokemoniPoga = new JButton("Mani pokemoni");
        PokemoniPoga.setBounds(320, 225, 160, 50);
        PokemoniPoga.setBackground(Color.BLACK);
        PokemoniPoga.setForeground(Color.WHITE);
        PokemoniPoga.setBorderPainted(true);
        PokemoniPoga.setFocusPainted(false);
        sakumsPanel.add(PokemoniPoga);

        
        JButton SakumaPoga = new JButton("Atpakaļ");
        SakumaPoga.setBounds(350, 470, 100, 35);
        SakumaPoga.setBackground(Color.BLACK);
        SakumaPoga.setForeground(Color.WHITE);
        SakumaPoga.setBorderPainted(true);
        SakumaPoga.setFocusPainted(false);
        cinasPanel.add(SakumaPoga);
        
        // Uzbrukt poga
        JButton UzbruktPoga = new JButton("UZBRUKT");
        UzbruktPoga.setBounds(100, 480, 200, 50);
        UzbruktPoga.setBackground(Color.BLACK);
        UzbruktPoga.setForeground(Color.WHITE);
        UzbruktPoga.setBorderPainted(true);
        UzbruktPoga.setFocusPainted(false);
        cinasAktivsPanel.add(UzbruktPoga);
        
        // Runāt poga
        JButton RunatPoga = new JButton("RUNĀT");
        RunatPoga.setBounds(300, 480, 200, 50);
        RunatPoga.setBackground(Color.BLACK);
        RunatPoga.setForeground(Color.WHITE);
        RunatPoga.setBorderPainted(true);
        RunatPoga.setFocusPainted(false);
        cinasAktivsPanel.add(RunatPoga);
        
        // neko nedarīt poga
        JButton NekoPoga = new JButton("NEKO NEDARĪT");
        NekoPoga.setBounds(500, 480, 200, 50);
        NekoPoga.setBackground(Color.BLACK);
        NekoPoga.setForeground(Color.WHITE);
        NekoPoga.setBorderPainted(true);
        NekoPoga.setFocusPainted(false);
        cinasAktivsPanel.add(NekoPoga);
        
        JButton SakumaPoga2 = new JButton("Atpakaļ");
        SakumaPoga2.setBounds(350, 400, 100, 35);
        SakumaPoga2.setBackground(Color.BLACK);
        SakumaPoga2.setForeground(Color.WHITE);
        SakumaPoga2.setBorderPainted(true);
        SakumaPoga2.setFocusPainted(false);
        PokemoniPanel.add(SakumaPoga2);
        
        
        JButton SakumaPoga3 = new JButton("Atpakaļ");
        SakumaPoga3.setBounds(350, 400, 100, 35);
        SakumaPoga3.setBackground(Color.BLACK);
        SakumaPoga3.setForeground(Color.WHITE);
        SakumaPoga3.setBorderPainted(true);
        SakumaPoga3.setFocusPainted(false);
        NokertPanel.add(SakumaPoga3);
        
        JButton CinitiesPoga = new JButton("Cīnīties");
        CinitiesPoga.setBounds(300, 400, 200, 50);
        CinitiesPoga.setBackground(Color.BLACK);
        CinitiesPoga.setForeground(Color.WHITE);
        CinitiesPoga.setBorderPainted(true);
        CinitiesPoga.setFocusPainted(false);
        cinasPanel.add(CinitiesPoga);
        
        JButton arstetPoga = new JButton("Ārstēt (" + 25 + "$)");
        arstetPoga.setBounds(75, 250, 150, 40);
        arstetPoga.setBackground(Color.GREEN);
        arstetPoga.setForeground(Color.WHITE);
        arstetPoga.setBorderPainted(true);
        arstetPoga.setFocusPainted(false);
        PokemoniPanel.add(arstetPoga);

        
        frame.add(galvenaisPanel);
        frame.setVisible(true);
        
        
        MuzikaMain("src/audio/main.wav");
        
        
        
        
        //--------------------------------------------------------------------------------------------------------------------------------
        // <===================================== LOĢIKA ====================================>
        //--------------------------------------------------------------------------------------------------------------------------------
        
        
        
        ArrayList<Pokemons> Pokemoni = new ArrayList<>();
        // Visi iespējamie pokemoni ko var noķert
        ArrayList<Pokemons> visiIespPokemoni = new ArrayList<>();
        visiIespPokemoni.add(new UdensP(18, 32, 0, 14, 32, "Squirtle", "/bildes/squirtle.png", "Ūdens", "Squirt! Squirt! Man patīk!"));
        visiIespPokemoni.add(new ElektriskaisP(19, 27, 0, 12, 27, "Electabuzz", "/bildes/electabuzz.png", "Elektrisks", "Zap! Zap! Zap!"));

        // Sākuma pokemons
        Pokemons sakumaPokemons = new ElektriskaisP(23, 21, 0, 6, 21, "Pikachu", "/bildes/pikachu.png", "Elektrisks", "PIIKAAAAAAA");
        Pokemoni.add(sakumaPokemons);     
        
        
        
        
        
        //--------------------------------------------------------------------------------------------------------------------------------
        // ================== POGAS LOĢIKA ====================
        //--------------------------------------------------------------------------------------------------------------------------------
        
        

        
        NokertPoga.addActionListener(e -> {
        	
        	if (nauda < 100) {
                JOptionPane.showMessageDialog(frame, "Nav pietiekami daudz naudas!");
                return;
            }

            // atņem naudu par samaksu
            nauda -= 100;
            
            updateNaudaLabel(naudaLabel);
            updateNaudaLabel(naudaLabel2);
        	
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
            
         // Maina krāsu noķert pogai ja nauda ir zem 100.
            if(nauda >= 100) {
                NokertPoga.setForeground(Color.GREEN);
                }
                if(nauda < 100) {
                	NokertPoga.setForeground(Color.RED);
                }
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
            
            // Maina krāsu noķert pogai ja nauda ir zem 100.
            if(nauda >= 100) {
                NokertPoga.setForeground(Color.GREEN);
                }
                if(nauda < 100) {
                	NokertPoga.setForeground(Color.RED);
                }
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
        	
        	StopMuzika("src/audio/main.wav");
        	MuzikaMain("src/audio/battle.wav");

            // Pretinieka pokemons
            IenaidniekaPokemons = randomIenaidnieks(visiIespPokemoni);

            PokemonaVards.setText("Tu: " + SpeletajaPokemons.getVards());
            IenaidniekaVards.setText("Pretinieks: " + IenaidniekaPokemons.getVards());

            PokemonaHP.setText("HP: " + SpeletajaPokemons.getHP()+"/"+SpeletajaPokemons.getMaxHP());
            IenaidniekaHP.setText("HP: " + IenaidniekaPokemons.HP+"/"+IenaidniekaPokemons.getMaxHP());
            PokemonaDEF.setText("DEF: " + SpeletajaPokemons.getDefense());
            PretiniekaDEF.setText("DEF: " + IenaidniekaPokemons.getDefense());
            PokemonaLVL.setText("LVL: " + SpeletajaPokemons.getLevel());
            PretiniekaLVL.setText("LVL: " + IenaidniekaPokemons.getLevel());
            
            if (SpeletajaPokemons.getBilde() != null)
                speletajaBilde.setIcon(new ImageIcon(Pokedatnis.class.getResource(SpeletajaPokemons.getBilde())));
            if (IenaidniekaPokemons.getBilde() != null)
                ienaidniekaBilde.setIcon(new ImageIcon(Pokedatnis.class.getResource(IenaidniekaPokemons.getBilde())));

        	cardLayout.show(galvenaisPanel, "cinasAktivs");
        	
        	TekstaEfekts(cinasInfo, "Pirmais gājiens ir "+SpeletajaPokemons.getVards()+ " ko tu darīsi?", 40);
        	
        });
        
        PokemoniPoga.addActionListener(e -> {
            cardLayout.show(galvenaisPanel, "pokemoni");
        });
        
        SakumaPoga.addActionListener(e -> {
        	// Maina krāsu noķert pogai ja nauda ir zem 100.
            if(nauda >= 100) {
                NokertPoga.setForeground(Color.GREEN);
                }
                if(nauda < 100) {
                	NokertPoga.setForeground(Color.RED);
                }
                
            cardLayout.show(galvenaisPanel, "sakums");
        });
        
        SakumaPoga2.addActionListener(e -> {
        	// Maina krāsu noķert pogai ja nauda ir zem 100.
            if(nauda >= 100) {
                NokertPoga.setForeground(Color.GREEN);
                }
                if(nauda < 100) {
                	NokertPoga.setForeground(Color.RED);
                }
                
            cardLayout.show(galvenaisPanel, "sakums");
        });
        
        SakumaPoga3.addActionListener(e -> {
        	NokertPoga.setVisible(true);
        	nokerts.setVisible(false);
        	OkPoga.setVisible(false);
        	nokertBilde.setVisible(false);
        	
        	// Maina krāsu noķert pogai ja nauda ir zem 100.
            if(nauda >= 100) {
                NokertPoga.setForeground(Color.GREEN);
                }
                if(nauda < 100) {
                	NokertPoga.setForeground(Color.RED);
                }
                
            cardLayout.show(galvenaisPanel, "sakums");
        });
        
        UzbruktPoga.addActionListener(e -> {
        	dialogaLabels.setVisible(false);
        	
        	
        	dmg = SpeletajaPokemons.getDamage() - IenaidniekaPokemons.getDefense();
        	if (dmg < 1)
        		dmg = 1;

            // Spēlētāja uzbrukums
            IenaidniekaPokemons.HP -= dmg;
            
            if (IenaidniekaPokemons.HP < 0)
            	IenaidniekaPokemons.HP = 0;
            
            
         // 25% iespēja ka pretinieks tiks paralizēts
            boolean specUzbrukums = SpeletajaPokemons.SpecialATK();

            // Parastais uzbrukums
            if (!specUzbrukums) {
            TekstaEfekts(cinasInfo, SpeletajaPokemons.getVards()+ " uzbruka "+IenaidniekaPokemons.getVards()+" un atņēma "
            +IenaidniekaPokemons.getVards()+" "+dmg+" HP!", 40);
            // Uzliekam dmg atpakaļ uz 0
            dmg = 0;
            
            ParbaudaHP();
            WinOrLoseParbaude();
            }
            
            	else {             
                        UzbruktPoga.setEnabled(false);
                        RunatPoga.setEnabled(false);
                        NekoPoga.setEnabled(false);
                    	
                        
                        String tips = SpeletajaPokemons.getTips();
                        
                        if(tips.equals("Elektrisks")) {
                        TekstaEfekts(cinasInfo,
                                SpeletajaPokemons.getVards()+" PARALIZĒJA "+IenaidniekaPokemons.getVards()+" un atņēma "+dmg+" HP! Pretinieks izlaiž gājienu!", 40);
                        // Uzliekam dmg atpakaļ uz 0
                        }
                        
                        else if(tips.equals("Ūdens")) {
                        	
                        	int HpBonus = 6;
                        	SpeletajaPokemons.setHP(SpeletajaPokemons.getHP() + HpBonus);
                        	
                        	TekstaEfekts(cinasInfo,
                                    SpeletajaPokemons.getVards()+" sadziedēja sevi (+"+HpBonus+" HP!) un nodarīja "+dmg+" HP "+IenaidniekaPokemons.getVards(), 40);
                        }
                        
                        	// Uzliekam dmg atpakaļ uz 0
                            dmg = 0;
                            
                            ParbaudaHP();
                            WinOrLoseParbaude();
                        
                        laiks(3000, () -> {
                        UzbruktPoga.setEnabled(true);
                        RunatPoga.setEnabled(true);
                        NekoPoga.setEnabled(true);
                        });
                        return;
            }         
            
            if (IenaidniekaPokemons.HP > 0) {
            	UzbruktPoga.setEnabled(false);
                RunatPoga.setEnabled(false);
                NekoPoga.setEnabled(false);
                
            	laiks(3000, () -> {
            	
            IenaidnieksAI();
            ParbaudaHP();
            WinOrLoseParbaude();
            dmg = 0;
            
            UzbruktPoga.setEnabled(true);
            RunatPoga.setEnabled(true);
            NekoPoga.setEnabled(true);
            	});
            }
        });
        
        RunatPoga.addActionListener(e -> {
        	dialogaLabels.setVisible(false);
        	
        	TekstaEfekts(cinasInfo, SpeletajaPokemons.getVards()+ " izlēma kautko teikt.", 40);
        	
        	UzbruktPoga.setEnabled(false);
            RunatPoga.setEnabled(false);
            NekoPoga.setEnabled(false);
            
            // spēlētāja pokemons runā
            laiks(2000, () -> {
            	dialogaLabels.setVisible(true);
            	PokemonsRuna(dialogaLabels, SpeletajaPokemons, 50);
					});
            dialogaLabels.setVisible(false);
            
            laiks(3000, () -> {
            	
                IenaidnieksAI();
                ParbaudaHP();
                WinOrLoseParbaude();
                dmg = 0;
                
                UzbruktPoga.setEnabled(true);
                RunatPoga.setEnabled(true);
                NekoPoga.setEnabled(true);
                	});
        });
        
        NekoPoga.addActionListener(e -> {
        	dialogaLabels.setVisible(false);
        	TekstaEfekts(cinasInfo, SpeletajaPokemons.getVards()+ " izlēma pilnīgi neko nedarīt.", 40);
            
        	UzbruktPoga.setEnabled(false);
            RunatPoga.setEnabled(false);
            NekoPoga.setEnabled(false);
            

            laiks(3000, () -> {
            	
                IenaidnieksAI();
                ParbaudaHP();
                WinOrLoseParbaude();
                dmg = 0;
                
                UzbruktPoga.setEnabled(true);
                RunatPoga.setEnabled(true);
                NekoPoga.setEnabled(true);
                	});
            
        });
        
        // Arstēt poga, kas atrodas Pokemoni panelī
        arstetPoga.addActionListener(e -> {

            String izveletais = (String)pokemonDropdown.getSelectedItem();
            if (izveletais == null) return;

            // Meklē izvēlēto pokemonu
            for (Pokemons p : Pokemoni) {
                if (p.getVards().equals(izveletais)) {

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
                    updateNaudaLabel(naudaLabel2);

                    JOptionPane.showMessageDialog(frame, p.getVards() + " tika pilnībā ārstēts!");
                }
            }
        });


          
        
        // Lai sākuma pokemons parādītos
        for (Pokemons p : Pokemoni) {
            pokemonDropdown.addItem(p.getVards());
            pokemonCinasDropdown.addItem(p.getVards());
        }
        
        
        
        
        //--------------------------------------------------------------------------------------------------------------------------------
        // ================ DROPDOWN Pokemoni ====================
        //--------------------------------------------------------------------------------------------------------------------------------
        
        
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
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------------------------------------
	// ============================= Metodes ===================================
	//--------------------------------------------------------------------------------------------------------------------------------
	
	
	
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

	// Update naudas tekstu
	public static void updateNaudaLabel(JLabel labelis) {
		labelis.setText("Nauda: " + nauda+"$");
	}
	
	
	// Teksta animācijas
	public static void TekstaEfekts(JLabel labelis, String teksts, int ms) {
		labelis.setText("");	// Notīra esošo tekstu
	    
	    new Thread(() -> {
	        try {
	            for (int i = 0; i < teksts.length(); i++) {
	                final int indekss = i;
	                
	                javax.swing.SwingUtilities.invokeLater(() -> {
	                	labelis.setText(teksts.substring(0, indekss + 1));
	                });
	                Thread.sleep(ms);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }).start();
	}
	
	public static void PokemonsRuna(JLabel labelis, Pokemons p, int ms) {
	    String teksts = p.getRunat();// Tekts ko pokemons runās
	    labelis.setText(""); // notīra iepriekšējo tekstu

	    new Thread(() -> {
	        try {
	            for (int i = 0; i < teksts.length(); i++) {
	                final int indekss = i;

	                // Atjauno tekstu labelī
	                javax.swing.SwingUtilities.invokeLater(() -> {
	                	labelis.setText(teksts.substring(0, indekss + 1));
	                });

	                Thread.sleep(ms);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }).start();
	}
	
	public static void PretinieksRuna(JLabel labelis, Ienaidnieks p, int ms) {
	    String teksts = p.getRunat();// Tekts ko pokemons runās
	    labelis.setText(""); // notīra iepriekšējo tekstu

	    new Thread(() -> {
	        try {
	            for (int i = 0; i < teksts.length(); i++) {
	                final int indekss = i;

	                // Atjauno tekstu labelī
	                javax.swing.SwingUtilities.invokeLater(() -> {
	                	labelis.setText(teksts.substring(0, indekss + 1));
	                });
	                Thread.sleep(ms);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }).start();
	}
	 
	// Laiks metode, pagaida specifisku laiku lai turpinātu kautko
	public static void laiks(int ms, Runnable turpinat) {
	    new javax.swing.Timer(ms, e -> {
	        turpinat.run();
	        ((javax.swing.Timer)e.getSource()).stop();
	    }).start();
	}
	
	public static void WinOrLoseParbaude() {
		dialogaLabels.setVisible(false);
	
			// Uzvara
        if (IenaidniekaPokemons.HP == 0) {
            int balva = 50;
            nauda += balva;
            updateNaudaLabel(naudaLabel);
            updateNaudaLabel(naudaLabel2);

            JOptionPane.showMessageDialog(frame, "Tu uzvarēji! Tu ieguvi " + balva + "$");
            cardLayout.show(galvenaisPanel, "sakums");
            StopMuzika("src/audio/battle.wav");
            MuzikaMain("src/audio/main.wav");
            
            // Maina krāsu noķert pogai ja nauda ir zem 100.
            if(nauda >= 100) {
                NokertPoga.setForeground(Color.GREEN);
                }
                if(nauda < 100) {
                	NokertPoga.setForeground(Color.RED);
                }
            return;
        }
            // Zaudē
        if (SpeletajaPokemons.getHP() == 0) {
                JOptionPane.showMessageDialog(frame, "Tu zaudēji!");
                cardLayout.show(galvenaisPanel, "sakums");
                StopMuzika("src/audio/battle.wav");
                MuzikaMain("src/audio/main.wav");
                
                // Maina krāsu noķert pogai ja nauda ir zem 100.
                if(nauda >= 100) {
                    NokertPoga.setForeground(Color.GREEN);
                    }
                    if(nauda < 100) {
                    	NokertPoga.setForeground(Color.RED);
                    }
            }
        
        }
        
	
	public static void ParbaudaHP() {
		if (SpeletajaPokemons.getHP() < 0)
            SpeletajaPokemons.setHP(0);
		
		PokemonaHP.setText("HP: " + SpeletajaPokemons.getHP() + "/" + SpeletajaPokemons.getMaxHP());
		IenaidniekaHP.setText("HP: " + IenaidniekaPokemons.HP + "/" + IenaidniekaPokemons.getMaxHP());
	}
	
	
	
	
	//--------------------------------------------------------------------------------------------------------------------------------
	// ============= SKAŅAS METODES ==============
	//--------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	public static void MuzikaMain(String cels){
	try {
		File fails = new File (cels);
		AudioInputStream ais = AudioSystem.getAudioInputStream(fails);
		muzika = AudioSystem.getClip();
		muzika.open(ais);
		FloatControl gainControl = 
			    (FloatControl) muzika.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
			muzika.loop(Clip.LOOP_CONTINUOUSLY);
			muzika.start();
	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        e.printStackTrace();
    }
	}
		
	
	public static void StopMuzika(String cels){
		if (muzika != null && muzika.isRunning()) {
			muzika.stop();
            muzika.close();
		}
	}
	
	public static void SFX(String cels) {
        try {
            File fails = new File(cels);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(fails);
            Clip c = AudioSystem.getClip();
            c.open(audioStream);
            c.start(); // vienu reizi spēlē skaņu
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	//--------------------------------------------------------------------------------------------------------------------------------
	// ======== AI Ienaidnieks metode ============
	//--------------------------------------------------------------------------------------------------------------------------------
	
	
	public static void IenaidnieksAI() {
		
		
		// 50% iespēja ka pretinieks uzbruks vai nu kautko citu darīs.
		if (iespejaUzbrukt == 50) { // nez vai gribu turpināt AI iespējas taisīt :-(
			int i = rand.nextInt(11);
			// 55% ka AI uzbruks
			if (i <= 5) {
				// Pretinieka uzbrukums
				dmg = IenaidniekaPokemons.getDamage() - SpeletajaPokemons.getDefense();
	        	if (dmg < 1)
	        		dmg = 1;
	        	
	        	TekstaEfekts(cinasInfo, IenaidniekaPokemons.getVards()+ " uzbruka "+SpeletajaPokemons.getVards()+" un atņēma "
			            +SpeletajaPokemons.getVards()+" "+dmg+" HP!", 40);
	        	
	            SpeletajaPokemons.setHP(SpeletajaPokemons.getHP() - dmg);
	            System.out.println("AI izlēma uzbrukt, un atņēma speletājam "+dmg+" dmg!");
	            
	            // 45% ka AI neko nedarīs vai kautko teiks.
			}else if(i >= 6) {
				// 18% ka AI neko nedarīs
				if (i < 8) {
				TekstaEfekts(cinasInfo, IenaidniekaPokemons.getVards()+ " izlēma pilnīgi neko nedarīt.", 40);
				System.out.println("AI izlēma neko nedarīt.");
				// 27% ka AI kautko teiks
				}else if(i >= 8) {
					TekstaEfekts(cinasInfo, IenaidniekaPokemons.getVards()+ " izlēma kautko teikt.", 40);
					System.out.println("AI izlēma runāt.");
					// Pretinieks runā
					laiks(2000, () -> {
						dialogaLabels.setVisible(true);
				PretinieksRuna(dialogaLabels, IenaidniekaPokemons, 50);
					});
					dialogaLabels.setVisible(false);
				}
			}
			// DEBUG lietiņas.
			System.out.println("AI indekss = "+ i);
		}
	}
	

}