import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class UI extends JFrame {
    private JTextField saesKeyField;
    private JTextField saesInputText;
    private JTextField saesOutputText;
    private JTextField doubleKeyField;
    private JTextField doubleInputText;
    private JTextField doubleOutputText;
    private JTextField tripleKey1Field;
    private JTextField tripleKey2Field;
    private JTextField tripleKey3Field;
    private JTextField tripleInputText;
    private JTextField tripleOutputText;
    private JTextArea meetInMiddleInputText;
    private JTextArea meetInMiddleOutputText;
    private JTextField cbcKeyField;
    private JTextArea cbcInputText;
    private JTextArea cbcOutputText;
    private JLabel cbcIVLabel;
    private JTextField cbcIVField;
    private JCheckBox useASCIICheckBox;

    public UI() {
        setTitle("Extended SAES UI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        BackgroundPanel saesPanel = createSAESPanel();
        tabbedPane.addTab("SAES", saesPanel);

        BackgroundPanel doublePanel = createDoublePanel();
        BackgroundPanel triplePanel = createTriplePanel();
        BackgroundPanel meetInMiddlePanel = createMeetInMiddlePanel();
        BackgroundPanel cbcPanel = createCBCPanel();

        tabbedPane.addTab("Double Encrypt/Decrypt", doublePanel);
        tabbedPane.addTab("Triple Encrypt/Decrypt", triplePanel);
        tabbedPane.addTab("Meet In The Middle Attack", meetInMiddlePanel);
        tabbedPane.addTab("CBC Mode", cbcPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private void setComponentSize(JComponent component, int width, int height) {
        component.setPreferredSize(new Dimension(width, height));
        component.setMinimumSize(new Dimension(width, height));
    }
    private BackgroundPanel createSAESPanel() {
        BackgroundPanel panel = new BackgroundPanel(new GridBagLayout(), "./2.jpg");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);

        saesKeyField = new JTextField();
        setComponentSize(saesKeyField, 150, 30);
        saesInputText = new JTextField();
        setComponentSize(saesInputText, 150, 30);
        saesOutputText = new JTextField();
        setComponentSize(saesOutputText, 150, 30);

        useASCIICheckBox = new JCheckBox("Use ASCII for encryption/decryption");

        JButton encryptButton = new JButton("Encrypt");
        setComponentSize(encryptButton, 150, 30);
        encryptButton.addActionListener(this::handleSAESEncrypt);

        JButton decryptButton = new JButton("Decrypt");
        setComponentSize(decryptButton, 150, 30);
        decryptButton.addActionListener(this::handleSAESDecrypt);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("16-bit Binary Key:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(saesKeyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Input Text (Plaintext or Ciphertext):"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(saesInputText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(useASCIICheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(encryptButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(decryptButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Output Text:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(saesOutputText, gbc);

        return panel;
    }

    private BackgroundPanel createDoublePanel() {
        BackgroundPanel panel = new BackgroundPanel(new GridBagLayout(), "./2.jpg");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);

        doubleKeyField = new JTextField();
        setComponentSize(doubleKeyField, 220, 30);
        doubleInputText = new JTextField();
        setComponentSize(doubleInputText, 220, 30);
        doubleOutputText = new JTextField();
        setComponentSize(doubleOutputText, 220, 30);

        JButton doubleEncryptButton = new JButton("Encrypt");
        setComponentSize(doubleEncryptButton, 220, 30);
        doubleEncryptButton.addActionListener(this::handleDoubleEncrypt);

        JButton doubleDecryptButton = new JButton("Decrypt");
        setComponentSize(doubleDecryptButton, 220, 30);
        doubleDecryptButton.addActionListener(this::handleDoubleDecrypt);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("32-bit Binary Key:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(doubleKeyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Input Text (Plaintext or Ciphertext):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(doubleInputText, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Output Text:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(doubleOutputText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(doubleEncryptButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(doubleDecryptButton, gbc);

        return panel;
    }
    private BackgroundPanel createTriplePanel() {
        BackgroundPanel panel = new BackgroundPanel(new GridBagLayout(),"./2.jpg");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);

        tripleKey1Field = new JTextField();
        setComponentSize(tripleKey1Field, 150, 30);
        tripleKey2Field = new JTextField();
        setComponentSize(tripleKey2Field, 150, 30);
        tripleKey3Field = new JTextField();
        setComponentSize(tripleKey3Field, 150, 30);
        tripleInputText = new JTextField();
        setComponentSize(tripleInputText, 150, 30);
        tripleOutputText = new JTextField();
        setComponentSize(tripleOutputText, 150, 30);

        JButton tripleEncryptButton = new JButton("Encrypt");
        setComponentSize(tripleEncryptButton, 100, 30);
        tripleEncryptButton.addActionListener(this::handleTripleEncrypt);

        JButton tripleDecryptButton = new JButton("Decrypt");
        setComponentSize(tripleDecryptButton, 100, 30);
        tripleDecryptButton.addActionListener(this::handleTripleDecrypt);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("First 16-bit Binary Key:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(tripleKey1Field, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Second 16-bit Binary Key:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(tripleKey2Field, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Third 16-bit Binary Key:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(tripleKey3Field, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Input Text (Plaintext or Ciphertext):"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(tripleInputText, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Output Text:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(tripleOutputText, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(tripleEncryptButton, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        panel.add(tripleDecryptButton, gbc);

        return panel;
    }

    private BackgroundPanel createMeetInMiddlePanel() {
        BackgroundPanel panel = new BackgroundPanel(new GridBagLayout(),"./2.jpg");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);

        meetInMiddleInputText = new JTextArea(10, 20);
        setComponentSize(meetInMiddleInputText, 250, 60);
        JScrollPane inputScroll = new JScrollPane(meetInMiddleInputText);
        setComponentSize(inputScroll, 200, 60);
        meetInMiddleOutputText = new JTextArea(10, 20);
        setComponentSize(meetInMiddleOutputText, 250, 80);
        meetInMiddleOutputText.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(meetInMiddleOutputText);
        setComponentSize(outputScroll, 200, 80);

        JButton meetInMiddleButton = new JButton("Attack");
        setComponentSize(meetInMiddleButton, 100, 30);
        meetInMiddleButton.addActionListener(this::handleMeetInMiddle);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Enter Plaintext-Ciphertext pairs (separated by spaces):"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(inputScroll, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Possible Keys:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(outputScroll, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(meetInMiddleButton, gbc);

        return panel;
    }

    private BackgroundPanel createCBCPanel() {
        BackgroundPanel panel = new BackgroundPanel(new GridBagLayout(),"./2.jpg");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);

        cbcKeyField = new JTextField();
        setComponentSize(cbcKeyField, 100, 30);
        cbcIVField = new JTextField();
        setComponentSize(cbcIVField, 100, 30);
        cbcInputText = new JTextArea(5, 20);
        setComponentSize(cbcInputText, 600, 60);
        JScrollPane inputScroll = new JScrollPane(cbcInputText);
        setComponentSize(inputScroll, 200, 60);
        cbcOutputText = new JTextArea(5, 20);
        setComponentSize(cbcOutputText, 600, 80);
        cbcOutputText.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(cbcOutputText);
        setComponentSize(outputScroll, 200, 80);

        JButton cbcEncryptButton = new JButton("Encrypt");
        setComponentSize(cbcEncryptButton, 100, 30);
        cbcEncryptButton.addActionListener(this::handleCBCEncrypt);

        JButton cbcDecryptButton = new JButton("Decrypt");
        setComponentSize(cbcDecryptButton, 100, 30);
        cbcDecryptButton.addActionListener(this::handleCBCDecrypt);

        cbcIVLabel = new JLabel("IV: Not generated yet");

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("16-bit Binary Key:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(cbcKeyField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("IV (for decryption):"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(cbcIVField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Input Text (Plaintext or Ciphertext):"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(inputScroll, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Output Text:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(outputScroll, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(cbcEncryptButton, gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        panel.add(cbcDecryptButton, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(cbcIVLabel, gbc);

        return panel;
    }
    private void handleSAESEncrypt(ActionEvent event) {
        try {
            String key = saesKeyField.getText();
            String input = saesInputText.getText();
            boolean useASCII = useASCIICheckBox.isSelected();

            if (!useASCII && !input.matches("[01]+")) {
                throw new IllegalArgumentException("Input string must be a binary string when ASCII mode is off.");
            }

            String encryptedText;
            if (useASCII) {
                encryptedText = SAES.encryptASCII(input, key);
            } else {
                encryptedText = SAES.encrypt(input, key);
            }
            saesOutputText.setText(encryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during SAES Encryption: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleSAESDecrypt(ActionEvent event) {
        try {
            String key = saesKeyField.getText();
            String ciphertext = saesInputText.getText();
            boolean useASCII = useASCIICheckBox.isSelected();
            String decryptedText;
            if (useASCII) {
                decryptedText = SAES.decryptASCII(ciphertext, key);
            } else {
                decryptedText = SAES.decrypt(ciphertext, key);
            }
            saesOutputText.setText(decryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during SAES Decryption: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDoubleEncrypt(ActionEvent event) {
        try {
            String binaryKey = doubleKeyField.getText(); // Get binary key as a string

            if (binaryKey.length() != 32 || !binaryKey.matches("[01]+")) {
                JOptionPane.showMessageDialog(this, "Key must be a 32-bit binary number.", "Key Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String plaintext = doubleInputText.getText();
            String encryptedText = ExtendedSAES.doubleEncrypt(plaintext, binaryKey);
            doubleOutputText.setText(encryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during encryption: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDoubleDecrypt(ActionEvent event) {
        try {
            String binaryKey = doubleKeyField.getText();
            // Ensure the binary key is a 32-bit binary string
            if (binaryKey.length() != 32 || !binaryKey.matches("[01]+")) {
                JOptionPane.showMessageDialog(this, "Key must be a 32-bit binary number.", "Key Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String ciphertext = doubleInputText.getText();
            String decryptedText = ExtendedSAES.doubleDecrypt(ciphertext, binaryKey);
            doubleOutputText.setText(decryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during decryption: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void handleMeetInMiddle(ActionEvent event) {
        try {
            String[] lines = meetInMiddleInputText.getText().split("\\n");
            String[] plaintexts = new String[lines.length];
            String[] ciphertexts = new String[lines.length];
            for (int i = 0; i < lines.length; i++) {
                String[] parts = lines[i].split("\\s+");
                plaintexts[i] = parts[0];
                ciphertexts[i] = parts[1];
            }
            List<String> keys = ExtendedSAES.meetInTheMiddleAttack(plaintexts, ciphertexts);
            meetInMiddleOutputText.setText(keys != null && !keys.isEmpty() ? String.join("\n", keys) : "No keys found.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during Meet In The Middle Attack: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void handleTripleEncrypt(ActionEvent event) {
        try {
            String key1 = tripleKey1Field.getText();
            String key2 = tripleKey2Field.getText();
            String key3 = tripleKey3Field.getText();
            String plaintext = tripleInputText.getText();
            String encryptedText = new ExtendedSAES().tripleEncrypt(plaintext, key1, key2, key3);
            tripleOutputText.setText(encryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during encryption: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleTripleDecrypt(ActionEvent event) {
        try {
            String key1 = tripleKey1Field.getText();
            String key2 = tripleKey2Field.getText();
            String key3 = tripleKey3Field.getText();
            String ciphertext = tripleInputText.getText();
            String decryptedText = new ExtendedSAES().tripleDecrypt(ciphertext, key1, key2, key3);
            tripleOutputText.setText(decryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during decryption: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void handleCBCEncrypt(ActionEvent event) {
        try {
            String key = cbcKeyField.getText();
            String plaintext = cbcInputText.getText();
            int iv = ExtendedSAES.generateRandomIV();
            cbcIVLabel.setText("IV: " + Integer.toBinaryString(iv));

            List<String> encryptedBlocks = ExtendedSAES.cbcEncrypt(plaintext, key, iv);

            String encryptedText = String.join(" ", encryptedBlocks);
            cbcOutputText.setText(encryptedText); // Display the encrypted binary blocks
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during CBC Encryption: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleCBCDecrypt(ActionEvent event) {
        try {
            String key = cbcKeyField.getText();
            String ciphertext = cbcInputText.getText();
            // Parse the IV from the cbcIVField instead of cbcIVLabel
            int iv = Integer.parseInt(cbcIVField.getText(), 2);
            List<Integer> ciphertextBlocks = ExtendedSAES.parseCiphertext(ciphertext); // Assume this method is implemented to convert the string to a List<Integer>
            String decryptedText = ExtendedSAES.cbcDecrypt(ciphertextBlocks, key, iv);
            cbcOutputText.setText(decryptedText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error during CBC Decryption: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UI ui = new UI();
            ui.setVisible(true);
        });
    }
}