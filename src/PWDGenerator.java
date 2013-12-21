/**
 * Created by jasper on 12/20/13.
 * Copyright (c) Jasper Reddin (AKA tenny1028) 2013
 */
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PWDGenerator extends JFrame implements ActionListener, ItemListener{

	// Text Boxes:
	public JTextField textOutput;
	public JTextField lengthOfPWD;

	// Buttons:
	public JButton generatePW;
	public JButton shuffleOutput;
	public JButton copyOutputToClipboard;

	// Checkbox options:
	public JCheckBox includeCapsCB;
	public JCheckBox includeLowerCaseCB;
	public JCheckBox includeNumbersCB;

	public boolean includeCaps;
	public boolean includeLowerCase;
	public boolean includeNumbers;

	public PWDGenerator(){
		super("Password Generator");

		textOutput = new JTextField(30);
		textOutput.addActionListener(this);
		lengthOfPWD = new JTextField("8",2);
		lengthOfPWD.addActionListener(this);

		generatePW = new JButton("Generate Password");
		generatePW.addActionListener(this);

		shuffleOutput = new JButton("Shuffle Output");
		shuffleOutput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt = textOutput.getText();
				textOutput.setText(WordShuffler.shuffle(txt));
			}
		});

		copyOutputToClipboard = new JButton("Copy To Clipboard");
		copyOutputToClipboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String theString = textOutput.getText();
				StringSelection selection = new StringSelection(theString);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, selection);
			}
		});

		JPanel optionsPanel = new JPanel(new FlowLayout());

		includeCapsCB = new JCheckBox("Include Caps",true);
		includeLowerCaseCB = new JCheckBox("Include Lower Case Characters",true);
		includeNumbersCB = new JCheckBox("Include Numbers",true);
		includeCapsCB.addItemListener(this);
		includeLowerCaseCB.addItemListener(this);
		includeNumbersCB.addItemListener(this);
		includeCaps = true;
		includeLowerCase = true;
		includeNumbers = true;

		optionsPanel.add(includeCapsCB);
		optionsPanel.add(includeLowerCaseCB);
		optionsPanel.add(includeNumbersCB);
		optionsPanel.add(new JLabel("Length in Characters:"));
		optionsPanel.add(lengthOfPWD);

		setLayout(new BorderLayout(5, 5));


		// LAYOUT OF COMPONENTS:
		// ---                title bar                ---
		// ---                textOutput               ---
		// ---generatePW,shuffleOutput,copyToClipboard ---
		// ---includeCapsCB,includeLowerCaseCB,includeNums ---

		System.out.println("Awesome!!");

		add(textOutput, BorderLayout.PAGE_START);
		add(shuffleOutput,BorderLayout.WEST);
		add(generatePW,BorderLayout.CENTER);
		add(copyOutputToClipboard,BorderLayout.EAST);
		add(optionsPanel,BorderLayout.PAGE_END);

		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);


	}
	public static void main(String[] args){
		new PWDGenerator();
		//RandomWordGenerator.nextWord(8,true,true,true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			int length = Integer.parseInt(lengthOfPWD.getText())-1;
			if(!lengthOfPWD.getText().equals("")&&length>=0){
				textOutput.setText(RandomWordGenerator.nextWord(length,includeCaps,includeLowerCase,includeNumbers));
			}

		}catch(NumberFormatException numEx){

		}

	}

	public void itemStateChanged(ItemEvent e) {

		Object source = e.getItemSelectable();

		if(source.equals(includeCapsCB)){
			includeCaps = !includeCaps;
			System.out.println("" + includeCaps);
		}else if(source.equals(includeLowerCaseCB)){
			includeLowerCase = !includeLowerCase;
			System.out.println("" + includeLowerCase);
		}else if(source.equals(includeNumbersCB)){
			includeNumbers = !includeNumbers;
			System.out.println("" + includeNumbers);
		}

		if(!includeCaps&&!includeNumbers&&!includeLowerCase){
			generatePW.setEnabled(false);
		}else{
			generatePW.setEnabled(true);
		}



	}
}








