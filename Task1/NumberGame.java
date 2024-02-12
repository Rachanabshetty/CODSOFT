package Task1;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class NumberGame extends JFrame {
	 private int randomNumber;
	    private JTextField guessField;
	    private JTextArea resultArea;
	    private int numberOfAttempts;
	    private JButton submitButton;

	    public NumberGame() {
	      
	        randomNumber = (int) (Math.random() * 100.0) + 1;
	        guessField = new JTextField(10);
	        resultArea = new JTextArea(5, 30);
	        numberOfAttempts = 0;

	        // Set up the JFrame
	        setTitle("Number Game");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

	        // Add components to the JFrame
	        add(new JLabel("Guess a number between 1 and 100: "));
	        add(guessField);
	        
	        
	         submitButton = new JButton("Submit Guess");
	        add(submitButton);

	        submitButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                processGuess();
	            }
	        });

	        add(resultArea);

	        // Set up the JFrame size and make it visible
	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    private void processGuess() {
	        int userGuess = Integer.parseInt(guessField.getText());

	        if (userGuess == randomNumber) {
	            displayResult("Congratulations! You guessed correctly! The number was " + randomNumber);
	        } else {
	            numberOfAttempts++;
	            String result = (userGuess > randomNumber) ? "Your guess is too high." : "Your guess is too low.";
	            displayResult(result);

	            if (numberOfAttempts >= 3) {
	                displayResult("Sorry, you ran out of guesses. The correct answer was " + randomNumber);
	                submitButton.setEnabled(false); // Disable the button after 3 attempts
	            }
	        }
	    }
	    

	    private void displayResult(String message) {
	        resultArea.append(message + "\n");
	        guessField.setText("");
	    }

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGame();
            }
        });

	}

}
